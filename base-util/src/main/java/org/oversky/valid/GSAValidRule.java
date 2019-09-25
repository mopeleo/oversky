package org.oversky.valid;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.format.IDCodeUtils;
import org.oversky.util.number.DoubleUtils;
import org.oversky.util.regex.RegExCheck;


public class GSAValidRule implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sep = "|";
	
	private String type;         //规则类别
	private String value;        //规则对应的值
	private String msg;			 //提示信息
	private String eq;			// ==
	private String min;			// 最小
	private String max;			// 最大
	private String pattern;		// 模式
	
	private String fieldName;       //属性名
	private String script;          //客户端效验JS
	
	public enum Rule {
		NotNull,Number,RegExp,Email,Date,Chinese,Mobile,IdCard,Length,Include,Exclude,Equals;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getEq() {
		return eq;
	}
	public void setEq(String eq) {
		this.eq = eq;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getJsonMsg(){
		return "{" + this.getFieldName() + ":'" + getMsg() + "'}";
	}

	//new LiveValidation("userid").add(Validate.Presence,{failureMessage:'用户名不能为空'});
	public String getScript(){
		if(this.script != null){
			return this.script;
		}
		if(StringUtils.isBlank(getFieldName())){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("new LiveValidation('").append(getFieldName()).append("')");

		String r = addFunc(this);
		this.script = sb.append(r).toString();
		return this.script;
	}
	
	public boolean validField(String fieldValue){
		if(StringUtils.isEmpty(getType())){
			throw new GSAValidException("请定义正确的效验规则");
		}

		Rule r = Enum.valueOf(Rule.class, getType());
		Pattern pattern = null;
		boolean result = true;
		switch(r){
			case NotNull:
				return StringUtils.isNotBlank(fieldValue);
			case Number:
				if(RegExCheck.isNumber(fieldValue)){
					if(StringUtils.isNotEmpty(getPattern())) {
						if("int".equalsIgnoreCase(getPattern())) {
							result = result && NumberUtils.isDigits(fieldValue);
						}
					}
					if(StringUtils.isNotEmpty(getEq())){
						result = result && getEq().equals(fieldValue);
					}else {
						if(StringUtils.isNotEmpty(getMin())){
							result = result && DoubleUtils.ge(NumberUtils.toFloat(fieldValue), NumberUtils.toFloat(getMin()));
						}
						if(StringUtils.isNotEmpty(getMax())){
							result = result && DoubleUtils.le(NumberUtils.toFloat(fieldValue), NumberUtils.toFloat(getMax()));
						}
					}
				}else{
					result = false;
				}
				return result;
			case RegExp:
				pattern = Pattern.compile(getPattern());
				return pattern.matcher(fieldValue).matches();
			case Email:
				pattern = Pattern.compile("^([^@\\s]+)@((?:[-a-z0-9]+\\.)+[a-z]{2,})$",Pattern.CASE_INSENSITIVE);
				return pattern.matcher(fieldValue).matches();
			case Mobile:
				pattern = Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
				return pattern.matcher(fieldValue).matches();
			case Chinese:
				pattern = Pattern.compile("^[\\u4e00-\\u9fa5]+$");
				return pattern.matcher(fieldValue).matches();
			case IdCard:
				return IDCodeUtils.validateIDCode(fieldValue);
			case Date:
				return RegExCheck.isDate(fieldValue);
			case Length:
				if(StringUtils.isNotEmpty(fieldValue)){
					if(StringUtils.isNotEmpty(getEq())){
						result = result && (Integer.parseInt(getEq()) == fieldValue.length());
					}
					if(StringUtils.isNotEmpty(getMin())){
						result = result && (Integer.parseInt(getMin()) <= fieldValue.length());
					}
					if(StringUtils.isNotEmpty(getMax())){
						result = result && (Integer.parseInt(getMax()) >= fieldValue.length());
					}
				}else{
					result = false;
				}
				return result;
			case Include:
				if(StringUtils.isNotEmpty(getValue())) {
					String[] include = getValue().split(sep);
					result = ArrayUtils.contains(include, fieldValue);
				}
				return result;
			case Exclude:
				if(StringUtils.isNotEmpty(getValue())) {
					String[] exclude = getValue().split(sep);
					result = !ArrayUtils.contains(exclude, fieldValue);
				}
				return result;
			case Equals:
				if(StringUtils.isNotEmpty(getValue())) {
					result = getValue().equals(fieldValue);
				}
				return result;
			default:
				return false;			
		}
	}
	
	public GSAValidRule addScript(GSAValidRule g){
		String comp = getScript();
		if(this.equals(g)){
			comp = comp.substring(0, comp.length()-1) + addFunc(g);
		}else{
			comp += g.getScript();
			this.fieldName = g.getFieldName();
		}
		this.script = comp;
		return this;
	}
	
	//.add(Validate.Presence,{failureMessage:'msg'});
	//TODO
	private String addFunc(GSAValidRule gvr){
		Rule r = Enum.valueOf(Rule.class, gvr.getType());
		switch(r){
			case NotNull:
				return ".add(Validate.Presence,{failureMessage:'" + gvr.getMsg() + "'});";
			case Number:
				StringBuffer num = new StringBuffer();
				num.append(".add(Validate.Numericality,{");
				if(StringUtils.isNotEmpty(gvr.getEq())){
					num.append("is:" + gvr.getEq() + ",wrongNumberMessage:'"+gvr.getMsg()+"',");
				}
				if(StringUtils.isNotEmpty(gvr.getMin())){
					num.append("minimum:" + gvr.getMin() + ",tooLowMessage:'" + gvr.getMsg() + "',");
				}
				if(StringUtils.isNotEmpty(gvr.getMax())){
					num.append("maximum:" + gvr.getMax() + ",tooHighMessage:'" + gvr.getMsg() + "',");
				}
				if(StringUtils.isEmpty(gvr.getMin())&&StringUtils.isEmpty(gvr.getMax())){
					num.append("notANumberMessage:'" + gvr.getMsg() + "',");
				}
				num.deleteCharAt(num.length()-1).append("});");
				return num.toString();
			case RegExp:
				return ".add(Validate.Format,{pattern:" + gvr.getPattern() + ",failureMessage:'" + gvr.getMsg() + "'});";
			case Email:
				return ".add(Validate.Email,{failureMessage:'" + gvr.getMsg() + "'});";
			case Mobile:
				return ".add(Validate.Mobile,{failureMessage:'" + gvr.getMsg() + "'});";
			case Chinese:
				return ".add(Validate.Chinese,{failureMessage:'" + gvr.getMsg() + "'});";
			case IdCard:
				return ".add(Validate.Idcard,{failureMessage:'" + gvr.getMsg() + "'});";
			case Date:
				return ".add(Validate.Date,{failureMessage:'" + gvr.getMsg() + "'});";
			case Length:
				StringBuffer len = new StringBuffer();
				len.append(".add(Validate.Length,{");
				if(StringUtils.isNotEmpty(gvr.getEq())){
					len.append("is:" + gvr.getEq() + ",");
				}
				if(StringUtils.isNotEmpty(gvr.getMin())){
					len.append("minimum:" + gvr.getMin() + ",tooShortMessage:'" + gvr.getMsg() + "',");
				}
				if(StringUtils.isNotEmpty(gvr.getMax())){
					len.append("maximum:" + gvr.getMax() + ",tooLongMessage:'" + gvr.getMsg() + "',");
				}
				if(StringUtils.isEmpty(gvr.getMin())&&StringUtils.isEmpty(gvr.getMax())){
					len.append("failureMessage:'" + gvr.getMsg() + "',");
				}
				len.deleteCharAt(len.length()-1).append("});");
				return len.toString();
			case Include:
				String[] includ = gvr.getValue().split(sep);
				StringBuffer in = new StringBuffer();
				in.append(".add(Validate.Inclusion,{within:[");
				for(String tmp : includ){
					in.append("'").append(tmp).append("',");
				}
				in.deleteCharAt(in.length()-1).append("],failureMessage:'" + gvr.getMsg() + "'});");
				return in.toString();
			case Exclude:
				String[] exclud = gvr.getValue().split(sep);
				StringBuffer ex = new StringBuffer();
				ex.append(".add(Validate.Exclusion,{within:[");
				for(String tmp : exclud){
					ex.append("'").append(tmp).append("',");
				}
				ex.deleteCharAt(ex.length()-1).append("],failureMessage:'" + gvr.getMsg() + "'});");
				return ex.toString();
			case Equals:
				return ".add(Validate.Confirmation,{match:'" + gvr.getValue() + "',failureMessage:'" + gvr.getMsg() + "'});";
			default:
				return "";			
		}
	}
	
}
