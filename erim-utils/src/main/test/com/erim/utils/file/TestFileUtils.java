/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * TestFileUtils.java : 2012-11-27
 */
package com.erim.utils.file;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 宋哲
 * @version 创建时间：2012-11-27
 * @description 
 */
public class TestFileUtils {
    
    @Test
    public void testGetSuffixByFileName() {
        
        String str = "test.png";
        Assert.assertEquals(".png", FileUtils.getSuffixByFileName(str));
        
        str = "test.sss.png";
        Assert.assertEquals(".png", FileUtils.getSuffixByFileName(str));
        
        str = "test";
        Assert.assertEquals("", FileUtils.getSuffixByFileName(str));
    }
}
