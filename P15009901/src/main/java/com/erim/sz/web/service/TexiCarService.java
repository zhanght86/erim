package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.common.bean.TexiCarPriceBean;
import com.erim.sz.web.dao.TexiCarDao;
import com.erim.web.service.CodeService;
@Service("texiCarService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
/**
 * 
 * @类名: TexiCarService
 * @描述: 租车包车
 * @作者: 王赛
 * @创建时间: 2015年11月27日 下午1:36:50
 *
 */
public class TexiCarService {
	@Autowired
	private TexiCarDao texicardao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectDriveById
	 * @描述: 租车包车
	 * @作者: 王赛
	 * @创建时间: 2015年11月27日 下午1:34:44 
	 * @param model
	 * @param id
	 *
	 */
	public TexiCarBean selectCarById(ModelMap model,Integer id){
		
		TexiCarBean bean = texicardao.selectcarTexi(id);
		return bean;
		
	}
	public TexiCarBean selectTexiCar(ModelMap model,Integer tdlId){
		TexiCarBean texiCarBean = new TexiCarBean();
		texiCarBean.setTdlId(tdlId);
		List<TexiCarBean> bean = texicardao.selectcarTexiList(texiCarBean);
		if(bean != null && bean.size() >0){
			return bean.get(0);
		}
		return null;
		
	}
	public TexiCarPriceBean selectTexiCarPriceBean(ModelMap model,TexiCarPriceBean bean){
		if(StringUtils.isEmpty(bean.getTcpDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bean.setTcpDate(sdf.format(date));
		}
		List<TexiCarPriceBean>  listBean = this.texicardao.selectTexiDrivePriceBeanList(bean);
		if(listBean.size()>0){
			return listBean.get(0);
		}else{
			return null;
		}
		
	}
}
