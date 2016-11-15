package com.erim.sz.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ComBusRegionBean;
import com.erim.sz.common.bean.PubNoticeBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.ComBusRegionDao;
import com.erim.sz.notice.dao.PubNoticeDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: PubNoticeService 
 * @Description: TODO(通知公告) 
 * @author 贺渊博
 * @date 2015年11月9日 下午10:16:20 
 *
 */
@Service("pubNoticeService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PubNoticeService {
	 @Autowired
	 private PubNoticeDao 		   pubNoticeDao;
	 @Autowired
	 private TmSystemRegionService tmSystemRegionService;
	 @Autowired
	 private ComBusRegionDao	   comBusRegionDao;
	 
	 /**
	  * @方法名：showList 
	  * @描述: 通知公告
	  * @作者：  贺渊博
	  * @创建时间：2015年11月9日 下午10:52:44
	  * @param model
	  * @param bean
	  */
	 public void showList (ModelMap model,PubNoticeBean bean){
		 bean.setPneNtype(ErimConstants.COMPANYROLE_CREATER);
		 List<PubNoticeBean> noticeList = pubNoticeDao.selectNotice(bean, model);
		 // 回传信息
 		 model.put("noticeList", noticeList);
 		 model.addAttribute("region", this.tmSystemRegionService.getCodeList());
 		 
 		 // 企业服务发范围
 		 List<ComBusRegionBean> list = new ArrayList<ComBusRegionBean>();
 		 list = comBusRegionDao.listRegionByCpyId(CommonUtil.getCpyId());
 		 model.addAttribute("listRegion", list);
	 }
	 
	 /**
	  * @方法名：selectNoticeById 
	  * @描述: 通知公告查询
	  * @作者： 贺渊博
	  * @创建时间：2015年11月9日 下午10:55:43
	  * @param model
	  * @param bean
	  */
     public void selectNoticeById(ModelMap model,PubNoticeBean bean){
    	 PubNoticeBean pub = pubNoticeDao.selectById(bean);
    	 model.addAttribute("pubNotice",pub);
     }
     
}
