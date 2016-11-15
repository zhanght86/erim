/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * AnalyticUtils.java : 2012-12-10
 */
package com.erim.flex.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.erim.core.exception.ErimException;
import com.erim.core.exception.SystemException;
import com.erim.core.lang.ExtHashMap;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.service.SqlService;
import com.erim.utils.lang.StringUtils;
import com.erim.utils.properties.PropertiesUtils;
import com.erim.utils.reflect.ReflectionUtils;
import com.erim.utils.spring.ContextUtils;

import flex.messaging.FlexContext;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-10
 * @description 解析组件标签
 */
@SuppressWarnings("unchecked")
public class ParseUtils {

    /**
     * 解析文本标签<br>
     * 1.[D]{xx},解析DataGrid选中第一行的字段<br>
     * 2.[S]{xx},解析session缓存的字段<br>
     * 3.[T]{xx},解析_inHashMap中datatemp中的内容，子service于before方法置入
     * 
     * @param bean 数据库对应的值
     * @param map flex传入的_inHashMap
     * 
     * @return 解析后的文本
     * 
     * @throws ErimException
     */
    public static String parseText(PageDetailBean bean, ExtHashMap<String, Object> map) throws ErimException {
        String text = bean.getText();
        String flag = StringUtils.getStringByStartEnd(text, "[", "]");
        String target = StringUtils.getStringByStartEnd(text, "{", "}");
        if ("".equals(flag) || "".equals(target)) {
            return bean.getText();
        }
        try {
            switch (flag.charAt(0)) {
            case 'D':
                return parseTextD(target, map);
            case 'S':
                return parseTextS(target);
            case 'T':
                return parseTextT(target, map);
            default:
                return "default";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(bean.getName() + "文本解析错误！\n\n" + e.getMessage());
        }
    }

    /**
     * 解析数据源标签<br>
     * 1.[C]{xx},解析代码表中对应的数据源<br>
     * 2.[M]{xx},解析反射方法对应的数据源<br>
     * 3.[N]{xx},解析反射方法对应的数据源，带参数map<br>
     * 4.[U]{xx},解析下划线对应的数据源<br>
     * 5.[S]{xx},解析执行SQL语句的数据源<br>
     * 
     * @param bean 数据库对应的值
     * 
     * @return 解析后的数据源对象
     */
    public static ExtHashMap<String, String> parseData(PageDetailBean bean, ExtHashMap<String, Object> map) throws ErimException {
        String data = bean.getData();
        String flag = StringUtils.getStringByStartEnd(data, "[", "]");
        String target = StringUtils.getStringByStartEnd(data, "{", "}");
        if ("".equals(flag) || "".equals(target)) {
            return null;
        }
        try {
            switch (flag.charAt(0)) {
            case 'C':
                return parseDataC(target);
            case 'M':
                return parseDataM(target);
            case 'N':
                return parseDataN(target, map);
            case 'U':
                return parseDataU(target);
            case 'S':
                return parseDataS(target);
            default:
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(bean.getName() + "数据源解析错误！\n\n" + e.getMessage());
        }
    }

    /**
     * 解析动作<br>
     * 1.[D]{xx},解析文件静态下载地址<br>
     * 2.[F]{xx},解析文件动态下载地址<br>
     * 3.[E]{xx},解析为flex端事件对应执行ActionScript方法，原字符返回不做处理<br>
     * 
     * @param bean 数据库对应的值
     * @param map flex传入的_inHashMap
     * 
     * @return 解析后的地址
     * 
     * @throws ErimException
     */
    public static String parseAction(PageDetailBean bean, ExtHashMap<String, Object> map) throws ErimException {
        String text = bean.getAction();
        String flag = StringUtils.getStringByStartEnd(text, "[", "]");
        String target = StringUtils.getStringByStartEnd(text, "{", "}");
        if ("".equals(flag)) {
            return bean.getAction();
        }
        try {
            switch (flag.charAt(0)) {
            case 'D':
                return parseActionD(target);
            case 'F':
                return parseActionF(target, map);
            case 'E':
                return text;
            default:
                return "default";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(bean.getName() + "动作解析错误！\n\n" + e.getMessage());
        }
    }

    /**
     * 解析从列表第一行获取值的文本
     * 
     * @param target
     * @param map
     * @return
     */
    private static String parseTextD(String target, ExtHashMap<String, Object> map) {
        Object o = ((ArrayList<HashMap<String, Object>>) map.get("dataitems")).get(0).get(target);
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    /**
     * 解析从session中获取的值
     * 
     * @param target
     * @param map
     * @return
     */
    private static String parseTextS(String target) {
        Object o = FlexContext.getFlexSession().getAttribute(target);
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    /**
     * 解析_inHashMap中datatemp中获取的值
     * 
     * @param target
     * @param map
     * @return
     */
    private static String parseTextT(String target, ExtHashMap<String, Object> map) {
        Object o = ((HashMap<String, Object>) map.get("datatemp")).get(target);
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    /**
     * 解析代码值类型的数据源
     * 
     * @param target
     * @return
     */
    private static ExtHashMap<String, String> parseDataC(String target) {
        return ErimUtils.getCodeByCodeId(target);
    }

    /**
     * 解析反射Bean下方法，获取数据源
     * 
     * @param target
     * @return
     */
    private static ExtHashMap<String, String> parseDataM(String target) throws Exception {
        String[] arrs = target.split(";");
        return (ExtHashMap<String, String>) ReflectionUtils.invokeMethod(ContextUtils.getContext().getBean(arrs[0]), arrs[1], null, null);
    }

    /**
     * 解析反射Bean下带参数的方法，获取数据源
     * 
     * @param target
     * @param map
     * @return
     */
    private static ExtHashMap<String, String> parseDataN(String target, ExtHashMap<String, Object> map) throws Exception {
        if (map == null) {
            return null;
        }
        String[] arrs = target.split(";");
        Class<?>[] a = { ExtHashMap.class };
        Object[] b = { map };
        return (ExtHashMap<String, String>) ReflectionUtils.invokeMethod(ContextUtils.getContext().getBean(arrs[0]), arrs[1], a, b);
    }

    /**
     * 解析下划线类型的数据源
     * 
     * @param target
     * @return
     */
    private static ExtHashMap<String, String> parseDataU(String target) {
        ExtHashMap<String, String> hashmap = new ExtHashMap<String, String>();
        String[] arrs = target.split(";");
        for (String item : arrs) {
            String[] items = item.split("_");
            hashmap.put(items[0], items[0] + ":" + items[1]);
        }
        return hashmap;
    }

    /**
     * 文件下载地址url，静态地址
     * 
     * @param target
     * @param map
     * @return
     */
    private static String parseActionD(String target) {
        if ("".equals(target)) {
            return PropertiesUtils.getPropertyByKey("app.file.url.down");
        } else {
            return PropertiesUtils.getPropertyByKey("app.file.url.down") + "/" + target;
        }
    }

    /**
     * 文件下载地址url，动态地址
     * 
     * @param target
     * @param map
     * @return
     */
    private static String parseActionF(String target, ExtHashMap<String, Object> map) {
        target = ((ArrayList<HashMap<String, Object>>) map.get("dataitems")).get(0).get(target).toString();
        return PropertiesUtils.getPropertyByKey("app.file.url.down") + "/" + target;
    }

    /**
     * 解析SQL类型的数据源
     * 
     * @param target
     * @return
     */
    private static ExtHashMap<String, String> parseDataS(String target) {
        ExtHashMap<String, String> hashmap = new ExtHashMap<String, String>();
        hashmap.put("sql", target);
        return ContextUtils.getContext().getBean("sql", SqlService.class).executeSql(hashmap);
    }

}