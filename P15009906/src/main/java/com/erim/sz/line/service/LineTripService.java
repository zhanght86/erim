package com.erim.sz.line.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.LineTripBean;
import com.erim.sz.line.dao.LineTripDao;

/**
 * @ClassName: LineTripService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年12月25日 上午1:19:03
 */
@Service("lineTripService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineTripService {
	
	@Autowired
	private LineTripDao lineTripDao;
	
	/**
	 * @Title: getTripByTdlId 
	 * @Description: 根据专线id查询行程
	 * @param @param lineTripBean
	 * @param @return    设定文件 
	 * @return List<LineTripBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午1:17:41 
	 * @throws
	 */
	public List<LineTripBean> getTripByTdlId(Integer tdlId){
		return this.lineTripDao.getTripByTdlId(tdlId);
	}
}