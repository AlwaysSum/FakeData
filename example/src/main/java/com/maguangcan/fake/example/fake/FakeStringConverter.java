package com.maguangcan.fake.example.fake;

import com.maguangcan.fake.IFakeConverter;
import com.maguangcan.fake.generate.StringGenerate;

import java.lang.annotation.Annotation;

public class FakeStringConverter implements IFakeConverter {

    @Override
    public Class annotationClass() {
        return FakeString.class;
    }

    @Override
    public Class targetClass() {
        return String.class;
    }

    @Override
    public Object fakeData(Annotation annotation) {
        return StringGenerate.getChineseName(true);
    }

}
