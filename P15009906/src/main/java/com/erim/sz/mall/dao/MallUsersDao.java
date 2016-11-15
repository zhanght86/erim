package com.erim.sz.mall.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallUsersBean;

/**
 * 
 * @ClassName: MallUsersDao 
 * @Description: 会员管理
 * @author maoxian
 * @date 2015年9月16日 下午6:56:04 
 *
 */
@Repository("mallusersDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallUsersDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageMallUsers
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<MallUsersBean> 返回类型
	 * @throws
	 */
	public List<MallUsersBean> selectPageMallUsers(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"mallusers.selectPageMallUsers",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

	/**
	 * 
	 * @Title: selectMallUsers
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return MallUsersBean 返回类型
	 * @throws
	 */
	public MallUsersBean selectMallUsers(Integer id) {
		return getSqlSession().selectOne("mallusers.selectByBookId", id);
	}
	/**
	 * @方法名：upgrade 
	 * @描述: 会员升级
	 * @作者： 贺渊博
	 * @创建时间：2015年11月12日 上午11:29:30
	 * @param bean
	 */
  public void upgrade(MallUsersBean bean){
	  getSqlSession().update("mallusers.upgrade",bean);
  }
}
