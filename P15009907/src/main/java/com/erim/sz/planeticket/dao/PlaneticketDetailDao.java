package com.erim.sz.planeticket.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketDetailBean;
	
 /**
  * @ClassName: PlaneticketDetailDao 
  * @Description: 机票管理 
  * @author maoxian
  * @date 2015年10月29日 下午12:04:45
  */
 @Repository("planeticketDao")
 @Scope(BeanDefinition.SCOPE_PROTOTYPE)
 public class PlaneticketDetailDao extends BaseDao{
	 
	 public List<PlaneticketDetailBean> selectPageTown(BaseBean baseBean, ModelMap model){
		 return getSqlSession().selectList("planeticketdetail.selectPageTown", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	 }
	 
	 

	/**
	 * @Title: 	  updatecode 
	 * @Description: 修改编码
	 * @param @param bean  设定文件 
	 * @return 	  void  返回类型 
	 * @throws
	 */
	public Integer updatecode(PlaneticketDetailBean bean){
		return getSqlSession().update("planeticketdetail.updatecode", bean);
	}
	 
	/**
	 * @Title: selectPlaneticket 
	 * @Description: 根据机票查询条件 查询所有机票 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
	public List<PlaneticketDetailBean> selectPlaneticket(PlaneticketDetailBean bean){
		return this.getSqlSession().selectList("planeticketdetail.selectPlaneticket",bean);
	}
	
	/**
	 * @Title: 		  selectPagePlaneticket 
	 * @Description:  分页查询
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return 		  List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
    public List<PlaneticketDetailBean> selectPagePlaneticket(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("planeticketdetail.selectPagePlaneticket", baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    } 
    
    /**
     * @Title: 		  	selectPlaneticket 
     * @Description: 	根据id查询
     * @param @param 	id
     * @param @return   设定文件 
     * @return 			PlaneticketDetailBean    返回类型 
     * @throws
     */
    public PlaneticketDetailBean selectPlaneticket(Integer id) {
        return getSqlSession().selectOne("planeticketdetail.selectBeanByPriId", id);
    }

    /**
     * @Title: 		  insertPlaneticket 
     * @Description:  插入
     * @param @param  bean
     * @param @return 设定文件 
     * @return       int    返回类型 
     * @throws
     */
    public int insertPlaneticket(PlaneticketDetailBean bean) {
        return getSqlSession().insert("planeticketdetail.insert", bean);
    }
    
	/**
	 * @Title: 		updatePlaneticket 
	 * @Description: 修改
	 * @param @param bean    设定文件 
	 * @return 		void    返回类型 
	 * @throws
	 */
    public void updatePlaneticket(PlaneticketDetailBean bean){
    	getSqlSession().update("planeticketdetail.update", bean);
    }
    
    /**
     * 
     * @Title: 		 deletePlaneticket 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return       void    返回类型 
     * @throws
     */
    public void deletePlaneticket(int id){
    	getSqlSession().update("planeticketdetail.delete", id);
    }
    /**
 	 * @Title:       deletePlaneticket
 	 * @Description: 上下架信息
 	 * @param @param id 设定文件
 	 * @return       void 返回类型
 	 * @throws
 	 */
 	public void deletePlaneticket(PlaneticketDetailBean bean) {
 		getSqlSession().update("planeticketdetail.deletebean", bean);
 	}
}
