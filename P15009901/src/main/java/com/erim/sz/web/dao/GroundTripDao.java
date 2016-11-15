package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundTriplBean;

/**
 * @ClassName: LineTripDao 
 * @Description: 专线
 * @author 李庆
 * @date 2015年11月6日 下午6:05:15 
 */
@Repository("groundtripDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundTripDao extends BaseDao{

	
	/**
	 * @描述: 根据产品ID获取行程管理信息
	 * @作者: 李庆
	 * @创建时间: 2015年11月18日 上午10:18:01
	 * @param tdlId
	 * @return
	 */
	public List<GroundTriplBean> getTripByTdlId(@Param("tdlId")Integer tdlId){
		return this.getSqlSession().selectList("groundtrip.tripByTxiId", tdlId);
	}
}
