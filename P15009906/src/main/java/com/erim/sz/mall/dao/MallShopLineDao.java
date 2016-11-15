package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallShopLineBean;

/**
 * @ClassName: MallShopLineDao 
 * @Description: 商城挑选专线管理
 * @author maoxian
 * @date 2015年12月4日 上午4:03:59
 */
@Repository("mallShopLineDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallShopLineDao extends BaseDao {

	
	/**
	 * @Title: getListByBean 
	 * @Description: 查询所有权限
	 * @param @param shopBean
	 * @param @return    设定文件 
	 * @return List<MallShopLineBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午4:03:35 
	 * @throws
	 */
	public List<MallShopLineBean> selectListByBean(MallShopLineBean shopBean){
		
		return this.getSqlSession().selectList("mallshopline.selectListByBean", shopBean);
	}
	
	
	/**
	 * @Title: insertAll 
	 * @Description: 插入所有
	 * @param @param listBean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午4:05:46 
	 * @throws
	 */
	public void insertAll(List<MallShopLineBean> listBean){
		this.getSqlSession().insert("mallshopline.insertAll", listBean);
	}
	
	/**
	 * @Title: deleteAll 
	 * @Description: 删除所有
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午4:06:50 
	 * @throws
	 */
	public void deleteAll(MallShopLineBean bean){
		this.getSqlSession().delete("mallshopline.deleteAll", bean);
	}
}