package com.erim.sz.planeticket.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;

/**
 * 
 * @ClassName:     PlaneticketTransitDao 
 * @Description:   TODO(往返中转航班) 
 * @author         贺渊博 
 * @date           2015年10月10日 下午5:51:32 
 *
 */
@Repository("planeticketTransitDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketTransitDao extends BaseDao {

}
