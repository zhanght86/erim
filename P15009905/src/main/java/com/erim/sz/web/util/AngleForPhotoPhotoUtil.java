package com.erim.sz.web.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifDirectory;
import com.erim.utils.properties.PropertiesUtils;


/**
 * @ClassName: AngleForPhotoPhotoUtil 
 * @Description: 解决手机等移动设备中照片上传至服务器方向不正确的问题
 * @author maoxian
 * @date 2016年1月7日 下午11:39:02
 */
public class AngleForPhotoPhotoUtil {
	
	/**
	 * @Title: createUrl 
	 * @Description: 矫正图片
	 * @param @param url
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2016年1月7日 下午11:59:03 
	 * @throws
	 */
	public static String createUrl(String url){
		int getRotateAngleForPhoto = AngleForPhotoPhotoUtil.getRotateAngleForPhoto(url); 
		
		url = AngleForPhotoPhotoUtil.rotatePhonePhoto(url, getRotateAngleForPhoto);
		return url;
	}
	
	/**
	 * 获取图片正确显示需要旋转的角度（顺时针）
	 * 
	 * @return
	 */
	public static int getRotateAngleForPhoto(String filePath) {
		File file = new File(filePath);

		int angle = 0;

		Metadata metadata;
		try {
			metadata = JpegMetadataReader.readMetadata(file);
			Directory directory = metadata.getDirectory(ExifDirectory.class);
			if (directory.containsTag(ExifDirectory.TAG_ORIENTATION)) {

				// Exif信息中方向
				int orientation = directory.getInt(ExifDirectory.TAG_ORIENTATION);

				// 原图片的方向信息
				if (6 == orientation) {
					// 6旋转90
					angle = 90;
				} else if (3 == orientation) {
					// 3旋转180
					angle = 180;
				} else if (8 == orientation) {
					// 8旋转90
					angle = 270;
				}
			}
		} catch (JpegProcessingException e) {
			e.printStackTrace();
		} catch (MetadataException e) {
			e.printStackTrace();
		}

		return angle;
	}

	/**
	 * 旋转手机照片
	 * 
	 * @return
	 */
	public static String rotatePhonePhoto(String fullPath, int angel) {
		BufferedImage src;
		try {
			src = ImageIO.read(new File(fullPath));

			int src_width = src.getWidth(null);
			int src_height = src.getHeight(null);

			Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);

			BufferedImage res = new BufferedImage(rect_des.width, rect_des.height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = res.createGraphics();

			g2.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
			g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

			g2.drawImage(src, null, null);

			ImageIO.write(res, "jpg", new File(fullPath));

		} catch (IOException e) {

			e.printStackTrace();
		}

		return fullPath;

	}

	public static Rectangle CalcRotatedSize(Rectangle src, int angel) {
		if (angel >= 90) {
			if (angel / 90 % 2 == 1) {
				int temp = src.height;
				src.height = src.width;
				src.width = temp;
			}
			angel = angel % 90;
		}

		double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
		double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
		double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
		double angel_dalta_width = Math.atan((double) src.height / src.width);
		double angel_dalta_height = Math.atan((double) src.width / src.height);

		int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
		int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
		int des_width = src.width + len_dalta_width * 2;
		int des_height = src.height + len_dalta_height * 2;
		return new Rectangle(new Dimension(des_width, des_height));
	}
}
