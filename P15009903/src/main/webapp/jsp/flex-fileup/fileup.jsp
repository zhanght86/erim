<%@ page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%

	    String realpath=request.getRealPath("/");
	    request.setCharacterEncoding("GBK");
	    
	    String fileName=request.getParameter("fileName");
	    String fileTemp="res/temp";
	    
	    System.out.println("----------");
	    System.out.println(realpath);
	    System.out.println(fileName);
	    System.out.println(fileTemp);
	    System.out.println("----------");
	    
	    String[] ads = fileTemp.split("/");
		for(int i=0;i<ads.length;i++){
		    realpath = realpath + File.separator + ads[i];
		}
	    
	    File testdir = new File(realpath);
		if (!testdir.exists()){
		    testdir.mkdirs();
		}
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
    	ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> list=upload.parseRequest(request);
		
		for (int i=0;list!=null&&i<list.size();i++) {
			FileItem item = (FileItem) list.get(i);
			if(item.isFormField()==false){
				item.write(new File(realpath+File.separator+fileName));
			}
		}
%>