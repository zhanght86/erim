/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * TestImageUtils.java : 2012-12-7
 */
package com.erim.utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

import org.junit.Test;

import com.erim.core.exception.ErimException;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-7
 * @description 
 */
public class TestImageUtils extends TestCase {

    @Test
    public void testScale() throws ErimException {
        // 原始图片为高度大于宽度
        ImageUtils.scale("D://share//test.jpg", "D://share//test2.jpg", 100, 100);
        // 读取文件
        BufferedImage src = null;
        try {
            src = ImageIO.read(new File("D://share//test2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取源图片宽高
        int widthSrc = src.getWidth(null);
        int heightSrc = src.getHeight(null);
        assertEquals(100, heightSrc);
        assertEquals(true, widthSrc < 100);
    }

}
