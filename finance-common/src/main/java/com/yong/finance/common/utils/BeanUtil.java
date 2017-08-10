package com.yong.finance.common.utils;

import com.yong.finance.constants.Constants;
import com.yong.finance.persistence.base.BaseEntity;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Administrator on 2017/4/7.
 */
public class BeanUtil {
    public static <T extends BaseEntity> T entityInit(Class<T> entityClass) throws Exception {
        T entity = entityClass.newInstance();
        invokeMethod(entityClass, loadSetMethodName("createTime"), Date.class, entity, new Date());
        invokeMethod(entityClass, loadSetMethodName("updateTime"), Date.class, entity, new Date());
        return entity;
    }

    public static <T extends BaseEntity> T createEntityInit(Class<T> entityClass) {
        T entity = null;
        try {
            entity = entityClass.newInstance();
            invokeMethod(entityClass, loadSetMethodName("createTime"), Date.class, entity, new Date());
            invokeMethod(entityClass, loadSetMethodName("updateTime"), Date.class, entity, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
    private static String loadSetMethodName(String filedName) {
        return "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
    }

    private static void invokeMethod(Class<?> entityClass, String methodName, Class<?> paramaterType, Object entity, Object param) {
        try {
            entityClass.getMethod(methodName, paramaterType).invoke(entity, param);
        } catch (Exception e) {
        }
    }

    /**
     * 复制bean
     *
     * @param obj1
     * @param obj2
     * @author sxz
     */
    public static <T> void setObjectClone(T obj1, T obj2) {
        try {
            Class class_1 = obj1.getClass();
            Field[] fields = class_1.getDeclaredFields();
            Class class_2 = obj2.getClass();
            for (Field field : fields) {
                field.setAccessible(true);
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), class_2);
                Method getMethod = pd.getReadMethod();
                Object o = getMethod.invoke(obj1);
                if (o != null) {
                    field.set(obj2, field.get(obj1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * map转bean
     *
     * @param map
     * @param obj
     * @param <T>
     * @author sxz
     */
    public static <T> T mapToBean(Map<String, Object> map, T obj) {
        try {
            Class _class = obj.getClass();
            for (Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = String.valueOf(entry.getValue());
                try {
                    Field field = _class.getDeclaredField(key);
                    String type = field.getType().toString();
                    field.setAccessible(true);
                    field.set(obj, typeTotype(value, type));
                } catch (Exception e) {
                    continue;
                }
            }
            try {
                Field field = _class.getDeclaredField("updateTime");
                field.setAccessible(true);
                field.set(obj, new Date());
                field = _class.getDeclaredField("createTime");
                field.setAccessible(true);
                field.set(obj, new Date());
                field = _class.getDeclaredField("state");
                field.setAccessible(true);
                field.set(obj, Constants.False);
            } catch (Exception e) {
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    /**
     * 类型转换
     *
     * @param type
     * @param obj
     * @param <T>
     * @author sxz
     */
    public static Object typeTotype(String param, String type) {

        if (type.equals("class java.lang.String")) {
            return String.valueOf(param);
        } else if (type.equals("class java.lang.Integer")) {
            return Integer.parseInt(param);
        } else if (type.equals("class java.lang.Bouble")) {
            return Double.parseDouble(param);
        } else if (type.equals("int")) {
            return Integer.parseInt(param);
        } else if (type.equals("double")) {
            return Double.parseDouble(param);
        }
        return null;
    }

}
