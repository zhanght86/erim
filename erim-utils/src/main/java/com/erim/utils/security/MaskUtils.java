/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * MaskUtils.java : 2013-2-28 下午12:49:19
 */
package com.erim.utils.security;

/**
 * @author 宋哲
 * @version 创建时间：2013-02-28 下午12:49:19
 * @description 数组加密工具
 */
public class MaskUtils {

    private String strMask;

    private int    eBits;

    public MaskUtils() {
        strMask = "";
        eBits = 4;
    }

    public MaskUtils(String mask) {
        strMask = "";
        eBits = 4;
        strMask = mask;
    }

    public MaskUtils(String mask, int eb) {
        strMask = "";
        eBits = 4;
        strMask = mask;
    }

    public void setMaskString(String mask) {
        strMask = mask;
    }

    public void setEBits(int i) {
    }

    public String getMaskString() {
        return strMask;
    }

    public static int getMaskBits(String mask) {
        return mask.length() * 4;
    }

    public static String setMask(String mask, int ebits, int n, int v) {
        if (ebits <= 0)
            return mask;
        int index = n / ebits;
        int j = n % ebits;
        int l = 0;
        if (mask != null)
            l = mask.length();
        else
            mask = new String();
        if (index >= l) {
            for (int i = 0; i < (index - l) + 1; i++)
                mask = mask + '0';
        }
        byte b = (byte) mask.charAt(index);
        int m = b < 48 || b > 57 ? (b - 65) + 10 : b - 48;
        if (v > 0)
            m |= 128 >> (8 - ebits) + j;
        else
            m &= ~(128 >> (8 - ebits) + j);
        int mc = m < 0 || m > 9 ? (m - 10) + 65 : m + 48;
        char c = (char) (mc);
        char buf[] = new char[mask.length()];
        buf = mask.toCharArray();
        buf[index] = c;
        mask = new String(buf);
        return mask;
    }

    /**
     * 根据掩码继续追加掩码
     * 
     * @param mask 掩码，初始为"0"
     * @param n 需要追加的数值
     * @param v 默认为1
     * @return 转化后的掩码
     */
    public static String setMask(String mask, int n, int v) {
        return setMask(mask, 4, n, v);
    }

    public String setMask(int n, int v) {
        return setMask(strMask, eBits, n, v);
    }

    public static int getMask(String mask, int ebits, int n) {
        int eb = ebits;
        if (mask == null || eb <= 0)
            return 0;
        int index = n / eb;
        int j = n % eb;
        if (index >= mask.length()) {
            return 0;
        } else {
            byte b = (byte) mask.charAt(index);
            int m = b < 48 || b > 57 ? (b - 65) + 10 : b - 48;
            return (m & 128 >> (8 - eb) + j) <= 0 ? 0 : 1;
        }
    }

    /**
     * 检测掩码中是否存在某整型数据，若存在则返回true，不存在则返回false
     * 
     * @param mask 掩码，字符串
     * @param n 检测值，整型
     * @return boolean
     */
    public static boolean getMask(String mask, int n) {
        int i = getMask(mask, 4, n);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getMask(int n) {
        return getMask(strMask, eBits, n);
    }

    public static void main(String[] args) {
        String auth = "0";
        for (int i = 0; i < 2048; i++) {
            auth = MaskUtils.setMask(auth, i, 1);
        }
        System.out.println(auth);
        System.out.println(auth.length());
    }
}
