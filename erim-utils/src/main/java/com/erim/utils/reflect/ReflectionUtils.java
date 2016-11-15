/**
 * Copyright (c) springside
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ReflectionUtils.java : Jan 18, 2010 3:47:33 PM
 */
package com.erim.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erim.core.exception.ErimException;

/**
 * @author springside.calvin
 * @version 创建时间：2011-10-9 上午10:23:07
 * @description Java反射工具集合
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ReflectionUtils {

    private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     * 
     * @param object 类对象
     * @param fieldName 属性名
     * 
     * @return result 属性值
     */
    public static Object getFieldValue(final Object object, final String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        if (field == null)
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        makeAccessible(field);
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     * 
     * @param object 类对象
     * @param filedName 属性名
     */
    public static void setFieldValue(final Object object, final String fieldName, final Object value) {
        Field field = getDeclaredField(object, fieldName);
        if (field == null)
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        makeAccessible(field);
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

    /**
     * 直接调用对象方法, 无视private/protected修饰符.
     * 
     * @param object 类对象
     * @param methodName 方法名
     * @param parameterTypes 参数类型数组
     * @param parameters 参数类型值数组
     * @throws TWSException
     */
    public static Object invokeMethod(final Object object, final String methodName, final Class<?>[] parameterTypes, final Object[] parameters) throws Exception {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (method == null)
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        method.setAccessible(true);
        try {
            return method.invoke(object, parameters);
        } catch (Exception e) {
            throw new ErimException(e.getCause().getMessage());
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField.
     * 
     * 如向上转型到Object仍无法找到, 返回null.
     */
    protected static Field getDeclaredField(final Object object, final String fieldName) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 强行设置Field可访问.
     */
    protected static void makeAccessible(final Field field) {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    /**
     * 循环向上转型,获取对象的DeclaredMethod.
     * 
     * 如向上转型到Object仍无法找到, 返回null.
     */
    protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 通过反射,获得Class定义中声明的父类的泛型参数的类型. 如无法找到
     * <p>
     * 返回Object.class. eg. public UserDao extends HibernateDao<User>
     * 
     * @param clazz The class to introspect
     * 
     * @return the first generic declaration, or Object.class if cannot be
     *         determined
     */
    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     * 
     * 如public UserDao extends HibernateDao<User,Long>
     * 
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * 
     * @return the index generic declaration, or Object.class if cannot be
     *         determined
     */
    public static Class getSuperClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }
        return (Class) params[index];
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成List.
     * 
     * @param collection 来源集合.
     * @param propertyName 要提取的属性名.
     */
    public static List convertElementPropertyToList(final Collection collection, final String propertyName) {
        List list = new ArrayList();
        try {
            for (Object obj : collection) {
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
        return list;
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串.
     * 
     * @param collection 来源集合.
     * @param propertyName 要提取的属性名.
     * @param separator 分隔符.
     */
    public static String convertElementPropertyToString(final Collection collection, final String propertyName, final String separator) {
        List list = convertElementPropertyToList(collection, propertyName);
        return StringUtils.join(list, separator);
    }

    /**
     * 转换字符串类型到clazz的property类型的值.
     */
    public static Object convertValue(Object value, Class<?> toType) {
        try {
            DateConverter dc = new DateConverter();
            dc.setUseLocaleFormat(true);
            dc.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
            ConvertUtils.register(dc, Date.class);
            return ConvertUtils.convert(value, toType);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException || e instanceof NoSuchMethodException)
            return new IllegalArgumentException("Reflection Exception1.", e);
        else if (e instanceof InvocationTargetException)
            return new RuntimeException("Reflection Exception2.", ((InvocationTargetException) e).getTargetException());
        else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    /**
     * 得到某个指定类的实例
     * 
     * @param <T> 返回实例对象的类型
     * @param c 实例对象的描述信息
     * @param type 实例对象的全路径名
     * 
     * @return 返回新创建的实例对象
     */
    public static <T> T getInstance(Class<T> c, String type) {
        try {
            Class clazz = Class.forName(type);
            return (T) clazz.newInstance();
        } catch (Exception e) {
            logger.error("反射实例化路径错误！", e.getMessage());
            return null;
        }
    }

}