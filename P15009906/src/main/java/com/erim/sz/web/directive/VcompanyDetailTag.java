package com.erim.sz.web.directive;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.service.VCompanyDetailService;

/**
 * @ClassName: VcompanyDetailTag 
 * @Description: 获取企业信息 
 * @author maoxian
 * @date 2015年12月23日 下午11:19:24
 */
public class VcompanyDetailTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	VCompanyDetailService vCompanyDetailService = (VCompanyDetailService)webApplicationContext.getBean("vCompanyDetailService");
	
	@Override
	public String getName() {
		return "vcompanydetail";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//cpyid
		SimpleNode cpyid      = (SimpleNode) node.jjtGetChild(0);
		Integer strcpyid      = (Integer) cpyid.value(context);
		
		//cpyValue
		SimpleNode cpyValue   = (SimpleNode) node.jjtGetChild(1);
		String strcpyValue    = (String) cpyValue.value(context);
		
		//返回值
		String bakStr = "";
		if(null != strcpyid && strcpyid>0){
			Session session = SecurityUtils.getSubject().getSession();
			VCompanyDetailBean bean = (VCompanyDetailBean)session.getAttribute("VcompanyDetailTag_"+strcpyid);
			if(null == bean){
				bean = vCompanyDetailService.selectById(strcpyid);
				session.setAttribute("VcompanyDetailTag_"+strcpyid, bean);
			}
			
			if(null != bean){
				bakStr = VcompanyDetailTag.getProperty(bean, strcpyValue);
			}
		}
		
		writer.write(bakStr);
		return true;
	}
	
	/**
	 * @Title: getProperty 
	 * @Description: 通过域名取得bean值
	 * @param @param bean
	 * @param @param fieldName
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午11:13:58 
	 * @throws
	 */
	private static String getProperty(Object bean, String fieldName) {  
	    Field[] fields = bean.getClass().getDeclaredFields();
	    Field.setAccessible(fields, true);     
	    Object obj = null;  
	    for (int i = 0; i < fields.length; i++) {  
	        Field field = fields[i];  
	        if (fieldName.equals(field.getName())) {  
	            try {  
	                obj = field.get(bean);  
	            } catch (Exception e) {  
	            	System.out.println(e);
	            }  
	        }  
	    }  
	    return null==obj?"":obj.toString();   
	}  
}
