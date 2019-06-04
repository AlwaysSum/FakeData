package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type Phone
 *
 *    @FakePhone
 *    private String testPhone;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakePhone {

    //默认的电话
    String[] value() default {};

}
