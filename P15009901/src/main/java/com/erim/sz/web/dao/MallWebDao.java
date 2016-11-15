package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallWebBean;

/**
 * 
 * @ClassName: MallWebDao 
 * @Description: 网站布局设置
 * @author maoxian
 * @date 2015年11月15日 下午1:25:28 
 *
 */
@Repository("mallWebDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallWebDao extends BaseDao {

	/**
	 * 
	 * @Title: selectMallWebByCode 
	 * @Description: 根据企业id 获取值
	 * @param @param code
	 * @param @return    设定文件 
	 * @return MallWebBean    返回类型 
	 * @throws
	 */
	public MallWebBean selectMallWebByCid(Integer cpyId){
		return this.getSqlSession().selectOne("mallweb.selectMallWebByCid", cpyId);
	}
}
