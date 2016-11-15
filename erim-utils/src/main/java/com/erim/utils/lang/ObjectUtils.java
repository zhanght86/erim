/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ObjectUtils.java : 2012-12-11
 */
package com.erim.utils.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-11
 * @description 
 */
public class ObjectUtils {

    /**
     * 根据序列化与反序列化，深度复制一个对象
     * 
     * @param src
     * @return
     */
    public static Object deepClone(Object src) {
        Object dst = null;

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(out);
            oo.writeObject(src);
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(in);
            dst = oi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dst;
    }

}
