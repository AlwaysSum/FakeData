package com.maguangcan.fake;

import com.maguangcan.fake.annotation.FakeDouble;
import com.maguangcan.fake.annotation.FakeEmails;
import com.maguangcan.fake.annotation.FakeFloat;
import com.maguangcan.fake.annotation.FakeInt;
import com.maguangcan.fake.annotation.FakeName;
import com.maguangcan.fake.annotation.FakePhone;
import com.maguangcan.fake.generate.NumGenerate;
import com.maguangcan.fake.generate.StringGenerate;

import java.util.ArrayList;
import java.util.List;

/**
 * 假数据自动生成的工厂
 */
class FakeGenerateFactory {

    private static List<IFakeConverter> fakeConverter;


    public List<IFakeConverter> getFakeConverter() {
        return fakeConverter;
    }


    public FakeGenerateFactory addFakeConverter(IFakeConverter converter) {
        if (fakeConverter == null) {
            fakeConverter = new ArrayList<>();
        }
        if (converter != null) {
            fakeConverter.add(converter);
        }
        return this;
    }

    /**
     * 解析fakeName
     *
     * @param annotation
     * @return
     */
    //根据不同的注解进行不同的解析
    public Object fakeName(FakeName annotation) {
        //如果该class为String
        if (annotation.value() == null || annotation.value().length < 1) {
            return StringGenerate.getChineseName(annotation.isBoy());
        } else {
            return StringGenerate.getRandomStrings(annotation.value());
        }
    }

    //解析电话号码
    public Object fakePhone(FakePhone annotation) {
        //如果该class为String
        if (annotation.value() == null || annotation.value().length < 1) {
            return StringGenerate.getPhone();
        } else {
            return StringGenerate.getRandomStrings(annotation.value());
        }
    }

    //解析邮箱号码
    public Object fakeEmails(FakeEmails annotation) {
        //如果该class为String
        if (annotation.value() == null || annotation.value().length < 1) {
            return StringGenerate.getEmail();
        } else {
            return StringGenerate.getRandomStrings(annotation.value());
        }
    }


    /**
     * 解析数值
     *
     * @param annotation
     * @return
     */
    //解析int类型
    public Object fakeInt(FakeInt annotation) {
        //如果没有设置默认值：则随机生成数据
        if (annotation.value() == 0) {
            return NumGenerate.getRandomInt(annotation.min(), annotation.max());
        }
        return annotation.value();
    }

    //解析double类型
    public Object fakeDouble(FakeDouble annotation) {
        if (annotation.value() == 0) {
            //如果该class为String
            return NumGenerate.getRandomDouble(annotation.min(), annotation.max(), annotation.smallNum());
        }
        return annotation.value();
    }

    //解析float类型
    public Object fakeFloat(FakeFloat annotation) {
        if (annotation.value() == 0) {
            //如果该class为String
            return NumGenerate.getRandomFloat(annotation.min(), annotation.max(), annotation.smallNum());
        }
        return annotation.value();
    }

    /**
     * ==================================================================
     * 单例模式
     */
    private static FakeGenerateFactory sInstance;

    private FakeGenerateFactory() {
    }

    public static FakeGenerateFactory getIns() {
        if (sInstance == null) {
            sInstance = new FakeGenerateFactory();
            fakeConverter = new ArrayList<>();
        }
        return sInstance;
    }

}
