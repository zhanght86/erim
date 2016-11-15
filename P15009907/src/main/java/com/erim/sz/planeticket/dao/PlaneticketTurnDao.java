package com.erim.sz.planeticket.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;

/**
 * 
 * @ClassName:   PlaneticketTurnDao 
 * @Description: TODO(单程中转航班) 
 * @author       贺渊博
 * @date         2015年10月10日 下午3:29:31 
 *
 */
@Repository("planeticketTurnDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketTurnDao extends BaseDao {
	
}
