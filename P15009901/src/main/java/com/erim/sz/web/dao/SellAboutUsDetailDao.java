package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.AboutUsBean;

/**
 * @ClassName:    CafeteriaPackageDao 
 * @Description:  TODO(套餐) 
 * @author        贺渊博 
 * @date          2015年10月2日 下午1:52:48 
 *
 */
@Repository("sellAboutUsDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellAboutUsDetailDao extends BaseDao{
	  
    /**
     * @Title:       selectCafeteriaPackage 
     * @Description: 根据id查询
     * @param        id
     * @param        设定文件 
     * @return       CafeteriaPackageBean    返回类型 
     */
    public AboutUsBean selectAboutUsBeanByCpyId(AboutUsBean bean) {
        List<AboutUsBean> listBean = getSqlSession().selectList("sellaboutus.selectSellAboutUsBean", bean);
        if(listBean != null && listBean.size() > 0){
        	return listBean.get(0);
        }else{
        	return null;
        }
    }
   
}
