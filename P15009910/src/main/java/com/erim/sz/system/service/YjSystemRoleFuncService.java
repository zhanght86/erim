package com.erim.sz.system.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.YjSystemFuncBean;
import com.erim.sz.system.bean.YjSystemRoleFuncBean;
import com.erim.sz.system.dao.YjSystemRoleFuncDao;

/**
 * 
 * @ClassName: YjSystemRoleFuncService 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:31:36
 */
@Service("yjSystemRoleFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class YjSystemRoleFuncService {

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(YjSystemRoleFuncService.class);
	
	@Autowired
	private YjSystemRoleFuncDao yjSystemRoleFuncDao;
	@Autowired
	private YjSystemFuncService yjSystemFuncService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入
	 * @param @param yjSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<YjSystemRoleFuncBean> yjSystemRoleFuncBeans){
		this.yjSystemRoleFuncDao.insertList(yjSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色查询对应权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<YjSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<YjSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.yjSystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
	}
	
	/**
	 * 
	 * @Title: deleteByRoleId 
	 * @Description: 根据角色id删除
	 * @param @param roleid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteByRoleId(String zxRoleId){
		this.yjSystemRoleFuncDao.deleteByRoleId(zxRoleId);
	}
	
	/**
	 * 
	 * @Title: selectFuncByRoleId 
	 * @Description: 根据角色id判断权限
	 * @param @param roleid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectFuncByRoleId(String roleid,ModelMap model){
		
		if(StringUtils.isNotBlank(roleid)){
			//获取角色所有权限
			List<YjSystemRoleFuncBean> listYjSystemRoleFuncBean = this.selectRoleFuncByRoleId(roleid);
			
			String funcode = "",childFunc = "";
			for(YjSystemRoleFuncBean funcBean : listYjSystemRoleFuncBean){
				String zxFuncCode = funcBean.getYjFuncCode();
				//截取parentcode
				String[] aYjFuncCode = zxFuncCode.split("_");
				if(!funcode.contains(aYjFuncCode[0])){
					funcode += aYjFuncCode[0]+",";
				}
				//获取二级菜单列表
				String chiFUnc = aYjFuncCode[0]+"_"+aYjFuncCode[1];
				if(!childFunc.contains(chiFUnc)){
					childFunc += chiFUnc+",";
				}
			}
			//去掉最后,号
			if(!"".equals(funcode)) funcode = funcode.substring(0,funcode.length()-1);
			if(!"".equals(childFunc)) childFunc = childFunc.substring(0,childFunc.length()-1);
			logger.info("funcode:"+funcode);
			logger.info("childFunc:"+childFunc);
			
			//获取父级所有权限
			List<YjSystemFuncBean> parentListFunc = this.yjSystemFuncService.selectFuncByCode(funcode.split(","));
			//获取所有子集权限
			List<YjSystemFuncBean> childListFunc = this.yjSystemFuncService.selectFuncByCode(childFunc.split(","));
			
			model.addAttribute("parentListFunc", parentListFunc);
			model.addAttribute("childListFunc", childListFunc);
		}
	}
}
