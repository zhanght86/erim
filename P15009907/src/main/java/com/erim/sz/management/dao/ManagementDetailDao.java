package com.erim.sz.management.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementDetailBean;

/***
 * @ClassName: ManagementDetailDao 
 * @Description: 签证
 * @author 龙龙
 * @date 2015年7月29日 下午4:57:16 
 */
@Repository("managementDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementDetailDao extends BaseDao {
	
	/**
	 * @方法名：selectPageTown 
	 * @描述:  同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月18日 下午7:12:29
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<ManagementDetailBean> selectPageTown(BaseBean baseBean, ModelMap model){
        return getSqlSession().selectList("managementdetail.selectPageTown", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}

	/**
	 * @Title: selectPageManagement 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ManagementDetailBean>    返回类型 
	 * @throws
	 */
    public List<ManagementDetailBean> selectPageManagement(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList(
        		"managementdetail.selectPageManagement",
        		baseBean,
        		new RowBounds(baseBean.getPageLinkBean().getStart(), 
        				baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @描述: 根据ID查询一条签证基础信息
     * @作者: 
     * @创建时间: 2015年11月30日 下午9:47:50
     * @param id
     * @return
     */
    public ManagementDetailBean selectManagement(Integer id) {
        return getSqlSession().selectOne("managementdetail.selectByBookId", id);
    }

    /**
     * 
     * @Title:          insertManagement 
     * @Description:    插入
     * @param @param    bean
     * @param @return   设定文件 
     * @return          int    返回类型 
     * @throws
     */
    public int insertManagement(ManagementDetailBean bean) {
        return getSqlSession().insert("managementdetail.insert", bean);
    }
    
   /**
    * @Title:          updateManagement 
    * @Description:    修改
    * @param @param    bean    设定文件 
    * @return          void    返回类型 
    * @throws
    */
    public void updateManagement(ManagementDetailBean bean){
    	getSqlSession().update("managementdetail.updateManagement", bean);
    }
    
    /**
     * @方法名：  updatePrice 
     * @描述:  签证价格管理修改
     * @作者：     贺渊博
     * @创建时间：2015年10月27日 下午4:06:24
     * @param bean
     *
     */
    public void updatePrice(ManagementDetailBean bean){
    	getSqlSession().update("managementdetail.updatePrice",bean);
    }
    
    /**
     * 
     * @Title:           deleteManagement 
     * @Description:     签证上下架
     * @param @param     id   设定文件 
     * @return           void    返回类型 
     */
    public void deleteManagement(ManagementDetailBean managementDetailBean){
    	getSqlSession().update("managementdetail.delete", managementDetailBean);
    }
    /**
     * @Title        修改编码
     * @Description  更新签证信息产品编号
     * @param        updateCodeBean
     */
	public Integer updatecode(ManagementDetailBean updateCodeBean) {
		return getSqlSession().update("managementdetail.updatecode",updateCodeBean);
		
	}
	 /**
	    * 
	    * @Title:          updateManagement 
	    * @Description:    修改预定方式
	    * @param @param    bean    设定文件 
	    * @return          void    返回类型 
	    * @throws
	    */
	    public void scheduledManagement(ManagementDetailBean bean){
	    	getSqlSession().update("managementdetail.update", bean);
	    }
}
