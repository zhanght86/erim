package com.erim.sz.zx.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.ZxSellCooperationBean;
import com.erim.sz.company.dao.VCompanyDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zx.dao.ZxSellCooperationDao;

/**
 * @ClassName: ZxSellCooperationService 
 * @Description: 专线 组团合作
 * @author maoxian
 * @date 2015年12月8日 下午3:54:30
 */
@Service
public class ZxSellCooperationService {

	@Autowired
	private ZxSellCooperationDao zxSellCooperationDao;
	@Autowired
	private VCompanyDetailDao    vCompanyDetailDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:55:38 
	 * @throws
	 */
	public Integer insert(ZxSellCooperationBean bean){
		try{
			bean.setCpyId(CommonUtil.getCpyId());
			bean.setZscCreateuser(CommonUtil.getLoginName());
			bean.setZscCreatetime(new Date());
			bean.setZscIsCoopertion("0");
			this.zxSellCooperationDao.insert(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(this.getClass(), e);
		}
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:56:35 
	 * @throws
	 */
	public Integer delete(ZxSellCooperationBean bean){
		try{
			bean.setCpyId(CommonUtil.getCpyId());
			this.zxSellCooperationDao.delete(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(this.getClass(), e);
		}
		
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 批量插入
	 * @param @param listBean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:59:09 
	 * @throws
	 */
	public Integer insertList(ZxSellCooperationBean bean){
		try{
			//是否合作用户  默认否
			bean.setZscIsCoopertion("0");
			bean.setCpyId(CommonUtil.getCpyId());
			bean.setZscCreatetime(new Date());
			bean.setZscCreateuser(CommonUtil.getLoginName());
			//删除已经存在的
			this.delete(bean);
			//批量更新
			this.vCompanyDetailDao.insertList(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
}
