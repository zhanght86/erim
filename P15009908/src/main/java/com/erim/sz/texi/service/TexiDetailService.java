package com.erim.sz.texi.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.texi.dao.TexiCarDao;
import com.erim.sz.texi.dao.TexiDetailDao;
import com.erim.sz.texi.dao.TexiDriveDao;
import com.erim.sz.texi.dao.TexiSendDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName:   TexiDetailService
 * @Description: 租车接口
 * @author 		王赛
 * @date 		2015年10月1日 下午4:06:16
 */
@Service("texiService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiDetailService {
	
	@Autowired
	private TexiDetailDao texiDetailDao;
	@Autowired
	private TexiSendDao texiSendDao;
	@Autowired
	private TexiCarDao texiCarDao;
	@Autowired
	private TexiDriveDao texiDriveDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CusSystemCooperationService cusSystemCooperationService;

	/**
	 * @Title: 		 showTexiTown 
	 * @Description: 同城同业
	 * @param @param model
	 * @param @param bean  设定文件 
	 * @return 		 void  返回类型 
	 * @throws
	 */
	public void showTexiTown(ModelMap model, TexiDetailBean bean) {
		
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		//获取国内国际港澳台的值
		String tdlInland = bean.getTdlInland();
		//如果为国内时清空国际的值
		if("02".equals(tdlInland)){
			bean.setTdlExternal(null);
			bean.setTdlForeign(null);
			bean.setTdlForeignCity(null);
		}
		//如果为国际清空国内的值
		if("01".equals(tdlInland)){
			bean.setTdlProvince(null);
			bean.setTdlCity(null);
			bean.setTdlCounty(null);
		}
		// 分页查询		
		List<TexiDetailBean> texiList = texiDetailDao.selectPageTown(bean, model);
		for (int i = 0; i < texiList.size(); i++) {
			TexiDetailBean detail = texiList.get(i);
			
			// 租车类型
			String applyType = "";
			// 根据租车ID获取是否有固定接送信息
			TexiSendBean sendBean = new TexiSendBean();
			sendBean.setTdlId(detail.getId());
			List<TexiSendBean> list = texiSendDao.selectTexiSendList(sendBean, model);
			if (list != null && list.size() > 0) {
				applyType += "固定接送 ";
			}
			// 根据租车ID获取是否有包车信息
			TexiCarBean carBean = texiCarDao.getTexiCarById(detail.getId());
			if (carBean != null) {
				applyType += "包车 ";
			}
			// 根据租车ID查询是否有自驾信息
			TexiDriveBean driveBean = texiDriveDao.getTextDriveById(detail.getId());
			if (driveBean != null) {
				applyType += "自驾";
			}
			detail.setApplyType(applyType);
			// 车辆档次
			String tdlTexttype = detail.getTdlTexttype();
			if (tdlTexttype != null && !"".equals(tdlTexttype)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				detail.setTdlTexttype(str);
			}
			// 车型
			String tdlType = detail.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				detail.setTdlType(str);
			}
			//可乘人数
			String tdlNum = detail.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				detail.setTdlNum(str);
			}
			//汽车品牌
			String tdlBrand = detail.getTdlBrand();
			if(tdlBrand !=null && !"".equals(tdlBrand)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTBRAND, tdlBrand);
				detail.setTdlBrand(str);
			}
			
			// 所在城市
			String hdlCity = detail.getTdlCity();
			if (hdlCity != null && !"".equals(hdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(hdlCity));
				detail.setTdlCity(str);
			}
		}
		// 回传信息
		model.put("texiList", texiList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TEXI);
	}
	
	/**
	 * @Title: 		 showTexi 
	 * @Description: 分页查询租车 
	 * @param model
	 * @param bean  设定文件 
	 * @return void  返回类型 
	 */
	public void showTexi(ModelMap model, TexiDetailBean bean) {
		
		//获取区域值
		String tdlInland = bean.getTdlInland();
		//当选择国内时，清空国际所在地等字段
		if("02".equals(tdlInland)){
			bean.setTdlExternal(null);
			bean.setTdlForeign(null);
			bean.setTdlForeignCity(null);
		}
		//当选择国外时，清空省市两个字段、清空汽车品牌字段
		else if("01".equals(tdlInland)){
			bean.setTdlProvince(null);
			bean.setTdlCity(null);
			bean.setTdlCounty(null);
			bean.setTdlBrand(null);
		}
      //如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer  cid=cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_TEXI);
			//产品ID
			if(0 != cid) bean.setId(cid);
		}
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		// 分页查询
		List<TexiDetailBean> texiList = texiDetailDao.selectPageTexi(bean, model);
		
		for (int i = 0; i < texiList.size(); i++) {
			TexiDetailBean detail = texiList.get(i);
			// 车辆档次
			String tdlTexttype = detail.getTdlTexttype();
			if (tdlTexttype != null && !"".equals(tdlTexttype)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				detail.setTdlTexttype(str);
			}
			// 车型
			String tdlType = detail.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				detail.setTdlType(str);
			}
			//可乘人数
			String tdlNum = detail.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				detail.setTdlNum(str);
			}
			//汽车品牌
			String tdlBrand = detail.getTdlBrand();
			if(tdlBrand !=null && !"".equals(tdlBrand)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTBRAND, tdlBrand);
				detail.setTdlBrand(str);
			}
			// 所在城市
			String hdlCity = detail.getTdlCity();
			if (hdlCity != null && !"".equals(hdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(hdlCity));
				detail.setTdlCity(str);
			}
			// 国际所在地
			String tdlExternal = detail.getTdlExternal();
			if (tdlExternal != null && !"".equals(tdlExternal)) {
				if ("01".equals(tdlExternal)) {
					detail.setTdlExternal("香港");
				}
				if ("02".equals(tdlExternal)) {
					detail.setTdlExternal("澳门");
				}
				if ("03".equals(tdlExternal)) {
					detail.setTdlExternal("台湾");
				}
			}
			
		}
		// 回传信息
		model.put("texiList", texiList);
		//设置字典
		setCode(model);
	}
	
	/**
	 * 
	 * @方法名: insertTexi
	 * @描述: 车辆信息增加
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月11日 下午3:24:20 
	 * @param model
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertTexi(ModelMap model, TexiDetailBean bean) {
		
		try{
			// 创建时间
			bean.setTdlCreatedate(new Date());
			// 创建用户
			bean.setTdlCreateuser(CommonUtil.getLoginName());
			// 公司ID
			bean.setCpyId(CommonUtil.getCpyId());
			// 默认下架
			bean.setTdlIsDelStatus(ErimConstants.YESORNO_NO);
			//获取国内国际值
			String tdlInland = bean.getTdlInland();
			//如果选择国内清空国际的值
			if("02".equals(tdlInland)){
				bean.setTdlExternal(null);
				bean.setTdlForeign(null);
				bean.setTdlForeignCity(null);
			}
			//当选择国外时，清空省市县三个字段字段
			else if("01".equals(tdlInland)){
				bean.setTdlProvince(null);
				bean.setTdlCity(null);
				bean.setTdlCounty(null);
			}
			// 插入数据
			Integer result = texiDetailDao.insertTexi(bean);
			if (CommonUtil.SUCCESS == result) {
				// 车辆信息ID
				Integer texiID = bean.getId();
				// 编码
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_TEXI, CommonUtil.getCpyId(), bean.getId());
				TexiDetailBean codeBean = new TexiDetailBean();
				codeBean.setId(texiID);
				codeBean.setTdlCode(code);
				// 执行更新
				texiDetailDao.updateCode(codeBean);
			}
			return result;
		}catch(Exception e){
			return CommonUtil.error(TexiDetailService.class, e);
		}
	}
	
	/**
	 * @Title: 		   selectTexiDetialById 
	 * @Description:   根据ID查询实体 
	 * @param @param   id
	 * @param @return  设定文件 
	 * @return 		   TexiDetailBean    返回类型 
	 * @throws
	 */
	public void selectTexiDetialById(ModelMap model,Integer id){
		TexiDetailBean bean1 = texiDetailDao.getTexiDetialById(id);
		// 车辆档次
		String tdlTexttype = bean1.getTdlTexttype();
		if (tdlTexttype != null && !"".equals(tdlTexttype)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
			bean1.setTdlTexttype(str);
		}
		//汽车品牌
		String tdlBrand = bean1.getTdlBrand();
		if(tdlBrand !=null && !"".equals(tdlBrand)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTBRAND, tdlBrand);
			bean1.setTdlBrand(str);
		}
		// 车型
		String tdlType = bean1.getTdlType();
		if (tdlType != null && !"".equals(tdlType)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
			bean1.setTdlType(str);
		}
		//可乘人数
		String tdlNum = bean1.getTdlNum();
		if(tdlNum != null && !"".equals(tdlNum)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
			bean1.setTdlNum(str);
		}
		//手自排
		String tdlTextgear = bean1.getTdlTextgear();
		if(tdlTextgear != null && !"".equals(tdlTextgear)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
			bean1.setTdlTextgear(str);
		}
		//汽车排量
		String tdlTextpail = bean1.getTdlTextpail();
		if(tdlTextpail != null && !"".equals(tdlTextpail)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
			bean1.setTdlTextpail(str);
		}
		model.addAttribute("texiDetail", bean1);
	}
	
	/**
	 * @方法名: getTexiDetialById
	 * @描述: 打开修改页面，获取一条租车信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 上午11:40:18 
	 * @param map
	 * @param bean
	 */
	public void getTexiDetialById(ModelMap map, TexiDetailBean bean) {
		
		// 租车信息ID
		Integer ID = bean.getId();
		TexiDetailBean detail = texiDetailDao.getTexiDetialById(ID);
		map.addAttribute("texiDetail", detail);
	}

	/**
	 * @Title: update
	 * @Description: 修改
	 * @param model
	 * @param bean 设定文件
	 * @return void 返回类型
	 */
	public Integer update(ModelMap model, TexiDetailBean bean) {
		Integer result = CommonUtil.ERROR;
		try{
			//获取国内国际值
			String tdlInland = bean.getTdlInland();
			//如果选择国内清空国际的值
			if("02".equals(tdlInland)){
				bean.setTdlExternal(null);
				bean.setTdlForeign(null);
				bean.setTdlForeignCity(null);
			}
			//当选择国外时，清空省市县三个字段字段
			else if("01".equals(tdlInland)){
				bean.setTdlProvince(null);
				bean.setTdlCity(null);
				bean.setTdlCounty(null);
			}
			// 创建时间
			bean.setTdlCreatedate(new Date());
			result = texiDetailDao.updateTexi(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: 		 setCode
	 * @Description: 查询字典
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model){
		//车型
		model.addAttribute("models",          this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//车型标准
		model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
		//档次
		model.addAttribute("tartlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TARTLEVEL));
		//档次
		model.addAttribute("texitype",        this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		//预定方式
		model.addAttribute("scheduled",        this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
		//汽车档位
		model.addAttribute("texigear",        this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTGEAR));
		//汽车品牌
		model.addAttribute("textbrand",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTBRAND));
		//汽车可乘坐人数
		model.addAttribute("textzuo",         this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.TEXTZUO));
		//汽车排量
		model.addAttribute("displacement",    this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.DISPLACEMENT));
		//省市
		model.addAttribute("provinces",       this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TEXI);
    	//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}

	/**
	 * @Title: 		 delete
	 * @Description: 上下架
	 * @param @param id 设定文件
	 * @return 		 int 返回类型  1代表上架，0代表下架
	 * @throws
	 */
	public int delete(TexiDetailBean bean) {
		try{
			texiDetailDao.deleteTexi(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @描述: 修改预定方式
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午3:51:45
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer update1(ModelMap model, TexiDetailBean bean) {
		Integer result = CommonUtil.ERROR;
		try{
			// 创建时间
			bean.setTdlCreatedate(new Date());
			result = texiDetailDao.updateScheduled(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: 		  selectTexi
	 * @Description:  根据主键查询指定的实体
	 * @param @param  id
	 * @param @return 设定文件
	 * @returnLine    DetailBean  返回签证实体对象
	 * @throws
	 */
	public TexiDetailBean selectTexi(int id,ModelMap model ){
		TexiDetailBean bean = texiDetailDao.getTexiDetialById(id);
		return bean;
	}
	
	/**
	 * @Title: 		 delete 
	 * @Description: 删除
	 * @param @param id  设定文件 
	 * @return 		 int 返回类型 
	 * @throws
	 */
	public int delete(Integer id) {
		try{
			texiDetailDao.deleteTexi(id);
			return CommonUtil.SUCCESS;
		} catch(Exception e) {
			return CommonUtil.error(getClass(), e);
		}		
	}
	
	/**
	 * @描述: 这是谁写的啊？ 连个注释都没有
	 * @作者: 
	 * @创建时间: 2015年12月8日 下午2:00:32
	 * @param map
	 * @return
	 */
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