package com.erim.sz.notice.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PubNoticeBean;

/**
 * 
 * @ClassName: PubNoticeDao 
 * @Description: TODO(通知公告) 
 * @author 贺渊博 
 * @date 2015年11月9日 下午10:16:08 
 *
 */
@Repository("pubNoticeDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PubNoticeDao extends BaseDao{
	/**
	 * 
	 * @方法名：selectNotice 
	 * @描述: 通知公告
	 * @作者： 贺渊博
	 * @创建时间：2015年11月9日 下午10:49:03
	 * @param baseBean
	 * @param model
	 * @return
	 *
	 */
	public List<PubNoticeBean> selectNotice(BaseBean baseBean,ModelMap model) {
		return getSqlSession().selectList("pubnotice.selectList",baseBean);
		
	}
	/**
	 * 
	 * @方法名：selectById 
	 * @描述: 通知公告
	 * @作者： 贺渊博
	 * @创建时间：2015年11月9日 下午10:48:42
	 * @param bean
	 * @return
	 *
	 */
  public PubNoticeBean selectById(PubNoticeBean bean){
	  return this.getSqlSession().selectOne("pubnotice.selectById",bean);
	  
  }
}
