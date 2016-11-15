package com.erim.sz.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.alipay.util.AlipayNotify;
import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.bean.PriceBackYjBean;
import com.erim.sz.common.bean.PriceServiceBean;
import com.erim.sz.web.service.CompanyDetailService;
import com.erim.sz.web.service.PriceBackYjService;
import com.erim.sz.web.service.PriceServiceService;

/**
 * 支付返回值
 * @author maoxian
 */
@Controller
public class PriceController {
	@Autowired
	private PriceServiceService  priceServiceService;
	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private PriceBackYjService   priceBackYjService;
	
	/////////////////////////////////////// 地接社 ///////////////////////////////////////////////////////////////
	
	/**
	 * 根据订单编号处理订单 
	 * @param out_trade_no
	 */
	public void updateService(String out_trade_no,ModelMap model,String trade_no){
		PriceServiceBean serviceBean = this.priceServiceService.findPriceBeanByPseNo(out_trade_no);
		//获取公司id
		Integer cpyId = serviceBean.getCpyId();
		
		CompanyDetailBean cdb = this.companyDetailService.selectByPriId(cpyId);
		
		//如果不为空 或者为审核时
		if(null != serviceBean && "0".equals(serviceBean.getPseIsSx())){
			//更改为支付成功
			serviceBean.setPseIsSx("1");
			serviceBean.setPseNo(out_trade_no);
			serviceBean.setPseSxtime(new Date());
			//结束时间增加一年
			Calendar c = Calendar.getInstance();
	        c.add(Calendar.YEAR, 1);
			serviceBean.setPseJstime(c.getTime());
			this.priceServiceService.update(serviceBean);
			
			//如果公司信息不为空 
			if(null != cdb && StringUtils.isNotBlank(cdb.getYjUserCode())){
				int i = this.priceBackYjService.countCpy(cdb.getYjUserCode());
				if(i>0){
					//佣金返利表
					PriceBackYjBean yjBean = new PriceBackYjBean();
					yjBean.setCpyId(cpyId);
					yjBean.setPybCreateuser(serviceBean.getPseCreateuser());
					yjBean.setPybCreatetime(new Date());
					yjBean.setYjUserCode(cdb.getYjUserCode());
					if(i<21){
						yjBean.setPybNtype("1");
						yjBean.setPybPrice(100);
					}else{
						yjBean.setPybNtype("2");
						yjBean.setPybPrice(200);
					}
					this.priceBackYjService.insert(yjBean);
				}
			}
		}
		
		model.addAttribute("companyDetail", cdb);
		model.addAttribute("out_trade_no", out_trade_no);
		model.addAttribute("price", 598);
	}
	
	/**
	 * 地接服务异步接口
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/price/service/notify")
	public String serviceNotify(HttpServletRequest request,ModelMap model) throws UnsupportedEncodingException{
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//支付宝交易号

		String trade_no     = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				this.updateService(out_trade_no,model,trade_no);
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				this.updateService(out_trade_no,model,trade_no);
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				
			System.out.println(1);
			model.addAttribute("message", "success");

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			System.out.println(2);
			model.addAttribute("message", "fail");
		}
		return "alipay/message";
	}
	
	/**
	 * 地接服务同步接口
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/price/service/return")
	public String serviceReturn(HttpServletRequest request,ModelMap model) throws UnsupportedEncodingException{
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no  = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//支付宝交易号

		String trade_no      = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//交易状态
		String trade_status  = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
			 	//如果有做过处理，不执行商户的业务程序
				this.updateService(out_trade_no,model,trade_no);
			}
			
			//该页面可做页面美工编辑
			System.out.println("验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			return "alipay/success";
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			System.out.println("验证失败");
			return "alipay/error";
		}
	}
	
	/////////////////////////////////////// 地接社 ///////////////////////////////////////////////////////////////
}
