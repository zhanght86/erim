/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * TestImageUtils.java : 2012-12-7
 */
package com.erim.utils.security;

import junit.framework.TestCase;

import org.junit.Test;

import com.erim.core.exception.ErimException;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-7
 * @description 
 */
public class TestMaskUtils extends TestCase {

    @Test
    public void testMAsk() throws ErimException {

        // 初始化参数
        int[] a = new int[1024];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        // 转码
        String auth = "0";
        for (int s : a) {
            auth = MaskUtils.setMask(auth, s, 1);
        }

        // 输出
        assertEquals(
                "7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF8",
                auth);
        assertFalse(MaskUtils.getMask(auth, 0));
        assertTrue(MaskUtils.getMask(auth, 1));
    }
}
