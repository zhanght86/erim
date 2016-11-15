package com.erim.sz.cwgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.alipay.config.AlipayConfig;
import com.erim.sz.common.alipay.util.AlipaySubmit;
import com.erim.sz.common.bean.PriceServiceBean;
import com.erim.sz.common.util.PayNoUtil;
import com.erim.sz.cwgl.service.PriceServiceService;
import com.erim.sz.system.bean.SellSystemUserBean;
import com.erim.sz.system.service.SellSystemUserService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: CwglController
 * @描述: 财务管理
 * @作者: 李庆
 * @创建时间: 2015年10月29日 下午4:37:15
 *
 */
@Controller
public class CwglController { 
	
	
	@Autowired
	private PriceServiceService   priceServiceService;
	@Autowired
	private SellSystemUserService sellSystemUserService;
	
	
	/**
	 * @Title: search 
	 * @Description: 费用管理
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/cwgl/detail/show")
	public String search(){
		return "/cwgl/detail/show";
	}

	
	/**
	 * @Title: payByLoginname 
	 * @Description: 根据用户名注册 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 下午4:33:39 
	 * @throws
	 */
	@RequestMapping(value="/price/pay/payByLoginname")
	public String payByLoginname(HttpServletRequest request,ModelMap model){
		//
		String loginname = request.getParameter("loginname");
		
		if(StringUtils.isNotBlank(loginname)){
			//根据用户名查询所在公司  根据公司信息生成订单
			SellSystemUserBean user = this.sellSystemUserService.selectUserByLoginname(loginname);
			if(null != user){
				return this.returnAlipay(user.getCpyId(), model, loginname,"ZFB");
			}
		}
		
		return null;
	}
	
	/**
	 * @Title: payService 
	 * @Description: 服务费支付
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午1:17:56 
	 * @throws
	 */
	@RequestMapping(value="/price/pay/payService")
	public String payService(ModelMap model,String v_pmode){
		
		return this.returnAlipay(CommonUtil.getCpyId(), model,CommonUtil.getLoginName(),v_pmode);
	}
	
	/**
	 * @Title: payServicePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月21日 下午10:10:29 
	 * @throws
	 */
	@RequestMapping(value="/price/pay/payServicePage")
	public String payServicePage(ModelMap model){
		
		return "/cwgl/pay/zf";
	}
	
	/**
	 * @Title: returnAlipay 
	 * @Description: 通用支付接口
	 * @param @param cpyId
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 下午5:05:58 
	 * @throws
	 */
	public String returnAlipay(Integer cpyId,ModelMap model,String loginname,String v_pmode){
		//如果参数为空  默认支付宝支付
		if(StringUtils.isBlank(v_pmode)) v_pmode = "ZFB";
		
		// 必填，不能修改
		// 服务器异步通知页面路径
		String notify_url = "http://www.jialvlianhe.com/price/service/notify";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数

		// 页面跳转同步通知页面路径
		String return_url = "http://www.jialvlianhe.com/price/service/return";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//获取企业id
		String getPseno = this.priceServiceService.getPseno(cpyId);
		
		//如果是已支付的 跳转支付完成页面
		if("-1".equals(getPseno)) return "/alipay/success";
				
		// 商户订单号
		String out_trade_no    = PayNoUtil.getPayService(cpyId);
		
		if(StringUtils.isNotBlank(getPseno)){
			//获取量价修改接口
			PriceServiceBean param = new PriceServiceBean();
			param.setCpyId(cpyId);
			param.setPseNo(out_trade_no);
			param.setPseCreatetime(new Date());
			param.setPseCreateuser(CommonUtil.getLoginName());
			this.priceServiceService.update(param);
		}
		// 商户网站订单系统中唯一订单号，必填

		// 订单名称
		String subject         = "组团社服务费";
		// 必填

		// 付款金额
		String total_fee       = "598";
		// 必填
		// 订单描述
		String body            = "组团社";
		// 商品展示地址
		String show_url        = "http://www.jialvlianhe.com";
		// 需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

		// 防钓鱼时间戳
		String anti_phishing_key = "";
		// 若要使用请调用类文件submit中的query_timestamp函数

		// 客户端的IP地址
		String exter_invoke_ip = "";
		
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service",          "create_direct_pay_by_user");
		sParaTemp.put("partner",           AlipayConfig.partner);   
		sParaTemp.put("seller_email",      AlipayConfig.seller_email);
		sParaTemp.put("_input_charset",    AlipayConfig.input_charset);
		sParaTemp.put("payment_type",      total_fee);
		sParaTemp.put("notify_url",        notify_url);
		sParaTemp.put("return_url",        return_url);
		sParaTemp.put("out_trade_no",      out_trade_no);
		sParaTemp.put("subject",       	   subject);
		sParaTemp.put("total_fee",         total_fee);
		sParaTemp.put("body", 			   body);
		sParaTemp.put("show_url", 		   show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip",   exter_invoke_ip);
		
		//支付宝还是其它支付方式
		if(!"ZFB".equals(v_pmode)){
			sParaTemp.put("paymethod", "bankPay");
			sParaTemp.put("defaultbank", v_pmode);
		}

		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
		model.addAttribute("sHtmlText",sHtmlText);
		
		//如果不为空
		if(StringUtils.isBlank(getPseno)){
			//声明插入bean
			PriceServiceBean service = new PriceServiceBean();
			service.setPseNo(out_trade_no);
			service.setPseName(subject);
			service.setPsePrice(Integer.parseInt(total_fee));
			service.setPseRemark(body);
			service.setPseShowurl(show_url);
			service.setCpyId(cpyId);
			service.setPseCreateuser(loginname);
			this.priceServiceService.insert(service);
		}
		return "/alipay/alipayapi";
	}
}
