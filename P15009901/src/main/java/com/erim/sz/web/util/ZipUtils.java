package com.erim.sz.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.erim.utils.properties.PropertiesUtils;

public class ZipUtils {
	/**
	 * @描述:远程文件打包下载 
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 下午7:42:22
	 * @param textList      为远程文件路径
	 * @param downloadName  下载到客户端的文件名
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static HttpServletResponse downLoadFiles(List<String> textList,String downloadName,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
	    try {
	        /**这个集合就是你想要打包的所有文件，
	         * 这里假设已经准备好了所要打包的文件*/
	        //List<File> files = new ArrayList<File>();
	 
	        /**创建一个临时压缩文件，
	         * 我们会把文件流全部注入到这个文件中
	         * 这里的文件你可以自定义是.rar还是.zip*/
	        File file = new File("c:/"+downloadName+".rar");
	        if (!file.exists()){   
	            file.createNewFile();   
	        }
	        response.reset();
	        //response.getWriter()
	        //创建文件输出流
	        FileOutputStream fous = new FileOutputStream(file);   
	        /**打包的方法我们会用到ZipOutputStream这样一个输出流,
	         * 所以这里我们把输出流转换一下*/
	        ZipOutputStream zipOut = new ZipOutputStream(fous);
	        /**这个方法接受的就是一个所要打包文件的集合，
	         * 还有一个ZipOutputStream*/
	        //textList为远程文件路径
	        zipFile(textList, zipOut);
	        zipOut.close();
	        fous.close();
	        return downloadZip(file,response);
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
	    /**直到文件的打包已经成功了，
	       * 文件的打包过程被我封装在FileUtil.zipFile这个静态方法中，
	       * 稍后会呈现出来，接下来的就是往客户端写数据了*/
	    return response ;
	}

	/**
	 * 把接受的全部文件打成压缩包 
	 * @param List<File>;  
	 * @param org.apache.tools.zip.ZipOutputStream  
	 */
	public static void zipFile(List files,ZipOutputStream outputStream) {
	    int size = files.size();
	    for(int i = 0; i < size; i++) {
	        String file = (String) files.get(i);
	        zipFile(file, outputStream);
	    }
	}

	public static HttpServletResponse downloadZip(File file,HttpServletResponse response) {
	    try {
	    // 以流的形式下载文件。
	    InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
	    byte[] buffer = new byte[fis.available()];
	    fis.read(buffer);
	    fis.close();
	    // 清空response
	    response.reset();

	    OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	    response.setContentType("application/octet-stream");

		//如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
	    response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(file.getName(), "UTF-8"));
	    toClient.write(buffer);
	    toClient.flush();
	    toClient.close();
	    } catch (IOException ex) {
	    ex.printStackTrace();
	    }finally{
	         try {
	                File f = new File(file.getPath());
	                f.delete();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	    }
	    return response;
	}

	/**  
	 * 根据输入的文件与输出流对文件进行打包
	 * @param File
	 * @param org.apache.tools.zip.ZipOutputStream
	 */
	public static void zipFile(String inputFile,
	        ZipOutputStream ouputStream) {
	    try {
	        if(true) {
	            if (StringUtils.isNotEmpty(inputFile)) {
	            	URL url = new URL(PropertiesUtils.getPropertyByKey("app.staticFileRes")+inputFile); 
	            	HttpURLConnection  conn = (HttpURLConnection)url.openConnection();  
	        		BufferedInputStream bins = new BufferedInputStream(conn.getInputStream());
	        		//获取文件名后缀
	        		int doc = inputFile.indexOf(".");
	        		if(doc >= 0){
	        			String suffix = inputFile.substring(doc,inputFile.length());
	        			ZipEntry entry = new ZipEntry(System.currentTimeMillis()+suffix);
		                ouputStream.putNextEntry(entry);
		                // 向压缩文件中输出数据   
		                int nNumber;
		                byte[] buffer = new byte[1024];
		                while ((nNumber = bins.read(buffer)) != -1) {
		                    ouputStream.write(buffer, 0, nNumber);
		                }
		                // 关闭创建的流对象   
		                bins.close();
		                //IN.close();
	        		}
	        		
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}