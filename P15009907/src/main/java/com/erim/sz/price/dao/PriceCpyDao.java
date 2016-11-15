package com.erim.sz.price.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PriceCpyBean;

/**
 * @ClassName: PriceCpyDao 
 * @Description: 佣金管理
 * @author maoxian
 * @date 2015年11月3日 上午11:26:12
 */
@Repository("priceCpyDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PriceCpyDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<PriceCpyBean>    返回类型 
	 * @throws
	 */
    public List<PriceCpyBean> selectPageLine(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("pricecpy.selectPageLine", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
   /**
    * 
    * @Title: updateLine 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateLine(PriceCpyBean bean){
    	getSqlSession().update("pricecpy.update", bean);
    }
}
