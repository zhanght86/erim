package com.erim.sz.web.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

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

import com.erim.sz.tm.bean.TmSystemRegionBean;
import com.erim.sz.tm.service.TmSystemRegionService;

/**
 * @ClassName: RegionToLineTag 
 * @Description: 省12 市12 县12  转换为 省1市1县1<br/> 省2市2县2
 * @author maoxian
 * @date 2015年12月20日 下午10:13:52
 */
public class RegionToLineTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "vregiontoline";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//省
		SimpleNode province   = (SimpleNode) node.jjtGetChild(0);
		String strprovince    = (String) province.value(context);
		
		//市
		SimpleNode city       = (SimpleNode) node.jjtGetChild(1);
		String strcity        = (String) city.value(context);
		
		//县
		SimpleNode town       = (SimpleNode) node.jjtGetChild(2);
		String strtown        = (String) town.value(context);
		
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(strprovince) && StringUtils.isNotBlank(strcity)){
			//省市县分组
			String[] astrprovince = strprovince.split(",");
			String[] astrcity     = strcity.split(","); 
			String[] astrtown     = {};
			if(StringUtils.isNotBlank(strtown)){
				astrtown = strtown.split(",");
			}
			//按照省进行遍历
			for(int i = 0 ; i<astrprovince.length; i++){
				sb.append(this.getNameByRegionCode(astrprovince[i]));
				if(StringUtils.isNotBlank(astrcity[i])){
					sb.append(this.getNameByRegionCode(astrcity[i]));
				}else{
					sb.append("");
				}
				if(StringUtils.isNotBlank(strtown)){
					if(StringUtils.isNotBlank(astrtown[i])){
						sb.append(this.getNameByRegionCode(astrtown[i]));
					}
				}else{
					sb.append("");
				}
				sb.append("<br/>");
			}
				
		}
		
		writer.write(sb.toString());
		return true;
	}
	
	/**
	 * @Title: getNameByRegionCode 
	 * @Description: 根据省市县编码 获取 省市县名称
	 * @param @param code
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午10:17:37 
	 * @throws
	 */
	public String getNameByRegionCode(String code){
		String strName = "";
		//遍历所有省市县
		List<TmSystemRegionBean> listTmSystemRegion = this.tmSystemRegionService.getCodeList();
		for(TmSystemRegionBean region : listTmSystemRegion){
			if(region.getRegionNo().equals(code)){
				strName = region.getRegionName();
			}
		}
		return strName;
	}
}
