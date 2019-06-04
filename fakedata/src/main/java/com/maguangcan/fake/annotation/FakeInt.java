package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Generates data of type Int
 *
 *    @FakeInt
 *    private Int testInt;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeInt {

    int value() default 0;//默认值

    int min() default 0;//开始值

    int max() default 100;//结束值
}
