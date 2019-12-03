package org.oversky.code.model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private String id;
	private String name;
	private String code;
	private String comment;
	private String group;
	private String originCode;
	private String dbms;
	private Column identityCol;	//自增长列
	private boolean cache;		//是否开启缓存
	private boolean ignore;		//是否忽略生成
	
	private List<Column> columns = new ArrayList<Column>();			//所有列
    private List<Column> keys = new ArrayList<Column>();			//所有主键
    private List<Column> colsExceptKey = new ArrayList<Column>();	//所有去除主键的列
	
	public void addColumn(Column col){
		columns.add(col);
	}
	
    public void addKey(Column key){
        keys.add(key);
    }
    
    public void addColsExceptKey(Column key){
        colsExceptKey.add(key);
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getComment() {
		return comment;
	}

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public String getDbms() {
        return dbms;
    }
	public Column getIdentityCol() {
		return identityCol;
	}

	public void setIdentityCol(Column identityCol) {
		this.identityCol = identityCol;
	}

	public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public List<Column> getKeys() {
		return keys;
	}
	public void setKeys(List<Column> keys) {
		this.keys = keys;
	}
    public List<Column> getColsExceptKey() {
        return colsExceptKey;
    }

    public void setColsExceptKey(List<Column> colsExceptKey) {
        this.colsExceptKey = colsExceptKey;
    }

	public boolean isCache() {
		return cache;
	}

	public void setCache(boolean cache) {
		this.cache = cache;
	}

	public boolean isIgnore() {
		return ignore;
	}

	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}	
}
