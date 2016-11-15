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

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.web.dao.PlaneticketDetailDao;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: PlaneticketDetailService 
 * @Description: 机票接口
 * @author maoxian
 * @date 2015年9月15日 下午12:56:50 
 *
 */
@Service("planeticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketDetailService {

	@Autowired
	private PlaneticketDetailDao planeticketDao;
	@Autowired
	private CodeService           codeService;


	public void showPlaneticket(ModelMap model, PlaneticketDetailBean bean,Integer limit) {
		if(StringUtils.isEmpty(bean.getPreDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setPreDate(dateStr);
		}
		// 分页查询
		List<PlaneticketDetailBean> planeticketList = planeticketDao.selectPagePlaneticket(bean, model,limit);
		// 回传信息
		model.put("planeticketList", planeticketList);
	}


	/**
	 * 
	 * @Title: selectPlaneticket
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @returnPlaneticketDetailBean    返回签证实体对象
	 * @throws
	 */
	public void selectPlaneticket(ModelMap model,Integer id){
		
		PlaneticketDetailBean bean = planeticketDao.selectPlaneticket(id);
		
		model.addAttribute("Planeticket",bean);
	}
	


}
