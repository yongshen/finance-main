package com.yong.finance.common.utils;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

public class EntityObjectConverter {
	 /* 
     * 实例化对象 
     */  
    private static DozerBeanMapper map = new DozerBeanMapper();  
      
    /** 
     * @Description: 将目标对象转换为指定对象，相同属性名进行属性值复制 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T getObject(Object source,Class<T> cls){  
        if (source==null) {  
            return null;  
        }  
        return (T) map.map(source, cls);  
    }  
      
    /** 
     * @Description: 两个对象之间相同属性名的属性值复制 
     */  
    public static void setObject(Object source,Object target){  
        map.map(source, target);  
    }  
      
    /** 
     * @Description: 对象集合中对象相同属性名的属性值复制 
     */  
    @SuppressWarnings("unchecked")  
    public static List getList(List source,Class cls){  
        List listTarget = new ArrayList();  
        if(source != null){  
            for (Object object : source) {  
                Object objTarget = EntityObjectConverter.getObject(object, cls);
                listTarget.add(objTarget);  
            }  
        }  
        return listTarget;  
    }  
}
