package com.erim.sz.texi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiSendPriceBean;

/**
 * @类名: TexiSendPriceDao
 * @描述: 租车管理固定接送量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月13日 下午4:14:36
 */
@Repository("texiSendPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiSendPriceDao extends BaseDao {

	/**
	 * @方法名: selectSendPriceList
	 * @描述: 租车管理固定接送量价管理数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午4:13:11 
	 * @param bean
	 * @param monthCount
	 * @return
	 */
	public List<TexiSendPriceBean> selectSendPriceList(TexiSendPriceBean bean, String[] monthCount) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", monthCount);
		map.put("bean", bean);
		
		return getSqlSession().selectList("sendPrice.selectSendPriceList", map);
	}
	
	/**
	 * @方法名: insertSendPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午4:16:25 
	 * @param bean
	 * @return
	 */
	public Integer insertSendPrice(TexiSendPriceBean bean) {
		return getSqlSession().insert("sendPrice.insert", bean);
	}
	
	/**
	 * @方法名: updateSendPrice
	 * @描述: 修改量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午4:18:39 
	 * @param bean
	 * @return
	 */
	public Integer updateSendPrice(TexiSendPriceBean bean) {
		return getSqlSession().update("sendPrice.updatePrice", bean);
	}

	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午4:17:08 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(TexiSendPriceBean bean) {
		return getSqlSession().update("sendPrice.updateIsOpen", bean);
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:26:10 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(TexiSendPriceBean bean) {
		return getSqlSession().update("sendPrice.updateBatchOpen", bean);
	}
}
