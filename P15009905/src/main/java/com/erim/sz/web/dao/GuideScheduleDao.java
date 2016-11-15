package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideScheduleBean;

/**
 * 
 * @ClassName: GuideScheduleDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年9月11日 下午3:38:43 
 *
 */
@Repository("guideScheduleDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideScheduleDao extends BaseDao{

	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param guideScheduleBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(GuideScheduleBean guideScheduleBean){
		return this.getSqlSession().insert("guideschedule.insert", guideScheduleBean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param guideScheduleBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(GuideScheduleBean guideScheduleBean){
		return this.getSqlSession().update("guideschedule.update", guideScheduleBean);
	}
	
	/**
	 * @Title: selectAll 
	 * @Description: 查询
	 * @param @param gdlId
	 * @param @return    设定文件 
	 * @return List<GuideScheduleBean>    返回类型 
	 * @throws
	 */
	public List<GuideScheduleBean> selectAll(GuideScheduleBean guideScheduleBean){
		return this.getSqlSession().selectList("guideschedule.selectAll", guideScheduleBean);
	}
}
