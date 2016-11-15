package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.system.bean.SellSystemFuncRescourceBean;
import com.erim.sz.system.dao.SellSystemFuncRescourceDao;

/**
 * 
 * @ClassName: SellSystemFuncRescourceService 
 * @Description: 角色权限关联
 * @author maoxian
 * @date 2015年8月2日 上午12:59:41
 */
@Service("sellSystemFuncRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemFuncRescourceService {

	@Autowired
	private SellSystemFuncRescourceDao sellSystemFuncRescourceDao;
	
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncRescourceBean> selectAll(){
		return this.sellSystemFuncRescourceDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectRecourceByFuncCode 
	 * @Description: 根据权限获取功能
	 * @param @param funcCode
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncRescourceBean> selectRecourceByFuncCode(String zxFuncCode){
		return this.sellSystemFuncRescourceDao.selectRecourceByFuncCode(zxFuncCode);
	}
}