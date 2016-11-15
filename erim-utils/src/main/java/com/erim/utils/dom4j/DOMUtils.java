/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * DOMUtils.java : 2012-8-21 下午2:39:16
 */
package com.erim.utils.dom4j;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

/**
 * @author 宋哲
 * @version 创建时间：2012-8-21 下午2:39:16
 * @description
 */
@SuppressWarnings("unchecked")
public class DOMUtils {

    /**
     * 获取某一节点下的所有叶子节点
     * 
     * @param element
     * @param elemList
     */
    public static void getElementList(Element element, List<Element> elemList) {
        // 若数据有问题则直接返回
        if (element == null || elemList == null) {
            return;
        }
        List<Element> elements = element.elements();
        if (elements.size() == 0) {
            // 没有子元素
            elemList.add(element);
        } else {
            // 有子元素
            for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
                Element e = (Element) it.next();
                // 递归遍历
                getElementList(e, elemList);
            }
        }
    }

    /**
     * 获取某一节点下的所有叶子节点,包括当前节点
     * 
     * @param element
     * @param elemList
     */
    public static void getElementChildList(Element element, List<Element> elemList) {
        // 若数据有问题则直接返回
        if (element == null || elemList == null) {
            return;
        }
        List<Element> elements = element.elements();
        if (elements.size() == 0) {
            // 没有子元素
            elemList.add(element);
        } else {
            elemList.add(element);
            // 有子元素
            for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
                Element e = (Element) it.next();
                // 递归遍历
                getElementChildList(e, elemList);
            }
        }
    }

    /**
     * 获取某一节点下的所有父节点，包括当前节点，不包括ROOT节点
     * 
     * @param element
     * @param elemList
     */
    public static void getElementParentList(Element element, List<Element> elemList) {
        if (!element.isRootElement()) {
            elemList.add(element);
            getElementParentList(element.getParent(), elemList);
        }
    }

}
