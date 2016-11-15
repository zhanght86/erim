package com.erim.sz.zy.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.zy.bean.ZySystemRescourceBean;
import com.erim.sz.zy.dao.ZySystemRescourceDao;

/**
 * 
 * @ClassName: ZySystemRescourceService 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:25:09 
 *
 */
@Service("zySystemRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemRescourceService {

	@Autowired
	private ZySystemRescourceDao zySystemRescourceDao;
	
	/**
	 * 
	 * @Title: havaAuthorityByRoleUrl 
	 * @Description: 根据角色和路径判断是否有权限
	 * @param @param roleid
	 * @param @param zyRescourceUrl
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean isHavaAuthorityByRoleUrl(String zyRescourceUrl){
		//根据路径查询实体
		ZySystemRescourceBean zySystemRescourceBean = this.zySystemRescourceDao.selectZySystemRescourceBean(zyRescourceUrl);
		if(null != zySystemRescourceBean){
			//获取编码
			String resourceCode = zySystemRescourceBean.getZyFuncRescourceCode();
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
	 * @param @param zyRescourceUrl
	 * @param @return    设定文件 
	 * @return ZySystemRescourceBean    返回类型 
	 * @throws
	 */
	public ZySystemRescourceBean getOneByRescourceUrl(String zyRescourceUrl){
		return this.zySystemRescourceDao.selectZySystemRescourceBean(zyRescourceUrl); 		
	}
}