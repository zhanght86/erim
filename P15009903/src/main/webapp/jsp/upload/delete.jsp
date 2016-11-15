<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>

<%

	//获取图片路径
	String imgUrl = request.getParameter("imgUrl");
	String realpath = application.getRealPath("res/"+imgUrl);
	
	System.out.println("删除路径为：" + realpath);
	
	File f = new File(realpath);
	if(f.isFile() && f.exists()){
		f.delete();
		out.print("{\"success\":1}");
	}else{
		out.print("{\"success\":2}");		
	}
%>