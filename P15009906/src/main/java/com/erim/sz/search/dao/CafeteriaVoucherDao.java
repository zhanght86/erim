package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaVoucherBean;

/**
 * @类名: CafeteriaVoucherDao
 * @描述: 查询某餐厅的代金券信息
 * @作者: 国亚文
 * @创建时间: 2015年12月31日 下午4:08:10
 */
 
@Repository("cafeteriaVoucherDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaVoucherDao extends BaseDao{
   /**
    * @方法名: selectVoucherByCpeId
    * @描述: 根据某餐厅id 查询代金券信息
    * @作者: 国亚文
    * @创建时间: 2015年12月31日 下午4:17:53 
    * @param cdlId
    * @return List<CafeteriaVoucherBean>
    */      
   public List<CafeteriaVoucherBean> selectVoucherByCpeId(Integer cdlId) {
    	return getSqlSession().selectList("cafeteriaVoucher.selectVoucherBycdlId", cdlId);
   }
    
    
}
