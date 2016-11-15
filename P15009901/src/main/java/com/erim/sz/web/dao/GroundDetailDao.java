package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;

/**
 * 
 * @ClassName: GroundDetailDao 
 * @Description: 当地旅游
 * @author maoxian
 * @date 2015年11月15日 下午4:02:49 
 *
 */
@Repository("groundDetailDao")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageLine
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<LineDetailBean> 返回类型
	 * @throws
	 */
	public List<GroundDetailBean> selectPageGround(BaseBean baseBean, ModelMap model, Integer limit) {
		return getSqlSession().selectList("grounddetail.selectPageGround",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
	}
	/**
	 * 
	 * @方法名: selectCafeteria
	 * @描述: 根据id查询当地游信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午10:17:48 
	 * @param id
	 * @return
	 *
	 */
	public GroundDetailBean selectGround(Integer id) {
        return getSqlSession().selectOne("grounddetail.selectgroundDetialById", id);
    }
	
	/**
	 * @Title: selectGroundExport 
	 * @Description: 导出文档用接口
	 * @param @param id
	 * @param @return    设定文件 
	 * @return GroundDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午5:10:10 
	 * @throws
	 */
	public GroundDetailBean selectGroundExport(Integer id){
		return this.getSqlSession().selectOne("grounddetail.selectGroundExport", id);
	}
	/**
	 * 
	 * @方法名: selectGround
	 * @描述: 行程查询管理
	 * @作者: 王赛
	 * @创建时间: 2015年11月25日 上午11:51:25 
	 * @param bean
	 * @return
	 *
	 */
	public GroundDetailBean selectGround(GroundDetailBean bean) {
        return getSqlSession().selectOne("grounddetail.selectBeanByPriId", bean);
    }
	public List<GroundPriceBean> selectPriceByGroundId(GroundPriceBean bean){
		return getSqlSession().selectList("groundprice.selectPriceByGroundId", bean);
	}
}
