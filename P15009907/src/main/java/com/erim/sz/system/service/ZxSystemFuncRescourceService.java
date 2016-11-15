package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.system.bean.ZxSystemFuncRescourceBean;
import com.erim.sz.system.dao.ZxSystemFuncRescourceDao;

/**
 * 
 * @ClassName: ZxSystemFuncRescourceService 
 * @Description: 角色权限关联
 * @author maoxian
 * @date 2015年8月2日 上午12:59:41
 */
@Service("zxSystemFuncRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemFuncRescourceService {

	@Autowired
	private ZxSystemFuncRescourceDao zxSystemFuncRescourceDao;
	
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有
	 * @param @return    设定文件 
	 * @return List<ZxSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemFuncRescourceBean> selectAll(){
		return this.zxSystemFuncRescourceDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectRecourceByFuncCode 
	 * @Description: 根据权限获取功能
	 * @param @param funcCode
	 * @param @return    设定文件 
	 * @return List<ZxSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemFuncRescourceBean> selectRecourceByFuncCode(String zxFuncCode){
		return this.zxSystemFuncRescourceDao.selectRecourceByFuncCode(zxFuncCode);
	}
}