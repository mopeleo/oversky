package org.oversky.base.util;

import java.math.BigDecimal;

public class DoubleUtils {

	// 默认小数点保留位数
	private static int scale = 2;
	// 默认比较函数小数点位数
	private static int compare_scale = 8;
	
	public static double round(double value) {
		return format(value, scale, true);
	}
	
	public static double truncate(double value) {
		return format(value, scale, false);
	}
	/**
	 * 提供指定数值的小数位四舍五入处理。
	 * @param value 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double value, int scale) {
		return format(value, scale, true);
	}
	
	/**
	 * 提供指定数值的小数位截断处理。
	 * @param value 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double truncate(double value, int scale) {
		return format(value, scale, false);
	}
	
	/**
	 * double 类型 保留小数点后N位数四舍五入
	 * @param sourse       原数据
	 *        dotlength    小数点后位数
	 *        halfup       是否四舍五入
	 */
	private static double format(double sourse, int scale, boolean halfup){
		if (scale < 0) {
			throw new IllegalArgumentException("Double计算结果保留精度必须大于等于0");
		}
	    BigDecimal df = BigDecimal.valueOf(sourse);
	    double dest ;
	    if(halfup){
	        dest = df.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	    }else{
            dest = df.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
	    }
	    return dest;
	}
	
	/**
	 * 判断first是否大于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean gt(double first, double second){
		BigDecimal f = BigDecimal.valueOf(first).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		BigDecimal s = BigDecimal.valueOf(second).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		return f.compareTo(s) > 0;
	}
	
	/**
	 * 判断first是否小于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean lt(double first, double second){
		BigDecimal f = BigDecimal.valueOf(first).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		BigDecimal s = BigDecimal.valueOf(second).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		return f.compareTo(s) < 0;
	}
	
	/**
	 * 判断first是否等于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean eq(double first, double second){
		BigDecimal f = BigDecimal.valueOf(first).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		BigDecimal s = BigDecimal.valueOf(second).setScale(compare_scale, BigDecimal.ROUND_HALF_UP);
		return f.compareTo(s) == 0;
	}
	
	
	public static void main(String[] args) {
		double rst = 5.2456576323888888888888888124433;
		System.out.println(rst);
		BigDecimal b = BigDecimal.valueOf(rst);
		System.out.println(b);;
		System.out.println(b.setScale(10, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(format(rst, 2, true));
		String s = String.format("%.2f",rst);
		System.out.println(s);
		double first = 1.2;
		double second = 1.199999999999;
		System.out.println("lt : " + lt(first, second));
		System.out.println("gt : " + gt(first, second));
		System.out.println("eq : " + eq(first, second));
	}
}
