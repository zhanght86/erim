package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.PriceBackYjBean;
import com.erim.sz.web.dao.PriceBackYjDao;

/**
 * @ClassName: PriceBackYjService 
 * @Description: 佣金返利接口
 * @author maoxian
 * @date 2015年12月21日 下午7:15:24
 */
@Service("priceBackYjService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PriceBackYjService {
	
	@Autowired
	private PriceBackYjDao priceBackYjDao;
	
	
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
		return this.priceBackYjDao.insert(priceBackYjBean);
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
		return this.priceBackYjDao.countCpy(yjUserCode);
	}
	
}
