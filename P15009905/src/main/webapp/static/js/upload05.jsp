<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="java.io.File"%>
<%@ page import="com.erim.sz.web.util.AngleForPhotoPhotoUtil"%>
<%@ page import="com.erim.utils.properties.PropertiesUtils"%>

<%!//得到文件的短路径，不包括目录
	public static String getShortFileName(String fileName) {
		if (fileName != null) {
			String oldFileName = new String(fileName);
			fileName = fileName.replace('\\', '/');
			// Handle dir
			if (fileName.endsWith("/")) {
				int idx = fileName.indexOf('/');
				if (idx == -1 || idx == fileName.length() - 1) {
					return oldFileName;
				} else {
					return oldFileName.substring(idx + 1, fileName.length() - 1);
				}
			}
			if (fileName.lastIndexOf("/") > 0) {
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
			}
			return fileName;
		}
		return "";
	}

	// 生成随机数
	public static String GenerateGUID(){
		UUID uuid = UUID.randomUUID();
	    return uuid.toString().replace("-", ""); 
	}
%>
<%
	// 确认有上传文件的请求
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	String guideId = "";
	if (isMultipart) {
		// Create a factory for disk-based file items
		org.apache.commons.fileupload.FileItemFactory factory = new DiskFileItemFactory();
		// 创建文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Parse the request
		List items = upload.parseRequest(request);
		// Process the uploaded items
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			org.apache.commons.fileupload.FileItem item = (org.apache.commons.fileupload.FileItem) iter.next();
			if (item.isFormField()) { // Process a regular form field
				String name = item.getFieldName();
				String value = item.getString("GBK");
				if (value != null && !"".equals(value)) {
					guideId += value;
				}
				System.out.println(name + "=" + value);
			} else { // Process a file upload

				String fieldName = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				boolean isInMemory = item.isInMemory();
				long sizeInBytes = item.getSize();
				System.out.println("上传的文件名是:" + fileName);
				if (fileName == null || fileName.length() == 0) {
					System.out.println("请选择一个文件来上传");
				} else {
					//获取随机数
					String guidName = GenerateGUID();
					System.out.println("获取随机guid:" + guidName);
					//更改fileName 为随机name
					String hz = fileName.substring(fileName.lastIndexOf("."),fileName.length());
					fileName = guidName+hz;
					//获取公司id
					System.out.println("guideId = " + guideId);
					String realpath = application.getRealPath("/static/img/user/"+guideId);
					
					System.out.println(realpath);
					File testdir = new File(realpath);
					if (!testdir.exists()){
					    testdir.mkdirs();
					}
					java.io.FileOutputStream fout = new java.io.FileOutputStream(realpath + "/" + getShortFileName(fileName));
					byte[] data = item.get();
					fout.write(data);
					fout.close();
					
					String url = "/img/user/"+guideId+"/"+getShortFileName(fileName);
					
					AngleForPhotoPhotoUtil.createUrl(realpath+"/"+getShortFileName(fileName));
					
					out.println("{\"filename\":\""+fileName+"\",\"url\":\"" + url + "\"}");
				}
			}
		}
	} else {
		System.out.println("请用文件上传表单来访问这个页面");
	}
%>