package org.oversky.util.number;

import java.util.Random;

import org.oversky.util.exception.BaseUtilException;

public class NumberUtils {

	private final static char[] NUMBER_CODES = {'0','1','2','3','4','5','6','7','8','9'};

	private NumberUtils(){}
	
	public static Long getRandomNumber(int length) {
		if(length > 18 || length < 1) {
			throw new BaseUtilException("错误的数字长度,支持长度在1-18之间");
		}
		char[] codes = new char[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			codes[i] = NUMBER_CODES[random.nextInt(NUMBER_CODES.length)];
		}
		if(codes[0] == '0') {
			codes[0] = '1';
		}
		String code = new String(codes);
		return Long.parseLong(code);
	}
	
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
