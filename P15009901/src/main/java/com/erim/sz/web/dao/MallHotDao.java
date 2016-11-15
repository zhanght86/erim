package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallHotBean;
import com.erim.sz.common.bean.MallShopBean;

/**
 * 
 * @ClassName: MallHotDao 
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月15日 下午4:32:35 
 *
 */
@Repository("mallHotDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallHotDao extends BaseDao {

	/**
	 * @Title: selectListMallHot 
	 * @Description: 根据条件查询热门
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallHotBean>    返回类型 
	 * @throws
	 */
	public List<MallHotBean> selectListMallHot(MallHotBean bean){
		return this.getSqlSession().selectList("mallhot.selectList", bean);
	}
}
