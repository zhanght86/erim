package com.erim.sz.texi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDrivePriceBean;

/**
 * 
 * @类名: TexiDrivePriceDao
 * @描述: 租车管理自驾量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月16日 下午3:48:52
 *
 */
@Repository("texiDrivePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiDrivePriceDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectCarPriceList
	 * @描述: 租车管理包车量价管理数据列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:12:24 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public List<TexiDrivePriceBean> selectDrivePriceList(TexiDrivePriceBean bean, String[] count) {
		
		List<TexiDrivePriceBean> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", count);
		map.put("bean", bean);
		
		try {
			list = getSqlSession().selectList("drivePrice.selectDrivePriceList", map);
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}
	
	/**
	 * 
	 * @方法名: insertDrivePrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:13:33 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertDrivePrice(TexiDrivePriceBean bean) {
		return getSqlSession().insert("drivePrice.insert", bean);
	}
	
	/**
	 * 
	 * @方法名: updateDrivePrice
	 * @描述: 修改量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:14:23 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateDrivePrice(TexiDrivePriceBean bean) {
		return getSqlSession().update("drivePrice.updatePrice", bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 修改上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:15:12 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsOpen(TexiDrivePriceBean bean) {
		return getSqlSession().update("drivePrice.updateIsOpen", bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:18:10 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateBatchIsOpen(TexiDrivePriceBean bean) {
		return getSqlSession().update("drivePrice.updateBatchOpen", bean);
	}
}
