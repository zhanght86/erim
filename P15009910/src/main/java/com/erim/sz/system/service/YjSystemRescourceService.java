package com.erim.sz.system.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.system.bean.YjSystemRescourceBean;
import com.erim.sz.system.dao.YjSystemRescourceDao;

/**
 * 
 * @ClassName: YjSystemRescourceService 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:25:09 
 *
 */
@Service("yjSystemRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class YjSystemRescourceService {

	@Autowired
	private YjSystemRescourceDao yjSystemRescourceDao;
	
	/**
	 * 
	 * @Title: havaAuthorityByRoleUrl 
	 * @Description: 根据角色和路径判断是否有权限
	 * @param @param roleid
	 * @param @param zxRescourceUrl
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean isHavaAuthorityByRoleUrl(String zxRescourceUrl){
		//根据路径查询实体
		YjSystemRescourceBean yjSystemRescourceBean = this.yjSystemRescourceDao.selectYjSystemRescourceBean(zxRescourceUrl);
		if(null != yjSystemRescourceBean){
			//获取编码
			String resourceCode = yjSystemRescourceBean.getYjFuncRescourceCode();
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
	 * @param @param zxRescourceUrl
	 * @param @return    设定文件 
	 * @return YjSystemRescourceBean    返回类型 
	 * @throws
	 */
	public YjSystemRescourceBean getOneByRescourceUrl(String zxRescourceUrl){
		return this.yjSystemRescourceDao.selectYjSystemRescourceBean(zxRescourceUrl); 		
	}
}