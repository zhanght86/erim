package com.erim.sz.company.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.bean.ZxSellCooperationBean;

/**
 * @ClassName: VCompanyDetailDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年12月6日 下午11:43:33
 */
@Repository("vcompanyDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VCompanyDetailDao extends BaseDao {

	/**
	 * @Title: selectPage 
	 * @Description: 查询所有
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<VCompanyDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月6日 下午11:44:23 
	 * @throws
	 */
	public List<VCompanyDetailBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("vcompanydetail.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
	
	
	/**
	 * @Title: insertList 
	 * @Description: 批量插入
	 * @param @param list
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:53:00 
	 * @throws
	 */
	public Integer insertList(ZxSellCooperationBean bean){
		return this.getSqlSession().insert("vcompanydetail.insertList", bean);
	}
}
