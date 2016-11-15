package com.erim.sz.line.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LinePriceBean;

/**
 * @ClassName: LinePriceDao 
 * @Description:专线量价接口
 * @author maoxian
 * @date 2015年12月25日 上午1:51:36
 */
@Repository("linePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LinePriceDao extends BaseDao {

	/**
	 * @Title: selectLinePriceList 
	 * @Description: 专线量价接口 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<LinePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午1:52:12 
	 * @throws
	 */
	public List<LinePriceBean> selectLinePriceList(LinePriceBean bean) {
		
		return getSqlSession().selectList("lineprice.selectPriceList", bean);
	}
	
	
}
