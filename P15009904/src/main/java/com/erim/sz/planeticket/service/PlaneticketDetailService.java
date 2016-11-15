package com.erim.sz.planeticket.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.PlaneticketMiddleBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.planeticket.dao.PlaneticketDetailDao;
import com.erim.sz.tm.service.TmSystemCountryService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.sz.zy.service.ZySystemCooperationService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: PlaneticketDetailService 
 * @Description: 机票管理
 * @author maoxian 
 * @date 2015年10月29日 上午11:07:38 
 *
 */
@Service("planeticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketDetailService {

	@Autowired
	private PlaneticketDetailDao     planeticketDao;
	@Autowired
	private CodeService              codeService;
	@Autowired
	private TmSystemRegionService    tmSystemRegionService;
	@Autowired
	private TmSystemCountryService 	 tmSystemCountryService;
	@Autowired
	private PlaneticketMiddleService planeticketMiddleService;
	@Autowired
	private ZySystemCooperationService  zySystemCooperationService;
	
	/**
	 * @方法名：showPlaneticketTown 
	 * @描述: 同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月18日 下午6:04:00
	 * @param model
	 * @param bean
	 */
	public void showPlaneticketTown(ModelMap model,PlaneticketDetailBean bean) {
		
		String date = bean.getPreDate();
    	if (StringUtils.isEmpty(date)) {
    		bean.setPreDate(DateUtil.getCuurentDate());
    	}
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		
		List<PlaneticketDetailBean> planeticketList = planeticketDao.selectPageTown(bean, model);
		//转码
		for(int i = 0;i < planeticketList.size();i++){
			PlaneticketDetailBean detail = planeticketList.get(i);
			//出发城市
			String ptdStartCity = detail.getPtdStartCity();
			if (ptdStartCity != null && !"".equals(ptdStartCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdStartCity));
				detail.setPtdStartCity(str);
			}
			//到达城市
			String ptdendCity = detail.getPtdEndCity();
			if (ptdendCity != null && !"".equals(ptdendCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdendCity));
				detail.setPtdEndCity(str);
			}
			//出发国际港澳台
			String ptdStartTown = detail.getPtdStartTown();
			if(ptdStartTown != null && !"".equals(ptdStartTown)){
				if("01".equals(ptdStartTown)){
					detail.setPtdStartTown("香港");
				}
				if("02".equals(ptdStartTown)){
					detail.setPtdStartTown("澳门");
				}
				if("03".equals(ptdStartTown)){
					detail.setPtdStartTown("台湾");
				}
			}
			//到达国际港澳台
			String ptdEndTown = detail.getPtdEndTown();
			if(ptdEndTown != null && !"".equals(ptdEndTown)){
				if("01".equals(ptdEndTown)){
					detail.setPtdEndTown("香港");
				}
				if("02".equals(ptdEndTown)){
					detail.setPtdEndTown("澳门");
				}
				if("03".equals(ptdEndTown)){
					detail.setPtdEndTown("台湾");
				}
			}
		}
		// 回传信息
		model.put("planeticketList", planeticketList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_PLANETICKET);
    	//省市县
        model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
	
	/**
	 * @Title: listPlaneTicketDetail 
	 * @Description: 查询机票
	 * @param @param model
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
	public List<PlaneticketDetailBean> listPlaneTicketDetail(PlaneticketDetailBean bean){
		return this.planeticketDao.selectPlaneticket(bean);
	}
	
	/**
	 * @方法名：   showPlaneticket 
	 * @描述:    获取数据列表
	 * @作者：       贺渊博
	 * @创建时间：2015年10月10日 下午2:27:52
	 * @param   model
	 * @param   bean
	 */
	public void showPlaneticket(ModelMap model, PlaneticketDetailBean bean) {
		bean.setCpyId(CommonUtil.getCpyId());
		//搜索项清空内容
		String startone = bean.getPtdStartState();
		if(null != startone && !"".equals(startone)){
			//如果选择国内，清空国际的值
			if("01".equals(startone)){
				bean.setPtdStartTown(null);//国际港澳台
				bean.setPtdForeign(null);//国家
				bean.setPtdForeigncity(null);//城市
			}
			//如果选择国际，清空国内的值
			else if("02".equals(startone)){
				bean.setPtdStartProvince(null);//省
				bean.setPtdStartCity(null);//市
			}
		}
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = zySystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_PLANETICKET);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		// 分页查询
		List<PlaneticketDetailBean> planeticketList = planeticketDao.selectPagePlaneticket(bean, model);
		//转码
		for(int i = 0;i < planeticketList.size();i++){
			PlaneticketDetailBean detail = planeticketList.get(i);
			//出发城市
			String ptdStartCity = detail.getPtdStartCity();
			if (ptdStartCity != null && !"".equals(ptdStartCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdStartCity));
				detail.setPtdStartCity(str);
			}
			//到达城市
			String ptdendCity = detail.getPtdEndCity();
			if (ptdendCity != null && !"".equals(ptdendCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdendCity));
				detail.setPtdEndCity(str);
			}
			String ptdStartTown = detail.getPtdStartTown();
			if(ptdStartTown != null && !"".equals(ptdStartTown)){
				if("01".equals(ptdStartTown)){
					detail.setPtdStartTown("香港");
				}
				if("02".equals(ptdStartTown)){
					detail.setPtdStartTown("澳门");
				}
				if("03".equals(ptdStartTown)){
					detail.setPtdStartTown("台湾");
				}
			}
			String ptdEndTown = detail.getPtdEndTown();
			if(ptdEndTown != null && !"".equals(ptdEndTown)){
				if("01".equals(ptdEndTown)){
					detail.setPtdEndTown("香港");
				}
				if("02".equals(ptdEndTown)){
					detail.setPtdEndTown("澳门");
				}
				if("03".equals(ptdEndTown)){
					detail.setPtdEndTown("台湾");
				}
			}
		}
		
		// 回传信息
		model.put("planeticketList", planeticketList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_PLANETICKET);
    	//省市县
        model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
        //国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}

	/**
	 * 
	 * @Title: 		 insert
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public int insert(ModelMap model,PlaneticketDetailBean bean,HttpServletRequest request) {
		try{
			//添加时上下架默认添加为下架，0代表下架
			bean.setPtdIsDelStatus("0");
			//添加时自动添加创建时间
			bean.setPtdCreatetime(new Date());
			//添加时自动添加创建用户
			bean.setPtdCreateuser((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
			//添加时自动添加公司id
			bean.setCpyId(CommonUtil.getCpyId());
			// 插入数据
			/*王赛：添加时国内国际、是否经停选择清空字段*/
			//出发国内国际值
			String ptdStartState = bean.getPtdStartState();
			if(null != ptdStartState && !"".equals(ptdStartState)){
				//选择国内时清空国际字段
				if("01".equals(ptdStartState)){
					bean.setPtdStartTown(null);
					bean.setPtdForeign(null);
					bean.setPtdForeigncity(null);
				}
				//选择国际时清空国内字段
				if("02".equals(ptdStartState)){
					bean.setPtdStartCity(null);
					bean.setPtdStartProvince(null);
				}
			}
			//到达国内国际值
			String ptdendstste = bean.getPtdEndState();
			if(null != ptdendstste && !"".equals(ptdendstste)){
				//选择国内时清空国际字段
				if("01".equals(ptdendstste)){
					bean.setPtdEndforeign(null);
					bean.setPtdEndforeigncity(null);
					bean.setPtdEndTown(null);
				}
				//选择国际时清空国内地段
				if("02".equals(ptdendstste)){
					bean.setPtdEndCity(null);
					bean.setPtdEndProvince(null);
				}
			}
			//获取是否经停的值
			String yesno = bean.getPtdYesno();
			if(null != yesno && !"".equals(yesno)){
				//如果选择否，清空国内国际所有的值
				if("01" .equals(yesno)){
					bean.setPtdGuojia(null);
					bean.setPtdProvince(null);
					bean.setPtdCity(null);
					bean.setPtdTown(null);
					bean.setPtdJingforeign(null);
					bean.setPtdJingcity(null);
				}
				//如果选择是，根据是否属于国内和国际清空国内和国际的值
				if("02".equals(yesno)){
					//获取经停国内国际的值
					String Guojia = bean.getPtdGuojia();
					if(null != Guojia && !"".equals(Guojia)){
						//如果选择国内时清空国际值
						if("01".equals(Guojia)){
							bean.setPtdTown(null);
							bean.setPtdJingforeign(null);
							bean.setPtdJingcity(null);
						}else if("02".equals(Guojia)){
							//选择国际时清空国内值
							bean.setPtdProvince(null);
							bean.setPtdCity(null);
						}
					}
				}
			}
			Integer result = planeticketDao.insertPlaneticket(bean);
			Integer pdlid    = bean.getId();
			if(result == CommonUtil.SUCCESS){
				Integer ID = bean.getId(); //该条数据ID
				Integer cpyID = bean.getCpyId();//公司ID
				//获取产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_PLANETICKET, cpyID,ID);
				bean.setPtdNo(code);
				//更新编码
				result = planeticketDao.updatecode(bean);
			}
			
			//获取添加中转数量
			String zzsl = request.getParameter("zzsl");
			if(StringUtils.isNotBlank(zzsl)){
				//中转数量
				Integer int_zz = Integer.parseInt(zzsl);
				
				List<PlaneticketMiddleBean> list = new java.util.ArrayList<PlaneticketMiddleBean>();
				
				for(int i =1;i<=int_zz;i++){
					String pdrnMiddleTime    = request.getParameter("pdrnMiddleTime"+i);
					if(StringUtils.isEmpty(pdrnMiddleTime)) continue;
					String pdrnMiddleState   = request.getParameter("pdrnMiddleState"+i);
					String pdrnProvince      = request.getParameter("pdrnProvince"+i);
					String pdrnMiddleCity    = request.getParameter("pdrnMiddleCity"+i);
					String pdrnExternal      = request.getParameter("pdrnExternal"+i);
					String pdrnForeign       = request.getParameter("pdrnForeign"+i);
					String pdrnForeignCity   = request.getParameter("pdrnForeignCity"+i);
					String pdrnMiddleEndtime = request.getParameter("pdrnMiddleEndtime"+i);
					
					PlaneticketMiddleBean middle = new PlaneticketMiddleBean();
					middle.setPdlId(pdlid);
					middle.setPdrnMiddleTime(pdrnMiddleTime);
					middle.setPdrnMiddleState(pdrnMiddleState);
					middle.setPdrnProvince(pdrnProvince);
					middle.setPdrnMiddleCity(pdrnMiddleCity);
					middle.setPdrnExternal(pdrnExternal);
					middle.setPdrnForeign(pdrnForeign);
					middle.setPdrnForeignCity(pdrnForeignCity);
					middle.setPdrnMiddleEndtime(pdrnMiddleEndtime);
					list.add(middle);
				}
				//如果中转不为空的
				if(null != list && list.size()>0){
					this.planeticketMiddleService.insertPlaneticket(list);
				}
			}
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * @Title: 		  selectPlaneticketDetialById 
	 * @Description:  根据ID查询实体 
	 * @param @param  id
	 * @param @return 设定文件 
	 * @return 		  TexiDetailBean    返回类型 
	 * @throws
	 */
	public void selectPlaneticketDetialById(ModelMap model,Integer id){
		
		PlaneticketDetailBean bean = planeticketDao.selectPlaneticket(id);
		
		model.addAttribute("planeticketDetail", bean);
	}

	/**
	 * @Title: updateMiddle 
	 * @Description: update 中转
	 * @param @param model
	 * @param @param bean
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月24日 上午1:10:29 
	 * @throws
	 */
	public Integer updateMiddle(ModelMap model, PlaneticketDetailBean bean,HttpServletRequest request){
		//出发国内国际值
		String ptdStartState = bean.getPtdStartState();
		if(null != ptdStartState && !"".equals(ptdStartState)){
			//选择国内时清空国际字段
			if("01".equals(ptdStartState)){
				bean.setPtdStartTown(null);
				bean.setPtdForeign(null);
				bean.setPtdForeigncity(null);
			}
			//选择国际时清空国际字段
			if("02".equals(ptdStartState)){
				bean.setPtdStartCity(null);
				bean.setPtdStartProvince(null);
			}
		}
		//到达国内国际值
		String ptdendstste = bean.getPtdEndState();
		if(null != ptdendstste && !"".equals(ptdendstste)){
			//选择国内时清空国际字段
			if("01".equals(ptdendstste)){
				bean.setPtdEndforeign(null);
				bean.setPtdEndforeigncity(null);
				bean.setPtdEndTown(null);
			}
			//选择国际时清空国内字段
			if("02".equals(ptdendstste)){
				bean.setPtdEndCity(null);
				bean.setPtdEndProvince(null);
			}
		}
		planeticketDao.updatePlaneticket(bean);
		
		//获取添加中转数量
		String zzsl = request.getParameter("zzsl");
		if(StringUtils.isNotBlank(zzsl)){
			//中转数量
			Integer int_zz = Integer.parseInt(zzsl);
			
			List<PlaneticketMiddleBean> list = new java.util.ArrayList<PlaneticketMiddleBean>();
			
			for(int i =1;i<int_zz;i++){
				String pdrnMiddleId      = request.getParameter("pdrnMiddleId"+i);
				String pdrnMiddleTime    = request.getParameter("pdrnMiddleTime"+i);
				if(StringUtils.isEmpty(pdrnMiddleTime)) continue;
				String pdrnMiddleState   = request.getParameter("pdrnMiddleState"+i);
				String pdrnProvince      = request.getParameter("pdrnProvince"+i);
				String pdrnMiddleCity    = request.getParameter("pdrnMiddleCity"+i);
				String pdrnExternal      = request.getParameter("pdrnExternal"+i);
				String pdrnForeign       = request.getParameter("pdrnForeign"+i);
				String pdrnForeignCity   = request.getParameter("pdrnForeignCity"+i);
				String pdrnMiddleEndtime = request.getParameter("pdrnMiddleEndtime"+i);
				
				PlaneticketMiddleBean middle = new PlaneticketMiddleBean();
				middle.setPdlId(bean.getId());
				middle.setPdrnMiddleTime(pdrnMiddleTime);
				middle.setPdrnMiddleState(pdrnMiddleState);
				middle.setPdrnProvince(pdrnProvince);
				middle.setPdrnMiddleCity(pdrnMiddleCity);
				middle.setPdrnExternal(pdrnExternal);
				middle.setPdrnForeign(pdrnForeign);
				middle.setPdrnForeignCity(pdrnForeignCity);
				middle.setPdrnMiddleEndtime(pdrnMiddleEndtime);
				if(StringUtils.isNotBlank(pdrnMiddleId)){
					middle.setId(Integer.parseInt(pdrnMiddleId));
					this.planeticketMiddleService.updatePlaneticket(middle);
				}else{
					list.add(middle);
				}
			}
			//如果中转不为空的
			if(null != list && list.size()>0){
				this.planeticketMiddleService.insertPlaneticket(list);
			}
		}
		
		return CommonUtil.SUCCESS;
	}
	
	/**
	 * 
	 * @Title: 		 update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return       void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, PlaneticketDetailBean bean) {
		try{
			/*王赛：机票修改时国内国际、是否经停选择清空字段*/
			//出发国内国际值
			String ptdStartState = bean.getPtdStartState();
			if(null != ptdStartState && !"".equals(ptdStartState)){
				//选择国内时清空国际字段
				if("01".equals(ptdStartState)){
					bean.setPtdStartTown(null);
					bean.setPtdForeign(null);
					bean.setPtdForeigncity(null);
				}
				//选择国际时清空国际字段
				if("02".equals(ptdStartState)){
					bean.setPtdStartCity(null);
					bean.setPtdStartProvince(null);
				}
			}
			//到达国内国际值
			String ptdendstste = bean.getPtdEndState();
			if(null != ptdendstste && !"".equals(ptdendstste)){
				//选择国内时清空国际字段
				if("01".equals(ptdendstste)){
					bean.setPtdEndforeign(null);
					bean.setPtdEndforeigncity(null);
					bean.setPtdEndTown(null);
				}
				//选择国际时清空国内字段
				if("02".equals(ptdendstste)){
					bean.setPtdEndCity(null);
					bean.setPtdEndProvince(null);
				}
			}
			//获取是否经停的值
			String yesno = bean.getPtdYesno();
			if(null != yesno && !"".equals(yesno)){
				//如果选择否，清空所有国内国际的值
				if("01" .equals(yesno)){
					bean.setPtdGuojia(null);
					bean.setPtdProvince(null);
					bean.setPtdCity(null);
					bean.setPtdTown(null);
					bean.setPtdJingforeign(null);
					bean.setPtdJingcity(null);
				}
				//如果选择是，根据是否属于国内和国际清空国内和国际的值
				if("02".equals(yesno)){
					//获取经停国内国际的值
					String Guojia = bean.getPtdGuojia();
					if(null != Guojia && !"".equals(Guojia)){
						//如果选择国内时清空国际值
						if("01".equals(Guojia)){
							bean.setPtdTown(null);
							bean.setPtdJingforeign(null);
							bean.setPtdJingcity(null);
						}else if("02".equals(Guojia)){
							//选择国际时清空国内值
							bean.setPtdProvince(null);
							bean.setPtdCity(null);
						}
					}
				}
			}
			planeticketDao.updatePlaneticket(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * 
	 * @Title: 		  delete
	 * @Description:  删除
	 * @param @param  id 设定文件
	 * @return        int 返回类型
	 * @throws
	 */
	public int delete(Integer id) {
		try{
		planeticketDao.deletePlaneticket(id);
		return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: 		 setCode 
	 * @Description: 放置字典 
	 * @param @param model 设定文件 
	 * @return 		 void  返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//飞机餐
		model.addAttribute("models", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.YOUORWU));
		//舱位
		model.addAttribute("ptdspace", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PTDSPACE));
		//预定方式
		model.addAttribute("scheduled", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
    	//省
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
    	//国家
    	model.addAttribute("country", this.tmSystemCountryService.getSystemCodeByCodeNo(0));
    	//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
    	//航程类型
    	model.addAttribute("ptdtype",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PTDTYPE));
        //单程中转出发国外城市 (港澳台)
 	    model.addAttribute("state", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
 	    //国内国际
 	    model.addAttribute("hbtype", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HBTYPE));
	}

	/**
	 * 
	 * @Title: 		  selectPlaneticket
	 * @Description:  根据主键查询指定的实体
	 * @param @param  id
	 * @param @return 设定文件
	 * @return        返回签证实体对象  PlaneticketDetailBean
	 * @throws
	 */
	public PlaneticketDetailBean selectPlaneticket(int id){
		return	planeticketDao.selectPlaneticket(id);
	}
	/**
	 * 
	 * @Title: 		 update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return       void 返回类型
	 * @throws
	 */
	public Integer update1(ModelMap model, PlaneticketDetailBean bean) {
		try{
			planeticketDao.updatePlaneticket1(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * @Title: 		 deletebean
	 * @Description: 上下架
	 * @param @param id 设定文件
	 * @return 		 int 返回类型  1代表上架，0代表下架
	 * @throws
	 */
	public int deletebean(PlaneticketDetailBean bean) {
		try{
			planeticketDao.deletePlaneticket(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
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
