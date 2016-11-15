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

import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.bean.TexiDrivePriceBean;
import com.erim.sz.web.dao.TexiDriveDao;
import com.erim.web.service.CodeService;
@Service("texiDriveService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiDriveService {
	@Autowired
	private TexiDriveDao texidrivedao;
	@Autowired
	private CodeService codeService;
	/**
	 * @方法名：selectDriveById 
	 * @描述:  租车自驾
	 * @作者：    贺渊博
	 * @创建时间：2015年11月23日 下午5:35:20
	 * @param model
	 * @param id
	 *
	 */
	public TexiDriveBean selectDriveById(ModelMap model,Integer id){
		TexiDriveBean bean = texidrivedao.selectDriveTexi(id);
		//转码
		//半天取车方式
		String zjlHfTakePlace = bean.getZjlHfTakePlace();
		if(null != zjlHfTakePlace && !"".equals(zjlHfTakePlace)){
			if("01".equals(zjlHfTakePlace)){
				bean.setZjlHfTakePlace("送车上门");
			}
			if("02".equals(zjlHfTakePlace)){
				bean.setZjlHfTakePlace("固定地点");
			}
		}
		//半天还车方式
		String zjlHfBackPlace = bean.getZjlHfBackPlace();
		if(null != zjlHfBackPlace && !"".equals(zjlHfBackPlace)){
			if("01".equals(zjlHfBackPlace)){
				bean.setZjlHfTakePlace("送车上门");
			}
			if("02".equals(zjlHfBackPlace)){
				bean.setZjlHfBackPlace("固定地点");
			}
		}
		//全天取车方式
		String ZjlTakePlace = bean.getZjlTakePlace();
		if(null != ZjlTakePlace && !"".equals(ZjlTakePlace)){
			if("01".equals(zjlHfTakePlace)){
				bean.setZjlTakePlace("送车上门");
			}
			if("02".equals(zjlHfTakePlace)){
				bean.setZjlTakePlace("固定地点");
			}
		}
		//全天还车方式
		String zjlBackPlace = bean.getZjlBackPlace();
		if(null != zjlBackPlace && !"".equals(zjlBackPlace)){
			if("01".equals(zjlHfTakePlace)){
				bean.setZjlBackPlace("送车上门");
			}
			if("02".equals(zjlHfTakePlace)){
				bean.setZjlBackPlace("固定地点");
			}
		}
		
		return bean;
	}
	public TexiDriveBean selectTexiDrive(ModelMap model,Integer tdlId){
		TexiDriveBean texiDriveBean = new TexiDriveBean();
		texiDriveBean.setTdlId(tdlId);
		List<TexiDriveBean> beanList = texidrivedao.selectTexiDrive(texiDriveBean);
		TexiDriveBean bean = new TexiDriveBean();
		if(beanList != null && beanList.size()>0){
			bean = beanList.get(0);
		}
		//转码
		//半天取车方式
		String zjlHfTakePlace = bean.getZjlHfTakePlace();
		if(null != zjlHfTakePlace && !"".equals(zjlHfTakePlace)){
			if("01".equals(zjlHfTakePlace)){
				bean.setZjlHfTakePlace("送车上门");
			}
			if("02".equals(zjlHfTakePlace)){
				bean.setZjlHfTakePlace("固定地点");
			}
		}
		//半天还车方式
		String zjlHfBackPlace = bean.getZjlHfBackPlace();
		if(null != zjlHfBackPlace && !"".equals(zjlHfBackPlace)){
			if("01".equals(zjlHfBackPlace)){
				bean.setZjlHfBackPlace("上门取车");
			}
			if("02".equals(zjlHfBackPlace)){
				bean.setZjlHfBackPlace("固定地点");
			}
		}
		//全天取车方式
		String ZjlTakePlace = bean.getZjlTakePlace();
		if(null != ZjlTakePlace && !"".equals(ZjlTakePlace)){
			if("01".equals(ZjlTakePlace)){
				bean.setZjlTakePlace("送车上门");
			}
			if("02".equals(ZjlTakePlace)){
				bean.setZjlTakePlace("固定地点");
			}
		}
		//全天还车方式
		String zjlBackPlace = bean.getZjlBackPlace();
		if(null != zjlBackPlace && !"".equals(zjlBackPlace)){
			if("01".equals(zjlBackPlace)){
				bean.setZjlBackPlace("上门取车");
			}
			if("02".equals(zjlBackPlace)){
				bean.setZjlBackPlace("固定地点");
			}
		}
		
		return bean;
	}
	public TexiDrivePriceBean selectTexiDrivePriceBean(ModelMap model,TexiDrivePriceBean bean){
		if(StringUtils.isEmpty(bean.getTdpDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bean.setTdpDate(sdf.format(date));
		}
		List<TexiDrivePriceBean>  listBean = this.texidrivedao.selectTexiDrivePriceBeanList(bean);
		if(listBean.size()>0){
			return listBean.get(0);
		}else{
			return null;
		}
		
	}
}
