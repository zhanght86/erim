package com.erim.sz.cus.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.cus.bean.CusSystemRescourceBean;
import com.erim.sz.cus.dao.CusSystemRescourceDao;

/**
 * 
 * @ClassName: CusSystemRescourceService 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:25:09 
 *
 */
@Service("cusSystemRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemRescourceService {

	@Autowired
	private CusSystemRescourceDao cusSystemRescourceDao;
	
	/**
	 * 
	 * @Title: havaAuthorityByRoleUrl 
	 * @Description: 根据角色和路径判断是否有权限
	 * @param @param roleid
	 * @param @param cusRescourceUrl
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean isHavaAuthorityByRoleUrl(String cusRescourceUrl){
		//根据路径查询实体
		CusSystemRescourceBean cusSystemRescourceBean = this.cusSystemRescourceDao.selectCusSystemRescourceBean(cusRescourceUrl);
		if(null != cusSystemRescourceBean){
			//获取编码
			String resourceCode = cusSystemRescourceBean.getCusFuncRescourceCode();
			System.out.println("权限路径是：resourceCode:"+resourceCode);
			//权限校验。判断是否包含权限。
			Subject subject = SecurityUtils.getSubject();
			System.out.println("是否包含权限:"+subject.isPermitted(resourceCode));
			return subject.isPermitted(resourceCode);
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: selectOneByRescourceUrl 
	 * @Description: 根据路径查询实体
	 * @param @param cusRescourceUrl
	 * @param @return    设定文件 
	 * @return CusSystemRescourceBean    返回类型 
	 * @throws
	 */
	public CusSystemRescourceBean getOneByRescourceUrl(String cusRescourceUrl){
		return this.cusSystemRescourceDao.selectCusSystemRescourceBean(cusRescourceUrl); 		
	}
}