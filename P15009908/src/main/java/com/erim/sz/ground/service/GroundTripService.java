package com.erim.sz.ground.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.ground.dao.GroundDetailDao;
import com.erim.sz.ground.dao.GroundTripDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: TicketPriceService 
 * @Description: 门票价格
 * @author maoxian
 * @date 2015年8月20日 上午1:02:24 
 */
@Service("groundTripService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundTripService {
	
	@Autowired
	private GroundTripDao groundTripDao;
	@Autowired
	private GroundDetailDao groundDetailDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @描述: 更新行程
	 * @作者: 
	 * @创建时间: 2015年12月9日 上午10:03:05
	 * @param request
	 * @param tdlId
	 */
	public void insertList(HttpServletRequest request, Integer tdlId) {
		//行程天数
		String xcsize = request.getParameter("xcsize");
		if(StringUtils.isNotBlank(xcsize)){
			//设置总天数
			Integer size = Integer.parseInt(xcsize);
			for(int i = 1; i<size; i++){
				String id            = request.getParameter("id"+i);
				String gddLine       = request.getParameter("gddLine"+i);
				String gddImg        = request.getParameter("gddImg"+i);
				String gddLunch      = request.getParameter("gddLunch"+i);
				String gddAfternoon  = request.getParameter("gddAfternoon"+i);
				String gddAm 		 = request.getParameter("gddAm"+i);
				String gddImge       = request.getParameter("gddImge"+i);
				String gddDinner     = request.getParameter("gddDinner"+i);
				String gddSupplement = request.getParameter("gddSupplement"+i);
				
				String[] gddTool       = request.getParameterValues("gddTool"+i);
				String[] gddLineup     = request.getParameterValues("gddLineup"+i);
				
				
				//行程
				GroundTriplBean tripBean = new GroundTriplBean();
				tripBean.setGddLine(gddLine);
				tripBean.setGddTool(CommonUtil.changetoString(gddTool));
				tripBean.setGddLineup(CommonUtil.changetoString(gddLineup));
				tripBean.setGddImg1(gddImg);
				tripBean.setGddImg2(gddImge);
				tripBean.setGddLunch(gddLunch);
				tripBean.setGddAfternoon(gddAfternoon);
				tripBean.setGddDinner(gddDinner);
				tripBean.setGddSupplement(gddSupplement);
				tripBean.setGddAm(gddAm);
				tripBean.setGmtCreat(new Date());
				tripBean.setTdlId(tdlId);
				
				if(StringUtils.isNotBlank(id)) {
					tripBean.setId(Integer.parseInt(id));
					this.groundTripDao.update(tripBean);
				} else {
					this.groundTripDao.insert(tripBean);
				}
			}
		}
	}
	
	/**
	 * @描述: 当地游修改界面进入行程管理页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午2:23:45
	 * @param tdlId
	 * @param model
	 */
	public void getTripUpdatePage(Integer tdlId,ModelMap model) {
		// 产品ID
		model.addAttribute("tdlId", tdlId);
		// 根据产品ID获取行程管理信息
		List<GroundTriplBean> list = groundTripDao.getTripByTdlId(tdlId);
		for(GroundTriplBean trip : list){
			//路线
			String lineup = trip.getGddLineup();
			if(StringUtils.isNotBlank(lineup)){
				String[] alineup = lineup.split(",");
				trip.setAgddLineup(alineup);
			}
			//工具
			String tool = trip.getGddTool();
			if(StringUtils.isNotBlank(tool)){
				String[] atool = tool.split(",");
				trip.setAgddTool(atool);
			}
		}
		// 行程管理列表
		model.addAttribute("groundtrip", list);
		// 根据产品ID获取一条当地游信息
		GroundDetailBean detail = new GroundDetailBean();
		detail.setId(tdlId);
		detail = groundDetailDao.selectGround(detail);
		model.addAttribute("groundDetail", detail);
		// 产品特色
		String gddFeature = detail.getGddFeature();
		if (gddFeature != null && !"".equals(gddFeature)) {
			model.addAttribute("gddFeature", gddFeature.split(","));
		} else {
			model.addAttribute("gddFeature", new String[]{""});
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
	public Integer insert(GroundTriplBean bean) {
		Integer result = CommonUtil.ERROR;
		// 执行新增
		result = groundTripDao.insert(bean);
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
	public Integer update(GroundTriplBean groundTriplBean){
		this.groundTripDao.update(groundTriplBean);
		return groundTriplBean.getId();
	}
	
	public void delete(Integer id){
		this.groundTripDao.delete(id);
	}
}