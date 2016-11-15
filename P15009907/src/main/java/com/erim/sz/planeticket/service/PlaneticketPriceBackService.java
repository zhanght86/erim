package com.erim.sz.planeticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.planeticket.dao.PlaneticketPriceBackDao;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: PlaneticketPriceService 
 * @Description: 机票价格
 * @author maoxian
 * @date 2015年8月20日 上午1:02:24 
 *
 */
@Service("PlaneticketPriceBackService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketPriceBackService {
	@Autowired
	private PlaneticketPriceBackDao         planeticketPriceBackDao;
	@Autowired
	private CodeService                codeService;
}