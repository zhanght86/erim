package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.web.bean.TmSystemRegionBean;

/**
 * 
 * @ClassName: RegionDao 
 * @Description: 年月日
 * @author maoxian
 * @date 2015年8月19日 下午4:48:39 
 *
 */
@Repository("tmSystemRegionDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TmSystemRegionDao extends BaseDao{
	

	/**
	 * @Title: selectAllCode 
	 * @Description: 查询所有城市
	 * @param @return    设定文件 
	 * @return List<TmSystemRegionBean>    返回类型 
	 * @throws
	 */
	public List<TmSystemRegionBean> selectAllCode(){
		return this.getSqlSession().selectList("tmsystemregion.selectList");
	}
	
	/**
	 * 
	 * @Title: getSystemRegionById
	 * @Description: 根据主键ID获取一条信息
	 * @param id
	 * @return
	 *
	 */
	public TmSystemRegionBean getSystemRegionById(Integer regionId) {
		return this.getSqlSession().selectOne("tmsystemregion.getSystemRegionById", regionId);
	}
	/**
	 * 
	 * 查询所有省份
	 * @return List<TmSystemRegionBean>    返回类型 
	 */
	public List<TmSystemRegionBean> getSystemRegionForProvince() {
		return this.getSqlSession().selectList("tmsystemregion.selectListForProvince");
	}
	/**
	 * 根据RegionName查询城市code
	 * @param bean
	 * @return
	 */
	public List<TmSystemRegionBean> getSystemRegionByRegionName(TmSystemRegionBean bean) {
		return this.getSqlSession().selectList("tmsystemregion.getSystemRegionByRegionName",bean);
	}
}
