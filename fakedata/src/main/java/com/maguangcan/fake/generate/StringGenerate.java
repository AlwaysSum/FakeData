package com.maguangcan.fake.generate;

import com.maguangcan.fake.RandomUtils;

import java.util.Random;

/**
 * 字符串随机生成器
 */
public class StringGenerate {


    //生成一个随机的字符串
    public static String getRandomString(int lenght) {
        return RandomUtils.getRandomChartAndNumber(lenght);
    }

    //获取一个数组中的随机字符串
    public static String getRandomStrings(String[] names) {
        if (names == null || names.length < 1) {
            return "";
        } else if (names.length == 1) {
            return names[0];
        } else {
            Random random = new Random();
            int index = random.nextInt(names.length);
            return names[index];
        }
    }

    /**
     * 返回手机号码
     */
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getPhone() {
        int index = NumGenerate.getRandomInt(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(NumGenerate.getRandomInt(1, 888) + 10000).substring(1);
        String third = String.valueOf(NumGenerate.getRandomInt(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    /**
     * 返回姓名
     */
    private static String firstName = "赵钱孙李周吴郑王冯陈蒋沈韩杨朱秦许何吕施张孔曹严魏陶姜谢苏潘葛范彭马方任袁柳史唐廉薛雷贺倪殷罗毕郝安常乐于傅齐康余顾孟黄穆萧尹姚邵汪祁毛米贝伏宋庞纪舒屈项祝董梁杜贾娄江郭梅林刁钟徐邱高夏蔡田胡凌虞柯卢莫丁邓";
    private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    //获取一个中文姓名
    public static String getChineseName(boolean isBoy) {
        int index = NumGenerate.getRandomInt(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        String str = isBoy ? boy : girl;//男孩的名字
        int length = str.length();
        index = NumGenerate.getRandomInt(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = NumGenerate.getRandomInt(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = NumGenerate.getRandomInt(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;
    }


    /**
     * 返回一个邮箱地址
     */
    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    public static String getEmail() {
        return getPhone() + email_suffix[(int) (Math.random() * email_suffix.length)];
    }

    /**
     * 返回一个随机的句子
     */
    public static final String[] englishSentence = {
            "Victory won’t e to me unless I go to it.",
            "Other men live to eat， while I eat to live.",
            "The brave and the wise can both pity and excuse，when cowards and fools shew no mercy.",
            "Truth is the daughter of time.",
            "You may be more happy than pinces，if you will be more virtuous.",
            "Cunning proceeds from want of capacity.",
            "It is never too late to mend.",
            "There is no man so bad，but he secretly respects the good.",
            "It's the easiest thing in the world for a man to deceive himself.",
            "The sting of a reproach，is the truth of it."
    };

    public static String getRandomSentence() {
        Random random = new Random();
        int index = random.nextInt(englishSentence.length);
        return englishSentence[index];
    }
}
