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
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: SearchAreaTag 
 * @Description: 区域搜索
 * @author maoxian
 * @date 2015年12月14日 下午4:13:16
 */
public class SearchAreaTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	//编码
	CodeService 					codeService = (CodeService)webApplicationContext.getBean("codeService");
	//省市县
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "vsearcharea";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		
		//国内 国外
		SimpleNode stdlGj        = (SimpleNode) node.jjtGetChild(0); String tdlGj         = (String) stdlGj.value(context);
		//省
		SimpleNode stdlProvince  = (SimpleNode) node.jjtGetChild(1); String tdlProvince   = (String) stdlProvince.value(context);
		//省
		SimpleNode stdlProSelect = (SimpleNode) node.jjtGetChild(2); String tdlProSelect  = (String) stdlProSelect.value(context);
		//市
		SimpleNode stdlCity	     = (SimpleNode) node.jjtGetChild(3); String tdlCity       = (String) stdlCity.value(context);
		//市
		SimpleNode stdlCiSelect  = (SimpleNode) node.jjtGetChild(4); String tdlCitySelec  = (String) stdlCiSelect.value(context);
		//港澳台
		SimpleNode stdlGat	     = (SimpleNode) node.jjtGetChild(5); String tdlGat        = (String) stdlGat.value(context);
		//港澳台
		SimpleNode stdlGatSelec  = (SimpleNode) node.jjtGetChild(6); String tdlGatSelec   = (String) stdlGatSelec.value(context);
		//国家
		SimpleNode stdlCountry   = (SimpleNode) node.jjtGetChild(7); String tdlCountry    = (String) stdlCountry.value(context);
		//国家
		SimpleNode stdlCounSelec = (SimpleNode) node.jjtGetChild(8); String tdlCounSelec  = (String) stdlCounSelec.value(context);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"search-div\">");
		sb.append("<label class=\"search-lab\" style=\"width:280px;\">");
		sb.append("<span class=\"smenu-title\">国内/国际：</span>");
		sb.append("<select class=\"search-input\" name=\"").append(tdlGj).append("\" province=\"country\">");
		
		sb.append("<option value=\"\"></option>");
		//国内  国际/港澳台
		List<CodeBean> listCodeGj = this.codeService.getSystemCodeListByCodeNo("C105");
		for(CodeBean code : listCodeGj){
			sb.append("<option ");
			if(StringUtils.isNotEmpty(tdlProSelect) && "01".equals(code.getCodeKey())){
				sb.append(" selected ");
			}
			if(StringUtils.isNotEmpty(tdlGatSelec) && "02".equals(code.getCodeKey())){
				sb.append(" selected ");
			}
			sb.append(" value=\"").append(code.getCodeKey()).append("\">").append(code.getCodeValue()).append("</option>");
		}
		sb.append("</select>");
		sb.append("</label>");
		sb.append("<label class=\"search-lab\" style=\"width:280px;display:none;\" province=\"gj\">");
		sb.append("<span class=\"smenu-title\">地区：</span>");
		sb.append("<select class=\"search-input\" name=\"").append(tdlGat).append("\" province=\"selgj\">");
		sb.append("<option value=\"\"></option>");
		listCodeGj = this.codeService.getSystemCodeListByCodeNo("C108");
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
		sb.append("<label class=\"search-lab\" style=\"width:280px;\" province=\"gn\">");
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
		sb.append("</label>");
		sb.append("<label class=\"search-lab\" style=\"width:280px;\" province=\"gn\">");
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
		sb.append("</label>");
		sb.append("</div>");
		//加载样式 插件等信息
		sb.append("<script type=\"text/javascript\" src=\"/static/js/province.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"/static/js/autocomplete.min/jquery.autocomplete.js\"></script>");
		sb.append("<script type=\"text/javascript\">$(function() {var guojiastr = '").append(this.getGuojiaForQuery(country)).append("';var arr = guojiastr.split(\",\");$(\".autoquerycountry\").autocomplete(arr);});</script>");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/js/autocomplete.min/jquery.autocomplete.css\"/>");
		
		//如果省和国际都为空则初始化所有
		if(StringUtils.isEmpty(tdlProSelect) && StringUtils.isEmpty(tdlGatSelec)){
			sb.append("<script>");
			sb.append("$(\"label[province='gn']\").hide();");
		    sb.append("$(\"label[province='gj']\").hide();");
		    sb.append("$(\"label[province='gjj']\").hide();");
		    sb.append("</script>");
		}
		//如果国际不为空 隐藏国内选项
		if(StringUtils.isNotBlank(tdlGatSelec)){
			sb.append("<script>");
			sb.append("$(\"label[province='gn']\").hide();");
			sb.append("$(\"label[province='gj']\").show();");
			//如果国际不为空 隐藏国内选项
			if(StringUtils.isNotBlank(tdlCounSelec)){
				sb.append("$(\"label[province='gjj']\").show();");
			}
			sb.append("</script>");
		}
	    
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
