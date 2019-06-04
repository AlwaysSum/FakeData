package com.maguangcan.fake.example.bean;

import com.maguangcan.fake.annotation.FakeDouble;
import com.maguangcan.fake.annotation.FakeEmails;
import com.maguangcan.fake.annotation.FakeFloat;
import com.maguangcan.fake.annotation.FakeInt;
import com.maguangcan.fake.annotation.FakeList;
import com.maguangcan.fake.annotation.FakeMap;
import com.maguangcan.fake.annotation.FakePhone;
import com.maguangcan.fake.annotation.FakeName;
import com.maguangcan.fake.example.fake.FakeHeader;
import com.maguangcan.fake.example.fake.FakeString;

import java.util.List;
import java.util.Map;


//测试对象

public class TestFake {

    //随机生成的姓名
    @FakeString
    private String testDiv;

    @FakeHeader
    private String testHeader;

    @FakeName
    private String testName;


    @FakePhone
    private String testPhone;

    @FakeEmails
    private String testEmails;

    @FakeList
    private List<String> testList;

    @FakeMap
    private Map<Integer, String> testMap;

    //随机生成的整形
    @FakeInt
    private Integer testInt;

    @FakeInt(max = 40, min = 15)
    private Integer testAge;

    //随机生成的小数
    @FakeDouble
    private double testDouble;

    @FakeFloat
    private float testFloat;

    public TestFake() {
    }


    public String getTestName() {
        return testName;
    }

    public String getTestPhone() {
        return testPhone;
    }

    public String getTestEmails() {
        return testEmails;
    }

    public Integer getTestAge() {
        return testAge;
    }

    public String getTestHeader() {
        return testHeader;
    }
}
