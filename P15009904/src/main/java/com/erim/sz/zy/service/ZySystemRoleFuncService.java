package com.erim.sz.zy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemFuncBean;
import com.erim.sz.zy.bean.ZySystemRoleFuncBean;
import com.erim.sz.zy.dao.ZySystemRoleFuncDao;

/**
 * 
 * @ClassName: ZySystemRoleFuncService 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:31:36
 */
@Service("zySystemRoleFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemRoleFuncService {

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ZySystemRoleFuncService.class);
	
	@Autowired
	private ZySystemRoleFuncDao     zySystemRoleFuncDao;
	@Autowired
	private ZySystemFuncService     zySystemFuncService;
//	@Autowired
//    private TmSystemRolefuncService  tmSystemRolefuncService;
//	@Autowired
//	private TmSystemfuncService		 tmSystemfuncService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入
	 * @param @param zySystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<ZySystemRoleFuncBean> zySystemRoleFuncBeans){
		this.zySystemRoleFuncDao.insertList(zySystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色查询对应权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.zySystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
	}
	
	/**
	 * 
	 * @Title: deleteByRoleId 
	 * @Description: 根据角色id删除
	 * @param @param roleid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteByRoleId(String zyRoleId){
		this.zySystemRoleFuncDao.deleteByRoleId(zyRoleId);
	}
	
	/**
	 * 
	 * @Title: selectFuncByRoleId 
	 * @Description: 根据角色id判断权限
	 * @param @param roleid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectFuncByRoleId(String roleid,ModelMap model,HttpServletRequest request){
		
		if(StringUtils.isNotBlank(roleid)){
			//获取角色所有权限
			//List<ZySystemRoleFuncBean> listZySystemRoleFuncBean = this.zySystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
			List<ZySystemRoleFuncBean> listZySystemRoleFuncBean = (List<ZySystemRoleFuncBean>)SecurityUtils.getSubject().getSession().getAttribute("roleFuncs");
			if(null != listZySystemRoleFuncBean && listZySystemRoleFuncBean.size()>0){
				//合作区域
				CompanyBusinessBean business =  CommonUtil.getCpyBusiness();
				
				String funcode = "",childFunc = "";
				for(ZySystemRoleFuncBean funcBean : listZySystemRoleFuncBean){
					String zyFuncCode = funcBean.getZyFuncCode();
					
					//截取parentcode
					String[] aZyFuncCode = zyFuncCode.split("_");
					if(!funcode.contains(aZyFuncCode[0])){
						
						//如果是直营则没有同城同业
						if(null != business && "04".equals(business.getCbsService())){
							if("SAMETOWN".equals(aZyFuncCode[0])) continue;
						}
						
						funcode += aZyFuncCode[0]+",";
					}
					//获取二级菜单列表
					String chiFUnc = aZyFuncCode[0]+"_"+aZyFuncCode[1];
					if(!childFunc.contains(chiFUnc)){
						//如果是直营则没有同城同业
						if(null != business && "04".equals(business.getCbsService()) && aZyFuncCode[0].equals("PRODUCT")){
							//同业
							String cbsProductType = business.getCbsProductType();
							//01酒店 02签证 03导游 04门票 05租车 06机票 07特色餐 08火车票
							String cbscs = "01".equals(cbsProductType)?"PRODUCT_HOTEL":
										   "02".equals(cbsProductType)?"PRODUCT_MANAGEMENT":
										   "03".equals(cbsProductType)?"PRODUCT_GUIDE":
										   "04".equals(cbsProductType)?"PRODUCT_TICKET":
										   "05".equals(cbsProductType)?"PRODUCT_TEXI":
										   "06".equals(cbsProductType)?"PRODUCT_PLANETICKET":
										   "07".equals(cbsProductType)?"PRODUCT_CAFETERIA":
										   "08".equals(cbsProductType)?"PRODUCT_TRANSTICKET":"";
							if(chiFUnc.equals(cbscs)){
								childFunc += chiFUnc+",";
							}
						}else{
							childFunc += chiFUnc+",";
						}
					}
				}
				//去掉最后,号
				if(!"".equals(funcode)) funcode = funcode.substring(0,funcode.length()-1);
				if(!"".equals(childFunc)) childFunc = childFunc.substring(0,childFunc.length()-1);
				logger.info("funcode:"+funcode);
				logger.info("childFunc:"+childFunc);
				
				//获取父级所有权限
			    List<ZySystemFuncBean> parentListFunc = this.zySystemFuncService.selectFuncByCode(funcode.split(","),request);
				//List<ZySystemFuncBean> parentListFunc = this.tmSystemfuncService.getSystemCoudeByACode(funcode.split(","));
				//获取所有子集权限
				List<ZySystemFuncBean> childListFunc = this.zySystemFuncService.selectFuncByCode(childFunc.split(","),request);
				//List<ZySystemFuncBean> childListFunc = this.tmSystemfuncService.getSystemCoudeByACode(childFunc.split(","));
				
				model.addAttribute("parentListFunc", parentListFunc);
				model.addAttribute("childListFunc", childListFunc);
			}
		}
	}
}
