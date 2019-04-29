package org.oversky.code.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.oversky.code.model.Column;
import org.oversky.code.model.Model;
import org.oversky.code.model.Table;
import org.oversky.code.parser.config.DataType;
import org.oversky.code.parser.config.DatabaseConfig;

public class DatabaseParser {

	private static String QUERY_ALL_TABLES_ORACLE = "select t.table_name,tc.comments as table_comment " 
			+ " from user_tables t, user_tab_comments tc where t.table_name=tc.table_name";
	private static String QUERY_ALL_TABLES_MYSQL = "select table_name,table_comment from information_schema.tables " 
			+ " where table_schema = (select database())";
	
	private static String QUERY_TABLE_ORACLE = "select b.comments,a.column_name,a.data_type,a.data_length,a.data_precision,a.data_scale,a.column_id,a.nullable,a.data_default,e.constraint_type "
			+ " from user_tab_columns a join user_col_comments b on a.table_name=b.table_name and a.column_name=b.column_name "
			+ " left join (select d.table_name,d.column_name,c.constraint_type "
			+ "     from user_constraints c,user_cons_columns d where c.constraint_name=d.constraint_name and c.constraint_type='P') e "
			+ " on b.table_name=e.table_name and b.column_name=e.column_name where lower(a.table_name) = ?";
	private static String QUERY_TABLE_MYSQL = "select column_name,data_type,column_type,column_comment,column_key,column_default,"
			+ " character_maximum_length,numeric_precision,numeric_scale,is_nullable,extra from information_schema.columns t "
			+ " where table_schema = (select database()) and table_name = ?";
	
