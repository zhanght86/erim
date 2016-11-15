package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageBean;

/**
 * @ClassName:    CafeteriaPackageDao 
 * @Description:  TODO(套餐) 
 * @author        贺渊博 
 * @date          2015年10月2日 下午1:52:48 
 *
 */
@Repository("cafeteriaPackageDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDao extends BaseDao{
	  
    /**
     * @Title:       selectCafeteriaPackage 
     * @Description: 根据id查询
     * @param        id
     * @param        设定文件 
     * @return       CafeteriaPackageBean    返回类型 
     */
    public CafeteriaPackageBean selectCafeteriaPackage(Integer id) {
        return getSqlSession().selectOne("cafeteriapackage.selectCafeteriaPackageById", id);
    }
   
}
