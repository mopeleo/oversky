package org.oversky.util.regex;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegExCheck {
	
	// 支持(19000101|1900-01-01|1900/01/01)  \s 匹配任何空白字符,包括空格、制表符、换页符等等
	public static final String regex_date = "((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?" //year1 闰年
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|"      //month+day 大
				+ "(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"               //month+day 小
				+ "(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|"                               //month+day 二月
				+ "(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?"                //year2 平年
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|"      //month+day 大
				+ "(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"               //month+day 小
				+ "(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";                        //month+day 二月
	public static final Pattern DATE_PATTERN = Pattern.compile(regex_date);

	private RegExCheck() {}
	
	/**
	 * 判断字符窜是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		if(StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[+-]?(0|([1-9]\\d*))(\\.\\d+)?$");
		return pattern.matcher(str).matches();
	}

	//效验字符串是否为日期格式，支持(1900 01 01|1900-00-00|1900/00/00)
	public static boolean isDate(String strDate) {
		if(strDate == null || (strDate.length() != 8 && strDate.length() != 10)){
			return false;
		}
		return DATE_PATTERN.matcher(strDate).matches();
	}

}
