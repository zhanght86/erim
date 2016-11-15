package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideRecordBean;

/**
 * @ClassName: GuideRecordDao 
 * @Description: 动态介绍
 * @author maoxian
 * @date 2015年11月4日 上午12:10:36
 */
@Repository("guideRecordDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideRecordDao extends BaseDao {

	/**
	 * @Title: getListRcordByBean 
	 * @Description: 查询导游动态
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<GuideRecordBean>    返回类型 
	 * @throws
	 */
    public List<GuideRecordBean> getListRcordByBean(GuideRecordBean bean){
    	return this.getSqlSession().selectList("guiderecord.getListRcordByBean", bean);
    }
}
