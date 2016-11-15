package com.erim.sz.texi.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiOrderBean;

   /***
    * 
    * @ClassName:   TexiOrderDao 
    * @Description: 租车订单 
    * @author       贺渊博
    * @date         2015年10月1日 下午4:15:10 
    *
    */
    @Repository("texiOrderDao")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public class TexiOrderDao extends BaseDao{

	/**
	 * @Title: 		  selectPageTexi 
	 * @Description:  分页查询
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return 		  List<TexiOrderBean>  返回类型 
	 * @throws
	 */
    public List<TexiOrderBean> selectPageTexi(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texiorder.selectPageTexi", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: 		  selectTexi 
     * @Description:  根据id查询
     * @param @param  id
     * @param @return 设定文件 
     * @return        TexiOrderBean  返回类型 
     * @throws
     */
    public TexiOrderBean selectTexi(Integer id) {
        return getSqlSession().selectOne("texiorder.selectByBookId", id);
    }

    
   /**
    * @return 
    * @Title: 		updateTexi 
    * @Description: 修改
    * @param @param bean  设定文件 
    * @return 		void  返回类型 
    * @throws
    */
    public int updateTexi(TexiOrderBean bean){
    	System.out.println("bean ::::::"+bean.getId()+"   ddd:"+bean.getTorIsThrough());
    	return getSqlSession().update("texiorder.receiveOrRefuse", bean);
    }
    
  
}
