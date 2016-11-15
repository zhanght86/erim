package com.erim.sz.message.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MessageProjectBean;

/**
 * 
 * @描述: 
 * 
 * @作者: （李庆）
 * @创建时间: 2015年11月27日 下午10:32:48
 */
@Repository("messageProjectBeanDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MessageProjectDao extends BaseDao {
	/**
	 * @Title: selectPageMessage
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<MessageProjectBean>    返回类型 
	 * @throws
	 */
    public List<MessageProjectBean> selectPageMessage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("messageproject.selectPageGround", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @描述: 根据当地游信息ID查询一条信息
     * @作者: 
     * @创建时间: 2015年11月25日 下午4:01:26
     * @param bean 当地游基础信息bean
     * @return
     */
    public MessageProjectBean selectGround(MessageProjectBean bean) {
        return getSqlSession().selectOne("messageproject.selectBeanByPriId", bean);
    }
    /**
     * @Title: 		  insertGround 
     * @Description:  新增当地旅游信息
     * @param @param  bean
     * @param @return 设定文件 
     * @return 		  int 返回类型 
     * @throws
     */
    public Integer insertGround(MessageProjectBean bean) {
        return getSqlSession().insert("messageproject.insert", bean);
    }
    /**
     * @Title: 		updateGround 
     * @Description: 修改
     * @param @param bean  设定文件 
     * @return 		void  返回类型 
     * @throws
     */
    public Integer updateGround(MessageProjectBean bean){
    	return getSqlSession().update("messageproject.update", bean);
    }
}
