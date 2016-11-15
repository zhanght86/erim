package com.erim.sz.texi.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiCarBean;


/**
 * 
 * @类名: TexiCarDao
 * @描述: 租车管理包车信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月12日 下午2:26:15
 *
 */
@Repository("texiCarDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiCarDao extends BaseDao {
	
	/**
	 * 
	 * @方法名: insert
	 * @描述: 包车信息增加
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 下午2:29:39 
	 * @param texiCarBean
	 * @return
	 *
	 */
	public Integer insert(TexiCarBean bean){
		return getSqlSession().insert("texicar.insert", bean);
	}
	
	/**
	 * @方法名: update
	 * @描述: 包车信息修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 下午2:29:23 
	 * @param texiCarBean
	 */
	public Integer update(TexiCarBean bean){
		return getSqlSession().update("texicar.update", bean);
	}
	
	/**
	 * @Title: selectTexiCarByTxiId 
	 * @Description: 根据产品ID查询包车信息
	 * @param tdlId
	 * @param 设定文件 
	 * @return TexiPriceBean 返回类型 
	 */
    public TexiCarBean getTexiCarById(Integer tdlId){
		return getSqlSession().selectOne("texicar.getTexiCarById", tdlId);
	}
}
