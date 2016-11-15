package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiSendBean;

/**
 * @描述:   固定接送数据
 * @作者: （heyuanbo）
 * @创建时间: 2015年11月24日 下午6:27:11
 */
@Repository("texiSendDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiSendDao extends BaseDao{
	/**
	 * @描述: 固定接送查询
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月24日 下午6:32:50
	 * @param id
	 * @return 返回类型 TexiSendBean
	 */
	
	public  TexiSendBean selectSendById(Integer id){
		return getSqlSession().selectOne("texisend.selectSendById",id);
	}
	public  TexiSendBean selectSendById2(Integer id){
		return getSqlSession().selectOne("texisend.selectSendById2",id);
	}	
		
	


}
