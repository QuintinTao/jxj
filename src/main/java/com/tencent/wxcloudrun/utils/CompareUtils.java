package com.tencent.wxcloudrun.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareUtils {

    private CompareUtils(){}

    /**
     *
     * 按照指定对象的字段排序(正序)
     *
     * @param list
     * @param param 排序字段
     * @param <T>
     * @throws IntrospectionException
     */
    public static final <T> void ObjSort(List<T> list , String param) throws IntrospectionException {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Class<?> type = o1.getClass();
                PropertyDescriptor descriptor1 = null;
                try {
                    descriptor1 = new PropertyDescriptor( param, type );
                    Method readMethod1 = descriptor1.getReadMethod();

                    PropertyDescriptor descriptor2 = new PropertyDescriptor( param, type );
                    Method readMethod2 = descriptor2.getReadMethod();
                    return readMethod1.invoke(o1).toString().compareTo(readMethod2.invoke(o2).toString());
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        });
    }

    /**
     *
     * 按照指定对象的字段倒叙排序
     *
     * @param list
     * @param param 排序字段
     * @param <T>
     * @throws IntrospectionException
     */
    public static final <T> void ObjSortReversed(List<T> list, String param) throws IntrospectionException {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Class<?> type = o1.getClass();
                PropertyDescriptor descriptor1 = null;
                try {
                    descriptor1 = new PropertyDescriptor( param, type );
                    Method readMethod1 = descriptor1.getReadMethod();

                    PropertyDescriptor descriptor2 = new PropertyDescriptor( param, type );
                    Method readMethod2 = descriptor2.getReadMethod();

                    return readMethod1.invoke(o1).toString().compareTo(readMethod2.invoke(o2).toString());
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        }.reversed());
    }

    public static final Boolean  isEmpty(Collection<?> collection){
        return (collection == null || collection.isEmpty());
    }


}
