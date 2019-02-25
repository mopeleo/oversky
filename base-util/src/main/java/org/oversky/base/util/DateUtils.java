package org.oversky.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

import org.oversky.base.exception.BaseUtilException;

public class DateUtils {

	public static final String pattern_time = "HHmmss";
	public static final String pattern_date = "yyyyMMdd";
	public static final String pattern_datetime = "yyyyMMddHHmmss";
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

	private DateUtils(){}
	
	private static String format(LocalDateTime date, String pattern) {
		return DateTimeFormatter.ofPattern(pattern).format(date);
	}
	
	private static String format(LocalDate date, String pattern) {
		return DateTimeFormatter.ofPattern(pattern).format(date);
	}
	
	public static String getNow(String pattern){
		return format(LocalDateTime.now(), pattern);
	}
	
	public static String getNowTime(){
		return format(LocalDateTime.now(), pattern_time);
	}
	
	public static String getNowDate(){
		return format(LocalDateTime.now(), pattern_date);
	}
	
	public static String getNowDateTime(){
		return format(LocalDateTime.now(), pattern_datetime);
	}
	
	public static LocalDate parseDate(String date) {
		String date8 = date;
		if(isDate(date)) {
			if(date.length() == 10) {
				date8 = date.substring(0, 4) + date.substring(5,7) + date.substring(8);
			}
			return LocalDate.parse(date8, DateTimeFormatter.ofPattern(pattern_date));
		}else {
			throw new BaseUtilException("请输入正确的日期格式字符串");
		}
	}

	//效验字符串是否为日期格式，支持(1900 01 01|1900-00-00|1900/00/00)
	public static boolean isDate(String strDate) {
		if(strDate == null || (strDate.length() != 8 && strDate.length() != 10)){
			return false;
		}
		return DATE_PATTERN.matcher(strDate).matches();
	}
	
	public static long dateMinus(String begindate, String enddate){
		LocalDate beginLD = parseDate(begindate);
		LocalDate endLD = parseDate(enddate);
//	    return endLD.toEpochDay() - beginLD.toEpochDay();	    
		return ChronoUnit.DAYS.between(beginLD, endLD);
	}
	
	public static boolean dateBetween(String date, String startdate, String enddate){
		return dateMinus(startdate, date) > 0 && dateMinus(date, enddate) > 0;
	}
	
	public static String addDays(String date, long days) {
		LocalDate ld = parseDate(date).plusDays(days);
		return format(ld, pattern_date);
	}
	
	public static String addMonths(String date, long months) {
		LocalDate ld = parseDate(date).plusMonths(months);
		return format(ld, pattern_date);
	}
	
	public static String addYears(String date, long years) {
		LocalDate ld = parseDate(date).plusYears(years);
		return format(ld, pattern_date);
	}
	
	
	public static int getCurrentAge(String birthDate){
		LocalDate ldt = parseDate(birthDate);
		LocalDate nowDate = LocalDate.now();
		int currentYear = nowDate.getYear();
		int currentMonth = nowDate.getMonthValue();
		int currentDay = nowDate.getDayOfMonth();
		int birthYear = ldt.getYear();
		int birthMonth = ldt.getMonthValue();
		int birthDay = ldt.getDayOfMonth();
		int age = currentYear - birthYear;
		if(age < 0){
			throw new BaseUtilException("请输入正确的出生年份:[" + birthYear + "]");
		}
		if(currentMonth < birthMonth){
			age = age - 1;
		}else if(currentMonth == birthMonth){
			if(currentDay < birthDay){
				age = age - 1;
			}
		}
		return age;
	}
	
	public static void main(String[] args){
		String s = "20081231";
		System.out.println(getCurrentAge(s));
		System.out.println(parseDate(s).plusDays(2));
		String start = "20190123";
		String end = "20190223";
		String validDate = "2019/01/31";
		System.out.println(isDate(validDate));
		System.out.println(parseDate(validDate));
		System.out.println(dateMinus(start, end));
		System.out.println(dateBetween("20190131", start, end));
		System.out.println(addDays(end, -10));
	}
}
