package org.oversky.util.format;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.oversky.util.date.DateUtils;
import org.oversky.util.exception.BaseUtilException;

public class IDCodeUtils {

	/**
	 * 身份证号码验证 
	 * 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。
	 * 排列顺序从左至右依次为：六位数字地址码， 八位数字出生日期码，三位数字顺序码和一位数字校验码。 
	 * 2、地址码(前六位数） 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。
	 * 3、出生日期码（第七位至十四位） 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
	 * 4、顺序码（第十五位至十七位） 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。
	 * 5、校验码（第十八位数）
	 * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
	 * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 
	 * （2）计算模 Y = mod(S, 11) 
	 * （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2 
	 */

	public static int[] Wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
	public static String[] ValCodeArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
	
	public static boolean validateIDCode(String IDCode) {
		//效验身份证长度
		if (IDCode == null || (IDCode.length() != 15 && IDCode.length() != 18)) {
			return false;
		}
		
		String Ai = "";
		if (IDCode.length() == 18) {
			Ai = IDCode.substring(0, 17);
		} else {
			Ai = IDCode.substring(0, 6) + "19" + IDCode.substring(6, 15);
		}
		
		//身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。
		if (!isDigital(Ai)) {
			return false;
		}
		
		//身份证出生年月
		String year = Ai.substring(6, 10);
		String birth = Ai.substring(6, 14);
		if (!DateUtils.isDate(birth)) {
			return false;
		}
		
		//身份证出生年月不在有效范围
		if ((LocalDate.now().getYear() - Integer.parseInt(year)) > 150
				|| DateUtils.dateMinus(birth, DateUtils.getNowDate()) <= 0) {
			return false;
		}
		
		//身份证地区编码错误
		Map<?, ?> h = getIDCodeAreaCode();
		if (h.get(Ai.substring(0, 2)) == null) {
			return false;
		}
		
		if (IDCode.length() == 18) {
			// 判断最后一位的值
			Ai += getLastCharAtIDCode(Ai);
			
			return Ai.equals(IDCode);
		}
		
		return true;
	}
	
	public static String get18IDCode(String IDCode){
		if(!validateIDCode(IDCode)){
			throw new BaseUtilException("错误的身份证号码");
		}
		
		if(IDCode.length() == 18){
			return IDCode;
		}
		
		String IDCode17 = IDCode.substring(0, 6) + "19" + IDCode.substring(6, 15);
		IDCode17 += getLastCharAtIDCode(IDCode17);
		return IDCode17;
	}
	
	public static String getIDCodeArea(String IDCode){
		if(!validateIDCode(IDCode)){
			throw new BaseUtilException("错误的身份证号码");
		}
		
		String areaCode = IDCode.substring(0, 2);
		return getIDCodeAreaCode().get(areaCode);		
	}
	
	public static HashMap<String, String> getIDCodeAreaCode() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("11", "北京");
		map.put("12", "天津");
		map.put("13", "河北");
		map.put("14", "山西");
		map.put("15", "内蒙古");
		map.put("21", "辽宁");
		map.put("22", "吉林");
		map.put("23", "黑龙江");
		map.put("31", "上海");
		map.put("32", "江苏");
		map.put("33", "浙江");
		map.put("34", "安徽");
		map.put("35", "福建");
		map.put("36", "江西");
		map.put("37", "山东");
		map.put("41", "河南");
		map.put("42", "湖北");
		map.put("43", "湖南");
		map.put("44", "广东");
		map.put("45", "广西");
		map.put("46", "海南");
		map.put("50", "重庆");
		map.put("51", "四川");
		map.put("52", "贵州");
		map.put("53", "云南");
		map.put("54", "西藏");
		map.put("61", "陕西");
		map.put("62", "甘肃");
		map.put("63", "青海");
		map.put("64", "宁夏");
		map.put("65", "新疆");
		map.put("71", "台湾");
		map.put("81", "香港");
		map.put("82", "澳门");
		map.put("91", "国外");
		
		return map;
	}

	public static String getIDCodeBirthday(String IDCode){
		if(!validateIDCode(IDCode)){
			throw new BaseUtilException("错误的身份证号码");
		}
		
		if(IDCode.length() == 15){
			IDCode = get18IDCode(IDCode);
		}
		
		return IDCode.substring(6, 14);
	}
	
	private static String getLastCharAtIDCode(String IDCode17){
		int totalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			totalmulAiWi += Integer.parseInt(String.valueOf(IDCode17.charAt(i)))* Wi[i];
		}
		int modValue = totalmulAiWi % 11;
		return ValCodeArr[modValue];
	}
	
	private static boolean isDigital(String str) {
        return str.matches("^[0-9]*$");
    }	
	
	public static void main(String[] args) {
		String IDCode = "111111111111111";
		System.out.println(validateIDCode(IDCode));
		System.out.println(getIDCodeArea(IDCode));
		System.out.println(getIDCodeBirthday(IDCode));
	}
}
