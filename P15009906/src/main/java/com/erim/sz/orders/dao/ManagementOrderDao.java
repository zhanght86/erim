package com.erim.sz.orders.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementOrderBean;

/***
 * 
* @ClassName: ManagementOrderDao 
* @Description: 签证订单
* @author 龙龙
* @date 2015年7月30日 下午1:01:43 
*
 */
@Repository("managementOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageManagement 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ManagementOrderBean>    返回类型 
	 * @throws
	 */
    public List<ManagementOrderBean> selectPageManagement(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("managementorder.selectPageManagement", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectManagement 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return ManagementOrderBean    返回类型 
     * @throws
     */
    public ManagementOrderBean selectManagement(Integer id) {
        return getSqlSession().selectOne("managementorder.selectByBookId", id);
    }
    

    /**
     * 
     * @Title: insertManagement 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertManagement(ManagementOrderBean bean) {
        return getSqlSession().insert("managementorder.insert", bean);
    }
    
   /**
    * 
    * @Title: updateManagement 
    * @Description: 修改为接单或拒接状态
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public int updateManagement(ManagementOrderBean bean){
    	System.out.println("bean ::::::"+bean.getId()+"   ddd:"+bean.getMorIsThrough());
    	return getSqlSession().update("managementorder.receiveOrRefuse", bean);
    }
    
    /**
     * 
     * @Title: deleteManagement 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteManagement(int id){
    	getSqlSession().update("managementorder.delete", id);
    }
}
