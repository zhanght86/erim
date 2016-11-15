package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.texi.service.TexiDriveService;

/**
 * @ClassName: 	 TexiDriveController 
 * @Description: 租车自驾详细控制
 * @author 		  王赛
 * @date 		 2015年10月1日 下午4:06:34 
 */
@Controller
public class TexiDriveController {
	
	@Autowired
   	private TexiDriveService texiDriveService;
   	
	/**
	 * @Title: showDrive
	 * @Description: 租车自驾查看
	 * @param model
	 * @param tdlId
	 * @param 设定文件 
	 * @return String 返回类型 
	 */
	@RequestMapping(value="/texi/drive/showdrive")
	public String showDrive(ModelMap model, TexiDriveBean bean) {
		
		texiDriveService.getTextDriveById(bean, model);
		
		return "/texi/drive/update";
	}
	
	/**
	 * @Title: update 
	 * @Description:   租车自驾修改
	 * @param @param   model
	 * @param @param   texiPriceBean
	 * @param @return  设定文件 
	 * @return int     返回类型   1代表修改成功 0代表修改失败
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/texi/drive/updte")
	public Integer update(ModelMap model,TexiDriveBean bean){
		return texiDriveService.update(bean);
	}
}