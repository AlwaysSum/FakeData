package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type Emails
 *
 *    @FakeEmails
 *    private String testEmails;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeEmails {

    //默认的电话
    String[] value() default {};

    int minLenght() default 5;

    int maxLenght() default 10;
}
