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
public class VtextarrayAb extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	CodeService codeService = (CodeService)webApplicationContext.getBean("codeService");
	
	@Override
	public String getName() {
		return "vtextarrayab";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//编码
		SimpleNode a1  = (SimpleNode) node.jjtGetChild(0);
		//strCode转为string
		String stara1  = (String) a1.value(context);
		//编码
		SimpleNode a2  = (SimpleNode) node.jjtGetChild(1);
		//strCode转为string
		String stara2  = (String) a2.value(context);
		//编码
		SimpleNode a3  = (SimpleNode) node.jjtGetChild(2);
		//strCode转为string
		String stara3  = (String) a3.value(context);
		//编码
		SimpleNode a4  = (SimpleNode) node.jjtGetChild(3);
		//strCode转为string
		String stara4  = (String) a4.value(context);
		
		//编码
		SimpleNode b1  = (SimpleNode) node.jjtGetChild(4);
		//strCode转为string
		String starb1  = (String) b1.value(context);
		//编码
		SimpleNode b2  = (SimpleNode) node.jjtGetChild(5);
		//strCode转为string
		String starb2  = (String) b2.value(context);
		//编码
		SimpleNode b3  = (SimpleNode) node.jjtGetChild(6);
		//strCode转为string
		String starb3  = (String) b3.value(context);
		//编码
		SimpleNode b4  = (SimpleNode) node.jjtGetChild(7);
		//strCode转为string
		String starb4  = (String) b4.value(context);
		
		StringBuffer sb = new StringBuffer();
		
		//如果序列化值不为空
		if(StringUtils.isNotBlank(stara1) && StringUtils.isNotBlank(starb1)){

			String[] astara1 = stara1.split(",");
			String[] astarb1 = starb1.split(",");
			
			if(null != astara1 && null != astarb1 && astara1.length>0 && astarb1.length>0){
				
				for(int i = 0 ; i < astara1.length ; i ++ ){

					if(StringUtils.isNotBlank(stara3)){
						sb.append(stara3);
					}
					if(StringUtils.isNotBlank(stara2)){
						sb.append(this.getValueByCode(astara1[i], stara2));
					}else{
						sb.append(astara1[i]);
					}
					if(StringUtils.isNotBlank(stara4)){
						sb.append(stara4);
					}
					
					///////////////////////////////////////////////////////////////////
					if(StringUtils.isNotBlank(starb3)){
						sb.append(starb3);
					}
					if(StringUtils.isNotBlank(starb2)){
						sb.append(this.getValueByCode(astarb1[i], starb2));
					}else{
						sb.append(astarb1[i]);
					}
					if(StringUtils.isNotBlank(starb4)){
						sb.append(starb4);
					}
				}
			}
		}
		
		writer.write(sb.toString());
		return true;
	}
	
	/**
	 * 转码
	 * @param code        要转的码
	 * @param parentcode  字典编码
	 * @return
	 */
	public String getValueByCode(String code,String parentcode){
		//循环字典
		List<CodeBean> listCode =  this.codeService.getSystemCodeListByCodeNo(parentcode);
		
		String retValue = "";
		//遍历 c
		for(CodeBean c : listCode){
			String cod = c.getCodeKey();
			if(cod.equals(code)){
				retValue = c.getCodeValue();
			}
		}
		return retValue;
	}
}
