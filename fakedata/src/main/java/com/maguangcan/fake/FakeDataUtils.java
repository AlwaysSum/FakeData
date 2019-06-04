package com.maguangcan.fake;

import com.maguangcan.fake.annotation.FakeDouble;
import com.maguangcan.fake.annotation.FakeEmails;
import com.maguangcan.fake.annotation.FakeFloat;
import com.maguangcan.fake.annotation.FakeInt;
import com.maguangcan.fake.annotation.FakeList;
import com.maguangcan.fake.annotation.FakeMap;
import com.maguangcan.fake.annotation.FakeName;
import com.maguangcan.fake.annotation.FakePhone;
import com.maguangcan.fake.generate.NumGenerate;
import com.maguangcan.fake.generate.StringGenerate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDataUtils {


    //添加一个解析构造器
    public static void addFakeConverter(IFakeConverter... convertesr) {
        if (convertesr != null) {
            for (IFakeConverter cov : convertesr) {
                if (cov != null) {
                    FakeGenerateFactory.getIns().addFakeConverter(cov);
                }
            }
        }
    }

    /**
     * 获取一个 类的 假数据集合
     *
     * @param tClass
     * @param <T>
     * @return
     */
    //通过Class获取该类的属性注解，然后将其赋值并实例化
    public synchronized static <T> T fake(Class<T> tClass) {
        try {
            //如果对象为String:随机生成一个长度为十位数的字符串
            if (String.class.isAssignableFrom(tClass)) {
                return (T) StringGenerate.getRandomSentence();
                //数字
            } else if (int.class.isAssignableFrom(tClass) || Integer.class.isAssignableFrom(tClass)
                    || long.class.isAssignableFrom(tClass) || Long.class.isAssignableFrom(tClass)) {
                return (T) Integer.valueOf(NumGenerate.getRandomInt(1, 100));
                //小数
            } else if (float.class.isAssignableFrom(tClass) || Float.class.isAssignableFrom(tClass)) {
                return (T) Float.valueOf(NumGenerate.getRandomFloat(0f, 100f, 1));
            } else if (double.class.isAssignableFrom(tClass) || Long.class.isAssignableFrom(tClass)) {
                return (T) Double.valueOf(NumGenerate.getRandomDouble(0f, 100f, 2));
                //如果是List对象
            } else if (List.class.isAssignableFrom(tClass)) {
                throw new IllegalAccessException("该方法不支持List参数的使用，请替换为fakeList()!");
            } else if (Map.class.isAssignableFrom(tClass)) {
                throw new IllegalAccessException("该方法不支持Map参数的使用，请替换为fakeMap()!");
            } else {
                //通过构造方法生成类
                T obj = tClass.newInstance();
                //获取到所有的属性：
                Field[] tFields = tClass.getDeclaredFields();
                //遍历注解
                for (Field tf : tFields) {
                    tf.setAccessible(true);
                    tf.set(obj, fakeFieldOfValue(tf));
                }
                return obj;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("初始化一个假数据对象失败！");
    }


    /**
     * 解析一个类，并生成List对象
     *
     * @param tClass 解析类
     * @param lenght 类长度
     * @param <T>
     * @return
     */
    public synchronized static <T> List<T> fakeList(Class<T> tClass, int lenght) {
        List<T> listObj = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            //添加一个集合
            listObj.add(fake(tClass));
        }
        return listObj;
    }


    /**
     * 解析一个类，并生成Map对象
     *
     * @param kClass 解析类
     * @param vClass 解析类
     * @param lenght 类长度
     * @return
     */
    public static <K, V> Map<K, V> fakeMap(Class<K> kClass, Class<V> vClass, int lenght) {
        Map<K, V> mapObj = new HashMap<>();
        for (int i = 0; i < lenght; i++) {
            //添加一个集合
            mapObj.put(fake(kClass), fake(vClass));
        }
        return mapObj;
    }


    /**
     * 通过一个属性获取到 该属性所拥有的值
     *
     * @return
     */
    private static Object fakeFieldOfValue(Field field) {
        //如果该属性标记为：假姓名
        Class typeClass = field.getType();//获取属性
        //判断属性是

        //判断属性是不是String 类型
        if (String.class.isAssignableFrom(typeClass)) {
            //String 类型可以设置 假的名字
            if (field.isAnnotationPresent(FakeName.class)) {
                return FakeGenerateFactory.getIns().fakeName(field.getAnnotation(FakeName.class));
            } else if (field.isAnnotationPresent(FakePhone.class)) {
                return FakeGenerateFactory.getIns().fakePhone(field.getAnnotation(FakePhone.class));
            } else if (field.isAnnotationPresent(FakeEmails.class)) {
                return FakeGenerateFactory.getIns().fakeEmails(field.getAnnotation(FakeEmails.class));
            }
            //如果是数字类型:整形
        } else if (int.class.isAssignableFrom(typeClass) || Integer.class.isAssignableFrom(typeClass)
                || long.class.isAssignableFrom(typeClass) || Long.class.isAssignableFrom(typeClass)) {
            //可以设置假的数字
            if (field.isAnnotationPresent(FakeInt.class)) {
                //设置随机的数字
                return FakeGenerateFactory.getIns().fakeInt(field.getAnnotation(FakeInt.class));
            }
            //浮点类型：
        } else if (float.class.isAssignableFrom(typeClass) || Float.class.isAssignableFrom(typeClass)) {
            if (field.isAnnotationPresent(FakeFloat.class)) {
                //设置随机的数字
                return FakeGenerateFactory.getIns().fakeFloat(field.getAnnotation(FakeFloat.class));
            }
            //双精度小数
        } else if (double.class.isAssignableFrom(typeClass) || Double.class.isAssignableFrom(typeClass)) {
            if (field.isAnnotationPresent(FakeDouble.class)) {
                return FakeGenerateFactory.getIns().fakeDouble(field.getAnnotation(FakeDouble.class));
            }
        }
        //如果是list
        else if (List.class.isAssignableFrom(typeClass)) {
            //如果是一个list对象
            if (field.isAnnotationPresent(FakeList.class)) {
                //Size长度
                FakeList annotation = field.getAnnotation(FakeList.class);
                //获取list的泛型对象
                Type genericType = field.getGenericType();
                //根据Type获取List
                return parseListType(genericType, annotation);
            }
        } else if (Map.class.isAssignableFrom(typeClass)) {
            //如果是一个Map对象
            if (field.isAnnotationPresent(FakeMap.class)) {
                //Size长度
                FakeMap annotation = field.getAnnotation(FakeMap.class);
                //获取Map的泛型对象
                Type genericType = field.getGenericType();
                //根据Type获取List
                return parseMapType(genericType, annotation);
            }
        }
        //自定义的属性解析判断
        for (IFakeConverter converter : FakeGenerateFactory.getIns().getFakeConverter()) {
            if (converter.targetClass().isAssignableFrom(typeClass)) {
                if (field.isAnnotationPresent(converter.annotationClass())) {
                    return converter.fakeData(field.getAnnotation(converter.annotationClass()));
                }
            }
        }

        return null;
    }

    /**
     * 根据类型获取List
     */
    public static Object parseListType(Type type, FakeList annotation) {
        //如果不存在泛型
        if (type == null) {
            return fakeList(annotation.valueClass(), annotation.lenght());
        }
        //如果泛型为单个Class
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type ptType = pt.getActualTypeArguments()[0];
            //得到泛型里的class类型对象
            if (ptType instanceof Class<?>) {
                Class<?> genericClazz = (Class<?>) ptType;
                //如果List中包含List则返回一个双层list
                return fakeList(genericClazz, annotation.lenght());
                //如果泛型包含List之类的
            } else if (ptType instanceof ParameterizedType) {
                List list = new ArrayList();
                int ptLenght = ((ParameterizedType) ptType).getActualTypeArguments().length;
                //如果泛型为一个
                //则为泛型为List
                if (ptLenght == 1) {
                    for (int i = 0, j = annotation.lenght(); i < j; i++) {
                        list.add(parseListType(ptType, annotation));
                    }
                    //如果为俩个则为Map
                } else if (ptLenght == 2) {
                    for (int i = 0, j = annotation.lenght(); i < j; i++) {
                        //添加一个Map对象:默认的Map对象以Int为Key
                        list.add(parseMapType(ptType, newFakeMap(annotation.mapKeyClass(), annotation.valueClass(), annotation.lenght())));
                    }
                }
                return list;
            }
        }
        return null;
    }

    /**
     * 根据类型获取Map
     */
    public static Object parseMapType(Type type, FakeMap annotation) {
        //如果不存在泛型
        if (type == null) {
            return fakeMap(annotation.keyClass(), annotation.valueClass(), annotation.lenght());
        }
        //如果泛型为单个Class
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type keyType = pt.getActualTypeArguments()[0];
            Type valueType = pt.getActualTypeArguments()[1];
            //得到泛型里的class类型对象
            if (keyType instanceof Class<?> && valueType instanceof Class<?>) {
                Class<?> keyGenericClazz = (Class<?>) keyType;
                Class<?> valueGenericClazz = (Class<?>) valueType;
                //如果Map的Key和Value都为正常的类型
                return fakeMap(keyGenericClazz, valueGenericClazz, annotation.lenght());
                //如果泛型Value包含map或者list之类的
            } else if (keyType instanceof Class<?> && valueType instanceof ParameterizedType) {
                Class<?> keyGenericClazz = (Class<?>) keyType;
                Map map = new HashMap();
                int vLenght = ((ParameterizedType) valueType).getActualTypeArguments().length;
                for (int i = 0, j = annotation.lenght(); i < j; i++) {
                    //如果map的vaule为list
                    if (vLenght == 1) {
                        //将valueType生成一个List作为key
                        map.put(fake(keyGenericClazz), parseListType(valueType, newFakeList(annotation.keyClass(), annotation.valueClass(), annotation.lenght())));
                    } else if (vLenght == 2) {
                        //将valueType生成一个Map作为key
                        map.put(fake(keyGenericClazz), parseMapType(valueType, annotation));
                    }
                }
                return map;
                //如果只有Key包含了map或者list
            } else if (keyType instanceof ParameterizedType && valueType instanceof Class<?>) {
                Class<?> valueGenericClazz = (Class<?>) valueType;
                Map map = new HashMap();
                int kLenght = ((ParameterizedType) keyType).getActualTypeArguments().length;
                for (int i = 0, j = annotation.lenght(); i < j; i++) {
                    //如果map的vaule为list
                    if (kLenght == 1) {
                        //将KeyType生成一个List作为key
                        map.put(parseListType(keyType, newFakeList(annotation.keyClass(), annotation.keyClass(), annotation.lenght())), fake(valueGenericClazz));
                    } else if (kLenght == 2) {
                        //将KeyType生成一个Map作为key
                        map.put(parseMapType(keyType, annotation), fake(valueGenericClazz));
                    }
                }
                return map;
                //如果Key和Value都是List和Map的话
            } else if (keyType instanceof ParameterizedType && valueType instanceof ParameterizedType) {
                Map map = new HashMap();
                int kLenght = ((ParameterizedType) keyType).getActualTypeArguments().length;
                int vLenght = ((ParameterizedType) valueType).getActualTypeArguments().length;
                //根据长度生成数据
                for (int i = 0, j = annotation.lenght(); i < j; i++) {
                    //初始化Key
                    Object kObject = null;
                    if (kLenght == 1) {
                        //key为一个list
                        kObject = parseListType(keyType, newFakeList(annotation.keyClass(), annotation.keyClass(), annotation.lenght()));
                    } else if (kLenght == 2) {
                        //key为一个map
                        kObject = parseMapType(keyType, annotation);
                    }
                    if (kObject == null) return null; //Key做非空判断
                    //初始化Value
                    Object vObject = null;
                    if (vLenght == 1) {
                        //key为一个list
                        vObject = parseListType(valueType, newFakeList(annotation.keyClass(), annotation.valueClass(), annotation.lenght()));
                    } else if (kLenght == 2) {
                        //key为一个map
                        vObject = parseMapType(valueType, annotation);
                    }
                    map.put(kObject, vObject);
                }
                return map;
            }
        }
        return null;
    }

    //生成一个FakeList
    private static FakeList newFakeList(final Class mapKeyClass, final Class valueClass, final int lenght) {
        return new FakeList() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return FakeList.class;
            }

            @Override
            public Class valueClass() {
                return valueClass;
            }

            @Override
            public Class mapKeyClass() {
                return mapKeyClass;
            }

            @Override
            public int lenght() {
                return lenght;
            }
        };
    }

    //生成一个FakeMap
    private static FakeMap newFakeMap(final Class keyClass, final Class valueClass, final int lenght) {
        return new FakeMap() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return FakeMap.class;
            }

            @Override
            public Class keyClass() {
                return keyClass;
            }

            @Override
            public Class valueClass() {
                return valueClass;
            }

            @Override
            public int lenght() {
                return lenght;
            }
        };
    }


}
