package com.erim.sz.transticket.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TransticketDetailBean;

/**
 * @ClassName: TransticketDetailDao 
 * @Description: 火车票
 * @author maoxian
 * @date 2015年10月13日 下午11:54:21 
 *
 */
@Repository("transticketDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TransticketDetailDao extends BaseDao {
	/**
	 * @方法名：selectPageTown 
	 * @描述: 同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午4:21:57
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<TransticketDetailBean> selectPageTown(BaseBean baseBean,ModelMap model){
        return getSqlSession().selectList("transticketdetail.selectPageTown", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));

	}

	/**
	 * 
	 * @Title: selectPageTransticket
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<TransticketDetailBean> 返回类型
	 * @throws
	 */
	public List<TransticketDetailBean> selectPageTransticket(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"transticketdetail.selectPageTransticket",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

	/**
	 * 
	 * @Title: selectTransticket
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return TransticketDetailBean 返回类型
	 * @throws
	 */
	public TransticketDetailBean selectTransticket(Integer id) {
		return getSqlSession().selectOne("transticketdetail.selectBeanByPriId", id);
	}

	/**
	 * 
	 * @Title: insertTransticket
	 * @Description: 插入
	 * @param @param bean
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertTransticket(TransticketDetailBean bean) {
		return getSqlSession().insert("transticketdetail.insert", bean);
	}

	/**
	 * 
	 * @Title: updateTransticket
	 * @Description: 修改
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateTransticket(TransticketDetailBean bean) {
		getSqlSession().update("transticketdetail.update", bean);
	}

	/**
	 * 
	 * @Title: deleteTransticket
	 * @Description: 上下架
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteTransticket(TransticketDetailBean bean) {
		getSqlSession().update("transticketdetail.delete", bean);
	}
	
	
	/**
	 * 
	 * @方法名: Transupdatecode
	 * @描述: 编码的自动生成
	 * @作者: 王赛
	 * @创建时间: 2015年10月15日 下午4:28:54 
	 * @param bean
	 * @return
	 *
	 */
	public Integer Transupdatecode(TransticketDetailBean bean){
		return getSqlSession().update("transticketdetail.Transupdatecode", bean);
	}
	
	 
}
