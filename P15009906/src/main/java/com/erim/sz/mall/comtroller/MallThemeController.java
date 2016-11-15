package com.erim.sz.mall.comtroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.MallThemeBean;
import com.erim.sz.common.bean.MallThemeTypeBean;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.mall.service.MallThemeService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: MallThemeController 
 * @Description: 主题推荐
 * @author maoxian
 * @date 2015年11月12日 上午11:45:33 
 * 
 */
 /**
  * 
  * @类名: MallThemeController
  * @描述: 追加逻辑：主题类型做活
  * @作者: 国亚文
  * @创建时间: 2015年12月25日 下午6:15:35
  */
@Controller
public class MallThemeController {

	@Autowired
	private MallThemeService  mallThemeService;
	@Autowired
    private LineDetailService lineDetailService;
	@Autowired
	private CodeService       codeService;
   
   /**
    * @Title: show 
    * @Description: 主题与专线关联信息
    * @param @param bean
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/theme/show")
   public String show(@ModelAttribute("malltheme") MallThemeBean bean,
		   @ModelAttribute("mallthemetype") MallThemeTypeBean beantype,
		   ModelMap model){
	   
	   //1.看传值中是否有“类型”变动,有变更，增修改数据
	   if(!StringUtils.isBlank(beantype.getInsertOrDelete())){
		   if ("0".equals(beantype.getInsertOrDelete()))
		   {
			   mallThemeService.deleteThemeType(beantype); 
		   }
		   else
		   {
			   mallThemeService.insertThemeType(beantype);  
			   
		   }
		   
	   }
	   	   
	   //获取字典主题类别列表
	   List<CodeBean> codeList1=this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.THEME);
	   model.addAttribute("codeList1",codeList1);
	   List<CodeBean> codeList2=this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.GAME);
	   model.addAttribute("codeList2",codeList2);
	   
	   //然后获取本商城定义的主题类别列表
	   MallThemeTypeBean qTypeBean=new MallThemeTypeBean();
	   List<MallThemeTypeBean> typelist=this.mallThemeService.listThemeType(qTypeBean, model);
	   model.addAttribute("listThemeType", typelist);	   
	   
	   //如果参数为空，则取第一个类别
	   if(StringUtils.isBlank(bean.getMteNtype())){
		   
		  if (!typelist.isEmpty()) 
		   bean.setMteNtype(typelist.get(0).getTheme_type_id());
	   }
	   //专线
	   this.lineDetailService.selectAllListIsCooper(model,bean.getMteNtype());
	   //model.addAttribute("listtline", this.lineDetailService.selectListByBean(new LineDetailBean()));
	   
	   this.mallThemeService.listTheme(bean, model);
	   return "/mall/theme/show";
   }
   
   
   /**
    * @Title: ajaxInsert 
    * @Description: 插入
    * @param @param lineBean    设定文件 
    * @return void    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/theme/insert")
   public @ResponseBody Integer ajaxInsert(HttpServletRequest request){
	  return this.mallThemeService.insert(request);
   }
   
}