package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type List
 *
 *    @FakeList
 *    private List testList;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeList {

    Class valueClass() default Integer.class;

    Class mapKeyClass() default Integer.class;

    int lenght() default 5;//长度
}
