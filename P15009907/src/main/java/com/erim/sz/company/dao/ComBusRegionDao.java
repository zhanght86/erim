package com.erim.sz.company.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ComBusRegionBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @描述: 公司业务类型地址信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月10日 下午5:36:38
 */
@Repository("comBusRegionDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ComBusRegionDao extends BaseDao {

	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 下午5:39:51
	 * @param bean
	 * @return
	 */
	public Integer insert(ComBusRegionBean bean) {
		return getSqlSession().insert("combusregion.insert", bean);
	}
	
	/**
	 * @描述: 删除
	 * @作者: 宁晓强
	 * @创建时间: 2016年1月8日 下午4:05:09
	 * @param bean
	 * @return
	 */
	public Integer deleteRegion(ComBusRegionBean bean) {
		return getSqlSession().delete("combusregion.delete", bean);
	}
	
	/**
	 * @Title: listRegionBean 
	 * @Description: 获取所有范围
	 * @param @param ntype
	 * @param @return    设定文件 
	 * @return List<ComBusRegionBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午9:32:09 
	 * @throws
	 */
	public List<ComBusRegionBean> listRegionBean(String ntype){
		ComBusRegionBean bean = new ComBusRegionBean();
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setCbrBusType(ntype);
		System.out.println(this.getSqlSession().selectList("combusregion.listRegion",bean)+"2222222222222222222");
		return this.getSqlSession().selectList("combusregion.listRegion",bean);
	}
	
	
	/**
	 * @Title: listRegion 
	 * @Description: 
	 * @param @param cid
	 * @param @return    设定文件 
	 * @return List<ComBusRegionBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 下午3:06:35 
	 * @throws
	 */
	public List<ComBusRegionBean> listRegionByCpyId(Integer cpyId){
		return this.getSqlSession().selectList("combusregion.listRegionByCpyId", cpyId);
	}
}
