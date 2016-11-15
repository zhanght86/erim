package com.erim.sz.common.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.erim.core.lang.ExtHashMap;
import com.erim.utils.properties.PropertiesUtils;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CountryTag 
 * @Description: 国家
 * @author maoxian
 * @date 2015年12月6日 下午9:11:52
 */
public class CountryTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vcountry";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//name
		SimpleNode name       = (SimpleNode) node.jjtGetChild(0);
		String strname        = (String) name.value(context);
		//id
		SimpleNode id         = (SimpleNode) node.jjtGetChild(1);
		String strid          = (String) id.value(context);
		//class
		SimpleNode cls        = (SimpleNode) node.jjtGetChild(2);
		String strcls         = (String) cls.value(context);
		
		SimpleNode disable    = (SimpleNode) node.jjtGetChild(3);
		String strdisable     = (String) disable.value(context);

		SimpleNode svalue     = (SimpleNode) node.jjtGetChild(4);
		String strvalue       = (String) svalue.value(context);
		
		//获取所有国家
		ExtHashMap<String, String> country = this.codeService.getSystemCodeByCodeNo("C067");
				
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"text\" class=\"autoquerycountry ").append(strcls).append("\" id=\"").append(strid).append("\" value=\"").append(strvalue).append("\" name=\"").append(strname).append("\" ").append(strdisable).append(" />");
		
		sb.append("<script type=\"text/javascript\">$(function() {var guojiastr = '").append(this.getGuojiaForQuery(country)).append("';var arr = guojiastr.split(\",\");$(\".autoquerycountry\").autocomplete(arr);});</script>");
		
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(PropertiesUtils.getPropertyByKey("app.staticRoot")).append("/js/autocomplete.min/jquery.autocomplete.css\"/>");
		writer.write(sb.toString());
		return true;
	}
	
	/**
	 * @Title: getGuojiaForQuery 
	 * @Description: 国家迭代
	 * @param @param map
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月6日 下午8:38:03 
	 * @throws
	 */
	public String getGuojiaForQuery(ExtHashMap<String, String> map){
	    Iterator<Entry<String, String>> iter = map.entrySet().iterator();
	    String s = "";
	    while(iter.hasNext()){
	       Entry<String,String> entry = (Entry<String,String>) iter.next();
	       Object a = entry.getValue();
	       s += a.toString()+",";
	    }
	    s = s.substring(0,s.length()-1);
	    return s;
	}
}
