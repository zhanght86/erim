package com.erim.sz.line.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineTripBean;


/**
 * @ClassName: LineTripDao 
 * @Description: 专线行程管理
 * @author maoxian
 * @date 2015年12月25日 上午1:17:57
 */
@Repository("linetripDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineTripDao extends BaseDao{
	
	/**
	 * @Title: getTripByTdlId 
	 * @Description: 根据专线id查询行程
	 * @param @param lineTripBean
	 * @param @return    设定文件 
	 * @return List<LineTripBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午1:17:41 
	 * @throws
	 */
	public List<LineTripBean> getTripByTdlId(Integer tdlId){
		return this.getSqlSession().selectList("linetrip.tripByLineId", tdlId);
	}
}
