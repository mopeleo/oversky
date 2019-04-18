package org.oversky.code.parser.config;

public class DataType {
	public final static String CODE_SEP = "_";

	public final static String INT = "int";
    public final static String LONG = "long";
    public final static String DOUBLE = "double";
    public final static String STRING = "string";

    public static enum SourceType{CDM, PDM_ORACLE, PDM_MYSQL};
    
    public static SourceType getSourceType(String dbms) {
		DataType.SourceType type = null;
		if(dbms.startsWith("ORACLE")){
		    type = DataType.SourceType.PDM_ORACLE;
		}else if(dbms.startsWith("MYSQL")){
            type = DataType.SourceType.PDM_MYSQL;
		}else {
			throw new RuntimeException("暂不支持的数据库类型:" + dbms);
		}
		return type;
    }
    
    public static String convertType(String datatype, SourceType sourceType){
        switch (sourceType){
            case CDM:
                return convertCDM(datatype);
            case PDM_ORACLE:
                return convertPDMOracle(datatype);
            case PDM_MYSQL:
                return convertPDMMysql(datatype);
            default:
                return LONG;            
        }
    }
    
    public static String convertCDM(String datatype){
        if(datatype.indexOf(",")>0){
            return DOUBLE;
        }
        if(datatype.equals("LI")) {
        	return LONG;
        }
        if(datatype.equals("I") || datatype.equals("SI") || datatype.equals("BT")){
            return INT;
        }
        if(datatype.startsWith("N")){
            String len = datatype.substring(1);
            if(Integer.parseInt(len) > 9){
                return LONG;
            }else{
                return INT;
            }
        }
        if(datatype.startsWith("DC")){
            String len = datatype.substring(2);
            if(Integer.parseInt(len) > 9){
                return LONG;
            }else{
                return INT;
            }            
        }
        if(datatype.startsWith("F")){
            return DOUBLE;
        }
        if(datatype.startsWith("A") || datatype.startsWith("VA")){
            return STRING;
        }
        //clob
        if(datatype.startsWith("LA") || datatype.startsWith("LVA") || datatype.startsWith("TXT")){
            return STRING;
        }
        //date&time
        if(datatype.equals("D") || datatype.equals("T") || datatype.equals("DT") || datatype.equals("TS") || datatype.equals("DS")){
            return STRING;
        }
        return STRING;
    }
    
    public static String convertPDMOracle(String datatype){
        if(datatype.indexOf(",")>0){
            return DOUBLE;
        }
        if(datatype.equals("SMALLINT")){
            return INT;
        }
        if(datatype.equals("INTEGER")){
            return LONG;
        }
        if(datatype.startsWith("NUMBER")){
            if(datatype.length() == 6){
                return LONG;
            }
            String len = datatype.substring(7, datatype.length()-1);
            if(Integer.parseInt(len) > 9){
                return LONG;
            }else{
                return INT;
            }
        }
        if(datatype.startsWith("FLOAT")){
            return DOUBLE;
        }
        if(datatype.startsWith("CHAR") || datatype.startsWith("VARCHAR")){
            return STRING;
        }
        //clob&blob
        if(datatype.equals("CLOB") || datatype.equals("BLOB")){
            return STRING;
        }
        //date&time
        if(datatype.equals("DATE") || datatype.equals("TIMESTAMP")){
            return STRING;
        }
        return STRING;
    }
    
    public static String convertPDMMysql(String datatype){
        if(datatype.equals("SMALLINT") || datatype.equals("TINYINT")){
            return INT;
        }
        if(datatype.equals("INT") || datatype.equals("BIGINT")) {
        	return LONG;
        }
        if(datatype.startsWith("NUMERIC") || datatype.startsWith("DECIMAL")){
            if(datatype.length() == 7){
                return LONG;
            }
            String desc = datatype.substring(8, datatype.length()-1);
            if(desc.indexOf(",") > 0) {
                String[] num = desc.split(",");
                if(Integer.parseInt(num[1]) == 0){
                    if(Integer.parseInt(num[0]) > 9){
                        return LONG;
                    }else{
                        return INT;
                    }
                }else{
                    return DOUBLE;
                }
            }else {
                if(Integer.parseInt(desc) > 9){
                    return LONG;
                }else{
                    return INT;
                }            	
            }
        }
        if(datatype.startsWith("FLOAT")){
            return DOUBLE;
        }
        if(datatype.indexOf(",")>0){
            return DOUBLE;
        }
        if(datatype.startsWith("CHAR") || datatype.startsWith("VARCHAR")){
            return STRING;
        }
        //clob
        if(datatype.equals("TEXT") || datatype.equals("LONGTEXT")){
            return STRING;
        }
        //blob
        if(datatype.equals("LONGBLOB") || datatype.equals("VBIN")){
            return STRING;
        }
        //date&time
        if(datatype.equals("DATE") || datatype.equals("TIME") || datatype.equals("DATETIME") || datatype.equals("TIMESTAMP")){
            return STRING;
        }
        return STRING;
    }
}
