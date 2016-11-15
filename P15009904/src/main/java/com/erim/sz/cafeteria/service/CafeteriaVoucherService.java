package com.erim.sz.cafeteria.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cafeteria.dao.CafeteriaVoucherDao;
import com.erim.sz.common.bean.CafeteriaVoucherBean;
import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;
	/**
	 * @ClassName:    CafeteriaVoucherService 
	 * @Description:  代金券接口 
	 * @author        贺渊博
	 * @date          2015年10月2日 下午6:08:25 
	 */
@Service("cafeteriaVoucherService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaVoucherService {
    @Autowired
    private CafeteriaVoucherDao 		 cafeteriaVoucherDao;
    @Autowired
    private CafeteriaVoucherPriceService cafeteriaVoucherPriceService;
    @Autowired
    private CodeService         		 codeService;
    
    /**
	 * @Title:          selectCafeteriaVoucherById 
	 * @Description:    根据套餐信息查询代金券
	 * @param          cdlId
	 * @return         CafeteriaVoucherBean    返回类型 
	 */
    public void selectCafeteriaVoucherById(CafeteriaVoucherBean bean,ModelMap model ){
	     //特色餐ID
    	Integer cdlId = bean.getCdlID();
    	CafeteriaVoucherBean detail = cafeteriaVoucherDao.selectCafeteriaVoucherById(cdlId);
    	//如果查询数据为空，则手动复制ID
    	if (detail == null){
    		detail = new CafeteriaVoucherBean();
    		detail.setCdlID(cdlId);
    	}
    	model.addAttribute("cafeteriaVoucher",detail);
    	// 查询代金券金额
    	List<CafeteriaVoucherPriceBean> list = this.cafeteriaVoucherPriceService.showList(detail.getId());
    	if (list == null || list.size() == 0) {
    		list.add(new CafeteriaVoucherPriceBean());
    		// 如果代金券list为null,则放进一个null的list
    		model.addAttribute("listVoucherPrice", list);
    	} else {
    		model.addAttribute("listVoucherPrice", list);
    	}
	}
    
    /**
     * @描述: 保存代金券信息
     * @作者: 贺渊博
     * @创建时间: 2015年11月24日 下午2:48:38
     * @param bean
     * @param request
     * @return
     */
	public Integer update(CafeteriaVoucherBean bean, HttpServletRequest request){
		Integer ID = bean.getId();
		Integer result = CommonUtil.ERROR;
		try {
			if (ID == null) {
				// 新增代金券信息
				result = cafeteriaVoucherDao.insert(bean);
				// 面额
				String[] acvpPriceTotal  = request.getParameterValues("cvpPriceTotal");
				// 同业价
				String[] acvpPriceTown   = request.getParameterValues("cvpPriceTown");  
				// 批发价
				String[] acvpPriceSale   = request.getParameterValues("cvpPriceSale"); 
				// 零售价
				String[] acvpPriceRetail = request.getParameterValues("cvpPriceRetail"); 
				
				// 如果代金劵面额不为空
				if(null != acvpPriceTotal && acvpPriceTotal.length > 0) {
					// 声明插入数组
					List<CafeteriaVoucherPriceBean> list = new ArrayList<CafeteriaVoucherPriceBean>();
					for(int i = 0; i < acvpPriceTotal.length; i++) {
						//价格bean
						CafeteriaVoucherPriceBean priceBean = new CafeteriaVoucherPriceBean();
						// 代金券面额
						priceBean.setCvpPriceTotal(changePrice(acvpPriceTotal[i]));
						// 同业价
						priceBean.setCvpPriceTown(changePrice(acvpPriceTown[i]));
						// 批发价
						priceBean.setCvpPriceSale(changePrice(acvpPriceSale[i]));
						// 零售价
						priceBean.setCvpPriceRetail(changePrice(acvpPriceRetail[i]));
						// 代金券ID
						priceBean.setDjqId(bean.getId());
						// 创建时间
						priceBean.setCvpCreatetime(new Date());
						list.add(priceBean);
					}
					if(null != list && list.size() > 0) {
						cafeteriaVoucherPriceService.insert(list);
					}
				}
			} else {
				result = cafeteriaVoucherDao.update(bean);
				   
				String[] acvpPriceTotal  = request.getParameterValues("cvpPriceTotal"); //面额
				String[] acvpPriceTown   = request.getParameterValues("cvpPriceTown");   //同业价
				String[] acvpPriceSale   = request.getParameterValues("cvpPriceSale"); //批发价
				String[] acvpPriceRetail = request.getParameterValues("cvpPriceRetail"); //零售价
				String[] acvpId 		 = request.getParameterValues("cvpId"); //ID
				   
				//如果代金劵面额不为空
				if(null != acvpPriceTotal && acvpPriceTotal.length > 0) {
					//声明插入数组
					List<CafeteriaVoucherPriceBean> list = new ArrayList<CafeteriaVoucherPriceBean>();
					for(int i = 0; i < acvpPriceTotal.length; i++) {
						//价格bean
						CafeteriaVoucherPriceBean priceBean = new CafeteriaVoucherPriceBean();
						priceBean.setCvpPriceTotal(this.changePrice(acvpPriceTotal[i]));
						priceBean.setCvpPriceTown(this.changePrice(acvpPriceTown[i]));
						priceBean.setCvpPriceSale(this.changePrice(acvpPriceSale[i]));
						priceBean.setCvpPriceRetail(this.changePrice(acvpPriceRetail[i]));
						priceBean.setDjqId(bean.getId());
						if(StringUtils.isNotBlank(acvpId[i])) {
							priceBean.setId(this.changePrice(acvpId[i]));
						   	cafeteriaVoucherPriceService.update(priceBean);
						} else {
							priceBean.setCvpCreatetime(new Date());
							list.add(priceBean);
						}
					}
					if(null != list && list.size()>0){
						this.cafeteriaVoucherPriceService.insert(list);
					}
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonUtil.ERROR;
		}
	}
	
	/**
	 * @描述: 判断是否为空 不为空 返回0
	 * @创建时间: 2015年11月24日 下午2:56:49
	 * @param price
	 * @return
	 */
	public Integer changePrice(String price){
		return StringUtils.isNotBlank(price) ? Integer.parseInt(price) : 0;
	}
	
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//代金券面额 
		model.addAttribute("voucher",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VOUCHER));
	}
    
}