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
 * @ClassName: Text 
 * @Description: 字典转换文本
 * @author maoxian
 * @date 2015年12月2日 下午2:03:11
 */
public class TextArrayTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vtextarray";
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
		
		if(StringUtils.isNotBlank(strCode)){
			//编码转为数组
			String[] astrCode = strCode.split(",");
			String retValue = "";
			//遍历 c
			for(CodeBean c : listCode){
				String cod = c.getCodeKey();
				for(String codecode : astrCode){
					if(cod.equals(codecode)){
						retValue += c.getCodeValue() + ",";
					}
				}
			}
			//返回值
			if(""!=retValue)  retValue = retValue.substring(0, retValue.length()-1);
			writer.write(retValue);
		}
		return true;
	}
}
