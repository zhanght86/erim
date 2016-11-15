package com.erim.sz.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * @Title: UploadFile.java
 * @Package com.erim.sz.web.util
 * @Description: TODO(文件或附件上传)
 * @author 于宪洋
 * @date 2015年8月20日 下午10:19:16
 * @version V1.0
 */

public class UploadFile {
	
	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 	上传文件
	 * @param @param 	request
	 * @param @return    设定文件
	 * @return String    返回文件名
	 * @throws
	 */
	public static final String uploadFile(HttpServletRequest request){
		//声明文件名
		String fileName = null;
		ServletContext servletContext = request.getSession().getServletContext();
		//获取文件存放路径
		String path = servletContext.getRealPath("upload/file");
		File f = new File(path);
		if(!f.exists()){
			f.mkdir();
		}
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(servletContext);
		if(resolver.isMultipart(request)){
			MultipartRequest multiRequest = (MultipartRequest) request;
			Iterator<String> it = multiRequest.getFileNames();
			while (it.hasNext()) {
				List<MultipartFile> fileList = multiRequest.getFiles(it.next());		
				for (int i = 0; i < fileList.size(); i++) {
					if(fileList.get(i) != null){
						try {
							InputStream is = fileList.get(i).getInputStream();
							//获得文件名（如果要操作多个文件上传需另作处理）
							fileName = fileList.get(i).getOriginalFilename();
							OutputStream os = new FileOutputStream(new File(path+"/"+fileList.get(i).getOriginalFilename()));
							byte[] buff = new byte[1024];
							int has = 0;
							while( (has = is.read(buff)) > 0 ){
								os.write(buff, 0, has);
							}
							os.close();
							is.close();
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return fileName;
	}
}
