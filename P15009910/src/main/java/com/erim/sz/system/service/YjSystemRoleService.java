package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.YjSystemUserBean;
import com.erim.sz.system.bean.YjSystemRoleBean;
import com.erim.sz.system.dao.YjSystemRoleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: YjSystemUserService 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("yjSystemRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class YjSystemRoleService {

	@Autowired
	private YjSystemRoleDao yjSystemRoleDao;
	
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<YjSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(YjSystemRoleBean roleBean, ModelMap model){
		
		roleBean.setCpyId(CommonUtil.getCpyId());
		roleBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<YjSystemRoleBean> userList  = this.yjSystemRoleDao.selectPage(roleBean, model);
		System.out.println("长度:"+userList.size());
		//回传
		model.addAttribute("userList", userList);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色表
	 * @param @param yjSystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(YjSystemRoleBean yjSystemRoleBean){
		yjSystemRoleBean.setCpyId(CommonUtil.getCpyId());
		return this.yjSystemRoleDao.insert(yjSystemRoleBean);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return YjSystemRoleBean    返回类型 
	 * @throws
	 */
	public void selectBeanById(int id,ModelMap model){
		model.addAttribute("yjSystemRole", this.yjSystemRoleDao.selectBeanById(id));
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param yjSystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(YjSystemRoleBean yjSystemRoleBean){
		this.yjSystemRoleDao.update(yjSystemRoleBean);
	}
	
	
	/**
	 * 
	 * @Title: selectYjSystemRoleByCpyId 
	 * @Description: 查询公司内所有角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<YjSystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<YjSystemRoleBean> selectYjSystemRoleByCpyId(int cpyId){
		return this.yjSystemRoleDao.selectYjSystemRoleByCpyId(cpyId);
	}

	public List<YjSystemUserBean> selectYjSystemUserByCpyId(int cpyid) {
		return  this.yjSystemRoleDao.selectYjSystemUserByCpyId(cpyid);
	}
}