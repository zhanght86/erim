/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ImageUtils.java : 2012-12-6
 */
package com.erim.utils.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.erim.core.exception.ErimException;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-6
 * @description 
 */
public class ImageUtils {

    /** 水印位置中间 */
    public static String POSITION_CENTER              = "1";

    /** 水印位置右下角 */
    public static String POSITION_BOTTOM_RIGHT_CORNER = "2";

    /** 水印位置斜体 */
    public static String POSITION_ITALIC              = "3";

    /**
     * 图片按像素缩放
     * 
     * @param srcImgPath 原图路径
     * @param targerPath 目标路径
     * @param width 更改后的像素宽度
     * @param height 更改后的像素高度
     * 
     * @throws ErimException
     */
    public static void scale(String srcImgPath, String targerPath, int width, int height) throws ErimException {
        try {

            // 读取文件
            BufferedImage src = ImageIO.read(new File(srcImgPath));
            // 获取源图片宽高
            int widthSrc = src.getWidth(null);
            int heightSrc = src.getHeight(null);
            // 原始图片宽高比
            float proportion = (float) widthSrc / (float) heightSrc;
            // 定义处理后的图片存储空间
            BufferedImage tag = null;
            Graphics g = null;

            // 判断使用长度缩放还是使用高度缩放
            if (widthSrc / width > heightSrc / height) {
                height = 0;
            } else {
                width = 0;
            }

            if (width == 0) {
                // 获取等比例宽度
                float tmp_width = (float) height * proportion;
                tag = new BufferedImage((int) tmp_width, height, BufferedImage.TYPE_INT_RGB);
                g = tag.getGraphics();
                // 绘制缩放后的图像
                g.drawImage(src, 0, 0, (int) tmp_width, height, null);
            } else if (height == 0) {
                // 获取等比例高度
                float tmp_heigth = (float) width / proportion;
                tag = new BufferedImage(width, (int) tmp_heigth, BufferedImage.TYPE_INT_RGB);
                g = tag.getGraphics();
                // 绘制缩放后的图像
                g.drawImage(src, 0, 0, width, (int) tmp_heigth, null);
            }
            g.dispose();
            // 输出文件
            ImageIO.write(tag, "jpg", new File(targerPath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErimException("图片缩放过程中发生错误！");
        }
    }

    /**
     * 图片添加水印<br>
     * ex:ImageUtils.water(pressText, srcImgPath, targerPath, 45, Color.red,"黑体", 1, 30, 0.3f, ImageUtils.POSITION_ITALIC);
     * 
     * @param pressText 水印文字内容
     * @param srcImgPath 源图片路径
     * @param targerPath 目标路径
     * @param degree 旋转角度
     * @param color 文字颜色
     * @param fontname 字体名称
     * @param fontstyle 字体样式
     * @param fontsize 字体大小
     * @param alpha 透明度
     * @param position 水印显示位置
     * 
     * @throws ErimException
     */
    public static void water(String pressText, String srcImgPath, String targerPath, Integer degree, Color color, String fontname, int fontstyle, int fontsize, float alpha, String position)
            throws ErimException {
        try {
            // 获取源图片宽高
            Image srcImg = ImageIO.read(new File(srcImgPath));
            int width = srcImg.getWidth(null);
            int height = srcImg.getHeight(null);
            // 生成处理后的图片存储空间
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            Graphics2D g = buffImg.createGraphics();
            // 绘制当前可用图像
            g.drawImage(srcImg, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontname, fontstyle, fontsize));
            // 设置透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            // 水印的位置
            if (degree != null && POSITION_ITALIC.equals(position)) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
                g.drawString(pressText, width / 2 - (((getLength(pressText) * fontsize) / 2)), height / 2);
            } else {
                if (POSITION_CENTER.equals(position)) {
                    g.drawString(pressText, width / 2 - (getLength(pressText) * fontsize) / (pressText.length()), height / 2);
                } else if (POSITION_BOTTOM_RIGHT_CORNER.equals(position)) {
                    g.drawString(pressText, width - (pressText.length() * fontsize) - 10, height - (getLength(pressText) * fontsize) / (pressText.length()));
                }
            }
            g.dispose();
            // 生成后图片路径
            ImageIO.write(buffImg, "JPG", new File(targerPath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErimException("图片添加水印过程中发生错误！");
        }
    }

    /**
     * 计算水印文字长度 
     * @param text
     * @return
     */
    public final static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

}
