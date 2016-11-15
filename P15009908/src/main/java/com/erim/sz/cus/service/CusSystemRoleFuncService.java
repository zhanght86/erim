package com.erim.sz.cus.service;

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

import com.erim.sz.cus.bean.CusSystemFuncBean;
import com.erim.sz.cus.bean.CusSystemRoleFuncBean;
import com.erim.sz.cus.dao.CusSystemRoleFuncDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CusSystemRoleFuncService 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:31:36
 */
@Service("cusSystemRoleFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemRoleFuncService {

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CusSystemRoleFuncService.class);
	
	@Autowired
	private CusSystemRoleFuncDao     cusSystemRoleFuncDao;
	@Autowired
	private CusSystemFuncService     cusSystemFuncService;
//	@Autowired
//    private TmSystemRolefuncService  tmSystemRolefuncService;
//	@Autowired
//	private TmSystemfuncService		 tmSystemfuncService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入
	 * @param @param cusSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<CusSystemRoleFuncBean> cusSystemRoleFuncBeans){
		this.cusSystemRoleFuncDao.insertList(cusSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色查询对应权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<CusSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.cusSystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
	}
	
	/**
	 * 
	 * @Title: deleteByRoleId 
	 * @Description: 根据角色id删除
	 * @param @param roleid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteByRoleId(String cusRoleId){
		this.cusSystemRoleFuncDao.deleteByRoleId(cusRoleId);
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
			//List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = this.cusSystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
			List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = (List<CusSystemRoleFuncBean>)SecurityUtils.getSubject().getSession().getAttribute("roleFuncs");
			if(null != listCusSystemRoleFuncBean && listCusSystemRoleFuncBean.size()>0){
				//合作区域
				//CompanyBusinessBean business =  CommonUtil.getCpyBusiness();
				
				String funcode = "",childFunc = "";
				for(CusSystemRoleFuncBean funcBean : listCusSystemRoleFuncBean){
					String cusFuncCode = funcBean.getCusFuncCode();
					
					//如果用户锁住了
					if(CommonUtil.isLockUser()){
						if(!"SYSTEM_PRICE_QUERY".equals(cusFuncCode)) continue;
						
						model.addAttribute("lockmessage", "试用24小时已经到期，请充值服务费后退出重新登录系统!");
					}
					
					//截取parentcode
					String[] aCusFuncCode = cusFuncCode.split("_");
					if(!funcode.contains(aCusFuncCode[0])){
						
						funcode += aCusFuncCode[0]+",";
					}
					//获取二级菜单列表
					String chiFUnc = aCusFuncCode[0]+"_"+aCusFuncCode[1];
					if(!childFunc.contains(chiFUnc)){
//						//如果是直营则没有同城同业
//						if(null != business && "04".equals(business.getCbsService()) && aCusFuncCode[0].equals("PRODUCT")){
//							//同业
//							String cbsProductType = business.getCbsProductType();
//							//01酒店 02签证 03导游 04门票 05租车 06机票 07特色餐 08火车票
//							String cbscs = "01".equals(cbsProductType)?"PRODUCT_HOTEL":
//										   "02".equals(cbsProductType)?"PRODUCT_MANAGEMENT":
//										   "03".equals(cbsProductType)?"PRODUCT_GUIDE":
//										   "04".equals(cbsProductType)?"PRODUCT_TICKET":
//										   "05".equals(cbsProductType)?"PRODUCT_TEXI":
//										   "06".equals(cbsProductType)?"PRODUCT_PLANETICKET":
//										   "07".equals(cbsProductType)?"PRODUCT_CAFETERIA":
//										   "08".equals(cbsProductType)?"PRODUCT_TRANSTICKET":"";
//							if(chiFUnc.equals(cbscs)){
//								childFunc += chiFUnc+",";
//							}
//						}else{
							childFunc += chiFUnc+",";
//						}
					}
				}
				//去掉最后,号
				if(!"".equals(funcode)) funcode = funcode.substring(0,funcode.length()-1);
				if(!"".equals(childFunc)) childFunc = childFunc.substring(0,childFunc.length()-1);
				logger.info("funcode:"+funcode);
				logger.info("childFunc:"+childFunc);
				
				//获取父级所有权限
			    List<CusSystemFuncBean> parentListFunc = this.cusSystemFuncService.selectFuncByCode(funcode.split(","),request);
				//List<CusSystemFuncBean> parentListFunc = this.tmSystemfuncService.getSystemCoudeByACode(funcode.split(","));
				//获取所有子集权限
				List<CusSystemFuncBean> childListFunc = this.cusSystemFuncService.selectFuncByCode(childFunc.split(","),request);
				//List<CusSystemFuncBean> childListFunc = this.tmSystemfuncService.getSystemCoudeByACode(childFunc.split(","));
				
				model.addAttribute("parentListFunc", parentListFunc);
				model.addAttribute("childListFunc", childListFunc);
			}
		}
	}
}
