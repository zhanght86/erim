package com.erim.sz.sameTown.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PubSametownBean;

/**
 * @ClassName: PubSametownDao 
 * @Description: 同城同业
 * @author maoxian
 * @date 2015年9月18日 上午11:29:11 
 *
 */
@Repository("pubSametownDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PubSametownDao extends BaseDao{

	/**
	 * @return 
	 * @Title: insert 
	 * @Description: 批量插入
	 * @param @param listPubSametownBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public void insert(PubSametownBean sametownBean){
		 this.getSqlSession().insert("pubsametown.insert",sametownBean);
	}
	
	/**
	 * 
	 * @Title: insertAll 
	 * @Description: 插入
	 * @param @param sametownBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertAll(PubSametownBean sametownBean){
		 this.getSqlSession().insert("pubsametown.insertAll",sametownBean);
	}
	
	/**
	 * @Title: delAll 
	 * @Description: 删除所有企业内
	 * @param @param sametownBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delAll(PubSametownBean sametownBean){
		this.getSqlSession().delete("pubsametown.deleteAll", sametownBean);
	}
	
	/**
	 * @Title: del 
	 * @Description: 删除同城
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void del(PubSametownBean sametownBean){
		this.getSqlSession().delete("pubsametown.delete", sametownBean);
	} 
	
	
	/**
	 * @Title: showList 
	 * @Description: 查询所有
	 * @param @param samebean
	 * @param @return    设定文件 
	 * @return List<PubSametownBean>    返回类型 
	 * @throws
	 */
	public List<PubSametownBean> showList(PubSametownBean samebean){
		return this.getSqlSession().selectList("pubsametown.selectList", samebean);
	}
	
	/**
	 * @描述: 批量增加
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午9:05:07
	 * @param list
	 * @return
	 */
	public Integer insertList(List<PubSametownBean> list) {
		return getSqlSession().insert("pubsametown.insertList", list);
	}
}
