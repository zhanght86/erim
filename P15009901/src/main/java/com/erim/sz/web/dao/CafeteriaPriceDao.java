package com.erim.sz.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPriceBean;

/**
 * 
 * @类名: CafeteriaPriceDao
 * @描述: 特色餐套餐量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月18日 上午11:10:42
 *
 */
@Repository("cafeteriaPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPriceDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectCafeteriaPriceList
	 * @描述: 量价信息列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:16:13 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public List<CafeteriaPriceBean> selectCafeteriaPriceList(CafeteriaPriceBean bean, String[] count) {
		List<CafeteriaPriceBean> list = new ArrayList<CafeteriaPriceBean>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		try {
			list = getSqlSession().selectList("cafeteriaprice.selectPriceList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public CafeteriaPriceBean getPriceBeanById(Integer id) {
		
		return getSqlSession().selectOne("cafeteriaprice.selectById", id);
	}
}
