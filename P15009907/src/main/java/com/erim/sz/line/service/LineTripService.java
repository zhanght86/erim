package com.erim.sz.line.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LineTripBean;
import com.erim.sz.line.dao.LineDetailDao;
import com.erim.sz.line.dao.LineTripDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @描述: 门票管理
 * 
 * @作者: （李庆）
 * @创建时间: 2015年12月1日 下午7:09:32
 */
@Service("lineTripService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineTripService {
	
	@Autowired
	private LineTripDao lineTripDao;
	@Autowired
	private LineDetailDao lineDetailDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 更新行程
	 * @param @param request    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(HttpServletRequest request,Integer tdlId){
		//行程天数
		String xcsize = request.getParameter("xcsize");
		if(StringUtils.isNotBlank(xcsize)){
			//设置总天数
			Integer size = Integer.parseInt(xcsize);
			for(int i = 1; i<size; i++){
				String id                  = request.getParameter("id"+i);
				String ltpStartplace       = request.getParameter("ltpStartplace"+i);
				
				//如果线路为空 进行下一个循环 
				if(StringUtils.isEmpty(ltpStartplace)) continue;
				
				String ltpRoadTrip1        = request.getParameter("ltpRoadTrip1"+i);
				String ltpFood1            = request.getParameter("ltpFood1"+i);
				String ltpRoad1 		   = request.getParameter("ltpRoad1"+i);
				String ltpRemark           = request.getParameter("ltpRemark"+i);
				String gddImge             = request.getParameter("gddImge"+i);
				String gddImg              = request.getParameter("gddImg"+i);
				String ltpFoodTrip1        = request.getParameter("ltpFoodTrip1"+i);
				
				String[] ldlTripTraffic    = request.getParameterValues("ldlTripTraffic"+i);
				String[] ltpEndplace       = request.getParameterValues("ltpEndplace"+i);
				//行程
				LineTripBean tripBean = new LineTripBean();
				tripBean.setLtpStartplace(ltpStartplace);
				tripBean.setLdlTripTraffic(CommonUtil.changetoString(ldlTripTraffic));
				tripBean.setLtpEndplace(CommonUtil.changetoString(ltpEndplace));
				tripBean.setLtpRoadTrip1(ltpRoadTrip1);
				tripBean.setLtpFood1(ltpFood1);
				tripBean.setLtpRemark(ltpRemark);
				tripBean.setGddImg1(gddImg);
				tripBean.setGddImg2(gddImge);
				tripBean.setLtpFoodTrip1(ltpFoodTrip1);
				tripBean.setLtpRoad1(ltpRoad1);
				tripBean.setGmtCreat(new Date());
				tripBean.setTdlId(tdlId);
				
				if(StringUtils.isNotBlank(id)){
					tripBean.setId(Integer.parseInt(id));
					this.lineTripDao.update(tripBean);
				}else{
					this.lineTripDao.insert(tripBean);
				}
			}	
		}
	}
	/**
	 * 
	 * @描述: 当地游修改界面进入行程管理页面
	 * @作者: （李庆）
	 * @创建时间: 2015年12月1日 下午7:09:13
	 * @param tdlId
	 * @param model
	 */
	public void getTripUpdatePage(Integer tdlId,ModelMap model) {
		// 产品ID
		model.addAttribute("tdlId", tdlId);
		// 根据产品ID获取行程管理信息
		List<LineTripBean> list = lineTripDao.getTripByTdlId(tdlId);
		for(LineTripBean trip : list){
			//路线
			String lineup = trip.getLtpEndplace();
			if(StringUtils.isNotBlank(lineup)){
				String[] alineup = lineup.split(",");
				trip.setAgddLineup(alineup);
			} else {
				trip.setAgddLineup(new String[]{""});
			}
			//工具
			String tool = trip.getLdlTripTraffic();
			if(StringUtils.isNotBlank(tool)){
				String[] atool = tool.split(",");
				trip.setAgddTool(atool);
			}
		}
		// 行程管理列表
		model.addAttribute("linetrip", list);
		// 根据产品ID获取一条当地游信息
		LineDetailBean detail = new LineDetailBean();
		detail.setId(tdlId);
		detail = lineDetailDao.selectLine(detail);
		model.addAttribute("lineDetail", detail);
		// 产品特色
		String ldlFeature = detail.getLdlFeature();
		if (ldlFeature != null && !"".equals(ldlFeature)) {
			model.addAttribute("ldlFeature", ldlFeature.split(","));
		} else {
			model.addAttribute("ldlFeature", new String[]{""});
		}
		// 有效期
		model.addAttribute("validity", codeService.getSystemCodeByCodeNo(DictionaryUtil.VALIDITY));
		// 交通工具
		 model.addAttribute("traffic", codeService.getSystemCodeByCodeNo(DictionaryUtil.TRAFFIC));
	}
	
	/**
	 * @Title: insert 
	 * @Description: 新增行程 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(LineTripBean bean) {
		Integer result = CommonUtil.ERROR;
		// 执行新增
		result = lineTripDao.insert(bean);
		// 当新增成功后返回ID
		if (result == CommonUtil.SUCCESS) {
			result = bean.getId();
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新行程 
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(LineTripBean lineTriplBean){
		this.lineTripDao.update(lineTriplBean);
		return lineTriplBean.getId();
	}
	
	public void delete(Integer id){
		this.lineTripDao.delete(id);
	}
}