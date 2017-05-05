package br.order.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class ReturnValueUtils {

    // 如果返回值是单个对象中的字段,默认填入显示字段
    public static JSONObject commonValue(Object object, String str)
            throws IllegalArgumentException, IllegalAccessException {
        String[] split = str.split(",");
        JSONObject obj = new JSONObject();
        if (object != null) {
            Class clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                for (String s : split) {
                    if (field.getName().equals(s)) {
                        obj.put(s, field.get(object));
                        break;
                    }
                }
            }
        }
        return obj;
    }

    // 如果返回值是单个对象中的字段,填入非显示字段,重载方法
    public static JSONObject commonValue(Object object, String str, boolean flag)
            throws IllegalArgumentException, IllegalAccessException {
        JSONObject obj = new JSONObject();
        if (object != null) {
            if (flag == true) {
                commonValue(object, str);
            }
            else {
                String[] split = str.split(",");
                Class clazz = object.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    obj.put(field.getName(), field.get(object));
                    for (String s : split) {
                        if (field.getName().equals(s)) {
                            obj.remove(field.getName());
                            break;
                        }
                    }
                }
            }
        }
        return obj;
    }

    // 如果返回值是list，填入显示字段
    public static <E> List<JSONObject> listValue(List<E> list, String str)
            throws IllegalArgumentException, IllegalAccessException {
        List<JSONObject> lists = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object object = list.get(i);
                JSONObject jsonObject = commonValue(object, str);
                lists.add(jsonObject);
            }
        }
        return lists;
    }

    // 如果返回值是list，填入非显示字段
    public static <E> List<JSONObject> listValue(List<E> list, String str, boolean flag)
            throws IllegalArgumentException, IllegalAccessException {
        if (flag == false) {
            List<JSONObject> lists = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Object object = list.get(i);
                    JSONObject jsonObject = commonValue(object, str, flag);
                    lists.add(jsonObject);
                }
            }
            return lists;
        }
        else {
            return listValue(list, str);
        }
    }

}
