package com.erim.sz.planeticket.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketReturnBean;
	
 /**
  * @ClassName: PlaneticketReturnDao 
  * @Description: 机票中转 
  * @author maoxian
  * @date 2015年10月29日 下午12:19:24
  */
 @Repository("planeticketReturnDao")
 @Scope(BeanDefinition.SCOPE_PROTOTYPE)
 public class PlaneticketReturnDao extends BaseDao{
	 
	/**
	 * 
	 * @Title: 		  selectPagePlaneticket 
	 * @Description:  分页查询
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return 		  List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
    public List<PlaneticketReturnBean> selectPagePlaneticket(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("planeticketreturn.selectPagePlaneticket", baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    } 
    /**
     * 
     * @Title: 		  	selectPlaneticket 
     * @Description: 	根据id查询
     * @param @param 	id
     * @param @return   设定文件 
     * @return 			PlaneticketDetailBean    返回类型 
     * @throws
     */
    public PlaneticketReturnBean selectPlaneticket(Integer id) {
        return getSqlSession().selectOne("planeticketreturn.selectBeanByPriId", id);
    }
    
    /**
     * @Title: insert 
     * @Description: 插入
     * @param @param returnBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    public Integer insert(PlaneticketReturnBean returnBean){
    	return this.getSqlSession().insert("planeticketreturn.insert", returnBean);
    }
    /**
	 * @Title: 	  updatecode 
	 * @Description: 修改编码
	 * @param @param bean  设定文件 
	 * @return 	  void  返回类型 
	 * @throws
	 */
	public Integer updatecode(PlaneticketReturnBean bean){
		return getSqlSession().update("planeticketreturn.updatecode", bean);
	}
    
    /**
     * @Title: update 
     * @Description: 修改
     * @param @param returnBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年11月24日 上午12:10:48 
     * @throws
     */
    public Integer update(PlaneticketReturnBean returnBean){
    	return this.getSqlSession().update("planeticketreturn.update", returnBean);
    }
    
}
