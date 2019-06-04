package com.maguangcan.fake;

import com.google.gson.Gson;
import com.maguangcan.fake.example.bean.TestFake;
import com.maguangcan.fake.example.fake.FakeStringConverter;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testFakeName() {
        FakeDataUtils.addFakeConverter(new FakeStringConverter());

        TestFake fake = FakeDataUtils.fake(TestFake.class);
        System.out.println("假数据：" + new Gson().toJson(fake));
    }


}