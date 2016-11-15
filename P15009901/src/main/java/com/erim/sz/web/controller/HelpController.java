package com.erim.sz.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.web.service.SellAboutUsDetailService;

/**
 * @ClassName: HelpController 
 * @Description: 帮助中心
 * @author maoxian
 * @date 2015年10月3日 上午11:38:35
 */
@Controller
public class HelpController {
	@Autowired
	private SellAboutUsDetailService sellAboutUsDetailService;
	/**
	 * @Title: about 
	 * @Description: 关于我们
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/help/abouts")
	public String abouts(ModelMap model,String searchModel,String about,@PathVariable("cpyno") String cpyno){
		if(StringUtils.isEmpty(about)){
			about = "1";
		}
		
		sellAboutUsDetailService.selectNewsBean(model, cpyno);
		model.addAttribute("searchModel",searchModel);
		model.addAttribute("about",about);
		return "help/abouts";
	}
	
	/**
	 * @Title: contact 
	 * @Description: 联系我们
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/help/contact")
	public String contact(ModelMap model,String searchModel){
		model.addAttribute("searchModel",searchModel);
		return "help/contact";
	}
	/**
	 * @描述: 什么是签证
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月25日 下午7:24:08
	 * @return:返回类型 String
	 */
	@RequestMapping(value = "/{cpyno}/help/huqian")
	public String help(){
		return "help/huqian";
	}
	/**
	 * @描述: xieyi
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月25日 下午9:00:31
	 * @return:返回类型 String
	 */
	@RequestMapping(value = "/{cpyno}/help/html/xieyi")
	public String xieyi(){
		return "help/html/xieyi";
	}
	/**
	 * @描述: 如何查询
	 * @return:返回类型 String
	 */
	@RequestMapping(value = "/{cpyno}/help/ruhechaxun")
	public String ruhechaxun(){
		return "help/ruhechaxun";
	}
	@RequestMapping(value = "/{cpyno}/help/yudingliucheng")
	public String yudingliucheng(){
		return "help/yudingliucheng";
	}
	@RequestMapping(value = "/{cpyno}/help/gentuanyou")
	public String gentuanyou(){
		return "help/gentuanyou";
	}
	@RequestMapping(value = "/{cpyno}/help/danfangcha")
	public String danfangcha(){
		return "help/danfangcha";
	}
	@RequestMapping(value = "/{cpyno}/help/banzizhu")
	public String banzizhu(){
		return "help/banzizhu";
	}
	@RequestMapping(value = "/{cpyno}/help/sirendingzhi")
	public String sirendingzhi(){
		return "help/sirendingzhi";
	}
	@RequestMapping(value = "/{cpyno}/help/menshidizhi")
	public String menshidizhi(){
		return "help/menshidizhi";
	}
	@RequestMapping(value = "/{cpyno}/help/huiyuanzhuce")
	public String huiyuanzhuce(){
		return "help/huiyuanzhuce";
	}
	@RequestMapping(value = "/{cpyno}/help/qianhetong")
	public String qianhetong(){
		return "help/qianhetong";
	}
	@RequestMapping(value = "/{cpyno}/help/chuxing")
	public String chuxing(){
		return "help/chuxing";
	}
	@RequestMapping(value = "/{cpyno}/help/teshurenqun")
	public String teshurenqun(){
		return "help/teshurenqun";
	}
	@RequestMapping(value = "/{cpyno}/help/gaoweihuodong")
	public String gaoweihuodong(){
		return "help/gaoweihuodong";
	}
	@RequestMapping(value = "/{cpyno}/help/huiyuandenglu")
	public String huiyuandenglu(){
		return "help/huiyuandenglu";
	}
	@RequestMapping(value = "/{cpyno}/help/vise")
	public String vise() {
		return "help/vise";
	}
}