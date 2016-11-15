package com.erim.sz.search.dao;

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
 * 
* @ClassName: ManagementDetailDao 
* @Description: 签证
* @author 龙龙
* @date 2015年7月29日 下午4:57:16 
*
 */
@Repository("managementDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementDetailDao extends BaseDao{

	/**
	 * 
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
     * 
     * @Title: selectManagement 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return ManagementDetailBean    返回类型 
     * @throws
     */
    public ManagementDetailBean selectManagement(Integer id) {
        return getSqlSession().selectOne("managementdetail.selectByBookId", id);
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
    public int insertManagement(ManagementDetailBean bean) {
        return getSqlSession().insert("managementdetail.insert", bean);
    }
    
   /**
    * 
    * @Title: updateManagement 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateManagement(ManagementDetailBean bean){
    	getSqlSession().update("managementdetail.updateManagement", bean);
    }
    
    /**
     * 
     * @Title: deleteManagement 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteManagement(Integer id){
    	getSqlSession().update("managementdetail.delete", id);
    }
}
