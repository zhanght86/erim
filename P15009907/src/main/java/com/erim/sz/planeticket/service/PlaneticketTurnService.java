package com.erim.sz.planeticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.planeticket.dao.PlaneticketTurnDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName:    PlaneticketTurnService 
 * @Description:  TODO(单程中转航班接口) 
 * @author        贺渊博 
 * @date          2015年10月10日 下午3:55:36 
 *
 */
@Service("planeticketTurnService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketTurnService {
	@Autowired
	private PlaneticketTurnDao planeticketTurnDao;
	@Autowired
	private  CodeService         codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	
}
	
	
	
	

