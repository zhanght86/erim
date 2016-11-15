package com.erim.sz.cus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cus.bean.CusSystemRoleBean;
import com.erim.sz.cus.dao.CusSystemRoleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("cusSystemRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemRoleService {

	@Autowired
	private CusSystemRoleDao cusSystemRoleDao;
	
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CusSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(CusSystemRoleBean roleBean, ModelMap model){
		//设置只能查看本公司
		roleBean.setCpyId(CommonUtil.getCpyId());
		
		roleBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<CusSystemRoleBean> userList  = this.cusSystemRoleDao.selectPage(roleBean, model);
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
		model.addAttribute("listrole", this.cusSystemRoleDao.selectBeanByCooperation(CommonUtil.getCpyId()));
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色表
	 * @param @param cusSystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(CusSystemRoleBean cusSystemRoleBean){
		cusSystemRoleBean.setCpyId(CommonUtil.getCpyId());
		return this.cusSystemRoleDao.insert(cusSystemRoleBean);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CusSystemRoleBean    返回类型 
	 * @throws
	 */
	public void selectBeanById(int id,ModelMap model){
		model.addAttribute("cusSystemRole", this.cusSystemRoleDao.selectBeanById(id));
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param cusSystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(CusSystemRoleBean cusSystemRoleBean){
		this.cusSystemRoleDao.update(cusSystemRoleBean);
	}
	
	/**
	 * @Title: selectRoleIdByRolenameCpyid 
	 * @Description: 根据角色名称查询角色id
	 * @param @param rolename
	 * @param @return    设定文件 
	 * @return CusSystemRoleBean    返回类型 
	 * @throws
	 */
	public CusSystemRoleBean selectRoleIdByRolenameCpyid(String rolename){
		CusSystemRoleBean param = new CusSystemRoleBean();
		param.setCpyId(CommonUtil.getCpyId());
		param.setCusRoleName(rolename);
		return this.cusSystemRoleDao.selectRoleIdByRolenameCpyid(param);
	}
	
	/**
	 * 
	 * @Title: selectCusSystemRoleByCpyId 
	 * @Description: 查询公司内所有角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<CusSystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemRoleBean> selectCusSystemRoleByCpyId(int cpyId){
		return this.cusSystemRoleDao.selectCusSystemRoleByCpyId(cpyId);
	}
}