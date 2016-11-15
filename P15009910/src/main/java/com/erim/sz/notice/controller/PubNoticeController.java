package com.erim.sz.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.PubNoticeBean;
import com.erim.sz.notice.service.PubNoticeService;

/**
 * 
 * @ClassName: PubNoticeController 
 * @Description: TODO(通知公告) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2015年11月10日 下午8:26:56 
 *
 */
@Controller
public class PubNoticeController {
	@Autowired
	private PubNoticeService  pubNoticeService;
	
	/**
	 * @方法名：view 
	 * @描述: 通知公告
	 * @作者：  贺渊博
	 * @创建时间：2015年11月10日 下午8:35:20
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/notice/detail/view")
	public String view (ModelMap model,PubNoticeBean bean){
		pubNoticeService.selectNoticeById(model, bean);
		
		return "notice/detail/view";
	}

}
