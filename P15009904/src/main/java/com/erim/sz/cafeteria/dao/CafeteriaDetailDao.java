package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;

/**
 * @ClassName:    CafeteriaDetailDao 
 * @Description:  (特色餐管理) 
 * @author        贺渊博
 * @date          2015年10月2日 上午8:52:07 
 */
@Repository("cafeteriadao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaDetailDao extends BaseDao {
	
	/**
	 * @方法名：selectPageTown 
	 * @描述: 同城同业	
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午3:33:09
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<CafeteriaDetailBean> selectPageTown (BaseBean baseBean, ModelMap model) {
		return getSqlSession().selectList("cafeteriadetail.selectPageTown", baseBean, 
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @描述: 分页查询
	 * @作者: 
	 * @创建时间: 2015年12月8日 上午11:26:16
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<CafeteriaDetailBean> selectPageCafeteria(BaseBean baseBean,ModelMap model ){
		return getSqlSession().selectList("cafeteriadetail.selectPageCafeteria", baseBean, 
				new RowBounds(baseBean.getPageLinkBean().getStart(),baseBean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @Title:         selectCafeteriaById
	 * @Description:   根据id查询
	 * @param          id
	 * @return         CafeteriaDetailBean返回类型
	 */
	public CafeteriaDetailBean selectCafeteria(Integer id){
		return getSqlSession().selectOne("cafeteriadetail.selectCafeteriaDetailById",id);
	}
	
	/**
	 * @描述: 特色餐新增方法
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月1日 下午3:41:51
	 * @param bean
	 * @return
	 */
	public Integer insertCafeteria(CafeteriaDetailBean bean) {
		return getSqlSession().insert("cafeteriadetail.insert", bean);
	}
	
	 /**
	  * @Title:       updateCafeteria
	  * @Description： 修改特色餐
	  * @return：          void 返回类型
	  */
	public Integer updateCafeteria(CafeteriaDetailBean bean){
	    return	getSqlSession().update("cafeteriadetail.update", bean);
	}
	
	 /**
	  * @Title:        deleteCafeteria
	  * @Description：   特色餐上线状态
	  * @return：
	  */
	public void deleteCafeteria(CafeteriaDetailBean bean) {
		getSqlSession().update("cafeteriadetail.delete", bean);
	}
	 
	/**
	 * 
	 * @方法名: updateCafeteriacode
	 * @描述: 编码自动生成
	 * @作者: 王赛
	 * @创建时间: 2015年10月15日 下午3:18:26 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateCafeteriacode(CafeteriaDetailBean bean){
		return getSqlSession().update("cafeteriadetail.updateCafeteriacode", bean);
	}

	/**
	 * @Title:       updateCafeteria
	 * @Description： 修改特色餐
	 * @return：          void 返回类型
	 */
	public Integer updateScheduled(CafeteriaDetailBean bean){
	    return	getSqlSession().update("cafeteriadetail.update1", bean);
	}    
}
