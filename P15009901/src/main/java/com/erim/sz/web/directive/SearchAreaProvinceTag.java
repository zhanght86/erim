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
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: SearchAreaProvinceTag 
 * @Description: 区域搜索
 * @author maoxian
 * @date 2015年12月14日 下午4:13:16
 */
public class SearchAreaProvinceTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	//编码
	CodeService 					codeService = (CodeService)webApplicationContext.getBean("codeService");
	//省市县
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "vsearchareaprovince";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		
		//省
		SimpleNode stdlProvince  = (SimpleNode) node.jjtGetChild(0); String tdlProvince   = (String) stdlProvince.value(context);
		//省
		SimpleNode stdlProSelect = (SimpleNode) node.jjtGetChild(1); String tdlProSelect  = (String) stdlProSelect.value(context);
		//市
		SimpleNode stdlCity	     = (SimpleNode) node.jjtGetChild(2); String tdlCity       = (String) stdlCity.value(context);
		//市
		SimpleNode stdlCiSelect  = (SimpleNode) node.jjtGetChild(3); String tdlCitySelec  = (String) stdlCiSelect.value(context);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"smenu-li\">");
		sb.append("<span class=\"smenu-title\">省：</span>");
		sb.append("<select class=\"search-input\" province=\"province\" name=\"").append(tdlProvince).append("\">");
		sb.append("<option value=\"\"></option>");
		//遍历所有省市县
		List<TmSystemRegionBean> listTmSystemRegion = this.tmSystemRegionService.getCodeList();
		//省
		for(TmSystemRegionBean region : listTmSystemRegion){
			//所有省
			if(1 == region.getRegionLevel()){
				sb.append("<option ");
				if(region.getRegionNo().equals(tdlProSelect)){
					sb.append(" selected ");
				}
				sb.append(" value=\"").append(region.getRegionNo()).append("\">").append(region.getRegionName()).append("</option>");
			}
		}
		sb.append("</select>");
		sb.append("<span class=\"smenu-title\">市：</span>");
		sb.append("<select class=\"search-input\" province=\"city\" name=\"").append(tdlCity).append("\">");
		sb.append("<option value=\"\"></option>");
		//如果省不为空 初始化市
		if(StringUtils.isNotBlank(tdlProSelect)){
			for(TmSystemRegionBean region : listTmSystemRegion){
				//所有省
				if(tdlProSelect.equals(region.getRegionPid().toString())){
					sb.append("<option ");
					if(region.getRegionNo().equals(tdlCitySelec)){
						sb.append(" selected ");
					}
					sb.append(" value=\"").append(region.getRegionNo()).append("\">").append(region.getRegionName()).append("</option>");
				}
			}
		}
		
		sb.append("</select>");
		sb.append("</div>");
		//加载样式 插件等信息
		sb.append("<script type=\"text/javascript\" src=\"/static/js/province.js\"></script>");
		
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
