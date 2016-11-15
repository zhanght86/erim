package com.erim.sz.system.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.SellSystemFuncBean;
import com.erim.sz.system.bean.SellSystemRoleFuncBean;
import com.erim.sz.system.dao.SellSystemRoleFuncDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: SellSystemRoleFuncService 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:31:36
 */
@Service("sellSystemRoleFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemRoleFuncService {

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SellSystemRoleFuncService.class);
	
	@Autowired
	private SellSystemRoleFuncDao sellSystemRoleFuncDao;
	@Autowired
	private SellSystemFuncService sellSystemFuncService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入
	 * @param @param sellSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<SellSystemRoleFuncBean> sellSystemRoleFuncBeans){
		this.sellSystemRoleFuncDao.insertList(sellSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色查询对应权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<SellSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.sellSystemRoleFuncDao.selectRoleFuncByRoleId(roleid);
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
		this.sellSystemRoleFuncDao.deleteByRoleId(zxRoleId);
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
			List<SellSystemRoleFuncBean> listSellSystemRoleFuncBean = this.selectRoleFuncByRoleId(roleid);
			
			String funcode = "",childFunc = "";
			for(SellSystemRoleFuncBean funcBean : listSellSystemRoleFuncBean){
				String zxFuncCode = funcBean.getSellFuncCode();
				//如果用户锁住了
				if(CommonUtil.isLockUser()){
					if(!"PRICE_FYGL_QUERY".equals(zxFuncCode)) continue;
					
					model.addAttribute("lockmessage", "试用24小时已经到期，请充值服务费后退出重新登录系统!");
				}
				//截取parentcode
				String[] aSellFuncCode = zxFuncCode.split("_");
				if(!funcode.contains(aSellFuncCode[0])){
					funcode += aSellFuncCode[0]+",";
				}
				//获取二级菜单列表
				String chiFUnc = aSellFuncCode[0]+"_"+aSellFuncCode[1];
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
			List<SellSystemFuncBean> parentListFunc = this.sellSystemFuncService.selectFuncByCode(funcode.split(","));
			//获取所有子集权限
			List<SellSystemFuncBean> childListFunc = this.sellSystemFuncService.selectFuncByCode(childFunc.split(","));
			
			model.addAttribute("parentListFunc", parentListFunc);
			model.addAttribute("childListFunc", childListFunc);
		}
	}
}
