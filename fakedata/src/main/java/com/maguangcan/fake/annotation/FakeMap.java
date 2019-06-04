package com.maguangcan.fake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generates data of type Map
 *
 *    @FakeMap
 *    private Map testMap;
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeMap {

    /**
     * Key
     *
     * @return
     */
    Class keyClass() default Integer.class;

    /**
     * value
     *
     * @return
     */
    Class valueClass() default String.class;

    int lenght() default 5;//长度
}
