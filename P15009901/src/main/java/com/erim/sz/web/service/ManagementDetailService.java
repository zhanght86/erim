package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementMaterialBean;
import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.web.dao.ManagementDetailDao;
import com.erim.sz.web.dao.ManagementMaterialDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: ManagementDetailService 
 * @Description: 签证
 * @author maoxian
 * @date 2015年9月15日 下午12:53:44 
 *
 */
@Service("managementService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ManagementDetailService {

	@Autowired
	private ManagementDetailDao managementDao;
	@Autowired
	private ManagementMaterialDao managementMaterialDao;
	@Autowired
	private LineDetailService   lineDetailService;
	@Autowired
	private TicketDetailService ticketDetailService;
	@Autowired
	private CodeService codeService;
	
	
	public void showManagement(ModelMap model,ManagementDetailBean bean, Integer limit) {
		if(bean.getMdlDate() == null || bean.getMdlDate() == ""){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bean.setMdlDate(sdf.format(date));
		}
		// 分页查询
		List<ManagementDetailBean> managementList = managementDao.selectPageManagement(bean, model,limit);
		for(int i =0;i<managementList.size();i++){
			/*字典转码*/
			//签证类型
			ManagementDetailBean detail = managementList.get(i);
			String mdlNtype =detail.getMdlNtype();
			if (!"".equals(mdlNtype) && mdlNtype != null) {
				String Str = codeService.getValueByCodeKeys(DictionaryUtil.NTYPE, mdlNtype);
				detail.setMdlNtype(Str);
			}
			// 入境次数
			String mdlNum = detail.getMdlNum();
			if (mdlNum != null && !"".equals(mdlNum)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.ENTRYNUM, mdlNum);
				detail.setMdlNum(str);
			}
			//送签地
			String mdlSend = detail.getMdlSend();
			if (mdlSend != null&& !"".equals(mdlSend)) {
				String Str = codeService.getValueByCodeKeys(DictionaryUtil.SEND, mdlSend);
				detail.setMdlSend(Str);
		    }
		}
		// 回传信息
		model.put("managementList", managementList);
		
		this.lineDetailService.selectHotLine(model);
		this.ticketDetailService.selectHoteTicket(model);
	}

	/**
	 * 
	 * @Title: selectManagement
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return ManagementDetailBean    返回签证实体对象
	 * @throws
	 */
	public void selectManagement(int id,ModelMap model){
		ManagementDetailBean ManagementBean = managementDao.selectManagement(id);
		/*字典转码*/
		//签证类型
		String mdlNtype =ManagementBean.getMdlNtype();
		if (!"".equals(mdlNtype) && mdlNtype != null) {
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.NTYPE, mdlNtype);
			ManagementBean.setMdlNtype(Str);
		}
		// 入境次数
		String mdlNum = ManagementBean.getMdlNum();
		if (mdlNum != null && !"".equals(mdlNum)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.ENTRYNUM, mdlNum);
			ManagementBean.setMdlNum(str);
		}
		//送签地
		String mdlSend = ManagementBean.getMdlSend();
		if (mdlSend != null&& !"".equals(mdlSend)) {
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.SEND, mdlSend);
			ManagementBean.setMdlSend(Str);
	    }
		//是否面签
		String mdlInterview = ManagementBean.getMdlInterview();
		if (mdlInterview != null&& !"".equals(mdlInterview)) {
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.INTERVIEW, mdlInterview);
			ManagementBean.setMdlInterview(Str);
	    }
		model.addAttribute("managementDetail", ManagementBean);
	}
  /**
   * @描述:  签证材料
   * @作者: （heyuanbo）
   * @创建时间: 2015年11月25日 上午11:25:22
   * @param model
   * @param id
   * @return 返回类型  ManagementDetailBean
   */

  public ManagementDetailBean selectMaterial (ModelMap model,int id){
	  ManagementDetailBean detail = managementDao.selectManagement(id);
	  //送签地
	  String mdlSend = detail.getMdlSend();
	 model.addAttribute("mdlSend", mdlSend.split(","));
	  
	 List<ManagementMaterialBean> l1 = new ArrayList<ManagementMaterialBean>();
	 List<ManagementMaterialBean> l2 = new ArrayList<ManagementMaterialBean>();
	 List<ManagementMaterialBean> l3 = new ArrayList<ManagementMaterialBean>();
	 List<ManagementMaterialBean> l4 = new ArrayList<ManagementMaterialBean>();
	 List<ManagementMaterialBean> l5 = new ArrayList<ManagementMaterialBean>();
	 
	//遍历所有
	List<ManagementMaterialBean> list = this.managementMaterialDao.selectListByMdlId(detail.getId());
	for(ManagementMaterialBean bean : list){
		if("在职".equals(bean.getMmlNtype())) l1.add(bean);
		if("自由职业".equals(bean.getMmlNtype())) l2.add(bean);
		if("在校学生".equals(bean.getMmlNtype())) l3.add(bean);
		if("退休人员".equals(bean.getMmlNtype())) l4.add(bean);
		if("学龄前儿童".equals(bean.getMmlNtype())) l5.add(bean);
	}
	model.addAttribute("mapMaterial1", l1);
	model.addAttribute("mapMaterial2", l2);
	model.addAttribute("mapMaterial3", l3);
	model.addAttribute("mapMaterial4", l4);
	model.addAttribute("mapMaterial5", l5);
	return detail;
}
  
  public void selectManagementPrice(ModelMap model,ManagementPriceBean bean){
	  List<ManagementPriceBean> listBean = this.managementDao.selectManagementPrice(bean);
	  if(listBean != null && listBean.size()>0){
		  model.addAttribute("managementprice", listBean.get(0));
	  }else{
		  model.addAttribute("managementprice", null);
	  }
  }
  /**
   * 根据签证id和材料分类（mmlNtype）查询所有附件名称
   * @描述: 
   * @作者: 吴哲元
   * @创建时间: 2015年12月25日 下午4:46:34
   * @param model
   * @param id
   * @return
   */
  public List<String> selectListByMdlIdAndType (int id,String mmlNtype){
	List<ManagementMaterialBean> materialBeanList = this.managementMaterialDao.selectListByMdlIdAndType(id,mmlNtype);
	List<String> textList = new ArrayList<String>();
	for(ManagementMaterialBean bean : materialBeanList){
		textList.add(bean.getMmlText());
	}
	return textList;
}
  /**
   * 通过id查询签证
   * @描述: 
   * @作者: 吴哲元
   * @创建时间: 2015年12月25日 下午7:30:01
   * @param id
   * @return
   */
  public ManagementDetailBean getManagementDetailBeanById(Integer id){
	  return managementDao.selectManagement(id); 
  }
  
}