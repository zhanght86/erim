package com.erim.sz.ground.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundOrderBean;

/***
 * 
* @ClassName: GroundOrderDao 
* @Description: 地接社订单 
* @author 龙龙
* @date 2015年7月30日 下午12:33:19 
*
 */
@Repository("groundOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGround 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GroundOrderBean>    返回类型 
	 * @throws
	 */
    public List<GroundOrderBean> selectPageGround(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("groundorder.selectPageGround", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectGround 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GroundOrderBean    返回类型 
     * @throws
     */
    public GroundOrderBean selectGround(Integer id) {
        return getSqlSession().selectOne("groundorder.selectByBookId", id);
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
    public int insertGround(GroundOrderBean bean) {
        return getSqlSession().insert("groundorder.insert", bean);
    }
    
   /**
 * @return 
    * 
    * @Title: updateGround 
    * @Description: 修改为接单或拒接状态
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public int updateGround(GroundOrderBean bean){
    	System.out.println("id为-------------------------"+bean.getGdoIsThrough());
    	return getSqlSession().update("groundorder.receiveOrRefuse", bean);
    }
    
    /**
     * 
     * @Title: deleteGround 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteGround(GroundOrderBean bean){
    	getSqlSession().update("groundorder.delete", bean);
    }
}
