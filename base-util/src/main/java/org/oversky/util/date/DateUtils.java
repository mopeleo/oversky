package org.oversky.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.oversky.util.exception.BaseUtilException;
import org.oversky.util.regex.RegExCheck;

public class DateUtils {

	public static final String pattern_time = "HHmmss";
	public static final String pattern_date = "yyyyMMdd";
	public static final String pattern_datetime = "yyyyMMddHHmmss";

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
		if(RegExCheck.isDate(date)) {
			if(date.length() == 10) {
				date8 = date.substring(0, 4) + date.substring(5,7) + date.substring(8);
			}
			return LocalDate.parse(date8, DateTimeFormatter.ofPattern(pattern_date));
		}else {
			throw new BaseUtilException("请输入正确的日期格式字符串");
		}
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
		System.out.println(parseDate(validDate));
		System.out.println(dateMinus(start, end));
		System.out.println(dateBetween("20190131", start, end));
		System.out.println(addDays(end, -10));
	}
}
