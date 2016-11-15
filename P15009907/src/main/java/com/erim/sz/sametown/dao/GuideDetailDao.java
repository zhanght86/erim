package com.erim.sz.sametown.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideDetailBean;

/**
 * 
 * @类名: GuideDetailDao
 * @描述: 导游
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:06:56
 *
 */
@Repository("guideDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageGuide
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<GuideDetailBean> 返回类型
	 * @throws
	 */
	public List<GuideDetailBean> selectPageGuide(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"guidedetail.selectPageGuide",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

}
