package com.erim.sz.ground.dao;

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
	 * @Title: insert 
	 * @Description: 新增 
	 * @param @param ticketPriceBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public Integer insert(GroundTriplBean bean){
		return getSqlSession().insert("groundtrip.insert", bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param ticketPriceBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(GroundTriplBean groundTriplBean){
		this.getSqlSession().update("groundtrip.update", groundTriplBean);
	}
	
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
	
	/**
	 * @Title: delete 
	 * @Description: 删除 
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delete(Integer id){
		this.getSqlSession().delete("groundtrip.delete",id);
	}

	/**
	 * @描述: 批量增加
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午7:17:54
	 * @param list
	 * @return
	 */
	public Integer insertList(List<GroundTriplBean> list) {
		return getSqlSession().insert("groundtrip.insertList", list);
	}
}
