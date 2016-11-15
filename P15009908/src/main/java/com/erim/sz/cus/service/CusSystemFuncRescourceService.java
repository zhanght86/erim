package com.erim.sz.cus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.cus.bean.CusSystemFuncRescourceBean;
import com.erim.sz.cus.dao.CusSystemFuncRescourceDao;

/**
 * 
 * @ClassName: CusSystemFuncRescourceService 
 * @Description: 角色权限关联
 * @author maoxian
 * @date 2015年8月2日 上午12:59:41
 */
@Service("cusSystemFuncRescourceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemFuncRescourceService {

	@Autowired
	private CusSystemFuncRescourceDao cusSystemFuncRescourceDao;
	
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncRescourceBean> selectAll(){
		return this.cusSystemFuncRescourceDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectRecourceByFuncCode 
	 * @Description: 根据权限获取功能
	 * @param @param funcCode
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncRescourceBean> selectRecourceByFuncCode(String cusFuncCode){
		return this.cusSystemFuncRescourceDao.selectRecourceByFuncCode(cusFuncCode);
	}
}