package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;

/**
 * @ClassName: CafeteriaVoucherPriceDao 
 * @Description: 代金劵管理
 * @author maoxian
 * @date 2015年11月8日 下午12:25:08
 */
@Repository("cafeteriaVoucherPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaVoucherPriceDao extends BaseDao {
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param bean
	 * @param 设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(List<CafeteriaVoucherPriceBean> list) {
		return getSqlSession().insert("cafeteriavoucherprice.insert", list);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaVoucherPriceBean bean){
		return this.getSqlSession().update("cafeteriavoucherprice.update",bean);
	}
	
	/**
	 * @Title: showList 
	 * @Description: 根据查询list
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<CafeteriaVoucherPriceBean>    返回类型 
	 * @throws
	 */
	public List<CafeteriaVoucherPriceBean> showList(Integer djqId){
		CafeteriaVoucherPriceBean bean = new CafeteriaVoucherPriceBean();
		bean.setDjqId(djqId);
		return this.getSqlSession().selectList("cafeteriavoucherprice.showList", bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(Integer id){
		return this.getSqlSession().delete("cafeteriavoucherprice.delete", id);
	}
}
