package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Generates data of type Double
 *
 *    @FakeDouble
 *    private double testDouble;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeDouble {

    int value() default 0;//默认值

    double min() default 0.d;//开始值

    double max() default 1.d;//结束值

    int smallNum() default 2;//保留俩位小数
}
