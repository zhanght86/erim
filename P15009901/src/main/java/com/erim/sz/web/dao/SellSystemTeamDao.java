package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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

	/**
	 * @Title: selectAll 
	 * @Description: 根据地域查询所有旅行社
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<SellSystemTeamBean>    返回类型 
	 * @author maoxian
	 * @date 2015年11月26日 下午4:37:50 
	 * @throws
	 */
	public List<SellSystemTeamBean> selectAll(SellSystemTeamBean bean){
		return this.getSqlSession().selectList("sellsystemteam.selectAll", bean);
	}
}
