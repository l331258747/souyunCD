package com.xrwl.fleet.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalUtil {


    /**
     * 金钱乘法
     */
    public static float multiply(float f1, float f2) {
        String v1 = Float.toString(f1);
        String v2 = Float.toString(f2);
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);

        float value = b1.multiply(b2).floatValue();

        return value;
    }


    /**
     * 金钱加法
     */
    public static float add(float f1, float f2) {
        String v1 = Float.toString(f1);
        String v2 = Float.toString(f2);
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        float value = b1.add(b2).floatValue();
        return value;
    }

    /**
     * 乘法
     *
     * @param v1    乘数
     * @param v2    被乘数
     * @param scale 小数点保留位数
     */
    public static String multiplyWithScale(String v1, String v2, int scale) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        BigDecimal result = b1.multiply(b2);
        result = result.setScale(scale);
        return result.toString();
    }

    /**
     * 金钱除法
     */
    public static float divide(float f1, float f2) {
        String v1 = Float.toString(f1);
        String v2 = Float.toString(f2);
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        float value = b1.divide(b2).floatValue();
        return value;
    }

    /**
     * 金钱除法
     */
    public static String divide(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);

        return b1.divide(b2).toString();
    }

    /**
     * 如果除不断，产生无限循环小数，那么就会抛出异常，解决方法就是对小数点后的位数做限制
     *
     * @param v2 小数模式 ，DOWN，表示直接不做四舍五入，参考{@link RoundingMode}
     */
    public static String divideWithRoundingDown(String v1, String v2) {
        return divideWithRoundingMode(v1, v2, RoundingMode.DOWN);
    }

    /**
     * 选择小数部分处理方式
     */
    public static String divideWithRoundingMode(String v1, String v2, RoundingMode roundingMode) {
        return divideWithRoundingModeAndScale(v1, v2, RoundingMode.DOWN, 0);
    }

    /**
     * 选择小数点后部分处理方式，以及保留几位小数
     *
     * @param v1           除数
     * @param v2           被除数
     * @param roundingMode 小数处理模式
     * @param scale        保留几位
     */
    public static String divideWithRoundingModeAndScale(String v1, String v2,
                                                        RoundingMode roundingMode, int scale) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, roundingMode).toString();
    }

    /**
     * 金钱减法
     */
    public static String subtract(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);

        return b1.subtract(b2).toString();
    }

    /**
     * 金钱减法
     */
    public static float subtract(float f1, float f2) {
        String v1 = Float.toString(f1);
        String v2 = Float.toString(f2);
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        float value = b1.subtract(b2).floatValue();
        return value;
    }
}