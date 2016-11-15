package com.erim.sz.ground.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.common.bean.PubSametownBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.ground.dao.GroundDetailDao;
import com.erim.sz.ground.dao.GroundTripDao;
import com.erim.sz.sameTown.dao.PubSametownDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * @ClassName: 	  GroundDetailService
 * @Description:  地接社接口
 * @author        龙龙
 * @date          2015年7月29日 下午4:19:14
 */
@Service("groundService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundDetailService {

	@Autowired
	private GroundDetailDao groundDetailDao;
	@Autowired
	private GroundTripDao groundtripDao;
	@Autowired
	private PubSametownDao pubSametownDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CusSystemCooperationService  cusSystemCooperationService;
	
	/**
	 * @描述: 同业资源列表展示
	 * @创建时间: 2015年11月15日 下午5:07:43
	 * @param model
	 * @param bean
	 */
	public void showGroundTown(ModelMap model,GroundDetailBean bean) {
		
		String date = bean.getGpeDate();
		if (StringUtils.isEmpty(date)) {
			bean.setGpeDate(DateUtil.getCuurentDate());
		}
		
		bean.setCpyId(CommonUtil.getCpyId());
		
		//获取国内国外值
		String gddInternation = bean.getGddInternation();
		//如果选择国内，清空国际的值
		if("1".equals(gddInternation)){
			bean.setGddCountylocation(null);
			bean.setGddMajorcountries(null);
			bean.setGddDeparturecity(null);
		}
		//如果选择国际，清空国内的值
		else if("2".equals(gddInternation)){
			bean.setGddProvice(null);
			bean.setGddCity(null);
			bean.setGddCounty(null);
		}
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_GROUND);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		// 分页查询
		List<GroundDetailBean> groundList = groundDetailDao.selectPageTown(bean,model);
		
		//转码
		for (int i = 0; i < groundList.size(); i++) {
			
			GroundDetailBean detail = groundList.get(i);
			
			//产品主题
			String GddStandards = detail.getGddStandards();
			if (GddStandards != null && !"".equals(GddStandards)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.THEME, GddStandards);
				detail.setGddStandards(str);
			}
			//产品形态
			String gddProduct = detail.getGddProduct();
			if (gddProduct != null && !"".equals(gddProduct)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, gddProduct);
				detail.setGddProduct(str);
			}
			//产品标准
			String gddThemeone = detail.getGddThemeone();
			if (gddThemeone != null && !"".equals(gddThemeone)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARDS, gddThemeone);
				detail.setGddThemeone(str);
			}
			//学生活动
			String game = detail.getGddGame();
			if(game != null && !"".equals(game)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, game);
				detail.setGddGame(str);
			}
		}
		
		// 回传信息
		model.put("groundList", groundList);
		//省市县
		model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
	
	/**
	 * @描述: 当地旅游管理数据列表
	 * @作者: 
	 * @创建时间: 2015年12月13日 上午10:36:53
	 * @param model
	 * @param bean
	 */
	public void showGround(ModelMap model, GroundDetailBean bean) {
		
		bean.setCpyId(CommonUtil.getCpyId());
		
		//获取国内国外值
		String gddInternation = bean.getGddInternation();
		//如果选择国内，清空国际的值
		if("1".equals(gddInternation)){
			bean.setGddCountylocation(null);
			bean.setGddMajorcountries(null);
			bean.setGddDeparturecity(null);
		}
		//如果选择国际，清空国内的值
		else if("2".equals(gddInternation)){
			bean.setGddProvice(null);
			bean.setGddCity(null);
		}
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_GROUND);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		// 分页查询
		List<GroundDetailBean> groundList = groundDetailDao.selectPageGround(bean,model);
		
		//转码
		for (int i = 0; i < groundList.size(); i++) {
			
			GroundDetailBean detail = groundList.get(i);
			
			//列表也显示国际港澳台、国家城市
			String gddCountylocation=detail.getGddCountylocation();
			if(gddCountylocation !=null && !"".equals(gddCountylocation)){
				if ("01".equals(gddCountylocation)) {
					detail.setGddCountylocation("香港");
				}
				if ("02".equals(gddCountylocation)) {
					detail.setGddCountylocation("澳门");
				}
				if ("03".equals(gddCountylocation)) {
					detail.setGddCountylocation("台湾");
				}
			}
			//产品主题
			String GddStandards = detail.getGddStandards();
			if (GddStandards != null && !"".equals(GddStandards)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.THEME, GddStandards);
				detail.setGddStandards(str);
			}
			//产品形态
			String gddProduct = detail.getGddProduct();
			if (gddProduct != null && !"".equals(gddProduct)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, gddProduct);
				detail.setGddProduct(str);
			}
			//产品标准
			String gddThemeone = detail.getGddThemeone();
			if (gddThemeone != null && !"".equals(gddThemeone)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARDS, gddThemeone);
				detail.setGddThemeone(str);
			}
			//学生活动
			String game = detail.getGddGame();
			if(game != null && !"".equals(game)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, game);
				detail.setGddGame(str);
			}
			// 所在城市
			String gddCity = detail.getGddCity();
			if (gddCity != null && !"".equals(gddCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gddCity));
				detail.setGddCity(str);
			}
		}
		
		// 回传信息
		model.put("groundList", groundList);
		//省市县
		model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}

	/**
	 * @描述: 插入
	 * @作者: 
	 * @创建时间: 2015年12月8日 下午3:42:07
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer insert(ModelMap model, GroundDetailBean bean) {
		
		try {
			// 是否上架
			bean.setGddIsDelStatus("0");
			bean.setGddCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			bean.setGddCreateuser(CommonUtil.getLoginName());
			bean.setCpyId(CommonUtil.getCpyId());
			
			// 国内/国际
			String gddInternation = bean.getGddInternation();
			// 当国内时，清空国际相关字段
			if ("1".equals(gddInternation)) {
				bean.setGddCountylocation(null);
				bean.setGddMajorcountries(null);
				bean.setGddDeparturecity(null);
			} else if ("2".equals(gddInternation)) {
				// 当国际时，清空国内相关字段
				bean.setGddCity(null);
				bean.setGddProvice(null);
				bean.setGddCounty(null);
			}
			
			// 判断出发城市是否为国际
			if ("04".equals(bean.getGddCountylocation())) {
				// 清空是否属于周边
				bean.setGddLocalwide(null);
			}
			
			// 获取是否属于学生活动
			String yesno = bean.getGddYesno();
			// 如果不属于学生活动则清空学生活动及学生活动加号文本框的值
			if ("01".equals(yesno)) {
				bean.setGddGame(null);
				bean.setGddAddgame(null);
			} else if("02".equals(yesno)) {
				// 如果属于学生活动则清空产品主题及其其他加号文本框的值
				bean.setGddStandards(null);
				bean.setGddAddstandard(null);
				bean.setGddAddstandards(null);
			}
			
			// 插入数据
			Integer result = groundDetailDao.insertGround(bean);
			
			// 当新增成功，返回ID，更新编码
			if (result == CommonUtil.SUCCESS) {
				// 该条数据ID
				Integer ID = bean.getId(); 
				// 公司ID
				Integer cpyID = bean.getCpyId(); 
				// 获取产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_GROUND, cpyID, ID);
				bean.setGddCode(code);
				// 更新编号
				result = groundDetailDao.updateGroundCode(bean);
			}
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @描述: 保存当地游基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月17日 下午2:53:37
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer insertGround(ModelMap model, GroundDetailBean bean) {
		
		// 是否上架
		bean.setGddIsDelStatus("0");
		bean.setGddCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		bean.setGddCreateuser(CommonUtil.getLoginName());
		bean.setCpyId(CommonUtil.getCpyId());
		// 国内/国际
		String gddInternation = bean.getGddInternation();
		// 当国内时，清空国际相关字段
		if("1".equals(gddInternation)) {
			bean.setGddCountylocation(null);
			bean.setGddMajorcountries(null);
			bean.setGddDeparturecity(null);
		} else if("2".equals(gddInternation)) {
			// 当国际时，清空国内相关字段
			bean.setGddCity(null);
			bean.setGddProvice(null);
			bean.setGddCounty(null);
		}
		// 获取是否属于学生活动
		String yesno = bean.getGddYesno();
		// 如果不属于学生活动则清空学生活动及学生活动加号文本框的值
		if ("01".equals(yesno)) {
			bean.setGddGame(null);
			bean.setGddAddgame(null);
		} else if("02".equals(yesno)) {
			// 如果属于学生活动则清空产品主题及其其他加号文本框的值
			bean.setGddStandards(null);
			bean.setGddAddstandard(null);
			bean.setGddAddstandards(null);
		}
		// 插入数据
		Integer result = groundDetailDao.insertGround(bean);
		// 当新增成功，返回ID，更新编码
		if (result == CommonUtil.SUCCESS) {
			// 该条数据ID
			Integer ID = bean.getId(); 
			// 公司ID
			Integer cpyID = bean.getCpyId(); 
			// 获取产品编号
			String code = CodeUtil.getShopCode(CodeUtil.NTYPE_GROUND, cpyID, ID);
			bean.setGddCode(code);
			// 更新编号
			result = groundDetailDao.updateGroundCode(bean);
		}
		return result;
	}

	/**
	 * @Title: 			selectGroundDetialById
	 * @Description: 	根据ID查询实体
	 * @param @param 	id
	 * @param @return 	设定文件
	 * @return 			TexiDetailBean 返回类型
	 * @throws
	 */
	public void selectGroundDetialById(ModelMap model, GroundDetailBean bean) {
		
		// 执行查询
		GroundDetailBean detail = groundDetailDao.selectGround(bean);
		// 主要景点
		String gddCharacteristic = detail.getGddCharacteristic();
		if (gddCharacteristic != null && !"".equals(gddCharacteristic)) {
			model.addAttribute("atdlCharacteristic", gddCharacteristic.split(","));
		} else {
			model.addAttribute("atdlCharacteristic", new String[]{""});
		}
		//线路玩法
		String gddProductine = detail.getGddProduct();
		if (gddProductine != null && !"".equals(gddProductine)) {
			model.addAttribute("Productine", gddProductine.split(","));
		} else {
			model.addAttribute("Productine", new String[]{""});
		}
		//学生活动
		String gddAddgame = detail.getGddAddgame();
		if (gddAddgame != null && !"".equals(gddAddgame)) {
			model.addAttribute("student", gddAddgame.split(","));
		} else {
			model.addAttribute("student", new String[]{""});
		}
		//产品主题
		String gddAddstandards = detail.getGddAddstandards();
		if (gddAddstandards != null && !"".equals(gddAddstandards)) {
			model.addAttribute("Producttheme", gddAddstandards.split(","));
		} else {
			model.addAttribute("Producttheme", new String[]{""});
		}
		
		model.addAttribute("groundDetail", detail);
	}

	/**
	 * @Title: 			update
	 * @Description: 	修改
	 * @param @param 	model
	 * @param @param 	bean 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model,GroundDetailBean bean) {
		try {
			//插入式获取国内国际的值
			String gddInternation = bean.getGddInternation();
			if("1".equals(gddInternation)) {
				bean.setGddCountylocation(null);
				bean.setGddMajorcountries(null);
				bean.setGddDeparturecity(null);
			} else if("2".equals(gddInternation)) {
				bean.setGddProvice(null);
				bean.setGddCity(null);
				bean.setGddCounty(null);
			}
			// 判断出发城市是否为国际
			if ("04".equals(bean.getGddCountylocation())) {
				// 清空是否属于周边
				bean.setGddLocalwide(null);
			}
			//获取是否属于学生活动
			String yesno = bean.getGddYesno();
			//如果不属于学生活动则清空学生活动及学生活动加号文本框的值
			if("01".equals(yesno)) {
				bean.setGddGame(null);
				bean.setGddAddgame(null);
			} else if("02".equals(yesno)) {
				//如果属于学生活动则清空产品主题及其其他加号文本框的值
				bean.setGddStandards(null);
				bean.setGddAddstandard(null);
				bean.setGddAddstandards(null);
			}
			groundDetailDao.updateGround(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @描述: 行程管理中补充当地游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午3:26:28
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer updatetrip(ModelMap model,GroundDetailBean bean, Integer tdlId) {
		try {
			// 当地游信息ID
			bean.setId(tdlId);
			// 执行修改
			Integer result = groundDetailDao.updateGroundTrip(bean);
			return result;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: 			setCode
	 * @Description: 	放置字典
	 * @param @param 	model 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {

		model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
		//产品涉及
		model.addAttribute("perimeter", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.YESORNO));
		//同城标识
		model.addAttribute("town", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TOWN));
		//产品形态
		model.addAttribute("product", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//产品主题
		model.addAttribute("theme", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.THEME));
		//产品标准
		model.addAttribute("standards", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//交通工具
		model.addAttribute("traffic", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TRAFFIC));
		//行程天数
		model.addAttribute("day", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.DAY));
		//产品标准定位
		model.addAttribute("norm",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.NORM));
		//产品型形态
		model.addAttribute("form",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.FORM));
		//学生活动
		model.addAttribute("game",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
		//预定方式
	    model.addAttribute("scheduled",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
		//省市县
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
        // 同城类型
 		model.addAttribute("sametownntype", ErimConstants.TOWN_GROUND);
	}
	
	/**
	 * @Title: 		  delete
	 * @Description: 上架下架信息
	 * @param @param id 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public int updateStatus(GroundDetailBean bean) {
		try {
			groundDetailDao.deleteGround(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: 		 delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return       void 返回类型
	 * @throws
	 */
	public int deletebean(Integer id) {
		try {
			groundDetailDao.deletegroundbean(id);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
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
	public Integer copyGroundDetail(GroundDetailBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 行程管理
		List<GroundTriplBean> list = new ArrayList<GroundTriplBean>();
		// 当地游信息
		List<PubSametownBean> sameList = new ArrayList<PubSametownBean>();
		// 被复制信息的产品ID
		Integer copyId = bean.getId();
		// 复制当地游基础信息
		result = groundDetailDao.copyGroundDetail(bean);
		if (CommonUtil.SUCCESS.equals(result)) {
			// 该条数据ID
			Integer ID = bean.getId(); 
			// 生成产品编号
			String code = CodeUtil.getShopCode(CodeUtil.NTYPE_GROUND, 0, ID);
			bean.setGddCode(code);
			// 创建时间
			bean.setGddCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			// 默认下架
			bean.setGddIsDelStatus("0");
			// 复制完成后修改部分字段
			result = groundDetailDao.updateCopyGround(bean);
			
			// 根据被复制当地游信息ID获取所有行程管理信息
			list = groundtripDao.getTripByTdlId(copyId);
			if (list != null && list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					GroundTriplBean tripModel = list.get(i);
					tripModel.setTdlId(ID); // 新信息ID
				}
				// 批量插入
				groundtripDao.insertList(list);
			}
			// 根据被复制当地游信息ID获取所有同业信息
			PubSametownBean samebean = new PubSametownBean();
			// 产品ID
			samebean.setId(copyId);
			// 同城类型
			samebean.setNtype(ErimConstants.TOWN_GROUND);
			// 公司ID
			samebean.setCpyidFrom(CommonUtil.getCpyId());
			// 执行查询
			sameList = pubSametownDao.showList(samebean);
			if (sameList != null && sameList.size() != 0) {
				for (int i = 0; i < sameList.size(); i++) {
					PubSametownBean sameModel = sameList.get(i);
					sameModel.setCid(ID); // 新ID
				}
				// 执行插入
				pubSametownDao.insertList(sameList);
			}
		}
		return result;
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
	/**
	 * @Title: 			update
	 * @Description: 	修改
	 * @param @param 	model
	 * @param @param 	bean 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public Integer update1(ModelMap model,GroundDetailBean bean) {
		try {
			//插入式获取国内国际的值
			String gddInternation = bean.getGddInternation();
			if("1".equals(gddInternation)){
				bean.setGddCountylocation(null);
				bean.setGddMajorcountries(null);
				bean.setGddDeparturecity(null);
			}else if("2".equals(gddInternation)){
				bean.setGddProvice(null);
				bean.setGddCity(null);
				bean.setGddCounty(null);
			}
			//获取是否属于学生活动
			String yesno = bean.getGddYesno();
			//如果不属于学生活动则清空学生活动及学生活动加号文本框的值
			if("01".equals(yesno)){
				bean.setGddGame(null);
				bean.setGddAddgame(null);
			}else if("02".equals(yesno))
			//如果属于学生活动则清空产品主题及其其他加号文本框的值
			{
				bean.setGddStandards(null);
				bean.setGddAddstandard(null);
				bean.setGddAddstandards(null);
			}
			//bean.setGddCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			groundDetailDao.updateScheduled(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
}