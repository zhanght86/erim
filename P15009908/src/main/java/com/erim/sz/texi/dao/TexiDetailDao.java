package com.erim.sz.texi.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDetailBean;

/***
 * @ClassName:   TexiDetailDao 
 * @Description: 租车
 * @author       王赛
 * @date         2015年10月1日 下午4:05:15 
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiDetailDao extends BaseDao {
	
	/**
	 * @方法名: updateCode
	 * @描述: 修改产品编号
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月11日 下午4:02:23 
	 * @param bean
	 */
	public void updateCode(TexiDetailBean bean){
		getSqlSession().update("texidetail.updateCode", bean);
	}

	/**
	 * @Title:        selectPageTexi 
	 * @Description:  分页查询
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return        List<TexiDetailBean> 返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTexi(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texidetail.selectPageTexi", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
	 * @Title: 		  selectPageTexi 
	 * @Description:  同城同业
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return        List<TexiDetailBean>    返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTown(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texidetail.selectPageTown", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @方法名: getTexiDetialById
     * @描述: 根据租车ID查询一条租车信息
     * @作者: 宁晓强
     * @创建时间: 2015年10月12日 上午11:43:56 
     * @param id 租车信息ID
     * @return 一条租车信息
     *
     */
    public TexiDetailBean getTexiDetialById(Integer id) {
        return getSqlSession().selectOne("texidetail.getTexiDetailById", id);
    }
    
    /**
     * 
     * @方法名: insertTexi
     * @描述: 车辆信息增加
     * @作者: 宁晓强
     * @创建时间: 2015年10月11日 下午4:25:10 
     * @param bean
     * @return
     *
     */
    public Integer insertTexi(TexiDetailBean bean) {
    	
        return getSqlSession().insert("texidetail.insert", bean);
    }
    
    /**
     * @Title: 		 updateTexi 
     * @Description: 修改
     * @param @param bean 设定文件 
     * @return       void 返回类型 
     * @throws
     */
	public Integer updateTexi(TexiDetailBean bean){
    	return getSqlSession().update("texidetail.update", bean);
	}

    /**
 	 * @Title:       deleteTexi
 	 * @Description: 上下架信息
 	 * @param @param id 设定文件
 	 * @return       void 返回类型
 	 * @throws
 	 */
 	public void deleteTexi(TexiDetailBean bean) {
 		getSqlSession().update("texidetail.delete", bean);
 	}
 	
 	/**
     * @Title: 		 deleteTexi
     * @Description: 删除
     * @param @param id  设定文件 
     * @return       void  返回类型 
     * @throws
     */
    public void deleteTexi(int id){
    	getSqlSession().update("texidetail.delet", id);
    }
    /**
     * @Title: 		 updateTexi 
     * @Description: 修改
     * @param @param bean 设定文件 
     * @return       void 返回类型 
     * @throws
     */
	public Integer updateScheduled(TexiDetailBean bean){
    	return getSqlSession().update("texidetail.update1", bean);
	}
}
