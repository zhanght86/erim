package com.erim.sz.web.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
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
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: SearchAreaCountryTag 
 * @Description: 国家搜索
 * @author maoxian
 * @date 2016年1月5日 下午7:17:37
 */
public class SearchAreaCountryTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	//编码
	CodeService 					codeService = (CodeService)webApplicationContext.getBean("codeService");
	//省市县
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "vsearchareacountry";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		
		//港澳台
		SimpleNode stdlGat	     = (SimpleNode) node.jjtGetChild(0); String tdlGat        = (String) stdlGat.value(context);
		//港澳台
		SimpleNode stdlGatSelec  = (SimpleNode) node.jjtGetChild(1); String tdlGatSelec   = (String) stdlGatSelec.value(context);
		//国家
		SimpleNode stdlCountry   = (SimpleNode) node.jjtGetChild(2); String tdlCountry    = (String) stdlCountry.value(context);
		//国家
		SimpleNode stdlCounSelec = (SimpleNode) node.jjtGetChild(3); String tdlCounSelec  = (String) stdlCounSelec.value(context);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"search-div\">");
		sb.append("<label class=\"search-lab\" style=\"width:280px;\" province=\"gj\">");
		sb.append("<span class=\"smenu-title\">地区：</span>");
		sb.append("<select class=\"search-input\" name=\"").append(tdlGat).append("\" province=\"selgj\">");
		sb.append("<option value=\"\"></option>");
		List<CodeBean> listCodeGj = this.codeService.getSystemCodeListByCodeNo("C108");
		for(CodeBean code : listCodeGj){
			sb.append("<option ");
			if(code.getCodeKey().equals(tdlGatSelec)){
				sb.append(" selected ");
			}
			sb.append(" value=\"").append(code.getCodeKey()).append("\">").append(code.getCodeValue()).append("</option>");
		}
		sb.append("</select>");
		sb.append("</label>");
		sb.append("<label class=\"search-lab\" style=\"width:280px;display:none;\" province=\"gjj\">");
		sb.append("<span class=\"smenu-title\">国家/城市：</span>");
		//获取所有国家
		ExtHashMap<String, String> country = this.codeService.getSystemCodeByCodeNo("C067");
		sb.append("<input type=\"text\" class=\"autoquerycountry search-input\" province=\"inputgj\" id=\"").append(tdlCountry);
		if(StringUtils.isNotBlank(tdlCounSelec)){
			sb.append("\" value=\"").append(tdlCounSelec);
		}
		sb.append("\" name=\"").append(tdlCountry).append("\" ").append(" />");
		//sb.append("<input type=\"text\" class=\"search-input\" province=\"inputgj\" name=\"").append(tdlCountry).append("\" />");
		sb.append("</label>");
		sb.append("</div>");
		//加载样式 插件等信息
		sb.append("<script type=\"text/javascript\" src=\"/static/js/province.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"/static/js/autocomplete.min/jquery.autocomplete.js\"></script>");
		sb.append("<script type=\"text/javascript\">$(function() {var guojiastr = '").append(this.getGuojiaForQuery(country)).append("';var arr = guojiastr.split(\",\");$(\".autoquerycountry\").autocomplete(arr);});</script>");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/js/autocomplete.min/jquery.autocomplete.css\"/>");
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
