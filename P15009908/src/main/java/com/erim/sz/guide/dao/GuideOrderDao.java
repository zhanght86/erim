package com.erim.sz.guide.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideOrderBean;

/***
 * 
* @ClassName: GuideOrderDao 
* @Description: 导游订单
* @author 龙龙
* @date 2015年7月30日 下午12:55:04 
*
 */
@Repository("guideOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGuide 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GuideOrderBean>    返回类型 
	 * @throws
	 */
    public List<GuideOrderBean> selectPageGuide(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("guideorder.selectPageGuide", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectGuide 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GuideOrderBean    返回类型 
     * @throws
     */
    public GuideOrderBean selectGuide(Integer id) {
        return getSqlSession().selectOne("guideorder.selectBeanByPriId", id);
    }
    

    /**
     * 
     * @Title: insertGuide 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertGuide(GuideOrderBean bean) {
        return getSqlSession().insert("guideorder.insert", bean);
    }
    
   /**
    * 
    * @Title: updateGuide 
    * @Description: 修改为接单或拒接状态
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public int updateGuide(GuideOrderBean bean){
     return	getSqlSession().update("guideorder.receiveOrRefuse", bean);
    }
    
    /**
     * 
     * @Title: deleteGuide 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteGuide(int id){
    	getSqlSession().update("guideorder.delete", id);
    }
}
