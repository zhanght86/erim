package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.SellSystemTeamBean;
import com.erim.sz.web.dao.SellSystemTeamDao;

/**
 * @ClassName: SellSystemTeamService 
 * @Description: 旅行社
 * @author maoxian
 * @date 2015年11月26日 下午4:39:42
 */
@Service("sellSystemTeamService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemTeamService {
	
	@Autowired
	private SellSystemTeamDao sellSystemTeamDao;
	
	/**
	 * @Title: selectAll 
	 * @Description: 根据地域查询所有旅行社
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<SellSystemTeamBean>    返回类型 
	 * @author maoxian
	 * @date 2015年11月26日 下午4:40:27 
	 * @throws
	 */
	public List<SellSystemTeamBean> selectAll(SellSystemTeamBean bean){
		return this.sellSystemTeamDao.selectAll(bean);
	}
}