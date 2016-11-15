package com.erim.sz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MemberController 
 * @Description: 会员中心
 * @author maoxian
 * @date 2015年10月5日 下午1:56:35
 */
@Controller
public class MemberController {
	
	/**
	 * @Title: index 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/index")
	public String index(){
		return "/member/index";
	}
	
	/**
	 * @Title: jipiao 
	 * @Description: 机票订单
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/jipiao")
	public String jipiao(){
		return "/member/jipiao";
	}
	
	/**
	 * @Title: all 
	 * @Description: 所有订单 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/all")
	public String all(){
		return "/member/all";
	}
	
	/**
	 * @Title: dangdiyou 
	 * @Description: 当地游
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/dangdiyou")
	public String dangdiyou(){
		return "/member/dangdiyou";
	}
	
	/**
	 * @Title: daoyou 
	 * @Description: 导游 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/daoyou")
	public String daoyou(){
		return "/member/daoyou";
	}
	
	/**
	 * @Title: jiudian 
	 * @Description: 酒店
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/jiudian")
	public String jiudian(){
		return "/member/jiudian";
	}
	
	/**
	 * @Title: lvyou 
	 * @Description: 旅游订单
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/lvyou")
	public String lvyou(){
		return "/member/lvyou";
	}
	
	/**
	 * @Title: menpiao 
	 * @Description: 门票
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/menpiao")
	public String menpiao(){
		return "/member/menpiao";
	}
	
	/**
	 * @Title: menpiao 
	 * @Description: 租车
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/zuche")
	public String zuche(){
		return "/member/zuche";
	}
	
	/**
	 * @Title: qianzheng 
	 * @Description: 签证
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/qianzheng")
	public String qianzheng(){
		return "/member/qianzheng";
	}
	
	/**
	 * @Title: tesecan 
	 * @Description: 特色餐
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/tesecan")
	public String tesecan(){
		return "/member/tesecan";
	}
	
	/**
	 * @Title: message 
	 * @Description: 个人资料
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/message")
	public String message(){
		return "/member/message";
	}
	
	/**
	 * @Title: anquan 
	 * @Description: 账户安全
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/member/anquan")
	public String anquan(){
		return "/member/anquan";
	}
}
