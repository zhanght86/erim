package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.PubCityshopBean;
import com.erim.sz.web.dao.PubCitytownDao;

/**
 * @ClassName: PubCitytownService 
 * @Description: 社会商圈
 * @author maoxian
 * @date 2015年10月3日 下午10:13:00
 */
@Service("pubCitytownService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PubCitytownService {

	@Autowired
	private PubCitytownDao  pubCitytownDao;
	
	/**
	 * @Title: update 
	 * @Description: 数据清洗
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(){
		List<PubCityshopBean> list = this.pubCitytownDao.selectAllCode();
		
		for(PubCityshopBean bean :list){
			String  lb = bean.getLb();
			
			String aa = "";
			if(lb.contains("医院：")){
					aa += lb +",";
			}
			
			System.out.println(aa);
		}
	}
}
