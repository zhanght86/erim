package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.ZxSystemRoleBean;
import com.erim.sz.system.dao.ZxSystemRoleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("zxSystemRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemRoleService {

	@Autowired
	private ZxSystemRoleDao zxSystemRoleDao;
	
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZxSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(ZxSystemRoleBean roleBean, ModelMap model){
		
		roleBean.setCpyId(CommonUtil.getCpyId());
		roleBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<ZxSystemRoleBean> userList  = this.zxSystemRoleDao.selectPage(roleBean, model);
		System.out.println("长度:"+userList.size());
		//回传
		model.addAttribute("userList", userList);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色表
	 * @param @param zxSystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(ZxSystemRoleBean zxSystemRoleBean){
		zxSystemRoleBean.setCpyId(CommonUtil.getCpyId());
		return this.zxSystemRoleDao.insert(zxSystemRoleBean);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZxSystemRoleBean    返回类型 
	 * @throws
	 */
	public void selectBeanById(int id,ModelMap model){
		model.addAttribute("zxSystemRole", this.zxSystemRoleDao.selectBeanById(id));
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param zxSystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(ZxSystemRoleBean zxSystemRoleBean){
		this.zxSystemRoleDao.update(zxSystemRoleBean);
	}
	
	
	/**
	 * 
	 * @Title: selectZxSystemRoleByCpyId 
	 * @Description: 查询公司内所有角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<ZxSystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemRoleBean> selectZxSystemRoleByCpyId(int cpyId){
		return this.zxSystemRoleDao.selectZxSystemRoleByCpyId(cpyId);
	}
}