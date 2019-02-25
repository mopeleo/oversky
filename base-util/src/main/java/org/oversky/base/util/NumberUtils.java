package org.oversky.base.util;

import java.util.regex.Pattern;

public class NumberUtils {

	private NumberUtils(){}
	
	/**
	 * 数字转换为二进制数组
	 * @param number
	 * @return
	 */
	public static int[] number2binaryArray(int number){
		String binaryString= Integer.toBinaryString(number);
		int    oneCount    = Integer.bitCount(number);
		int[]  binaryArray = new int[oneCount];
		
		int start = 0;
		int len   = binaryString.length();
		for(int i = 0 ; i < oneCount ; i ++){
			start = binaryString.indexOf("1", start);
			System.out.println("start :" + start);
			binaryArray[i] = 1<<(len-start-1);
			start ++;
		}
		return binaryArray;
	}
	
	/**
	 * 判断字符窜是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	
	
	public static void main(String[] args) {
		int num = 777;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.bitCount(num));
		long l = System.currentTimeMillis();
		int[] test = number2binaryArray(num);
		l = System.currentTimeMillis() - l;
		System.out.println("total times : " + l);
		for(int i : test){
			System.out.println(i);
		}
	}
}
