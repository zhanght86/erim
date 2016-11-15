package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuideRecordBean;
import com.erim.sz.web.service.GuideRecordService;

/**
 * 
 * @ClassName: GuideRecordController 
 * @Description: 导游动态查看
 * @author maoxian
 * @date 2015年9月10日 下午7:56:16 
 *
 */
@Controller
public class GuideRecordController {

	@Autowired
	private GuideRecordService guideRecordService;

	/**
	 * @描述: 我的动态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午5:34:14
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/record")
	public String record(ModelMap model,GuideRecordBean bean){
		guideRecordService.selectGuideRecordByRecord(bean, model);
		return "records";
	}
	
	/**
	 * 
	 * @Title: addRecordsPage 
	 * @Description: 导游动态新增页面
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/addRecordsPage")
	public String addRecordsPage(){
		return "addRecord";
	}
	
	/**
	 * @描述: 新增我的动态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午5:34:49
	 * @param model
	 * @param guideRecordBean
	 * @return
	 */
	@ResponseBody 
	@RequestMapping("/addRecords")
	public Integer addRecords(ModelMap model, GuideRecordBean bean) {
		return guideRecordService.insert(bean);
	}
	
	/**
	 * @描述: 删除一条我的动态信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午4:13:59
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delRecords")
	public String delRecords(ModelMap model,Integer id) {
		
		guideRecordService.del(id);
		
		return record(model, new GuideRecordBean());
	}
}