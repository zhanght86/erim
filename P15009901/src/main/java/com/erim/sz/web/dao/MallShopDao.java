package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallShopBean;

/**
 * 
 * @ClassName: MallShopDao 
 * @Description: 商城管理
 * @author maoxian
 * @date 2015年9月16日 下午6:56:04 
 *
 */
@Repository("mallshopDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallShopDao extends BaseDao {

	/**
	 * @Title: selectAllByShopBean 
	 * @Description: 商城
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallShopBean>    返回类型 
	 * @throws
	 */
	public List<MallShopBean> selectList(MallShopBean bean){
		return this.getSqlSession().selectList("mallshop.selectList", bean);
	}
}
