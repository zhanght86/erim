package com.erim.sz.search.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundDetailBean;

/***
 * 
* @ClassName: GroundDetailDao 
* @Description: 地接社
* @author 龙龙
* @date 2015年7月29日 下午4:17:29 
*
 */
@Repository("groundDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundDetailDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGround 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GroundDetailBean>    返回类型 
	 * @throws
	 */
    public List<GroundDetailBean> selectPageGround(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("grounddetail.selectPageGround", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectGround 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GroundDetailBean    返回类型 
     * @throws
     */
    public GroundDetailBean selectGround(Integer id) {
        return getSqlSession().selectOne("grounddetail.selectBeanByPriId", id);
    }
    /**
     * 
     * @Title: selectGround 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GroundDetailBean    返回类型 
     * @throws
     */
    public GroundDetailBean selectprice(Integer gddId) {
    	System.out.println("进入到dao");
        return getSqlSession().selectOne("groundprice", gddId);
    }

    /**
     * 
     * @Title: insertGround 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertGround(GroundDetailBean bean) {
        return getSqlSession().insert("grounddetail.insert", bean);
    }
    
   /**
    * 
    * @Title: updateGround 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateGround(GroundDetailBean bean){
    	getSqlSession().update("grounddetail.update", bean);
    }
    
    /** 
	 * 
	 * @Title: delete
	 * @Description: 上架下架信息
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteGround(GroundDetailBean bean) {
		System.out.println("获取到的上架下架信息dao"+bean.getGddIsDelStatus());
		getSqlSession().update("grounddetail.delete", bean);
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deletegroundbean(int id){
    	getSqlSession().update("grounddetail.deletebean", id);
    	System.out.println("删除获取到的方法");
    }

}
