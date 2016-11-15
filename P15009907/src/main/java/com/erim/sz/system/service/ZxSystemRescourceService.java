package com.erim.sz.system.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.system.bean.ZxSystemRescourceBean;
import com.erim.sz.system.dao.ZxSystemRescourceDao;

/**
 * 
 * @ClassName: ZxSystemRescourceService 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:25:09 
 *
 */
@Service("zxSystemRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemRescourceService {

	@Autowired
	private ZxSystemRescourceDao zxSystemRescourceDao;
	
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
		ZxSystemRescourceBean zxSystemRescourceBean = this.zxSystemRescourceDao.selectZxSystemRescourceBean(zxRescourceUrl);
		if(null != zxSystemRescourceBean){
			//获取编码
			String resourceCode = zxSystemRescourceBean.getZxFuncRescourceCode();
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
	 * @return ZxSystemRescourceBean    返回类型 
	 * @throws
	 */
	public ZxSystemRescourceBean getOneByRescourceUrl(String zxRescourceUrl){
		return this.zxSystemRescourceDao.selectZxSystemRescourceBean(zxRescourceUrl); 		
	}
}