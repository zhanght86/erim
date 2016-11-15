package com.erim.sz.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.service.AbstractService;
import com.erim.sz.bean.TeamCompanyDetailBean;
import com.erim.sz.common.bean.YjSystemUserBean;
import com.erim.sz.common.constant.ErimConstants;

/**
 * @ClassName: TeamCompanyDetailService 
 * @Description: 合作信息
 * @author maoxian
 * @date 2015年12月18日 上午2:54:48
 */
@Service("teamCompanyDetail")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TeamCompanyDetailService extends AbstractService<TeamCompanyDetailBean> {
	// --------------------------------------------------------------------------
	//
	// Methods Implements
	//
	// --------------------------------------------------------------------------

	@Override
	public String getNameSpace() {
		// TODO Auto-generated method stub
		return "teamCompanyDetail";
	}

	// --------------------------------------------------------------------------
	//
	// Methods Extends
	//
	// --------------------------------------------------------------------------

	@Override
	public void dealPageDetail(PageDetailBean bean) throws ErimException {

		// 先执行父类
		super.dealPageDetail(bean);

	}

	/**
	 * @Title: setMap 
	 * @Description: 地接/专线/直营通用设置
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午9:04:40 
	 * @throws
	 */
	public void setMap(){
		_inHashMap.put("cusIsThrough", ErimConstants.YESORNO_YES);
		_inHashMap.put("qrysort", "cpy_through_time");
		_inHashMap.put("qrymode", "desc");
	}
	
	/**
	 * 地接社
	 */
	public void djs() throws ErimException {
		_inHashMap.put("cpyRoe", ErimConstants.COMPANYROLE_CREATER);
		this.setMap();
		super.list();
	}
	
	/**
	 * 直营商
	 */
	public void zys() throws ErimException {
		_inHashMap.put("cpyRoe", ErimConstants.COMPANYROLE_ZY);
		this.setMap();
		super.list();
	}
	
	/**
	 * 专线商
	 */
	public void zxs() throws ErimException {
		_inHashMap.put("cpyRoe", ErimConstants.COMPANYROLE_LINE);
		this.setMap();
		super.list();
	}
	
	/**
	 * 组团社
	 */
	public void zts() throws ErimException {
		_inHashMap.put("cpyRoe", ErimConstants.COMPANYROLE_SELLER);
		this.setMap();
		super.list();
	}
	
	/**
	 * @Title: insertuser 
	 * @Description: 创建用户
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午3:54:52 
	 * @throws
	 */
	public void checkuser() throws ErimException{
		if(StringUtils.isNotBlank(commonGetColumn("cpyYjLoginname"))){
			throw new BusinessException("该公司已创建佣金帐号,不可重复创建!");
		}
		super.init();
	}
}
