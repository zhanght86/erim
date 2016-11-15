package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideRecordBean;

/**
 * @ClassName: GuideRecordDao 
 * @Description: 导游动态管理
 * @author maoxian
 * @date 2015年9月10日 下午7:52:25 
 */
@Repository("guideRecordDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideRecordDao extends BaseDao {

	/**
	 * @描述: 根据条件查询所有动态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月27日 下午4:47:27
	 * @param bean
	 * @return
	 */
	public List<GuideRecordBean> selectGuideRecordByRecord(GuideRecordBean bean){
		return getSqlSession().selectList("guiderecord.selectGuideRecordByRecord", bean);
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param guideRecordBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(GuideRecordBean bean) {
		return getSqlSession().insert("guiderecord.insert", bean);
	}
	
	/**
	 * @描述: 根据ID删除一条我的动态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午4:11:50
	 * @param bean
	 * @return
	 */
	public Integer del(GuideRecordBean bean){
		return getSqlSession().delete("guiderecord.delete", bean);
	}
}
