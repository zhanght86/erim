package com.erim.sz.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemRoleBean;
import com.erim.sz.zy.dao.ZySystemRoleDao;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("zySystemRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemRoleService {

	@Autowired
	private ZySystemRoleDao zySystemRoleDao;
	
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZySystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(ZySystemRoleBean roleBean, ModelMap model){
		//设置只能查看本公司
		roleBean.setCpyId(CommonUtil.getCpyId());
		
		roleBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<ZySystemRoleBean> userList  = this.zySystemRoleDao.selectPage(roleBean, model);
		System.out.println("长度:"+userList.size());
		//回传
		model.addAttribute("userList", userList);
	}
	
	/**
	 * @Title: selectBeanByCooperation 
	 * @Description: 根据共享角色查询 共享帐户
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectBeanByCooperation(ModelMap model){
		model.addAttribute("listrole", this.zySystemRoleDao.selectBeanByCooperation(CommonUtil.getCpyId()));
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色表
	 * @param @param zySystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(ZySystemRoleBean zySystemRoleBean){
		zySystemRoleBean.setCpyId(CommonUtil.getCpyId());
		return this.zySystemRoleDao.insert(zySystemRoleBean);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZySystemRoleBean    返回类型 
	 * @throws
	 */
	public void selectBeanById(int id,ModelMap model){
		model.addAttribute("zySystemRole", this.zySystemRoleDao.selectBeanById(id));
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param zySystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(ZySystemRoleBean zySystemRoleBean){
		this.zySystemRoleDao.update(zySystemRoleBean);
	}
	
	/**
	 * @Title: selectRoleIdByRolenameCpyid 
	 * @Description: 根据角色名称查询角色id
	 * @param @param rolename
	 * @param @return    设定文件 
	 * @return ZySystemRoleBean    返回类型 
	 * @throws
	 */
	public ZySystemRoleBean selectRoleIdByRolenameCpyid(String rolename){
		ZySystemRoleBean param = new ZySystemRoleBean();
		param.setCpyId(CommonUtil.getCpyId());
		param.setZyRoleName(rolename);
		return this.zySystemRoleDao.selectRoleIdByRolenameCpyid(param);
	}
	
	/**
	 * 
	 * @Title: selectZySystemRoleByCpyId 
	 * @Description: 查询公司内所有角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleBean> selectZySystemRoleByCpyId(int cpyId){
		return this.zySystemRoleDao.selectZySystemRoleByCpyId(cpyId);
	}
}