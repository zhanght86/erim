package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallThemeBean;
import com.erim.sz.common.bean.MallThemeTypeBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: MallThemeDao 
 * @Description: 主题推荐
 * @author maoxian
 * @date 2015年12月4日 上午12:22:43
 */
@Repository("mallThemeDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallThemeDao extends BaseDao {

	/**
	 * @方法名: insertTheme
	 * @描述: 商户插入一条主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 下午5:35:48 
	 * @param bean
	 * @return
	 */	
	public Integer insertTheme(MallThemeTypeBean bean){
		return this.getSqlSession().insert("malltheme.insertTheme", bean);
	}
	
	/**
	 * @方法名: deleteTheme
	 * @描述: 商户删除一条主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 下午5:35:48 
	 * @param bean
	 * @return
	 */	
	public Integer deleteTheme(MallThemeTypeBean bean){
		return this.getSqlSession().delete("malltheme.deleteTheme", bean);
	}
	/**
	 * @Title: insert 
	 * @Description: 插入 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallThemeBean bean){
		return this.getSqlSession().insert("malltheme.insert", bean);
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 插入数组 
	 * @param @param listBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insertList(List<MallThemeBean> listBean){
		return this.getSqlSession().insert("malltheme.insertList", listBean);
	}
	
	
	/**
	 * @Title: deletecpy 
	 * @Description: 删除
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer deletecpy(MallThemeBean bean){
		return this.getSqlSession().delete("malltheme.deletecpy", bean);
	}
	
	
	/**
	 * @Title: selectList 
	 * @Description: 根据实体查询list
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallThemeBean>    返回类型 
	 * @throws
	 */
	public List<MallThemeBean> selectList(MallThemeBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.getSqlSession().selectList("malltheme.selectList", bean);
	}
	
	/**
	 * @方法名: selectThemeList
	 * @描述:  获取当前商户定义的主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 下午5:33:57 
	 * @param  List<MallThemeTypeBean>
	 * @return
	 */
	 
	public List<MallThemeTypeBean> selectThemeList(MallThemeTypeBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.getSqlSession().selectList("malltheme.selectThemeList", bean);
	}
}
