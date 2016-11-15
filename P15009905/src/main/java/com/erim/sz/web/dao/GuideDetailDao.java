package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideDetailBean;

/**
 * @ClassName: GuideDetailDao 
 * @Description: 导游
 * @author maoxian
 * @date 2015年9月10日 上午10:50:02 
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideDetailDao extends BaseDao {

	/**
	 * @Title: selectGuideByGdlCodePwd 
	 * @Description: 根据导游证号得到实体
	 * @param @param gdlCode
	 * @param @return    设定文件 
	 * @return GuideDetailBean    返回类型 
	 * @throws
	 */
	public GuideDetailBean selectGuideByGdlCodePwd(String gdlMobileUsers){
		return this.getSqlSession().selectOne("guidedetail.selectGuideByGdlCode", gdlMobileUsers);
	}
	
	/**
	 * @描述: 保存导游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午4:00:42
	 * @param guideDetailBean
	 */
	public Integer update(GuideDetailBean bean) {
		return getSqlSession().update("guidedetail.updateGuide", bean);
	}
	
	/**
	 * @描述: 根据导游ID获取一条导游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午2:35:08
	 * @param id
	 * @return
	 */
	public GuideDetailBean getGuideDetailById(Integer id) {
		return getSqlSession().selectOne("guidedetail.getGuideDetailById", id);
	}
	
	/**
	 * @描述: 修改导游密码
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月30日 上午11:17:51
	 * @param bean
	 * @return
	 */
	public Integer updateGuidePsd(GuideDetailBean bean) {
		return getSqlSession().update("guidedetail.updatePsd", bean);
	}
}
