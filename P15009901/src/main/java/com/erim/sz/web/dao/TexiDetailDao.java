package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDetailBean;

/**
 * @ClassName: TexiDetailDao
 * @Description: 租车详情
 * @author maoxian
 * @date 2015年9月12日 下午5:31:37
 *
 */
@Repository("texiDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectTexi
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return TexiDetailBean 返回类型
	 * @throws
	 */
	public TexiDetailBean selectTexi(Integer id) {

		return getSqlSession().selectOne("texidetail.selectById", id);
	}
	
	/**
	 * 
	 * @Title: selectPageTexi 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<TexiDetailBean>    返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTexi(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("texidetail.selectPageTexi", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    }
    
    public List<TexiDetailBean> selectPageTexiSend1(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("texidetail.selectPageTexiSend1", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    }
    
    public List<TexiDetailBean> selectPageTexiCar1(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("texidetail.selectPageTexiCar1", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    }
    public List<TexiDetailBean> selectPageTexiDrive1(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("texidetail.selectPageTexiDrive1", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    }
    
}
