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
 * @ClassName: CheckBoxArrayTag 
 * @Description: 输入字符串改为checkbox  
 * 1,2,3,4,5
 * <input type='checkbox' value='1'/>1<input type='checkbox' value='2'/>2
 * @author maoxian
 * @date 2015年12月8日 上午11:31:32
 */
public class CheckBoxArrayTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vcheckboxarray";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//编码
		SimpleNode code = (SimpleNode) node.jjtGetChild(0);
		//strCode转为string
		String strCode  = (String) code.value(context);
		//父级编码
		SimpleNode pcode = (SimpleNode) node.jjtGetChild(1);
		//name
		SimpleNode sname = (SimpleNode) node.jjtGetChild(2);
		String strname = (String)sname.value(context);
		//id
		SimpleNode id = (SimpleNode) node.jjtGetChild(3);
		String strid = (String)id.value(context);
		//cls
		SimpleNode cls = (SimpleNode) node.jjtGetChild(4);
		String strcls = (String)cls.value(context);
		
		//循环字典
		List<CodeBean> listCode =  this.codeService.getSystemCodeListByCodeNo((String)pcode.value(context));
		
		//编码转为数组
		String[] astrCode = strCode.split(",");
		StringBuffer sb   = new StringBuffer();
		//遍历 c
		for(CodeBean c : listCode){
			String cod = c.getCodeKey();
			for(String codecode : astrCode){
				if(cod.equals(codecode)){
					sb.append("<label class=\"checkbox inline\">");
					sb.append("<input type=\"checkbox\" value=\"").append(codecode).append("\"");
					if(StringUtils.isNotBlank(strname)){
						sb.append(" name=\"").append(strname).append("\"");
					}
					if(StringUtils.isNotBlank(strid)){
						sb.append(" id=\"").append(strid).append("\"");
					}
					if(StringUtils.isNotBlank(strcls)){
						sb.append(" class=\"").append(strcls).append("\"");
					}
					sb.append("/>").append(c.getCodeValue());
					sb.append("</label>");
				}
			}
		}
		//返回值
		writer.write(sb.toString());
		return true;
	}
}
