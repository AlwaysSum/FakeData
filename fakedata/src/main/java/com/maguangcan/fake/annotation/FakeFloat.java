package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type Float
 *
 *    @FakeFloat
 *    private Float testFloat;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeFloat {

    int value() default 0;//默认值

    float min() default 0.f;//开始值

    float max() default 1.f;//结束值

    int smallNum() default 2;//保留俩位小数
}
