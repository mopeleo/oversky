package org.oversky.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleMath {

	// 默认小数点保留位数
	private static final int DIVIDE_SCALE = 10;
	private int scale = 2;
	private BigDecimal initVal;

	public DoubleMath(int initValue, int scale){
		this.scale = scale;
		this.initVal = new BigDecimal(Integer.toString(initValue));
	}

	public DoubleMath(Double initValue, int scale){
		this.scale = scale;
		this.initVal = doubleToBigDecimal(initValue);
	}
	
	public double doubleValue(){
		return doubleValue(this.scale);
	}
	
	public double doubleValue(int scale){
		return round(this.initVal.doubleValue(), scale);
	}
	
	/**
	 * 提供精确的加法运算
	 * @param value 加数
	 * @return 两个参数的和
	 */
	public DoubleMath add(Double value) {
		this.initVal = this.initVal.add(doubleToBigDecimal(value));
		return this;
	}

	/**
	 * 提供精确的减法运算
	 * @param value 减数
	 * @return 两个参数的差
	 */
	public DoubleMath sub(Double value) {
		this.initVal = this.initVal.subtract(doubleToBigDecimal(value));
		return this;
	}

	/**
	 * 提供精确的乘法运算
	 * @param value 乘数
	 * @return 两个参数的积
	 */
	public DoubleMath mul(Double value) {
		this.initVal = this.initVal.multiply(doubleToBigDecimal(value));
		return this;
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后10位，以后的数字四舍五入。
	 * @param divisor  除数
	 * @return 两个参数的商
	 */
	public DoubleMath div(Double divisor) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		this.initVal = this.initVal.divide(doubleToBigDecimal(divisor), DIVIDE_SCALE, RoundingMode.HALF_UP);
		return this;
	}

	/**
	 * double类型性转换为BigDecimal，为空Double类型初始化为0
	 * @param val
	 * @return
	 */
	private static BigDecimal doubleToBigDecimal(Double val){
		BigDecimal bd = null;
		if(val == null){
			bd = new BigDecimal("0");
		}else{
			bd = new BigDecimal(Double.toString(val));
		}
		return bd;
	}
	
	/**
	 * 提供指定数值的（精确）小数位四舍五入处理。
	 * @param value 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(Double value, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = doubleToBigDecimal(value);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * 判断first是否大于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean gt(Double first, Double second){
		BigDecimal f = doubleToBigDecimal(first);
		BigDecimal s = doubleToBigDecimal(second);
		return f.compareTo(s) > 0;
	}
	
	/**
	 * 判断first是否小于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean lt(Double first, Double second){
		BigDecimal f = doubleToBigDecimal(first);
		BigDecimal s = doubleToBigDecimal(second);
		return f.compareTo(s) < 0;
	}
	
	/**
	 * 判断first是否等于second
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean eq(Double first, Double second){
		BigDecimal f = doubleToBigDecimal(first);
		BigDecimal s = doubleToBigDecimal(second);
		return f.compareTo(s) == 0;
	}
	
	public static void main(String[] args) {
		DoubleMath dm = new DoubleMath(6, 2);
		double rst = dm.add(3.33).sub(null).mul(5.2898376263573888888888888888882783).doubleValue(10);
		System.out.println(rst);
		BigDecimal b = new BigDecimal(rst);
		System.out.println(b.toString());
		String s = String.format("%.2f",rst);
		System.out.println(s);
		
		System.out.println(eq(1.2, 1.20));
	}
}