	public static Model parse(DatabaseConfig config, String excludePattern) {
		Connection connect = getConnect(config);
		Model model = new Model();
		String dbms = config.getDbtype().toUpperCase();
		DataType.SourceType type = DataType.getSourceType(dbms);

		try {
			PreparedStatement ps = connect.prepareStatement(getTableList(type));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Table table = new Table();
				String tableName = rs.getString("table_name").toLowerCase();
				String tableComment = rs.getString("table_comment");

				table.setComment(tableComment);
				table.setDbms(dbms);
				table.setId(tableName);
				table.setOriginCode(tableName);
				if(tableComment != null && tableComment.toLowerCase().indexOf("[cache]") >= 0) {
					table.setCache(true);
				}
				String code = "";
                if(tableName.indexOf(DataType.CODE_SEP) > 0){
                    String[] parts = tableName.split(DataType.CODE_SEP);
                    table.setGroup(parts[0]);
                    for(int p = 0; p < parts.length; p++){
                        code += parts[p].substring(0, 1).toUpperCase() + parts[p].substring(1);
                    }
                }else{
                    code = tableName;
                }
				table.setCode(code);
				table.setName(code);
				
				model.addTable(table);
			}
			rs.close();
			
			ps = connect.prepareStatement(getTableColumnList(type));
			for(Table tab : model.getTables()) {
				ps.setString(1, tab.getOriginCode());
				rs = ps.executeQuery();
				fillTable(type, tab, rs);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnect(connect);
		return model;
	}

	private static void fillMysqlTable(Table tab, ResultSet rs) throws SQLException {
		while(rs.next()) {
			Column col = new Column();
			col.setComment(rs.getString("column_comment"));
			col.setDefaultValue(rs.getString("column_default"));
			String len = rs.getString("character_maximum_length");
			if(len == null || "".equals(len)) {
				col.setLength(rs.getString("numeric_precision"));
			}else {
				col.setLength(len);
			}
			String nullAble = rs.getString("is_nullable").toUpperCase();
			if("NO".equals(nullAble)) {
				col.setMandatory("1");
			}else {
				col.setMandatory("0");
			}
			col.setOriginDatatype(rs.getString("column_type").toUpperCase());
			col.setDatatype(DataType.convertType(col.getOriginDatatype(), DataType.SourceType.PDM_MYSQL));
			col.setPrecision(rs.getString("numeric_scale"));
			String columnName = rs.getString("column_name").toLowerCase();
			col.setOriginCode(columnName);
			col.setId(columnName);
            String code = "";
            if(columnName.indexOf(DataType.CODE_SEP) > 0){
                String[] parts = columnName.split(DataType.CODE_SEP);
                code = parts[0];
                for(int p = 1; p < parts.length; p++){
                    code += parts[p].substring(0, 1).toUpperCase() + parts[p].substring(1);
                }
            }else{
                code = columnName;
            }
            col.setCode(code);
            col.setName(code);
			String identity = rs.getString("extra").toUpperCase();
			if("AUTO_INCREMENT".equals(identity)) {
				col.setIdentity("1");
				tab.setIdentityCol(col);
				tab.getColumns().add(0, col);
			}else {
				col.setIdentity("0");
				tab.addColumn(col);
			}
            
            String pri = rs.getString("column_key").toUpperCase();
            if("PRI".equals(pri)) {
            	tab.addKey(col);
            }else {
            	tab.addColsExceptKey(col);
            }
		}
	}
	
	private static void fillOracleTable(Table tab, ResultSet rs) throws SQLException {
		while(rs.next()) {
			Column col = new Column();
			col.setId(rs.getString("column_id"));
			col.setComment(rs.getString("comments") == null ? "" : rs.getString("comments"));
			col.setDefaultValue(rs.getString("data_default"));
			col.setLength(rs.getString("data_length"));
			String realLen = rs.getString("data_precision");
			if(realLen != null && !"".equals(realLen)) {
				col.setLength(realLen);
			}
			col.setPrecision(rs.getString("data_scale"));
			String nullAble = rs.getString("nullable").toUpperCase();
			if("N".equals(nullAble)) {
				col.setMandatory("1");
			}else {
				col.setMandatory("0");
			}
			//把数字型转换为NUMBER(P,S)的类型
			String type = rs.getString("data_type").toUpperCase();
			if("NUMBER".equals(type)) {
				if(col.getPrecision() != null && Integer.parseInt(col.getPrecision()) > 0) {
					type = type + "("+ col.getLength() +"," + col.getPrecision() + ")";
				}else {
					type = type + "("+ col.getLength() + ")";
				}
			}
			col.setOriginDatatype(type);
			col.setDatatype(DataType.convertType(col.getOriginDatatype(), DataType.SourceType.PDM_ORACLE));
			String columnName = rs.getString("column_name").toLowerCase();
			col.setOriginCode(columnName);
            String code = "";
            if(columnName.indexOf(DataType.CODE_SEP) > 0){
                String[] parts = columnName.split(DataType.CODE_SEP);
                code = parts[0];
                for(int p = 1; p < parts.length; p++){
                    code += parts[p].substring(0, 1).toUpperCase() + parts[p].substring(1);
                }
            }else{
                code = columnName;
            }
            col.setCode(code);
            col.setName(code);

            // oracle无法设置递增字段
			col.setIdentity("0");
			tab.addColumn(col);

            String pri = rs.getString("constraint_type");
            if("P".equals(pri)) {
            	tab.addKey(col);
            }else {
            	tab.addColsExceptKey(col);
            }
		}
	}
	
	private static String getTableList(DataType.SourceType type) {
		switch(type) {
			case PDM_ORACLE :
				return QUERY_ALL_TABLES_ORACLE;
			case PDM_MYSQL:
				return QUERY_ALL_TABLES_MYSQL;
			default:
				throw new NullPointerException("不支持的数据类型");
		}
	}
	
	private static String getTableColumnList(DataType.SourceType type) {
		switch(type) {
			case PDM_ORACLE :
				return QUERY_TABLE_ORACLE;
			case PDM_MYSQL:
				return QUERY_TABLE_MYSQL;
			default:
				throw new NullPointerException("不支持的数据类型");
		}
	}
	
	private static void fillTable(DataType.SourceType type, Table tab, ResultSet rs) throws SQLException {
		switch(type) {
			case PDM_ORACLE :
				fillOracleTable(tab, rs);
				break;
			case PDM_MYSQL:
				fillMysqlTable(tab, rs);
				break;
			default:
				throw new NullPointerException("不支持的数据类型");
		}
	}
	
	private static Connection getConnect(DatabaseConfig config) {
		Connection connection = null;
		try {
			Class.forName(config.getDriver());
	        connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	private static void closeConnect(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
