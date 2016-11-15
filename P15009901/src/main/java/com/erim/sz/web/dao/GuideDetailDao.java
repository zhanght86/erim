package com.erim.sz.web.dao;

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
 * @ClassName: GuideDetailDao 
 * @Description: 导游详情
 * @author maoxian
 * @date 2015年11月3日 下午1:11:27
 */
@Repository("guideDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideDetailDao extends BaseDao {

	/**
	 * @描述: 根据ID获取一条导游基础信息
	 * @作者: 
	 * @创建时间: 2015年11月27日 下午9:31:29
	 * @param id
	 * @return
	 */
	public GuideDetailBean selectGuide(Integer id) {

		return getSqlSession().selectOne("guidedetail.selectById", id);
	}
	
	/**
	 * 
	 * @Title: selectPageGuide 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GuideDetailBean>    返回类型 
	 * @throws
	 */
    public List<GuideDetailBean> selectPageGuide(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("guidedetail.selectPageGuide", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    }
    
}
