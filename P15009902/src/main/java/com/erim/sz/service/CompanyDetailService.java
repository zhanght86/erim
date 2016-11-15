package com.erim.sz.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.service.AbstractService;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.bean.ZxSellCooperationBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.utils.ip.IP4;

import flex.messaging.FlexContext;

/**
 * @ClassName: CompanyDetailService 
 * @Description: 审核企业信息
 * @author maoxian
 * @date 2015年12月15日 下午4:34:09
 */

@Service("companyDetail")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyDetailService extends AbstractService<VCompanyDetailBean> {
	// --------------------------------------------------------------------------
	//
	// Methods Implements
	//
	// --------------------------------------------------------------------------

	@Override
	public String getNameSpace() {
		// TODO Auto-generated method stub
		return "companyDetail";
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
	 * @Title: zxs 
	 * @Description: 专线审核页面
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 下午4:35:56 
	 * @throws
	 */
	public void zxs() throws ErimException {
		this.orderBy(ErimConstants.COMPANYROLE_LINE);
		super.list();
	}

	/**
	 * @Title: zts 
	 * @Description: 组团审核页面
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 下午4:35:56 
	 * @throws
	 */
	public void zts() throws ErimException {
		this.orderBy(ErimConstants.COMPANYROLE_SELLER);
		super.list();
	}
	
	/**
	 * @Title: zys 
	 * @Description: 直营审核页面
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 下午4:35:56 
	 * @throws
	 */
	public void zys() throws ErimException {
		this.orderBy(ErimConstants.COMPANYROLE_ZY);
		super.list();
	}
	
	/**
	 * @Title: djs 
	 * @Description: 地接审核页面
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 下午4:35:56 
	 * @throws
	 */
	public void djs() throws ErimException {
		this.orderBy(ErimConstants.COMPANYROLE_CREATER);
		super.list();
	}
	
	/**
	 * @Title: orderBy 
	 * @Description: 放置当前要查询的角色 和排序
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 下午9:05:12 
	 * @throws
	 */
	public void orderBy(String roe) throws ErimException{
		_inHashMap.put("cpyRoe", roe);
		_inHashMap.put("cpyIsThrough", ErimConstants.YESORNO_NO);
		_inHashMap.put("qrysort", "cpy_createdate");
		_inHashMap.put("qrymode", "desc");
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 审核地接社
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 
	 * @throws
	 */
	public void updatedjs() throws ErimException {
		if(ErimConstants.YESORNO_NO.equals(commonGetColumn("cpyIsThrough"))){
			_inHashMap.put("id", commonGetColumn("id"));
			this.update();
			
			//审核过后分配权限
			String cpyId = _inHashMap.get("id").toString();
			if(StringUtils.isNotBlank(cpyId)){
				this.insertSameTown(Integer.parseInt(cpyId));
			}
			
			_inHashMap.put("cusIsThrough", ErimConstants.YESORNO_YES);
			getSqlSession().update(namespace + ".updatedjs", _inHashMap);
		}else{
			throw new BusinessException("该数据已被审核,不能重复审核！");
		}
	}
	/**
	 * 
	 * @Title: update 
	 * @Description: 审核直营商
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 
	 * @throws
	 */
	public void updatezys() throws ErimException {
		if(ErimConstants.YESORNO_NO.equals(commonGetColumn("cpyIsThrough"))){
			_inHashMap.put("id", commonGetColumn("id"));
			this.update();
			_inHashMap.put("zyIsThrough", ErimConstants.YESORNO_YES);
			getSqlSession().update(namespace + ".updatezys", _inHashMap);
		}else{
			throw new BusinessException("该数据已被审核,不能重复审核！");
		}
	}
	/**
	 * 
	 * @Title: update 
	 * @Description: 审核专线商
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 
	 * @throws
	 */
	public void updatezxs() throws ErimException {
		if(ErimConstants.YESORNO_NO.equals(commonGetColumn("cpyIsThrough"))){
			_inHashMap.put("id", commonGetColumn("id"));
			this.update();
			_inHashMap.put("cusIsThrough", ErimConstants.YESORNO_YES);
			getSqlSession().update(namespace + ".updatezxs", _inHashMap);
		}else{
			throw new BusinessException("该数据已被审核,不能重复审核！");
		}
	}
	/**
	 * 
	 * @Title: update 
	 * @Description: 审核组团
	 * @param @throws ErimException    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 
	 * @throws
	 */
	public void updatezts() throws ErimException {
		if(ErimConstants.YESORNO_NO.equals(commonGetColumn("cpyIsThrough"))){
			_inHashMap.put("id", commonGetColumn("id"));
			this.update();
			
			//审核过后分配权限
			String cpyId = _inHashMap.get("id").toString();
			if(StringUtils.isNotBlank(cpyId)){
				this.insertSellCooperation(Integer.parseInt(cpyId));
			}
			
			_inHashMap.put("cusIsThrough", ErimConstants.YESORNO_YES);
			getSqlSession().update(namespace + ".updatezts", _inHashMap);
		}else{
			throw new BusinessException("该数据已被审核,不能重复审核！");
		}
	}
	
	/**
	 * 通用修改方法
	 */
	public void update() throws ErimException {
		_inHashMap.put("cpyIsThrough", ErimConstants.YESORNO_YES);
		_inHashMap.put("cpyThroughTime", new Date());
		_inHashMap.put("cpyThroughUser", FlexContext.getFlexSession().getAttribute("userName"));
		_inHashMap.put("cpyThroughIp", IP4.getIP4(FlexContext.getHttpRequest()));
		
		super.update();
	}
	
	/**
	 * @Title: insertSellCooperation 
	 * @Description: 插入合作
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午3:00:10 
	 * @throws
	 */
	public void insertSellCooperation(Integer cpyId){
		//清除纪录
		this.getSqlSession().delete("zxsellcooperation.deleteBySellId", cpyId);
		
		//插入纪录
		ZxSellCooperationBean paramBean = new ZxSellCooperationBean();
		paramBean.setCpyId(cpyId);
		paramBean.setZscCreatetime(new Date());
		paramBean.setZscIsCoopertion("0");
		paramBean.setZscCreateuser(FlexContext.getFlexSession().getAttribute("userName").toString());
		this.getSqlSession().insert("zxsellcooperation.insert", paramBean);
	}
	
	/**
	 * @Title: insertSameTown 
	 * @Description: insertSameTown
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 下午9:52:25 
	 * @throws
	 */
	public void insertSameTown(Integer cpyId){
//		初始化同城同业选项
		getSqlSession().insert("pubsametown.deletecpyId", cpyId);
//		添加同城同业选项
		getSqlSession().insert("pubsametown.insertHotel", cpyId);
		getSqlSession().insert("pubsametown.insertTicket", cpyId);
		getSqlSession().insert("pubsametown.insertTexi", cpyId);
		getSqlSession().insert("pubsametown.insertCafeteria", cpyId);
		getSqlSession().insert("pubsametown.insertGround", cpyId);
		getSqlSession().insert("pubsametown.insertGuide", cpyId);
	}
}
