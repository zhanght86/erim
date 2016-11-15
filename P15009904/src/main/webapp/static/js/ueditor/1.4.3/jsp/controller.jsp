<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.baidu.ueditor.ActionEnter"
    import="com.erim.utils.properties.PropertiesUtils"
    import="java.io.File"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
    response.setHeader("Content-Type" , "text/html");
    
    //String rootPath = PropertiesUtils.getPropertyByKey("app.file.path.ueditor");
    String rootPath = application.getRealPath( "/" );
    
    out.write( new ActionEnter( request, rootPath ).exec() );
    
%>