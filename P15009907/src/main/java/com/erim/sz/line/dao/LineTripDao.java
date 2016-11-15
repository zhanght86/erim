package com.erim.sz.line.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineTripBean;

/**
 * @ClassName: LineTripDao 
 * @Description: 专线
 * @author 李庆
 * @date 2015年11月6日 下午6:05:15 
 */
@Repository("linetripDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineTripDao extends BaseDao{

	/**
	 * @Title: insert 
	 * @Description: 新增 
	 * @param @param ticketPriceBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public Integer insert(LineTripBean bean){
		return getSqlSession().insert("linetrip.insert", bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param ticketPriceBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(LineTripBean tripBean){
		this.getSqlSession().update("linetrip.update", tripBean);
	}
	
	/**
	 * @描述: 根据产品ID获取行程管理信息
	 * @作者: 李庆
	 * @创建时间: 2015年11月18日 上午10:18:01
	 * @param tdlId
	 * @return
	 */
	public List<LineTripBean> getTripByTdlId(@Param("tdlId")Integer tdlId){
		return this.getSqlSession().selectList("linetrip.tripByTxiId", tdlId);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除 
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delete(Integer id){
		this.getSqlSession().delete("linetrip.delete",id);
	}

	/**
	 * @描述: 批量增加
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午7:17:54
	 * @param list
	 * @return
	 */
	public Integer insertList(List<LineTripBean> list) {
		return getSqlSession().insert("linetrip.insertList", list);
	}
}
