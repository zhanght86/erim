package com.erim.sz.web.dao;

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
	 * @Title: listMallDestination 
	 * @Description: 根据企业id查询所有当地游标签 
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<MallDestinationBean>    返回类型 
	 * @throws
	 */
	public List<MallDestinationBean> listMallDestination(Integer cpyId){
		return this.getSqlSession().selectList("malldestination.selectList", cpyId);
	} 
	
}
