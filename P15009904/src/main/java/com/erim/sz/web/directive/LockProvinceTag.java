package com.erim.sz.web.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
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
import com.erim.sz.tm.bean.TmSystemRegionBean;
import com.erim.sz.tm.service.TmSystemRegionService;

/**
 * @ClassName: LockProvinceTag 
 * @Description: 根据注册可服务范围确定添加产品区域
 * @author maoxian
 * @date 2015年12月6日 下午1:40:29
 */
public class LockProvinceTag extends Directive {


	//注入 codeService
	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	
	TmSystemRegionService tmSystemRegionService = (TmSystemRegionService)webApplicationContext.getBean("tmSystemRegionService");
	
	@Override
	public String getName() {
		return "lockProvince";
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
		//isnull
		SimpleNode isnull     = (SimpleNode) node.jjtGetChild(3);
		String strisnull      = (String) isnull.value(context);
		//selected
		SimpleNode sel        = (SimpleNode) node.jjtGetChild(4);
		String strsel         = (String) sel.value(context);
		//city
		SimpleNode child      = (SimpleNode) node.jjtGetChild(5);
		String strchild       = (String) child.value(context);
		//town
		SimpleNode town       = (SimpleNode) node.jjtGetChild(6);
		String strtown        = (String) town.value(context);
		//city
		SimpleNode selectcity = (SimpleNode) node.jjtGetChild(7);
		String strselectcity  = (String) selectcity.value(context);
		//town
		SimpleNode selecttown = (SimpleNode) node.jjtGetChild(8);
		String strselecttown  = (String) selecttown.value(context);
		
		//获取公司企业信息
		VCompanyDetailBean companyDetail = (VCompanyDetailBean)SecurityUtils.getSubject().getSession().getAttribute("userCommpany");
		
		if(null != companyDetail){
			//获取地接可服务范围 省
			String cbsRanProvince1 = companyDetail.getCbsProProvince();

			//根据编号获取所有省
			List<TmSystemRegionBean> listTmSystemRegion =  tmSystemRegionService.getSystemCodeListByCodeNo(100000);
			//StringBuffer
			StringBuffer sb = new StringBuffer();
			sb.append("<select ");
			if(StringUtils.isNotBlank(strname))   sb.append(" name=\"").append(strname).append("\"");
			if(StringUtils.isNotBlank(strid))     sb.append(" id=\"").append(strid).append("\"");
			if(StringUtils.isNotBlank(strcls))    sb.append(" class=\"").append(strcls).append("\"");
			if(StringUtils.isNotBlank(strchild)){
				sb.append(" onchange=\"lock.city($(this),'").append(strchild).append("','").append(strtown).append("','','');\"");
			}
			sb.append(">");
			//如果为空 默认第一个空置
			//if(StringUtils.isNotBlank(strisnull)) sb.append("<option value=\"\"></option>");
			//如果数组不为空
			if(null != listTmSystemRegion){
				// for循环下标
				int i = 0;
				//遍历所有省
				for(TmSystemRegionBean regionBean : listTmSystemRegion){
					String code = regionBean.getRegionNo();
					if(code.equals(cbsRanProvince1)){
						sb.append("<option value=\"").append(code).append("\"");
						
						//设置选中
						if(code.equals(strsel)){
							sb.append(" selected ");
						}
						//如果省为空 默认展示第一个省，调取子集
						if(!StringUtils.isNotBlank(strsel) && i == 0){
							strsel = code;
						}
						
						sb.append("");
						sb.append(">");
						sb.append(regionBean.getRegionName()).append("</option>");
						i++;
					}
				}
			}
			sb.append("</select>");
			
			//如果不为空 直接调取子集
			if(StringUtils.isNotBlank(strsel)){
				sb.append("<script>lock.city($('#"+strid+"'),'").append(strchild).append("','").append(strtown).append("','").append(strselectcity).append("','").append(strselecttown).append("');</script>");
			}
			writer.write(sb.toString());
		}
		writer.write("");
		return true;
	}
}
