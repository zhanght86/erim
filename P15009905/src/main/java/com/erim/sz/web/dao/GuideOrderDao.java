package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideOrderBean;

/**
 * @ClassName: GuideOrderDao 
 * @Description: 接口
 * @author maoxian
 * @date 2015年9月10日 下午4:46:31 
 *
 */
@Repository("guideOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGuide 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GuideOrderBean>    返回类型 
	 * @throws
	 */
    public List<GuideOrderBean> selectGuide(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("guideorder.selectGuide", baseBean);
    }
    /**
     * 
     * @Title: selectGuide 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return GuideOrderBean    返回类型 
     * @throws
     */
    public GuideOrderBean selectGuide(Integer id) {
        return getSqlSession().selectOne("guideorder.selectBeanByPriId", id);
    }
    
}
