package com.maguangcan.fake.generate;

import java.math.BigDecimal;

public class NumGenerate {

    /**
     * 生成一个范围内的随机数字
     */
    public static int getRandomInt(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

    /**
     * 生成一个范围内的随机数字
     */
    public static double getRandomDouble(double min, double max,int smallNum) {
        double num = Math.random() * (max - min) + min;
        return new BigDecimal(num).setScale(smallNum, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 生成一个范围内的随机数字
     */
    public static float getRandomFloat(double min, double max,int smallNum) {
        double num = Math.random() * (max - min) + min;
        return new BigDecimal(num).setScale(smallNum, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
