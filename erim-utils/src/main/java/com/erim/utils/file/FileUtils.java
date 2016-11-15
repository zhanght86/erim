/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FileUtils.java : 2012-11-27
 */
package com.erim.utils.file;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 宋哲
 * @version 创建时间：2012-11-27
 * @description 
 */
public class FileUtils {

    private static final int           MAX_SERIAL = 999999;

    private static final AtomicInteger atomic     = new AtomicInteger();

    /**
     * 获取线程安全的自增序列
     *  
     * @return 自增序列
     */
    private static int getNextInteger() {
        int value = atomic.incrementAndGet();
        if (value >= MAX_SERIAL) {
            atomic.set(0);
        }
        return value;
    }

    /**
     * 根据时间及自增序列获取唯一值
     * 
     * @return 唯一文件名
     */
    public static String getFileName() {
        int serial = getNextInteger();
        long millsec = System.currentTimeMillis();
        return String.format("%13d_%06d", millsec, serial);
    }

    /**
     * 根据不同的系统，处理路径
     * 
     * @param path 以"/"分隔的路径
     * @return
     */
    public static String dealFilePath(String path) {
        // 根据不同的系统获取真实路径
        String[] ads = path.split("/");
        String newpath = ads[0];
        for (int i = 1; i < ads.length; i++) {
            newpath += File.separator + ads[i];
        }
        return newpath;
    }

    /**
     * 根据文件上传的ID获取批次号
     * 
     * @param id 文件ID
     * @return 批次号
     */
    public static String getBatchByFileId(String id) {
        String[] ads = id.split("_");
        return ads[0] + "_" + ads[1];
    }

    /**
     * 根据文件名返回文件后缀，带点号
     * 
     * @param filename
     * @return
     */
    public static String getSuffixByFileName(String filename) {
        if (filename.contains(".")) {
            String[] ads = filename.split("[.]");
            return "." + ads[ads.length - 1];
        }
        return "";
    }

    /**
     * 根据文件名返回文件除后缀之外的部分
     * 
     * @param filename
     * @return
     */
    public static String getPreNameByFileName(String filename) {
        String suffix = getSuffixByFileName(filename);
        if ("".equals(suffix)) {
            return filename;
        } else {
            return filename.substring(0, filename.length() - suffix.length());
        }
    }
}