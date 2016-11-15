package com.erim.sz.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.PriceBackYjBean;
import com.erim.sz.price.dao.PriceBackYjDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: PriceBackYjDao 
 * @Description: 佣金返利
 * @author maoxian
 * @date 2015年12月17日 下午11:34:53
 */
@Service("priceBackYjService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PriceBackYjService {
	
	@Autowired
	private PriceBackYjDao priceBackYjDao;
	
	/**
	 * @Title: selectCooperation 
	 * @Description: 
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午11:35:41 
	 * @throws
	 */
	public Integer selectCooperation(){
		return this.priceBackYjDao.selectCooperation(CommonUtil.getYjUserCode());
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
	public List<PriceBackYjBean> selectPriceBackYj(){
		return this.priceBackYjDao.selectPriceBackYj(CommonUtil.getYjUserCode());
	}
	
}