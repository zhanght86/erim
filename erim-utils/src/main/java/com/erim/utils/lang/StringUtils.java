/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * StringUtils.java : 2012-2-7 下午8:39:55
 */
package com.erim.utils.lang;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-7 下午8:39:55
 * @description
 */
public class StringUtils {

    private static int CH_CHAR_LENGTH = 2;

    /**
     * 截取开始和结束字符中间的字段
     * 
     * @param s String 将要截取的字符串
     * @param sStart String 起始字符
     * @param sEnd String 结束字符
     * 
     * @return String 截取后的字符串
     */
    public static String getStringByStartEnd(String s, String sStart, String sEnd) {
        if (s == null) {
            return "";
        }
        int iStart = s.indexOf(sStart);
        int iEnd = s.indexOf(sEnd);
        if (iStart == -1 || iEnd == -1) {
            return "";
        }
        return s.substring(iStart + sStart.length(), iEnd);
    }

    /**
     * 以新字符串替换字符串中的旧字符串
     * 
     * @param line 源字符串
     * @param oldString 将要替换的字符串
     * @param newString 替换后的字符串
     * 
     * @return String 替换后的字符串
     */
    public static String replace(String line, String oldString, String newString) {
        if (line == null) {
            return null;
        }
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = line.indexOf(oldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    /** 
     * 获取字符串的长度，如果有中文，则每个中文字符计为CH_CHAR_LENGTH位
     *
     * @param value
     *            指定的字符串
     * @return 字符串的长度
     */
    public static int lengthWithChinese(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += CH_CHAR_LENGTH;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * 根据HTTP的URL地址获取URI地址
     * 
     * @param URL地址
     * 
     * @return URI地址
     */
    public static String getURIBuURL(String url) {
        int i = url.indexOf("//");
        int j = url.indexOf("/", i + 2);
        return url.substring(j);
    }

}
