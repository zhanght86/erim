package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallImageBean;

/**
 * @ClassName: MallImageDao 
 * @Description: 首页大图
 * @author maoxian
 * @date 2015年12月3日 下午8:55:35
 */
@Repository("mallImageDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallImageDao extends BaseDao {

	
	/**
	 * @Title: listMallImage 
	 * @Description: 所有
	 * @param @return    设定文件 
	 * @return List<MallImageBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月3日 下午8:53:30 
	 * @throws
	 */
	public List<MallImageBean> selectAll(){
		return this.getSqlSession().selectList("mallimage.selectAll");
	}
}
