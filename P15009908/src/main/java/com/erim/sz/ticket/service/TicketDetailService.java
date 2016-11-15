package com.erim.sz.ticket.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.ticket.dao.TicketDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: 	 TicketDetailService
 * @Description: 门票接口
 * @author       陈鹏
 * @date 		 2015年7月29日 下午8:02:48
 *
 */
@Service("ticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketDetailService {

	@Autowired
	private TicketDetailDao ticketDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CusSystemCooperationService  cusSystemCooperationService;
	
	/**
	 * @描述: 同业资源展示列表
	 * @作者: 
	 * @创建时间: 2015年11月30日 下午4:38:38
	 * @param model
	 * @param bean
	 */
	public void showTicketTown(ModelMap model, TicketDetailBean bean){
		
		String date = bean.getTplDate();
    	if (StringUtils.isEmpty(date)) {
    		bean.setTplDate(DateUtil.getCuurentDate());
    	}
    	
    	// 是否国内
    	String tdlWithinOrOuter = bean.getTdlWithinOrOuter();
    	// 国内
    	if ("01".equals(tdlWithinOrOuter)) {
    		// 清空港澳台，国家，国外城市
    		bean.setTdlNation(null);
    		bean.setTdlCountyone(null);
    		bean.setTdlCityone(null);
    	} else if ("02".equals(tdlWithinOrOuter)) {
    		// 清空省市县
    		bean.setTdlProvince(null);
    		bean.setTdlCity(null);
    		bean.setTdlCounty(null);
    	}
    	
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		
		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTown(bean, model);
		
		// 回传信息
		model.put("ticketList", ticketList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TEXI);
	}
	
	/**
	 * @方法名：showTicket 
	 * @描述: 产品管理门票管理列表
	 * @作者：贺渊博
	 * @创建时间：2015年11月11日 下午4:17:07
	 * @param model
	 * @param bean
	 */
	public void showTicket(ModelMap model, TicketDetailBean bean) {
		bean.setCpyId(CommonUtil.getCpyId());
		//获取景点区域值
		String withinOrOuter = bean.getTdlWithinOrOuter();
		//当选择国内时，清空国际所在地等字段
		if("01".equals(withinOrOuter)){
			bean.setTdlNation(null);
			bean.setTdlCountyone(null);
			bean.setTdlCityone(null);
		}
		//当选择国外时，清空省市区县三个字段
		else if("02".equals(withinOrOuter)){
			bean.setTdlProvince(null);
			bean.setTdlCity(null);
			bean.setTdlCounty(null);
		}
		
		bean.setCpyId(CommonUtil.getCpyId());
		//如果是合作用户查询合作用户的操作权限写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_TICKET);
			//产品id
			if(0 != cid) bean.setId(cid);
			
		}
		// 省
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		// ///////////////////////////////// 字典设置end

		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTicket(bean, model);
		
		// 回传信息
		model.put("ticketList", ticketList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TICKET);
    	//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}

	/**
	 * @Title: 		  insert
	 * @Description:  插入
	 * @param @param  model
	 * @param @param  bean 设定文件
	 * @return        void 返回类型
	 * @throws
	 */
	public Integer insert(ModelMap model, TicketDetailBean ticketDetailBean) {
		try {
			
			//添加时自动添加系统默认时间
			ticketDetailBean.setTdlCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			//添加时自动添加用户名
			ticketDetailBean.setTdlCreateuser((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
			//添加时自动添加公司id
			ticketDetailBean.setCpyId((Integer) SecurityUtils.getSubject().getSession().getAttribute("userCpyId"));
			//添加时自动添加为未审核通过
			ticketDetailBean.setTdlIsThrough("0");
			//添加时自动添加上下架，默认添加下架，0代表下架
			ticketDetailBean.setTdlIsDelStatus("0");
			//添加时选择国内或国际
			String  withinOrOuter = ticketDetailBean.getTdlWithinOrOuter();
			//选择国内时国际添加为空
			if("01".equals(withinOrOuter)){
				ticketDetailBean.setTdlNation(null);
				ticketDetailBean.setTdlCityone(null);
				ticketDetailBean.setTdlCountyone(null);
			}
			//如果选择国际时国内省市县添加为空
			else if("02".equals(withinOrOuter)){
				ticketDetailBean.setTdlProvince(null);
				ticketDetailBean.setTdlCity(null);
				ticketDetailBean.setTdlCounty(null);
			}
			// 插入数据
			Integer result = ticketDao.insertTicket(ticketDetailBean);
			// 当新增成功，返回ID，更新编码
			if (result == CommonUtil.SUCCESS) {
				Integer ID = ticketDetailBean.getId(); // 该条数据ID
				Integer cpyID = ticketDetailBean.getCpyId(); // 公司ID
				// 获取产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_TICKET, cpyID, ID);
				ticketDetailBean.setTdlCode(code);
				// 更新编号
				result = ticketDao.updateTicketcode(ticketDetailBean);
			}	
			return result;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * 
	 * @Title: 		  update
	 * @Description:  修改
	 * @param @param  model
	 * @param @param  bean 设定文件
	 * @return        void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, TicketDetailBean bean) {
		try {
			//添加时选择国内或国际
			String  withinOrOuter = bean.getTdlWithinOrOuter();
			//选择国内时国际添加为空
			if("01".equals(withinOrOuter)){
				bean.setTdlNation(null);
				bean.setTdlCityone(null);
				bean.setTdlCountyone(null);
			}
			//如果选择国际时国内省市县添加为空
			else if("02".equals(withinOrOuter)){
				bean.setTdlProvince(null);
				bean.setTdlCity(null);
				bean.setTdlCounty(null);
			}
			bean.setTdlCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ticketDao.updateTicket(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: 		  setCode
	 * @Description:  放置字典
	 * @param @param  model 设定文件
	 * @return 		  void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {
		//
		model.addAttribute("models", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		
		model.addAttribute("models", this.codeService.getSystemCodeByCodeNo("C017"));
		//
		model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
		// 省市县
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		// 信用卡
		model.addAttribute("credit", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CREDIT));
		// 景点级别
		model.addAttribute("level", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LEVEL));
		// 景点主题
		model.addAttribute("attractions", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));
		// 预定方式
		model.addAttribute("scheduled", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
		// 国家  香港 澳门 台湾 国家
		model.addAttribute("state", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
		// 国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}

	/**
	 * @Title: 		  delete
	 * @Description:  上下架
	 * @param @param  id 设定文件
	 * @return 		  void 返回类型
	 * @throws
	 */

	public int delete(TicketDetailBean bean) {
		try {
			ticketDao.deleteTicket(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: 		  selectBeanByPriId
	 * @Description:  ID查询门票基础信息 查看专用 
	 * @param @param  id
	 * @param @return 设定文件
	 * @return 		  TicketDetailBean 返回类型
	 * @throws
	 */
	public void selectBeanByPriId(ModelMap model, Integer id) {
		TicketDetailBean bean = this.ticketDao.getTicketById(id);
		// 省
		String province = bean.getTdlProvince();
		if (!"".equals(province) && province != null) {
			String proviceStr = tmSystemRegionService.getSystemRegionById(Integer.valueOf(province));
			bean.setTdlProvince(proviceStr);
		}
		// 市
		String tdlCity = bean.getTdlCity();
		if (!"".equals(tdlCity) && tdlCity != null) {
			String tdlCityStr = tmSystemRegionService.getSystemRegionById(Integer.valueOf(tdlCity));
			bean.setTdlCity(tdlCityStr);
		}
		// 县
		String county = bean.getTdlCounty();
		if (!"".equals(county) && county != null) {
			String countyStr = tmSystemRegionService.getSystemRegionById(Integer.valueOf(county));
			bean.setTdlCounty(countyStr);
		}
		//景点级别
		String tdlScenicLevel = bean.getTdlScenicLevel();
		if (!"".equals(tdlScenicLevel) && tdlScenicLevel != null) {
			String tdlScenicLevelStr = codeService.getValueByCodeKeys("C098", tdlScenicLevel);
			bean.setTdlScenicLevel(tdlScenicLevelStr);
		}
		//景点主题
		String tdlAttractions = bean.getTdlAttractions();
		if (!"".equals(tdlAttractions) && tdlAttractions != null) {
			String tdlAttractionsStr = codeService.getValueByCodeKeys("C099", tdlAttractions);
			bean.setTdlAttractions(tdlAttractionsStr);
		}
		String TdlNation=bean.getTdlNation();
		if(TdlNation!=null && !"".equals(TdlNation)){
			if("01".equals(TdlNation)){
				bean.setTdlNation("香港");
			}
			if("02".equals(TdlNation)){
				bean.setTdlNation("澳门");
			}
			if("03".equals(TdlNation)){
				bean.setTdlNation("台湾");
			}
		}
		model.addAttribute("ticketDetail", bean);
	}
	
	/**
	 * @Title: 		 selectBeanByPriIdUpdete
	 * @Description: 根据ID获取一条信息 - 修改专用
	 * @param 		 model
	 * @param 		 id
	 */
	public void selectBeanByPriIdUpdete(ModelMap model, Integer id) {
		TicketDetailBean detail = this.ticketDao.getTicketById(id);
		model.addAttribute("altattractions", detail.getTdlAddtheme().split(","));
		model.addAttribute("ticketDetail", detail);
	}
	
	/**
	 * @Title: 		  update
	 * @Description:  修改
	 * @param @param  model
	 * @param @param  bean 设定文件
	 * @return        void 返回类型
	 * @throws
	 */
	public Integer update1(ModelMap model, TicketDetailBean bean) {
		try {
			ticketDao.updateTicket1(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: 		 delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return 		 int 返回类型
	 * @throws
	 */
	public int delete(Integer id) {
		try {
			ticketDao.deleteTicket(id);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	public String getGuojiaForQuery(ExtHashMap map){
	    Iterator iter = map.entrySet().iterator();
	    String s = "";
	    while(iter.hasNext()){
	       Entry entry = (Entry) iter.next();
	       Object a = entry.getValue();
	       s += a.toString()+",";
	    }
	    return s;
	}
}
