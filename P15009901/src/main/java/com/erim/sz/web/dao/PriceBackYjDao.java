package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PriceBackYjBean;

/**
 * @ClassName: PriceBackYjDao 
 * @Description: 佣金返利接口
 * @author maoxian
 * @date 2015年12月21日 下午7:10:49
 */
@Repository("priceBackYjDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PriceBackYjDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入佣金返利表
	 * @param @param priceBackYjBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月21日 下午7:11:51 
	 * @throws
	 */
	public Integer insert(PriceBackYjBean priceBackYjBean){
		return this.getSqlSession().insert("pricebackyj.insert", priceBackYjBean);
	}
	
	/**
	 * @Title: countCpy 
	 * @Description: 查询已合作的用户有多少家
	 * @param @param yjUserCode
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月21日 下午7:14:09 
	 * @throws
	 */
	public Integer countCpy(String yjUserCode){
		return this.getSqlSession().selectOne("pricebackyj.countCpy", yjUserCode);
	}
}
