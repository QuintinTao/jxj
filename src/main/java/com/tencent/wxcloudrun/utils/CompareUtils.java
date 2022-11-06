package com.tencent.wxcloudrun.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
    //传入日期，计算有效期，4年
    public static String calPeriodOfValidity(Timestamp starTime, int addYear){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(starTime);
        cal.add(Calendar.YEAR, 4);
        Date date = cal.getTime();
        return df.format(date);
    }
    public static String  sensitiveProtection(String target){
        if(target != null && target.length() > 1) {
            return target.replace(target.charAt(1), '*');
        }
        return target;
    }

    public static String  sensitiveProtectionMuti(String target){
        if(target != null && target.length() > 3) {
            return target.replace(target.charAt(1), '*').replace(target.charAt(2),'*').replace(target.charAt(3),'*');
        }
        return target;
    }

    public static void main(String[] args) {
//        Timestamp t = new Timestamp(1667267417000L);
//        System.out.println(CompareUtils.calPeriodOfValidity(t,4));
        System.out.println(sensitiveProtectionMuti("13889290880"));
    }
}
