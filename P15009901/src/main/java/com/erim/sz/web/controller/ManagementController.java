package com.erim.sz.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.web.service.ManagementDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.sz.web.util.ZipUtils;
import com.erim.utils.properties.PropertiesUtils;
import com.erim.web.service.CodeService;

/**
 * @ClassName: ManagementController 
 * @Description: 签证
 * @author maoxian
 * @date 2015年10月29日 下午4:28:53
 */
@Controller
public class ManagementController {
	
	@Autowired
	private ManagementDetailService managementDetailService;
	@Autowired
	private CodeService		   	    codeService;
	/**
	 * @Title: qianzhengxiang 
	 * @Description: 详细签证
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
//	@RequestMapping(value = "/{cpyno}/management/qianzhengxiang/{id}/{mdlDate}")
//	public String qianzhengxiang1(ModelMap model,@PathVariable("id") Integer id,@PathVariable("mdlDate") String mdlDate) {
//		this.managementDetailService.selectManagement(id,model);
//		this.managementDetailService.selectMaterial(model, id);
//		ManagementPriceBean bean = new ManagementPriceBean();
//		bean.setMdlId(id);
//		bean.setMdlDate(mdlDate);
//		this.managementDetailService.selectManagementPrice(model, bean);
//		return "/management/qianzhengxiang";
//	}
	@RequestMapping(value = "/{cpyno}/management/qianzhengxiang/{id}")
	public String qianzhengxiang(ModelMap model,@PathVariable("id") Integer id, String mdlDate) {
		this.managementDetailService.selectManagement(id,model);
		this.managementDetailService.selectMaterial(model, id);
		ManagementPriceBean bean = new ManagementPriceBean();
		bean.setMdlId(id);
		if(StringUtils.isEmpty(mdlDate)){
			bean.setMdlDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));	
		}else{
			bean.setMdlDate(mdlDate);
		}
		
		this.managementDetailService.selectManagementPrice(model, bean);
		return "/management/qianzhengxiang";
	}
	
	/**
	 * @Title: qianzhengxiang 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/management/qianzheng")
	public String qianzhengxiang(ModelMap model,@ModelAttribute("manament")ManagementDetailBean bean) {
		
		this.managementDetailService.showManagement(model, bean, 10);
		//列表页查询项
		model.addAttribute("country",      this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.COUNTRY));
		//是否面签
		model.addAttribute("models",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.INTERVIEW));
		//签证类型
		model.addAttribute("ntype",        this.codeService.getSystemCodeByCodeNo(DictionaryUtil.NTYPE));
		//送签地
		model.addAttribute("send",         this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEND));
		return "/management/qianzheng";
	}
	/**
	 * 签证材料下载
	 * @描述: 
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 下午7:35:37
	 * @param request
	 * @param response
	 * @param id 签证id
	 * @param mmlNtype 签证材料类型
	 * @throws Exception
	 */
	@RequestMapping("/{cpyno}/management/qianzheng/download/{id}")
    public void download(HttpServletRequest request,
            HttpServletResponse response,@PathVariable("id") Integer id,String mmlNtype) throws Exception {
		//ManagementDetailBean detailBean = managementDetailService.getManagementDetailBeanById(id);
		String mmlNtypeS = "";
		if(StringUtils.isNotEmpty(mmlNtype)){
			if(mmlNtype.equals("1")){
				mmlNtypeS = "在职";
			}else if(mmlNtype.equals("2")){
				mmlNtypeS = "自由职业";
			}else if(mmlNtype.equals("3")){
				mmlNtypeS = "在校学生";
			}else if(mmlNtype.equals("4")){
				mmlNtypeS = "退休人员"; 
			}else if(mmlNtype.equals("5")){
				mmlNtypeS = "学龄前儿童";
			}
		}
		//String downloadName = detailBean.getMdlAddress()+detailBean.getMdlSend()+mmlNtypeS;
		//String ss = request.getSession().getServletContext().getRealPath("/")+"static/images/001.jpg";
		List<String> textList = managementDetailService.selectListByMdlIdAndType(id, mmlNtypeS);
//		String rootPath = PropertiesUtils.getPropertyByKey("app.staticFileRes");
//		List<File> files = new ArrayList<File>();
//		for(String mmlText : textList){
//			files.add(new File(rootPath + mmlText));
//		}
		ZipUtils.downLoadFiles(textList,mmlNtypeS, request, response);
	}
	
}