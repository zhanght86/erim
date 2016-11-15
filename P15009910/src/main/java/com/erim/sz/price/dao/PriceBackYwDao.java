package com.erim.sz.price.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PriceBackYwBean;

/**
 * @ClassName: PriceBackYwDao 
 * @Description: 运维费返利
 * @author maoxian
 * @date 2015年12月17日 下午11:34:53
 */
@Repository("priceBackYwDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PriceBackYwDao extends BaseDao {

	/**
	 * @Title: selectPageYw 
	 * @Description: 分页查询运维费支付历史
	 * @param @param baseBean
	 * @param @return    设定文件 
	 * @return List<PriceBackYwBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午1:56:41 
	 * @throws
	 */
	public List<PriceBackYwBean> selectPage(PriceBackYwBean baseBean,ModelMap model){
		return getSqlSession().selectList("pricebackyw.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
}
