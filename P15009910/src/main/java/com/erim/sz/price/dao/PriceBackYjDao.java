package com.erim.sz.price.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PriceBackYjBean;

/**
 * @ClassName: PriceBackYjDao 
 * @Description: 佣金返利
 * @author maoxian
 * @date 2015年12月17日 下午11:34:53
 */
@Repository("priceBackYjDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PriceBackYjDao extends BaseDao {

	/**
	 * @Title: selectCount 
	 * @Description: 查看共有多少家合作用户
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午11:31:42 
	 * @throws
	 */
	public Integer selectCooperation(String yjUserCode){
		return this.getSqlSession().selectOne("pricebackyj.selectCooperation", yjUserCode);
	}
	
	/**
	 * @Title: selectPriceBackYj 
	 * @Description: 得到佣金返利方式
	 * @param @param yjUserCode
	 * @param @return    设定文件 
	 * @return List<PriceBackYjBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月21日 下午4:27:47 
	 * @throws
	 */
	public List<PriceBackYjBean> selectPriceBackYj(String yjUserCode){
		return this.getSqlSession().selectList("pricebackyj.selectPybPrice", yjUserCode);
	}
}
