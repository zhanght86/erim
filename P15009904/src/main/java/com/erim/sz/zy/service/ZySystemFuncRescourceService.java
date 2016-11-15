package com.erim.sz.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.zy.bean.ZySystemFuncRescourceBean;
import com.erim.sz.zy.dao.ZySystemFuncRescourceDao;

/**
 * 
 * @ClassName: ZySystemFuncRescourceService 
 * @Description: 角色权限关联
 * @author maoxian
 * @date 2015年8月2日 上午12:59:41
 */
@Service("zySystemFuncRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemFuncRescourceService {

	@Autowired
	private ZySystemFuncRescourceDao zySystemFuncRescourceDao;
	
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有
	 * @param @return    设定文件 
	 * @return List<ZySystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemFuncRescourceBean> selectAll(){
		return this.zySystemFuncRescourceDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectRecourceByFuncCode 
	 * @Description: 根据权限获取功能
	 * @param @param funcCode
	 * @param @return    设定文件 
	 * @return List<ZySystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemFuncRescourceBean> selectRecourceByFuncCode(String zyFuncCode){
		return this.zySystemFuncRescourceDao.selectRecourceByFuncCode(zyFuncCode);
	}
}