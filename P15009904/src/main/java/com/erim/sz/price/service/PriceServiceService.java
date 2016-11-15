package com.erim.sz.price.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.PriceServiceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.price.dao.PriceServiceDao;

/**
 * 
 * 充值接口
 * @author maoxian
 *
 */
@Service
public class PriceServiceService {

	@Autowired
	private PriceServiceDao priceServiceDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入接口
	 * @param @param service    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午8:37:58 
	 * @throws
	 */
	public void insert(PriceServiceBean service){
		service.setPseCreatetime(new Date());
		service.setPseIsSx("0");
		service.setPseNtype(ErimConstants.COMPANYROLE_CREATER);
		this.priceServiceDao.insert(service);
	}
	
	/**
	 * @Title: getPseno 
	 * @Description: 根据企业id查询数据数据返回企业基础信息
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 下午4:47:58 
	 * @throws
	 */
	public String getPseno(Integer cpyId){
		PriceServiceBean bean  = this.priceServiceDao.getServiceByCpyId(cpyId);
		return null != bean ? "1".equals(bean.getPseIsSx())? "-1" : bean.getPseNo() : "";
	}
	
	
	/**
	 * @Title: update 
	 * @Description: 修改支付编号信息
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月29日 下午3:24:52 
	 * @throws
	 */
	public void update(PriceServiceBean bean){
		this.priceServiceDao.update(bean);
	}
}