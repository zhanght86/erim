/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * HashMap.java : 2012-2-13 上午1:49:37
 */
package com.erim.core.lang;

import java.util.HashMap;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-13 上午1:49:37
 * @description
 */
public class ExtHashMap<K, V> extends HashMap<K, V> {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = 1L;

    public String getString(String key) {
        if (get(key) == null) {
            return null;
        }
        return get(key).toString();
    }

    public int getInt(String key) {
        if (get(key) == null) {
            return 0;
        }
        return Integer.parseInt(get(key).toString());
    }

    public Integer getInteger(String key) {
        if (get(key) == null) {
            return null;
        }
        return Integer.valueOf(get(key).toString());
    }

    public Object getObject(String key) {
        return get(key);
    }

}
