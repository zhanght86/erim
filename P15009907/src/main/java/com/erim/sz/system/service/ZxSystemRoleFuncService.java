package com.erim.sz.system.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.ZxSystemFuncBean;
import com.erim.sz.system.bean.ZxSystemRoleFuncBean;
import com.erim.sz.system.dao.ZxSystemRoleFuncDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: ZxSystemRoleFuncService 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:31:36
 */
@Service("zxSystemRoleFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemRoleFuncService {

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ZxSystemRoleFuncService.class);
	
	@Autowired
	private ZxSystemRoleFuncDao zxSystemRoleFuncDao;
	@Autowired
	private ZxSystemFuncService zxSystemFuncService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入
	 * @param @param zxSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<ZxSystemRoleFuncBean> zxSystemRoleFuncBeans){
		this.zxSystemRoleFuncDao.insertList(zxSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色查询对应权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<ZxSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.zxSystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
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
		this.zxSystemRoleFuncDao.deleteByRoleId(zxRoleId);
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
			List<ZxSystemRoleFuncBean> listZxSystemRoleFuncBean = this.selectRoleFuncByRoleId(roleid);
			
			//获取权限
			String userIsManagement = (String)SecurityUtils.getSubject().getSession().getAttribute("userIsManagement");
			
			String funcode = "",childFunc = "";
			for(ZxSystemRoleFuncBean funcBean : listZxSystemRoleFuncBean){
				String zxFuncCode = funcBean.getZxFuncCode();
				//如果用户锁住了
				if(CommonUtil.isLockUser()){
					if(!"SYSTEM_PRICE_QUERY".equals(zxFuncCode)) continue;
					
					model.addAttribute("lockmessage", "试用24小时已经到期，请充值服务费后退出重新登录系统!");
				}
				//截取parentcode
				String[] aZxFuncCode = zxFuncCode.split("_");
				if(!funcode.contains(aZxFuncCode[0])){
					funcode += aZxFuncCode[0]+",";
				}
				//获取二级菜单列表
				String chiFUnc = aZxFuncCode[0]+"_"+aZxFuncCode[1];
				if(!childFunc.contains(chiFUnc)){
					//如果不是国际线 隐藏签证
					if("0".equals(userIsManagement)){
						if(chiFUnc.contains("MANAGEMENT")) continue;
					}
					childFunc += chiFUnc+",";
				}
			}
			//去掉最后,号
			if(!"".equals(funcode)) funcode = funcode.substring(0,funcode.length()-1);
			if(!"".equals(childFunc)) childFunc = childFunc.substring(0,childFunc.length()-1);
			logger.info("funcode:"+funcode);
			logger.info("childFunc:"+childFunc);
			
			//获取父级所有权限
			List<ZxSystemFuncBean> parentListFunc = this.zxSystemFuncService.selectFuncByCode(funcode.split(","));
			//获取所有子集权限
			List<ZxSystemFuncBean> childListFunc = this.zxSystemFuncService.selectFuncByCode(childFunc.split(","));
			
			model.addAttribute("parentListFunc", parentListFunc);
			model.addAttribute("childListFunc", childListFunc);
		}
	}
}
