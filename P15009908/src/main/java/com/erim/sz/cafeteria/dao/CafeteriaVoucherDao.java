package com.erim.sz.cafeteria.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaVoucherBean;
	
/**
 * @ClassName:    CafeteriaVoucherDao 
 * @Description:  代金券 
 * @author        贺渊博 
 * @date          2015年10月2日 下午4:40:44 
 */
@Repository("cafeteriaVoucherDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaVoucherDao extends BaseDao{
	
	/**
	 * @Title: selectCafeteriaVoucherById
	 * @Description: 根据套餐查询代金券信息
	 * @return       CafeteriaVoucherBean
	 */
	public CafeteriaVoucherBean selectCafeteriaVoucherById(Integer cdlId){
    	return  getSqlSession().selectOne("cafeteriavoucher.selectCafeteriaVoucherById",cdlId);
    }
	
	/**
	 * @描述: 新增代金券信息
	 * @作者: 贺渊博
	 * @创建时间: 2015年11月24日 下午2:51:33
	 * @param bean
	 * @return
	 */
	public Integer insert(CafeteriaVoucherBean bean) {
		return getSqlSession().insert("cafeteriavoucher.insert", bean);
	}
		
	/**
	 * @Title: 		  update 
	 * @Description:  代金券修改
	 * @param @param  cafeteriaVoucherBean 设定文件 
	 * @return        void  返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaVoucherBean bean){
		return getSqlSession().update("cafeteriavoucher.update", bean);
	}
	
}
