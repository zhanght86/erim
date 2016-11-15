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

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.web.dao.TexiDetailDao;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: TexiDetailService 
 * @Description: 租车接口
 * @author maoxian
 * @date 2015年9月12日 下午5:35:21 
 *
 */
@Service("texiService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiDetailService {

	@Autowired
	private TexiDetailDao texiDao;
	@Autowired
	private LineDetailService   lineDetailService;
	@Autowired
	private TicketDetailService ticketDetailService;
	@Autowired
	private CodeService           codeService;
	/**
	 * @Title: selectTexiDetialById
	 * @Description: 根据ID查询实体
	 * @param @param id
	 * @param @return 设定文件
	 * @return TexiDetailBean 返回类型
	 * @throws
	 */
	public void selectTexiDetialById(ModelMap model, Integer id) {
		TexiDetailBean detail = texiDao.selectTexi(id);
		/*字典转码*/
		//车型
		String tdlType = detail.getTdlType();
		if (tdlType != null && !"".equals(tdlType)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
			detail.setTdlType(str);
		}
		//乘坐人数
		String tdlNum = detail.getTdlNum();
		if(tdlNum != null && !"".equals(tdlNum)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
			detail.setTdlNum(str);
		}
		//汽车排量
		String tdlTextpail = detail.getTdlTextpail();
		if(tdlTextpail != null && !"".equals(tdlTextpail)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
			detail.setTdlTextpail(str);
		}
		//汽车手自排
		String tdlTextgear = detail.getTdlTextgear();
		if(tdlTextgear != null && !"".equals(tdlTextgear)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
			detail.setTdlTextgear(str);
		}
		//车辆档次
		String tdlTexttype = detail.getTdlTexttype();
		if(tdlTexttype != null && !"".equals(tdlTexttype)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
			detail.setTdlTexttype(str);
		}
		model.addAttribute("texiDetail", detail);
		
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);

	}
	/**
	 * @Title: showTexi 
	 * @Description: 分页查询租车 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showTexi(ModelMap model, TexiDetailBean bean,Integer limit) {
		
		// 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTexi(bean, model,limit);
		/*字典转码*/
        for(int i = 0;i < texiList.size();i++){
        	TexiDetailBean TexiBean = texiList.get(i);
        	//车型
        	String tdlType = TexiBean.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				TexiBean.setTdlType(str);
			} 
			//载客数
			String tdlNum = TexiBean.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				TexiBean.setTdlNum(str);
			}
			//车辆档次
			String tdlTexttype = TexiBean.getTdlTexttype();
			if(tdlTexttype != null && !"".equals(tdlTexttype)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				TexiBean.setTdlTexttype(str);
			}
			//汽车排量
			String tdlTextpail = TexiBean.getTdlTextpail();
			if(tdlTextpail != null && !"".equals(tdlTextpail)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
				TexiBean.setTdlTextpail(str);
			}
			//汽车手自排
			String tdlTextgear = TexiBean.getTdlTextgear();
			if(tdlTextgear != null && !"".equals(tdlTextgear)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
				TexiBean.setTdlTextgear(str);
			}
        }
        // 回传信息
		model.put("texiList", texiList);
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);
	}
	
	/**
	 * @Title: showTexiSend 
	 * @Description: 分页查询租车 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showTexiSend(ModelMap model, TexiDetailBean bean,Integer limit) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			bean.setTspDate(DateUtil.getCuurentDate());
		}
		if(StringUtils.isEmpty(bean.getSendType())){
			bean.setSendType("01");
		}
		// 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTexiSend1(bean, model,limit);
		/*字典转码*/
        for(int i = 0;i < texiList.size();i++){
        	TexiDetailBean TexiBean = texiList.get(i);
        	//车型
        	String tdlType = TexiBean.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				TexiBean.setTdlType(str);
			} 
			//载客数
			String tdlNum = TexiBean.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				TexiBean.setTdlNum(str);
			}
			//车辆档次
			String tdlTexttype = TexiBean.getTdlTexttype();
			if(tdlTexttype != null && !"".equals(tdlTexttype)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				TexiBean.setTdlTexttype(str);
			}
			//汽车排量
			String tdlTextpail = TexiBean.getTdlTextpail();
			if(tdlTextpail != null && !"".equals(tdlTextpail)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
				TexiBean.setTdlTextpail(str);
			}
			//汽车手自排
			String tdlTextgear = TexiBean.getTdlTextgear();
			if(tdlTextgear != null && !"".equals(tdlTextgear)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
				TexiBean.setTdlTextgear(str);
			}
        }
        // 回传信息
		model.put("texiList", texiList);
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);
	}
	
	/**
	 * @Title: showTexiCar 
	 * @Description: 分页查询租车 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showTexiCar(ModelMap model, TexiDetailBean bean,Integer limit) {
		// 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTexiCar1(bean, model,limit);
		/*字典转码*/
        for(int i = 0;i < texiList.size();i++){
        	TexiDetailBean TexiBean = texiList.get(i);
        	//车型
        	String tdlType = TexiBean.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				TexiBean.setTdlType(str);
			} 
			//载客数
			String tdlNum = TexiBean.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				TexiBean.setTdlNum(str);
			}
			//车辆档次
			String tdlTexttype = TexiBean.getTdlTexttype();
			if(tdlTexttype != null && !"".equals(tdlTexttype)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				TexiBean.setTdlTexttype(str);
			}
			//汽车排量
			String tdlTextpail = TexiBean.getTdlTextpail();
			if(tdlTextpail != null && !"".equals(tdlTextpail)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
				TexiBean.setTdlTextpail(str);
			}
			//汽车手自排
			String tdlTextgear = TexiBean.getTdlTextgear();
			if(tdlTextgear != null && !"".equals(tdlTextgear)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
				TexiBean.setTdlTextgear(str);
			}
        }
        // 回传信息
		model.put("texiList", texiList);
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);
	}
	

	/**
	 * @Title: showTexiDrive 
	 * @Description: 分页查询租车 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showTexiDrive(ModelMap model, TexiDetailBean bean,Integer limit) {
		// 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTexiDrive1(bean, model,limit);
		/*字典转码*/
        for(int i = 0;i < texiList.size();i++){
        	TexiDetailBean TexiBean = texiList.get(i);
        	//车型
        	String tdlType = TexiBean.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				TexiBean.setTdlType(str);
			} 
			//载客数
			String tdlNum = TexiBean.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				TexiBean.setTdlNum(str);
			}
			//车辆档次
			String tdlTexttype = TexiBean.getTdlTexttype();
			if(tdlTexttype != null && !"".equals(tdlTexttype)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				TexiBean.setTdlTexttype(str);
			}
			//汽车排量
			String tdlTextpail = TexiBean.getTdlTextpail();
			if(tdlTextpail != null && !"".equals(tdlTextpail)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.DISPLACEMENT, tdlTextpail);
				TexiBean.setTdlTextpail(str);
			}
			//汽车手自排
			String tdlTextgear = TexiBean.getTdlTextgear();
			if(tdlTextgear != null && !"".equals(tdlTextgear)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTGEAR, tdlTextgear);
				TexiBean.setTdlTextgear(str);
			}
        }
        // 回传信息
		model.put("texiList", texiList);
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);
	}
}