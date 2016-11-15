package com.erim.sz.planeticket.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;

/***
 * 
 * @ClassName: planeticketDetailDao
 * @Description: 机票
 * @author 龙龙
 * @date 2015年7月29日 下午6:05:15
 *
 */
@Repository("planeticketpriceturnDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketPriceTurnDao extends BaseDao {

}
