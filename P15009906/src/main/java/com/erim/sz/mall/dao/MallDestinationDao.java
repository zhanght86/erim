package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallDestinationBean;

/**
 * @ClassName: MallDestinationDao 
 * @Description: 目的地旅游
 * @author maoxian
 * @date 2015年11月11日 下午7:33:56 
 *
 */
@Repository("mallDestinationDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallDestinationDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入关联信息
	 * @param @param mallDestinationBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallDestinationBean mallDestinationBean){
		return this.getSqlSession().insert("malldestination.insert", mallDestinationBean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除基本信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(Integer id){
		return this.getSqlSession().delete("malldestination.delete", id);
	}
	
	
	/**
	 * @Title: selectAll 
	 * @Description: 根据数据查询
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallDestinationBean>    返回类型 
	 * @throws
	 */
	public List<MallDestinationBean> selectAll(MallDestinationBean bean){
		return this.getSqlSession().selectList("malldestination.select", bean);
	}
	/**
	 * 
	 * @方法名: selectAllDestName
	 * @描述:获取省市区三级地名的集合，供页面模糊查询使用 
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 上午10:46:43 
	 * @return List<String>
	 */	 
	public List<String> selectAllDestName(){
		return this.getSqlSession().selectList("malldestination.selectDest");
	}
}
