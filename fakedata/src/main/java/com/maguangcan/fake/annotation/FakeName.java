package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type Name
 *
 *    @FakeName
 *    private String testName;
 */
//可以注解 字段、枚举、方法参数
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)  //运行时通过反射获取
public @interface FakeName {

    String[] value() default {};

    boolean isBoy() default  true;

}
