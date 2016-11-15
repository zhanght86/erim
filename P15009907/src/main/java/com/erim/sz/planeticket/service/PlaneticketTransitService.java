package com.erim.sz.planeticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.planeticket.dao.PlaneticketTransitDao;

/**
 * 
 * @ClassName:     PlaneticketTransitService 
 * @Description:   TODO(往返中转航班接口) 
 * @author         贺渊博 
 * @date           2015年10月10日 下午5:50:30 
 *
 */
@Service("planeticketTransitService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketTransitService {
	@Autowired
	private PlaneticketTransitDao planeticketTransitDao;

}