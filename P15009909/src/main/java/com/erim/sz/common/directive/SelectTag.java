package com.erim.sz.common.directive;

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

import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: Select 
 * @Description: 下拉
 * @author maoxian
 * @date 2015年12月2日 下午2:03:31
 */
public class SelectTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vselect";
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
		//parentcode
		SimpleNode parentcode = (SimpleNode) node.jjtGetChild(3);
		String strparentcode  = (String) parentcode.value(context);
		//isnull
		SimpleNode isnull     = (SimpleNode) node.jjtGetChild(4);
		String strisnull      = (String) isnull.value(context);
		//selected
		SimpleNode sel        = (SimpleNode) node.jjtGetChild(5);
		String strsel         = (String) sel.value(context);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<select ");
		if(StringUtils.isNotBlank(strname))   sb.append(" name=\"").append(strname).append("\"");
		if(StringUtils.isNotBlank(strid))     sb.append(" id=\"").append(strid).append("\"");
		if(StringUtils.isNotBlank(strcls))    sb.append(" class=\"").append(strcls).append("\"");
		sb.append(">");
		
		//如果
		if(StringUtils.isNotBlank(strisnull)) sb.append("<option value=\"\"></option>");
		
		if(StringUtils.isNotBlank(strparentcode)){
			//根据父级编码查询list
			List<CodeBean> listCode = this.codeService.getSystemCodeListByCodeNo(strparentcode);
			for(CodeBean code : listCode){
				sb.append("<option value=\"").append(code.getCodeKey()).append("\"");
				
				//设置选中
				if(code.getCodeKey().equals(strsel)){
					sb.append(" selected ");
				}
				
				sb.append("");
				sb.append(">");
				sb.append(code.getCodeValue()).append("</option>");
			}
		}
		
		sb.append("</select>");
		writer.write(sb.toString());
		return true;
	}
}
