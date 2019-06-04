package com.maguangcan.fake.example;

import android.app.Application;

import com.maguangcan.fake.FakeDataUtils;
import com.maguangcan.fake.example.fake.FakeHeaderConverter;
import com.maguangcan.fake.example.fake.FakeStringConverter;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //添加转换器
        FakeDataUtils.addFakeConverter(
                new FakeStringConverter(),
                new FakeHeaderConverter());
    }
}
