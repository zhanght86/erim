package com.erim.sz.line.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.line.dao.LinePriceDao;

/**
 * @ClassName: LinePriceService 
 * @Description: 量价查询接口 
 * @author maoxian
 * @date 2015年12月25日 上午1:53:25
 */
@Service("linePriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LinePriceService {
	
	@Autowired
	private LinePriceDao linePriceDao;
	
	
	/**
	 * @Title: selectLinePriceList 
	 * @Description: 量价查询接口
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<LinePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午1:53:09 
	 * @throws
	 */
	public List<LinePriceBean> selectLinePriceList(LinePriceBean bean) {
		
		return this.linePriceDao.selectLinePriceList(bean);
	}
}