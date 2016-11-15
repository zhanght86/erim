package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallThemeBean;
import com.erim.sz.common.bean.MallThemeTypeBean;

/**
 * 
 * @ClassName: MallThemeDao 
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月15日 下午4:32:35 
 *
 */
@Repository("mallThemeDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallThemeDao extends BaseDao {

	/**
	 * @Title: selectListMallTheme 
	 * @Description: 根据条件查询热门
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallThemeBean>    返回类型 
	 * @throws
	 */
	public List<MallThemeBean> selectListMallTheme(MallThemeBean bean){
		return this.getSqlSession().selectList("malltheme.selectList", bean);
	}
	/**
	 * @方法名: selectListMallThemeType
	 * @描述: 根据单位id查询主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月27日 下午4:51:56 
	 * @param bean
	 * @return List<MallThemeTypeBean> 
	 */
	
	public List<MallThemeTypeBean> selectListMallThemeType(MallThemeBean bean){
		return this.getSqlSession().selectList("malltheme.selectTypeList", bean);
	}
}
