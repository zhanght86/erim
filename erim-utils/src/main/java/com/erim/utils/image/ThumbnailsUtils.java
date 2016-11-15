/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ThumbnailsUtils.java : 2012-12-11
 */
package com.erim.utils.image;

import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-11
 * @description 
 */
public class ThumbnailsUtils {

    /**
     * 根据传入的字符串返回Thumbnail水印位置
     * 
     * @param flag
     * @return
     */
    public static Position getPosition(String flag) {

        char f = flag.charAt(0);

        switch (f) {
        case '1':
            return Positions.BOTTOM_RIGHT;
        case '2':
            return Positions.BOTTOM_CENTER;
        case '3':
            return Positions.BOTTOM_LEFT;
        case '4':
            return Positions.CENTER_RIGHT;
        case '5':
            return Positions.CENTER;
        case '6':
            return Positions.CENTER_LEFT;
        case '7':
            return Positions.TOP_RIGHT;
        case '8':
            return Positions.TOP_CENTER;
        case '9':
            return Positions.TOP_LEFT;
        default:
            return Positions.BOTTOM_LEFT;
        }
    }

}
