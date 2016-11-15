package com.erim.sz.line.service;

import java.text.SimpleDateFormat;
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
import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.line.dao.LineDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: LineDetailService
 * @描述: 专线接口
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:15:31
 *
 */
@Service("lineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineDetailService {

	@Autowired
	private LineDetailDao         lineDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	

	public void showLine(ModelMap model, LineDetailBean bean) {
		
		   bean.setCpyId(CommonUtil.getCpyId());
		    //获取国内国外值
				String ldlInternation = bean.getLdlInternation();
				//如果选择国内，清空国际的值
				if("1".equals(ldlInternation)){
					bean.setLdlCountylocation(null);
					bean.setLdlMajorcountries(null);
					bean.setLdlDeparturecity(null);
				}
				//如果选择国际，清空国内的值
				else if("2".equals(ldlInternation)){
					bean.setLdlProvince(null);
					bean.setLdlCity(null);
					bean.setLdlCounty(null);
				}
		
		       // 分页查询
				List<LineDetailBean> lineList = lineDao.selectPageLine(bean, model);
				for (int i = 0; i < lineList.size(); i++) {
					LineDetailBean detail = lineList.get(i);
					
					//列表也显示国际港澳台、国家城市
					String ldlCountylocation=detail.getLdlCountylocation();
					if(ldlCountylocation !=null && !"".equals(ldlCountylocation)){
						if ("01".equals(ldlCountylocation)) {
							detail.setLdlCountylocation("香港");
						}
						if ("02".equals(ldlCountylocation)) {
							detail.setLdlCountylocation("澳门");
						}
						if ("03".equals(ldlCountylocation)) {
							detail.setLdlCountylocation("台湾");
						}
					}
					// 大交通
					String ldlBigTraffic = detail.getLdlBigTraffic();
					if (ldlBigTraffic != null && !"".equals(ldlBigTraffic)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.VEHICLE, ldlBigTraffic);
						detail.setLdlBigTraffic(str);
					}
					// 大交通
					String ldlBigTraffic1 = detail.getLdlBigTraffic1();
					if (ldlBigTraffic1 != null && !"".equals(ldlBigTraffic1)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.VEHICLE, ldlBigTraffic1);
						detail.setLdlBigTraffic1(str);
					}
					//产品形态
					String ldlProductForm = detail.getLdlProductForm();
					if (ldlProductForm != null && !"".equals(ldlProductForm)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, ldlProductForm);
						detail.setLdlProductForm(str);
					}
					//产品标准
					String ldlProductStandard = detail.getLdlProductStandard();
					if (ldlProductStandard != null && !"".equals(ldlProductStandard)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARD, ldlProductStandard);
						detail.setLdlProductStandard(str);
					}
					//产品主题
					String ldlProType1 = detail.getLdlProType1();
					if (ldlProType1 != null && !"".equals(ldlProType1)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.THEME, ldlProType1);
						detail.setLdlProType1(str);
					}
					//学生活动
					String ldlGame = detail.getLdlGame();
					if (ldlGame != null && !"".equals(ldlGame)) {
						String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, ldlGame);
						detail.setLdlGame(str);
					}
					
					// 所在城市
					String ldlCity = detail.getLdlCity();
					if (ldlCity != null && !"".equals(ldlCity)) {
						String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ldlCity));
						detail.setLdlCity(str);
					}
				}
		// 回传信息
		model.put("lineList", lineList);
		//省市县
		model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	
		
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer insert(ModelMap model,LineDetailBean bean){
		try{
			bean.setLdlCreatedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			bean.setLdlCreateuser((String)SecurityUtils.getSubject().getSession().getAttribute("userName"));
			//是否上架默认下架0
			bean.setLdlIsDelStatus("0");
			bean.setCpyId((Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId"));
			// 插入数据
			Integer result=lineDao.insertLine(bean);
			 //但新增成功，返回ID，更新编码
			if(result == CommonUtil.SUCCESS){
				Integer ID=bean.getId();
				Integer cpyID=bean.getCpyId();
				//获取产品编码
				String code=CodeUtil.getShopCode(CodeUtil.NTYPE_LINE, cpyID, ID);
				bean.setLdlCode(code);
				//更新编码
				 result= lineDao.Lineupdatecode(bean);
			}
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * 
	 * @Title: insert
	 * @Description: 保存专线基本信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer insertGround(ModelMap model,LineDetailBean bean){
		
			bean.setLdlCreatedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			bean.setLdlCreateuser((String)SecurityUtils.getSubject().getSession().getAttribute("userName"));
			bean.setLdlIsDelStatus("0");
			bean.setCpyId((Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId"));
			// 插入数据
			Integer result=lineDao.insertLine(bean);
			 //但新增成功，返回ID，更新编码
			if(result == CommonUtil.SUCCESS){
				Integer ID=bean.getId();
				Integer cpyID=bean.getCpyId();
				//获取产品编码
				String code=CodeUtil.getShopCode(CodeUtil.NTYPE_LINE, cpyID, ID);
				bean.setLdlCode(code);
				//更新编码
				 result= lineDao.Lineupdatecode(bean);
			}
			return bean.getId();
	}
	/**
	 * @Title: selectLineDetialById 
	 * @Description: 根据ID查询实体 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return LineDetailBean    返回类型 
	 * @throws
	 */
	public void selectLineDetialById(ModelMap model, LineDetailBean bean){
		
		LineDetailBean detail=lineDao.selectLine(bean);
		if(StringUtils.isNotBlank(detail.getLdlAddgame())){
			//添加学生活动逗号分隔成数组
			model.addAttribute("ldladdgame", detail.getLdlAddgame().split(","));
		}
		if(StringUtils.isNotBlank(detail.getLdlAttraction())){
			//主要景点逗号分隔成数组
			model.addAttribute("atdlCharacteristi", detail.getLdlAttraction().split(","));
		}
		//产品主题逗号分隔成数组
		String proType = detail.getLdlProType2();
		if (StringUtils.isNotBlank(proType)) {
			model.addAttribute("ldlProType2", detail.getLdlProType2().split(","));
		} else {
			String[] str = {""};
			model.addAttribute("ldlProType2", str);
		}
		model.addAttribute("lineDetail", detail);
	}
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(ModelMap model, LineDetailBean bean) {
		try{
			lineDao.updateLine(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int delete(Integer id){
		try{
		lineDao.deleteLine(id);
		return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}		
	}
	
	
	/**
	 * @Title: getlineBusiness 
	 * @Description: 可服务专线
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午1:05:39 
	 * @throws
	 */
	public void getlineBusiness(ModelMap model){
		//获取业务范围
		CompanyBusinessBean bussiness = (CompanyBusinessBean)SecurityUtils.getSubject().getSession().getAttribute("userBussiness");
		
		//国内选择专线
		String cbsServiceInside  = bussiness.getCbsServiceInside();
		//国内填写线
		String cbsServiceAdd     = bussiness.getCbsServiceAdd();
		//国际选择线
		String cbsServiceOuter   = bussiness.getCbsServiceOuter();
		//国际自定义线
		String cbsServiceRest    = bussiness.getCbsServiceRest();
		//港澳台
		String cbsSerInterna     = bussiness.getCbsSerInterna();
		//转码-国内选择专线
		String strCbsServiceInside  = this.codeService.getValueByCodeKeys("C116", cbsServiceInside);
		//转码-国际自定义线
		String strcbsServiceOuter   = this.codeService.getValueByCodeKeys("C118", cbsServiceOuter);
		//转码-港澳台自定义线
		String strcbsSerInterna     = this.codeService.getValueByCodeKeys("C108", cbsSerInterna);
		
		String returnStr = "";
		returnStr += StringUtils.isNotBlank(strCbsServiceInside)?strCbsServiceInside+",":"";
		returnStr += StringUtils.isNotBlank(cbsServiceAdd)?cbsServiceAdd+",":"";
		returnStr += StringUtils.isNotBlank(strcbsServiceOuter)?strcbsServiceOuter+",":"";
		returnStr += StringUtils.isNotBlank(cbsServiceRest)?cbsServiceRest+",":"";
		returnStr += StringUtils.isNotBlank(strcbsSerInterna)?strcbsSerInterna+",":"";
		
		if(returnStr.lastIndexOf(",") == returnStr.length()-1 && StringUtils.isNotBlank(returnStr)){
		  returnStr.substring(0, returnStr.length()-1);
		}
		model.addAttribute("myline",returnStr.split(","));
	}
	
		
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		
		this.getlineBusiness(model);
		
    	//车型标准
    	model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
    	//是否属于周边
    	model.addAttribute("yesorno", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.YESORNO));
       //国内外旅游
    	model.addAttribute("abroad",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ABROAD));
    	//主题游
    	model.addAttribute("theme",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.THEME));
    	//可受理群众
    	model.addAttribute("attestor",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTESTOR));
    	//用餐类型
    	model.addAttribute("type",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.Type));
    	//所属专线
    	model.addAttribute("line",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LINE));
    	//产品形态
    	model.addAttribute("product",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
    	//客人构成
    	model.addAttribute("guest",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GUEST));
    	//产品标准
    	model.addAttribute("standard",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARD));
    	//大交通
    	model.addAttribute("vehicle",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLE));
    	//交通工具
    	model.addAttribute("traffic",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TRAFFIC));
    	//主要景区
    	model.addAttribute("attraction",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTION));
    	//同城标识
    	model.addAttribute("samesig",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SAMESIG));
    	//行程天数
    	model.addAttribute("fate",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.FATE));
    	//是否属于学生活动:
    	model.addAttribute("game",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
    	//预定方式
	    model.addAttribute("scheduled",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
    	//省市县
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
    	
	}
	/**
	 * 
	 * @Title: selectLine
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @returnLineDetailBean    返回签证实体对象
	 * @throws
	 */
	public LineDetailBean selectLine(LineDetailBean bean){
		LineDetailBean bean1 = lineDao.selectLine(bean);
        // 是否属于周边旅游
		String ldlPerimeterIs = bean1.getLdlPerimeterIs();
		if (ldlPerimeterIs != null && !"".equals(ldlPerimeterIs)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.YESORNO, ldlPerimeterIs);
			bean1.setLdlPerimeterIs(str);
		}
		// 产品主题
		String ldlProType1 = bean1.getLdlProType1();
		if (ldlProType1 != null && !"".equals(ldlProType1)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.SCENIC, ldlProType1);
			bean1.setLdlProType1(str);
		}
		//产品形态
		String ldlProductForm = bean1.getLdlProductForm();
		if (ldlProductForm != null && !"".equals(ldlProductForm)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, ldlProductForm);
			bean1.setLdlProductForm(str);
		}
		//产品分类
		String ldlAttribute1 = bean1.getLdlAttribute1();
		if (ldlAttribute1 != null && !"".equals(ldlAttribute1)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.ABROAD, ldlAttribute1);
			bean1.setLdlAttribute1(str);
		}
		//所属专线
		String ldlSpecialLine = bean1.getLdlSpecialLine();
		if (ldlSpecialLine != null && !"".equals(ldlSpecialLine)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.LINE, ldlSpecialLine);
			bean1.setLdlSpecialLine(str);
		}
		//大交通
		String ldlBigTraffic = bean1.getLdlBigTraffic();
		if (ldlBigTraffic != null && !"".equals(ldlBigTraffic)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TRAFFIC, ldlBigTraffic);
			bean1.setLdlBigTraffic(str);
		}
		//产品标准
		String ldlProductStandard = bean1.getLdlProductStandard();
		if (ldlProductStandard != null && !"".equals(ldlProductStandard)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARD, ldlProductStandard);
			bean1.setLdlProductStandard(str);
		}
	
		//主要景点
		String ldlAttraction = bean1.getLdlAttraction();
		if (ldlAttraction != null && !"".equals(ldlAttraction)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.ATTRACTION, ldlAttraction);
			bean1.setLdlAttraction(str);
		}
	
		return bean1;
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public int delete(LineDetailBean bean) {
		try{
			lineDao.deletePlaneticket(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}

	
	/**
	 * @描述: 复制功能
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午5:08:39
	 * @param bean
	 * @return
	 */
//	public Integer copyGroundDetail(LineDetailBean bean) {
//		Integer result = CommonUtil.ERROR;
//		
//		// 行程管理
//		List<LineTripBean> list = new ArrayList<LineTripBean>();
//		// 被复制信息的产品ID
//		Integer copyId = bean.getId();
//		// 复制当地游基础信息
//		result = lineDao.copyGroundDetail(bean);
//		if (CommonUtil.SUCCESS.equals(result)) {
//			// 该条数据ID
//			Integer ID = bean.getId(); 
//			// 生成产品编号
//			String code = CodeUtil.getShopCode(CodeUtil.NTYPE_GROUND, 0, ID);
//			bean.setLdlCode(code);
//			// 创建时间
//			bean.setLdlCreatedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//			// 默认下架
//			bean.setLdlIsDelStatus("0");
//			// 复制完成后修改部分字段
//			result = lineDao.updateCopyGround(bean);
//			
//			// 根据被复制当地游信息ID获取所有行程管理信息
//			list = linetripDao.getTripByTdlId(copyId);
//			if (list != null && list.size() != 0) {
//				for (int i = 0; i < list.size(); i++) {
//					LineTripBean tripModel = list.get(i);
//					tripModel.setTdlId(ID); // 新信息ID
//				}
//				// 批量插入
//				linetripDao.insertList(list);
//			}
//		}
//		return result;
//	}
	
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
	/**
	 * 
	 * @描述: 行程管理中补充当地游信息
	 * @作者: （李庆）
	 * @创建时间: 2015年12月1日 下午12:06:30
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer updatetrip(ModelMap model, LineDetailBean bean,Integer tdlId) {
		try{
			//专线信息ID
			bean.setId(tdlId);
			//执行修改
			Integer result = lineDao.updateTrip(bean);
			
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}

	public void insertList(HttpServletRequest request, Integer tdlId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Title: 			update
	 * @Description: 	修改
	 * @param @param 	model
	 * @param @param 	bean 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public Integer update1(ModelMap model,LineDetailBean bean) {
		try {
			
			lineDao.updateLine1(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
}