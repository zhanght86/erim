package com.erim.sz.web.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.service.TmSystemRegionService;

/**
 * @ClassName: RegionTag 
 * @Description: 省市县转换
 * @author maoxian
 * @date 2015年12月7日 下午10:48:36
 */
public class RegionTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "vregion";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//name
		SimpleNode code       = (SimpleNode) node.jjtGetChild(0);
		String strcode        = (String) code.value(context);
		
		String strName = "";
		//遍历所有省市县
		List<TmSystemRegionBean> listTmSystemRegion = this.tmSystemRegionService.getCodeList();
		
		for(TmSystemRegionBean region : listTmSystemRegion){
			if(region.getRegionNo().equals(strcode)){
				strName = region.getRegionName();
			}
		}
		
		writer.write(strName);
		return true;
	}
}
