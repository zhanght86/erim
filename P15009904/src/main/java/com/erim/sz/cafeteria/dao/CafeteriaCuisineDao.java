package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaCuisineBean;
	/**
	 * @ClassName:   CafeteriaCuisineDao 
	 * @Description: 特色菜 
	 * @author       贺渊博 
	 * @date        2015年10月2日 下午3:18:45 
	 */
@Repository("cafeteriaCuisineDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaCuisineDao extends BaseDao{
	/**
	 * @Description:     分页查询
	 * @param            baseBean
	 * @param @param     model 
	 * @return           List<CafeteriaCuisineBean> 返回类型
	 */
//	public List<CafeteriaCuisineBean> selectPageCuisine(BaseBean baseBean,ModelMap model){
//		return getSqlSession().selectList("cafeteriacuisine.selectPageCuisine",baseBean, 
//				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
//	}
	/**
	 * 
	 * @方法名: selectCuisine
	 * @描述: 特色菜列表页(不分页显示)
	 * @作者: 王赛
	 * @创建时间: 2015年11月18日 下午2:40:37 
	 * @param bean
	 * @param model
	 * @return
	 *
	 */
	public List<CafeteriaCuisineBean> selectCuisine(CafeteriaCuisineBean bean,ModelMap model) {
		return getSqlSession().selectList("cafeteriacuisine.selectCuisine", bean);
					
	}
	/**
 	 * @Title: 		 deleteTexi
 	 * @Description: 特色菜上下架
 	 * @param @param id 设定文件
 	 * @return       void 返回类型
 	 * @throws
 	 */
	public void delCuisine(CafeteriaCuisineBean cafeteriaCuisineBean){
		getSqlSession().update("cafeteriacuisine.delCuisine",cafeteriaCuisineBean);
	}
	/**
	 * @方法名：     delete 
	 * @描述:     特色菜删除
	 * @作者：        贺渊博
	 * @创建时间： 2015年10月18日 上午11:13:56
	 * @param    id
	 *
	 */
	public void delete(int id){
		getSqlSession().delete("cafeteriacuisine.delete",id);
	}
	
	/**
	   * @Title:           查询
	   * @Description:     根据id查询特色菜
	   * @param @param     id
	   * @param @return    设定文件 
	   * @return 			CafeteriaCuisineBean    返回类型 
	   * @throws
	   */
	    public CafeteriaCuisineBean selectCafeteriaCuisineById(CafeteriaCuisineBean bean){
	    	return this.getSqlSession().selectOne("cafeteriacuisine.selectCafeteriaCuisineById",bean);
	    }
  
	/**
	 * @Title:        insert 
	 * @Description:  新增 
	 * @param @param  cafeteriaCuisineBean
	 * @param @return 设定文件 
	 * @return        int 返回类型 
	 * @throws
	 */
	public Integer insert(CafeteriaCuisineBean bean){
		return this.getSqlSession().insert("cafeteriacuisine.insert", bean);
	}
	
	/**
	 * @Title: 		  update 
	 * @Description:  修改
	 * @param @param  cafeteriaCuisineBean 设定文件 
	 * @return        void  返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaCuisineBean bean){
		return this.getSqlSession().update("cafeteriacuisine.update", bean);
	}
	

}
