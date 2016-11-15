package com.erim.sz.planeticket.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;

/**
 * 
 * @ClassName:    PlaneticketBackDao 
 * @Description:  TODO(往返直飞航班) 
 * @author        贺渊博 
 * @date          2015年10月10日 下午4:42:34 
 *
 */
@Repository("planeticketBackDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketBackDao extends BaseDao {
	
	
}

