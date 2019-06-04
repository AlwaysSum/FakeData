package com.maguangcan.fake;

import java.lang.annotation.Annotation;

public interface IFakeConverter {

    Class annotationClass();

    Class targetClass();

    Object fakeData(Annotation annotation);
}
