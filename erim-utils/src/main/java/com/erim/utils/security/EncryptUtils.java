/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * EncryptUtils.java : 2013-2-28 下午12:49:19
 */
package com.erim.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 宋哲
 * @version 创建时间：2013-02-28 下午12:49:19
 * @description 加密工具
 */
public class EncryptUtils {
    
    /**
     * 获取密码的hash值
     * 
     * @param pass 密码
     * @return
     */
    public static String pass_hash(String pass) {
        if (pass == null || pass.length() == 0)
            return "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte mhash[] = md.digest(pass.getBytes());
        char sopin[] = new char[40];
        int n = 0;
        for (int i = 0; i < 20; i++) {
            n = ((mhash[i] >> 4) & 0x0F);
            sopin[i * 2 + 0] = (char) ((n >= 0 && n <= 9) ? ('0' + n) : ('a' + (n - 10)));
            n = (mhash[i] & 0x0F);
            sopin[i * 2 + 1] = (char) ((n >= 0 && n <= 9) ? ('0' + n) : ('a' + (n - 10)));
        }
        return new String(sopin);
    }
}
