package org.oversky.base.entity;

import java.io.Serializable;

import org.oversky.base.constant.PubDefine;
import org.oversky.base.service.BaseReqDto;

public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderByClause;

	public String getOrderByClause() {
		return orderByClause;
	}

	public BaseEntity orderBy(String column) {
		return orderByDesc(column);
	}
	
	public BaseEntity orderBy(BaseReqDto reqDto) {
		if(PubDefine.ORDERTYPE_ASC.equals(reqDto.getOrderType())) {
			return orderByAsc(reqDto.getOrderBy());
		}else {
			return orderByDesc(reqDto.getOrderBy());
		}
	}
	
	public BaseEntity orderByDesc(String column) {
		if(column == null || "".equals(column.trim())) {
			return this;
		}
		
		if(orderByClause == null) {
			orderByClause = column + " desc ";
		}else {
			orderByClause +=  ", " + column + " desc ";
		}
		
		return this;
	}
	
	public BaseEntity orderByAsc(String column) {
		if(column == null || "".equals(column.trim())) {
			return this;
		}
		
		if(orderByClause == null) {
			orderByClause = column + " asc ";
		}else {
			orderByClause +=  ", " + column + " asc ";
		}
		
		return this;
	}	
	
}
