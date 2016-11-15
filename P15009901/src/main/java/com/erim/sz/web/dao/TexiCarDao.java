package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.common.bean.TexiCarPriceBean;

@Repository("texicardao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiCarDao extends BaseDao{
	
	/**
	 * 
	 * @方法名: selectcarTexi
	 * @描述: 租车包车查看
	 * @作者: 王赛
	 * @创建时间: 2015年11月27日 下午1:30:20 
	 * @param id
	 * @return
	 *
	 */
	public List<TexiCarBean> selectcarTexiList(TexiCarBean bean){
		return getSqlSession().selectList("texicar.selectList",bean);
	}
	public TexiCarBean selectcarTexi(Integer id){
		return getSqlSession().selectOne("texicar.selectBycarId",id);
	}
	public List<TexiCarPriceBean> selectTexiDrivePriceBeanList(TexiCarPriceBean bean){
		return getSqlSession().selectList("texicarprice.selectPageTexiCarPrice",bean);
	}
}
