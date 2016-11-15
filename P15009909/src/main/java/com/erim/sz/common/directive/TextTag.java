package com.erim.sz.common.directive;

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

import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: Text 
 * @Description: 字典转换文本
 * @author maoxian
 * @date 2015年12月2日 下午2:03:11
 */
public class TextTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vtext";
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
		
		//循环字典
		List<CodeBean> listCode =  this.codeService.getSystemCodeListByCodeNo((String)pcode.value(context));
		
		String retValue = "";
		//遍历 c
		for(CodeBean c : listCode){
			String cod = c.getCodeKey();
			if(cod.equals(strCode)){
				retValue = c.getCodeValue();
			}
		}
		writer.write(retValue);
		return true;
	}
}
