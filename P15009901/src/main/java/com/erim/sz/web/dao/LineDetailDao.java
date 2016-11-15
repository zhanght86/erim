package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.common.bean.LineTripBean;

/**
 * @ClassName: LineDetailDao 
 * @Description: 专线 
 * @author maoxian
 * @date 2015年10月3日 下午1:39:16
 */
@Repository("linedetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineDetailDao extends BaseDao {

	
	
	 /**
     * @Title: selectLineByCpyid 
     * @Description: 根据企业id搜索专线
     * @param @param cpyId
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @author maoxian
     * @date 2015年12月10日 下午11:00:53 
     * @throws
     */
    public List<LineDetailBean> selectLineByaCpyid(String[] cpyId,LineDetailBean bean,Integer sellId){
    	bean.setAstrcpyId(cpyId);
    	bean.setSellId(sellId);
    	return this.getSqlSession().selectList("linedetail.selectLineByaCpyid", bean);
    }
    
	/**
	 * @Title: selectListById 
	 * @Description: 根据数组查询id
	 * @param @param id
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
	public List<LineDetailBean> selectListById(Integer[] id){
		return this.getSqlSession().selectList("linedetail.selectListById", id);
	}
	
	/**
	 * @Title: selectBeanByLineId 
	 * @Description: 根据id查询专线 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return LineDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月27日 下午7:27:19 
	 * @throws
	 */
	public LineDetailBean selectBeanByLineId(Integer id){
		return this.getSqlSession().selectOne("linedetail.selectBeanByLineId", id);
	}
	
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
	public List<LineDetailBean> selectPageLine(BaseBean baseBean, ModelMap model, Integer limit) {
		return getSqlSession().selectList("linedetail.selectPageLine",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
	}
	/**
	 * 
	 * @Title: selectLine
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return LineDetailBean 返回类型
	 * @throws
	 */
	public LineDetailBean selectLine(Integer id) {
		return getSqlSession().selectOne("linedetail.selectLineDetialById", id);
	}
	public List<LinePriceBean> selectPriceByLineId(LinePriceBean bean){
		return getSqlSession().selectList("lineprice.selectPriceByLineId", bean);
	}
	public List<LineTripBean> selectLineTripByLineId(LinePriceBean bean){
		return getSqlSession().selectList("linetrip.tripByTxiId", bean);
	}
	/**
	 * @Title: selectHotLine 
	 * @Description: 热门前
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
	public List<LineDetailBean> selectHotLine(){
		return this.getSqlSession().selectList("linedetail.selectHotLine");
	}
	/**
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
    public List<LineDetailBean> selectPageLine(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("linedetail.selectPageLine", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
	
	
	public List<LineDetailBean> selectZb(){
		return this.getSqlSession().selectList("linedetail.selectZb");
	}
	public List<LineDetailBean> selectGn(){
		return this.getSqlSession().selectList("linedetail.selectGn");
	}
	public List<LineDetailBean> selectGw1(){
		return this.getSqlSession().selectList("linedetail.selectGw1");
	}
	public List<LineDetailBean> selectGw2(){
		return this.getSqlSession().selectList("linedetail.selectGw2");
	}
	public List<LineDetailBean> selectGw3(){
		return this.getSqlSession().selectList("linedetail.selectGw3");
	}
}
