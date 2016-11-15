package com.erim.sz.planeticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.planeticket.dao.PlaneticketBackDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.web.service.CodeService;

/**
 * @ClassName:    PlaneticketBackService 
 * @Description:  TODO(往返直飞航班接口) 
 * @author        贺渊博 
 * @date          2015年10月10日 下午4:41:36 
 */
@Service("planeticketBackService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketBackService {
	@Autowired
	private PlaneticketBackDao planeticketBackDao;
	@Autowired
	private  CodeService         codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
}
