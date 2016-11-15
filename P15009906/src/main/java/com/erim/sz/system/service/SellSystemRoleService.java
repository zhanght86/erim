package com.erim.sz.system.service;

import java.util.List;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.SellSystemRoleBean;
import com.erim.sz.system.dao.SellSystemRoleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: SellSystemUserService 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("sellSystemRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemRoleService {

	@Autowired
	private SellSystemRoleDao sellSystemRoleDao;
	
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<SellSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(SellSystemRoleBean roleBean, ModelMap model){
		
		roleBean.setCpyId(CommonUtil.getCpyId());
		roleBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<SellSystemRoleBean> userList  = this.sellSystemRoleDao.selectPage(roleBean, model);
		System.out.println("长度:"+userList.size());
		//回传
		model.addAttribute("userList", userList);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色表
	 * @param @param sellSystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(SellSystemRoleBean sellSystemRoleBean){
		sellSystemRoleBean.setCpyId(CommonUtil.getCpyId());
		return this.sellSystemRoleDao.insert(sellSystemRoleBean);
	}
	
	/**
	 * @描述: 注册专用插入角色表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月15日 下午5:59:02
	 * @param bean
	 * @return
	 */
	public Integer insertRole(SellSystemRoleBean bean) {
		return sellSystemRoleDao.insert(bean);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return SellSystemRoleBean    返回类型 
	 * @throws
	 */
	public void selectBeanById(int id,ModelMap model){
		model.addAttribute("sellSystemRole", this.sellSystemRoleDao.selectBeanById(id));
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param sellSystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(SellSystemRoleBean sellSystemRoleBean){
		this.sellSystemRoleDao.update(sellSystemRoleBean);
	}
	
	
	/**
	 * 
	 * @Title: selectSellSystemRoleByCpyId 
	 * @Description: 查询公司内所有角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<SellSystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemRoleBean> selectSellSystemRoleByCpyId(int cpyId){
		return this.sellSystemRoleDao.selectSellSystemRoleByCpyId(cpyId);
	}
}