package com.erim.sz.guide.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideScheduleBean;

/***
 * 
* @ClassName: GuideScheduleDao 
* @Description: 导游档期
* @author 龙龙
* @date 2015年7月30日 下午5:24:39 
*
 */
@Repository("guideScheduleDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideScheduleDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGuide 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GuideScheduleBean>    返回类型 
	 * @throws
	 */
    public List<GuideScheduleBean> selectPageGuide(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("guideschedule.selectPageGuide", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectGuide 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GuideScheduleBean    返回类型 
     * @throws
     */
    public GuideScheduleBean selectGuide(Integer id) {
        return getSqlSession().selectOne("guideschedule.selectByBookId", id);
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
    public int insertGuide(GuideScheduleBean bean) {
        return getSqlSession().insert("guideschedule.insert", bean);
    }
    
   /**
    * 
    * @Title: updateGuide 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateGuide(GuideScheduleBean bean){
    	getSqlSession().update("guideschedule.update", bean);
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
    	getSqlSession().update("guideschedule.delete", id);
    }
}
