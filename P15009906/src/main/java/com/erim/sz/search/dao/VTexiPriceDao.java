package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.VTexiPriceBean;

/**
 * @ClassName: VTexiPriceDao 
 * @Description: 车辆价格表
 * @author maoxian
 * @date 2015年12月20日 下午7:50:52
 */
@Repository("vTexiPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VTexiPriceDao extends BaseDao {

	/**
	 * @Title: selectTexiPrice 
	 * @Description: 根据bean 查询量价
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<VTexiPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午7:52:01 
	 * @throws
	 */
	public List<VTexiPriceBean> selectTexiPrice(VTexiPriceBean bean) {
		return this.getSqlSession().selectList("vtexiprice.selectTexiPrice", bean);
	}
}
