package com.erim.sz.texi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.texi.dao.TexiCarDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: TexiDriveService
 * @Description:包车
 * @author heyuanbo
 * @date 2015年10月1日
 *
 */
@Service("texiCarService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiCarService {

	@Autowired
	private TexiCarDao texiCarDao;

	/**
	 * @描述: 根据产品ID查询包车信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 上午11:25:54
	 * @param bean
	 * @param map
	 */
	public void getTexiCarById(TexiCarBean bean, ModelMap map) {

		// 产品ID
		Integer tdlId = bean.getTdlId();
		TexiCarBean detail = texiCarDao.getTexiCarById(tdlId);
		// 如果查询数据为空，则手动赋值ID
		if (detail == null) {
			detail = new TexiCarBean();
			detail.setTdlId(tdlId);
		}
		map.addAttribute("texiDrive", detail);
	}

	/**
	 * @Title: update 
	 * @Description: 包车数据更新
	 * @param bean
	 * @param 设定文件 
	 * @return Integer 返回类型 
	 */
	public Integer update(TexiCarBean bean) {
		// 定义返回状态
		Integer result = CommonUtil.ERROR;
		// 包车信息ID
		Integer ID = bean.getId();
		try {
			
			if (ID == null) {
				result = texiCarDao.insert(bean);
			} else {
				result = texiCarDao.update(bean);
			}
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return CommonUtil.ERROR;
		}
	}
}
