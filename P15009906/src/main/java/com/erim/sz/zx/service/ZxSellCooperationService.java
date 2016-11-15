package com.erim.sz.zx.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.ZxSellCooperationBean;
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
	
	
	/**
	 * @Title: updateAll 
	 * @Description: 更新所有
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月10日 下午11:39:21 
	 * @throws
	 */
	public Integer updateAll(HttpServletRequest request){
		//专线id
		String lineId = request.getParameter("lineId");
		//企业id
		String cpyId  = request.getParameter("cpyId");
		//选中状态
		String sts  = request.getParameter("sts");
		//如果都不为空
		if(StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(cpyId)){
			//声明空数组
			String[] atrlineId = lineId.split(",");
			String[] atrcpyId  = cpyId.split(",");
			String[] stsArr  = sts.split(",");
			/*
			//初始化合作列表
			ZxSellCooperationBean deleteBean = new ZxSellCooperationBean();
			deleteBean.setZscCooperiontime(new Date());
			deleteBean.setZscCooperionuser(CommonUtil.getLoginName());
			deleteBean.setSellCpyId(CommonUtil.getCpyId());
			this.zxSellCooperationDao.deleteAll(deleteBean);
			*/
			for(int i = 0 ; i < atrcpyId.length ;  i++ ){
				//声明数组
				ZxSellCooperationBean zx = new ZxSellCooperationBean();
				zx.setSellCpyId(CommonUtil.getCpyId());
				zx.setCpyId(Integer.parseInt(atrcpyId[i]));
				zx.setCid(Integer.parseInt(atrlineId[i]));
				zx.setZscCooperiontime(new Date());
				zx.setZscCooperionuser(CommonUtil.getLoginName());
				zx.setZscIsCoopertion(stsArr[i]);
				this.zxSellCooperationDao.update(zx);
			}
			
		}
		return 1;
	}
	
}
