package com.erim.sz.data.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.SellSystemTeamBean;

/**
 * @ClassName: SellSystemTeamDao 
 * @Description: 所有旅行社
 * @author maoxian
 * @date 2015年11月26日 下午4:36:40
 */
@Repository("sellSystemTeamDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellSystemTeamDao extends BaseDao {

	/***
	 * 
	 * @Title: selectPageData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param baseBean
	 * @param @param map
	 * @param @return    设定文件 
	 * @return List<SellSystemTeamBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemTeamBean> selectPageData(SellSystemTeamBean baseBean,ModelMap map){
		return this.getSqlSession().selectList("sellsystemteam.selectPageData", baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
}
