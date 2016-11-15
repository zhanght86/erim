package com.erim.sz.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.URL;  
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;  

/**
 * @ClassName: DownloadImageUtil
 * @Description: 图片下载
 * @author maoxian
 * @date 2015年12月25日 下午6:43:47
 */
public class ImageUtil {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		download("http://file.jialvlianhe.com/res/cpy/189/upload/20151222/aca1d9a7304b49d7965c98f6ca58562f.png", "51bi.gif", "/Users/maoxian/Downloads/");
	}

	/**
	 * @Title: download 
	 * @Description: 下载图片
	 * @param @param urlString
	 * @param @param filename
	 * @param @param savePath
	 * @param @throws Exception    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午6:53:10 
	 * @throws
	 */
	public static String download(String urlString, String filename, String savePath) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		String lastSave = sf.getPath() + "/" + filename;
		OutputStream os = new FileOutputStream(lastSave);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
		
		return lastSave;
	}
	
	/**
	 * @Title: deleteFile 
	 * @Description: 图片删除
	 * @param @param filePath    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午6:54:13 
	 * @throws
	 */
	public static void deleteFile(String filePath){
		File file=new File(filePath);
		file.delete();
	}
	
	/**
	 * @Title: getImgStr 
	 * @Description: 图片转为64位编码
	 * @param @param imgFile
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午6:55:31 
	 * @throws
	 */
	public static String getImgStr(String imgFile) {
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
	}
}
