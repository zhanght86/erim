package com.erim.sz.guide.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuideDetailBean;

/**
 * @ClassName: GuideDetailDao
 * @Description: 导游
 * @author 陈鹏
 * @date 2015年7月29日 下午8:05:04
 */
@Repository("guideDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuideDetailDao extends BaseDao {
	
	/**
	 * @方法名：selectPageTown 
	 * @描述: 同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午4:01:25
	 * @param baseBean
	 * @param model
	 * @return
	 */
    public List<GuideDetailBean> selectPageTown(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("guidedetail.selectPageTown", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
	/**
	 * @Title: selectPageGuide
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<GuideDetailBean> 返回类型
	 * @throws
	 */
	public List<GuideDetailBean> selectPageGuide(BaseBean baseBean, ModelMap model) {
		return getSqlSession().selectList("guidedetail.selectPageGuide", baseBean, 
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}

	/**
	 * @Title: selectGuide
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return GuideDetailBean 返回类型
	 * @throws
	 */
	public GuideDetailBean selectGuide(GuideDetailBean bean) {
		return getSqlSession().selectOne("guidedetail.selectBeanByPriId", bean);
	}
	
	/**
	 * @Title: selectById 
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return GuideDetailBean    返回类型 
	 * @throws
	 */
	public GuideDetailBean selectById(Integer id){
		return this.getSqlSession().selectOne("guidedetail.selectBeanByPriId", id);
	}

	/**
	 * @Title: insertGuide
	 * @Description: 插入
	 * @param @param bean
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertGuide(GuideDetailBean bean) {
		return getSqlSession().insert("guidedetail.insert", bean);
	}

	/**
	 * @Title: updateGuide
	 * @Description: 修改
	 * @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer updateGuide(GuideDetailBean bean) {
		return getSqlSession().update("guidedetail.update", bean);
	}

	/**
	 * @Title: deleteGuide
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteGuide(int id) {
		getSqlSession().update("guidedetail.delete", id);
	}
	
	/**
	 * @描述: 更改是否上下架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月15日 下午3:38:54
	 * @param bean
	 * @return
	 */
	public Integer deleteguide(GuideDetailBean bean) {
		return getSqlSession().update("guidedetail.updateDelStatus", bean);
	}
	
	/**
	 * @方法名: Guideupdatecode
	 * @描述:编码的自动生成 
	 * @作者: 王赛
	 * @创建时间: 2015年10月15日 下午3:51:59 
	 * @param bean
	 * @return
	 */
	public Integer Guideupdatecode(GuideDetailBean bean){
		return getSqlSession().update("guidedetail.Guideupdatecode", bean);
	} 
	/**
	 * @Title: updateGuide
	 * @Description: 修改
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateScheduled(GuideDetailBean bean) {
		getSqlSession().update("guidedetail.update1", bean);
	}

	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户登录名获取用户信息
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
    public GuideDetailBean selectUserByLoginname(String cusUserLoginname){
    	 return getSqlSession().selectOne("guidedetail.selectUserByUsers", cusUserLoginname);
    }

}
