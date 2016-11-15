package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundTriplBean;

/**
 * @ClassName: GroundTripDao 
 * @Description: 专线行程
 * @author maoxian
 * @date 2015年12月24日 下午10:45:15
 */
@Repository("groundtripDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundTripDao extends BaseDao{

	
	/**
	 * @Title: getTripByTdlId 
	 * @Description: 根据专线获取行程信息
	 * @param @param tdlId
	 * @param @return    设定文件 
	 * @return List<GroundTriplBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月24日 下午10:45:01 
	 * @throws
	 */
	public List<GroundTriplBean> getTripByTdlId(Integer tdlId){
		return this.getSqlSession().selectList("groundtrip.tripByTxiId", tdlId);
	}
	

}
