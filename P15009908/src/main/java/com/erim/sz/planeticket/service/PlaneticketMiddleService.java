package com.erim.sz.planeticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PlaneticketMiddleBean;
import com.erim.sz.planeticket.dao.PlaneticketMiddleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: PlaneticketMiddleService 
 * @Description: 机票中转
 * @author maoxian 
 * @date 2015年10月29日 上午11:00:48 
 *
 */
@Service("planeticketMiddleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketMiddleService {

	@Autowired
	private PlaneticketMiddleDao planeticketMiddleDao;
	
	/**
	 * @Title: insertPlaneticket 
	 * @Description: 新增方法
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertPlaneticket(List<PlaneticketMiddleBean> list) {
		return this.planeticketMiddleDao.insertPlaneticket(list);
	}
	
	/**
	 * @Title: selectPlaneticketDetailMiddleById 
	 * @Description: 修改方法
	 * @param @param model  id
	 * @param @return    设定文件 
	 * @throws
	 */
	public void selectPlaneticketDetailMiddleById(ModelMap model,Integer id) {
		model.addAttribute("planeticketDetailMiddleList", this.planeticketMiddleDao.selectPlaneticketByPldId(id));
	}

	/**
	 * @Title: updatePlaneticket 
	 * @Description: 修改
	 * @param @param middleBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月24日 下午2:48:41 
	 * @throws
	 */
	public Integer updatePlaneticket(PlaneticketMiddleBean middleBean){
		this.planeticketMiddleDao.updatePlaneticket(middleBean);
		return CommonUtil.SUCCESS;
	}
}
