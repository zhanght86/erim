package com.erim.sz.mall.comtroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.MallHotBean;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.mall.service.MallHotService;

/**
 * 
 * @ClassName: MallHotController 
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月12日 上午2:20:15 
 *
 */
@Controller
public class MallHotController {

   @Autowired
   private MallHotService    mallHotService;
   @Autowired
   private LineDetailService lineDetailService;
   
   
   /**
    * @Title: show 
    * @Description: 热门精选
    * @param @param bean
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/hot/show")
   public String show(@ModelAttribute("mallhot") MallHotBean bean,ModelMap model){
	   //model.addAttribute("listhot", this.lineDetailService.selectListByBean(new LineDetailBean()));
	   //如果为空默认周边旅游
	   if(StringUtils.isBlank(bean.getMhtNtype())){
		   bean.setMhtNtype("1");
	   }
	   
	   LineDetailBean lineBean=new LineDetailBean();
	   lineBean.setMhtNtype(bean.getMhtNtype());
	   String tes=lineBean.getMhtNtype();
	   lineBean.setListNation(new ArrayList<String>());
	   List<String> sl=lineBean.getListNation();
	   
	   if (bean.getMhtNtype().equals("1"))
	   {
		   lineBean.setLdlPerimeterIs("02"); //02 周边 01 非周边
		   
	   }
	   else
	   {
		   lineBean.setLdlPerimeterIs("01");  
		   if (bean.getMhtNtype().equals("2"))//guonei
		   {
			      //sql 查询时 排除下列名单
			      sl.add("港");
				  sl.add("澳");
				  sl.add("台");
				  sl.add("日本");
				  sl.add("韩国");
				  sl.add("朝鲜");
				  sl.add("日韩");
				  sl.add("南亚");
				  sl.add("俄罗斯");
				  sl.add("欧");
				  sl.add("欧美");
				  sl.add("美洲");
				  sl.add("中东");
				  sl.add("非洲");
				  sl.add("泰国");
			   
		   }
		   else if (bean.getMhtNtype().equals("3"))//港澳台/日韩朝/东南亚
		   {
			   //sql 查询时 包含下列名单
			   sl.add("港澳台");
			   sl.add("日本");
			   sl.add("韩国");
			   sl.add("朝鲜");
			   sl.add("日韩");
			   sl.add("南亚");
			   sl.add("泰国");
			   sl.add("香港");
			   sl.add("澳门");
			   sl.add("台湾");
			  
			  
		   }
		   else if (bean.getMhtNtype().equals("4"))//俄罗斯/欧洲/美洲
		   {
			 //sql 查询时 包含下列名单
			  sl.add("俄罗斯");
			  sl.add("欧");
			  sl.add("欧美");
			  sl.add("美洲"); 
		   }
		   else if (bean.getMhtNtype().equals("5"))//澳洲/中东/非洲
		   {
			 //sql 查询时 包含下列名单
			  sl.add("澳洲");
			  sl.add("中东");
			  sl.add("非洲"); 
			  sl.add("澳新"); 
		   }		   
	   }
	   
	   System.out.print("测试："+lineBean.getMhtNtype());
	   
	   //设置专线
	   this.lineDetailService.selectAllListIsCooperAndNation(model,lineBean);
	   //如果为空默认周边旅游
	   if(StringUtils.isBlank(bean.getMhtNtype())){
		   bean.setMhtNtype("1");
	   }
	   this.mallHotService.listHot(bean, model);
	   return "/mall/hot/show";
   }
   
   /**
    * @Title: ajaxInsert 
    * @Description: 插入
    * @param @param lineBean    设定文件 
    * @return void    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/hot/insert")
   public @ResponseBody Integer ajaxInsert(HttpServletRequest request){
	  return this.mallHotService.insert(request);
   }
   
}