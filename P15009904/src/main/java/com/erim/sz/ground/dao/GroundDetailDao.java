package com.erim.sz.ground.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundDetailBean;

/**
 * @ClassName: GroundDetailDao 
 * @Description: 地接社
 * @author 龙龙
 * @date 2015年7月29日 下午4:17:29 
 */
@Repository("groundDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundDetailDao extends BaseDao {
	
	/**
	 * @方法名：selectPageTown 
	 * @描述: 同城同业
	 * @作者：  贺渊博
	 * @创建时间：2015年11月11日 下午3:54:29
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<GroundDetailBean> selectPageTown (BaseBean baseBean, ModelMap model) {
		return getSqlSession().selectList("grounddetail.selectPageTown",baseBean, 
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}

	/**
	 * @Title: selectPageGround 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GroundDetailBean>    返回类型 
	 * @throws
	 */
    public List<GroundDetailBean> selectPageGround(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("grounddetail.selectPageGround", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @描述: 根据当地游信息ID查询一条信息
     * @作者: 
     * @创建时间: 2015年11月25日 下午4:01:26
     * @param bean 当地游基础信息bean
     * @return
     */
    public GroundDetailBean selectGround(GroundDetailBean bean) {
        return getSqlSession().selectOne("grounddetail.selectBeanByPriId", bean);
    }
    
    /**
     * @描述: 根据当地游信息ID查询一条信息
     * @作者: 
     * @创建时间: 2015年11月25日 下午4:01:07
     * @param id 当地游信息ID
     * @return
     */
    public GroundDetailBean selectById(Integer id){
    	return getSqlSession().selectOne("grounddetail.selectBeanByPriId", id);
    }
    

    /**
     * @Title: 		  insertGround 
     * @Description:  新增当地旅游信息
     * @param @param  bean
     * @param @return 设定文件 
     * @return 		  int 返回类型 
     * @throws
     */
    public Integer insertGround(GroundDetailBean bean) {
        return getSqlSession().insert("grounddetail.insert", bean);
    }
    
    /**
     * @方法名: updateGroundCode
     * @描述: 更新当地旅游信息产品编号
     * @作者: 宁晓强
     * @创建时间: 2015年10月10日 上午11:59:56 
     * @param bean
     * @return
     */
    public Integer updateGroundCode(GroundDetailBean bean) {
    	return getSqlSession().update("grounddetail.updateGroundCode", bean);
    }
    
    /**
     * @描述: 复制完成后更改部分字段
     * @作者: 宁晓强
     * @创建时间: 2015年11月15日 下午5:18:51
     * @param bean
     * @return
     */
    public Integer updateCopyGround(GroundDetailBean bean) {
    	return getSqlSession().update("grounddetail.updateCopyGround", bean);
    }
    
    /**
     * @Title: 		updateGround 
     * @Description: 修改
     * @param @param bean  设定文件 
     * @return 		void  返回类型 
     * @throws
     */
    public void updateGround(GroundDetailBean bean){
    	getSqlSession().update("grounddetail.update", bean);
    }
    
    /**
     * @Title: 		updateGround 
     * @Description: 修改行程管理
     * @param @param bean  设定文件 
     * @return 		void  返回类型 
     * @throws
     */
    public Integer updateGroundTrip(GroundDetailBean bean){
    	return getSqlSession().update("grounddetail.updatetrip", bean);
    }
    
    /** 
	 * @Title: 		 delete
	 * @Description: 上架下架信息
	 * @param @param id 设定文件
	 * @return       void 返回类型
	 * @throws
	 */
	public void deleteGround(GroundDetailBean bean) {
		
		getSqlSession().update("grounddetail.delete", bean);
	}
	
	/**
	 * @Title: 		 delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return       void 返回类型
	 * @throws
	 */
	public void deletegroundbean(int id){
    	getSqlSession().update("grounddetail.deletebean", id);
    }
	
	/**
	 * @描述: 根据当地游基础信息ID复制一条当地游基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午4:36:24
	 * @param bean
	 * @return
	 */
	public Integer copyGroundDetail(GroundDetailBean bean) {
		return getSqlSession().insert("grounddetail.copyGroundDetail", bean);
	}
	 /**
     * @Title: 		updateGround 
     * @Description: 修改
     * @param @param bean  设定文件 
     * @return 		void  返回类型 
     * @throws
     */
    public void updateScheduled(GroundDetailBean bean){
    	getSqlSession().update("grounddetail.update1", bean);
    }
}
