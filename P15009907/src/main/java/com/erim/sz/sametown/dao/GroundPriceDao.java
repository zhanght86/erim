package com.erim.sz.sametown.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: GroundPriceDao
 * @描述: 当地游量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月25日 上午10:02:41
 *
 */
@Repository("groundPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundPriceDao extends BaseDao{

	/**
	 * 
	 * @方法名: selectGroundPriceList
	 * @描述: 当地游量价管理信息数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 上午10:12:35 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
    public List<GroundPriceBean> selectGroundPriceList(GroundPriceBean bean, String[] count) {
    	List<GroundPriceBean> list = new ArrayList<GroundPriceBean>();
    	
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
    	
		list = getSqlSession().selectList("groundprice.selectPriceList", map);
		
		return list;
    }
    /**
     * 
     * @方法名: insertPrice
     * @描述: 新增
     * @作者: 宁晓强
     * @创建时间: 2015年10月25日 上午10:13:22 
     * @param bean
     * @return
     *
     */
    public Integer insertPrice(GroundPriceBean bean) {
    	return getSqlSession().insert("groundprice.insert", bean);
    }
    /**
     * 
     * @方法名: updatePrice
     * @描述: 修改
     * @作者: 宁晓强
     * @创建时间: 2015年10月25日 上午10:13:51 
     * @param bean
     * @return
     *
     */
    public Integer updatePrice(GroundPriceBean bean) {
    	return getSqlSession().update("groundprice.update", bean);
    }
    /**
     * 
     * @方法名: updateIsOpen
     * @描述: 修改是否出售状态
     * @作者: 宁晓强
     * @创建时间: 2015年10月25日 上午10:14:22 
     * @param bean
     * @return
     *
     */
    public Integer updateIsOpen(GroundPriceBean bean) {
    	return getSqlSession().update("groundprice.updateIsOpen", bean);
    }
    /**
     * 
     * @方法名: updateBatchOpen
     * @描述: 批量修改是否出售状态
     * @作者: 宁晓强
     * @创建时间: 2015年10月25日 上午10:15:32 
     * @param bean
     * @param count
     * @return
     *
     */
    public Integer updateBatchOpen(GroundPriceBean bean, String[] count) {
    	Integer result = CommonUtil.ERROR;
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		result = getSqlSession().update("groundprice.updateBatchIsOpen", map);
		
		return result;
    }
}
