package com.maguangcan.fake.example.fake;

import com.maguangcan.fake.IFakeConverter;
import com.maguangcan.fake.generate.StringGenerate;

import java.lang.annotation.Annotation;

//测试头像
public class FakeHeaderConverter implements IFakeConverter {

    @Override
    public Class annotationClass() {
        return FakeHeader.class;
    }

    @Override
    public Class targetClass() {
        return String.class;
    }

    private String[] headers = {
            "https://img3.duitang.com/uploads/item/201506/28/20150628184445_wLCGt.jpeg",
            "http://img3.imgtn.bdimg.com/it/u=3914950518,3569645197&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3443176063,4021563566&fm=26&gp=0.jpg",
            "http://img.52z.com/upload/news/image/20181108/20181108204521_83402.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3681314776,2030230321&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4138706082,2410427846&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=900692010,1380848729&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1261583998,1505908403&fm=11&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3988201624,2682701933&fm=11&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4145942749,3847567111&fm=11&gp=0.jpg",
    };

    @Override
    public Object fakeData(Annotation annotation) {
        return StringGenerate.getRandomStrings(headers);
    }

}
