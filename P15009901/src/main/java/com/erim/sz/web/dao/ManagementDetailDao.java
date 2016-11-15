package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementPriceBean;

/**
 * 
 * @ClassName: ManagementDetailDao 
 * @Description: 签证
 * @author maoxian
 * @date 2015年9月15日 下午12:50:30 
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
    public List<ManagementDetailBean> selectPageManagement(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList(
        		"managementdetail.selectPageManagement",
        		baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
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
        return getSqlSession().selectOne("managementdetail.selectBeanByPriId", id);
    }
    /**
     * 根据mdlId查询management_price价格最低的数据
     * @param mdlId
     * @return
     */
    public List<ManagementPriceBean> selectManagementPrice(ManagementPriceBean bean){
    	 List<ManagementPriceBean> listBean = getSqlSession().selectList("managementprice.selectPageManagementPrice",bean);
    	 return listBean;
    }

}
