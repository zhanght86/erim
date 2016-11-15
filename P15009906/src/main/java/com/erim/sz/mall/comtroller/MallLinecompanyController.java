package com.erim.sz.mall.comtroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.MallLinecompanyBean;
import com.erim.sz.mall.service.MallLinecompanyService;

/**
 * 
 * @ClassName: MallLinecompanyController 
 * @Description: 合作用户
 * @author maoxian
 * @date 2015年11月11日 下午11:56:39 
 *
 */
@Controller
public class MallLinecompanyController {

   @Autowired
   private MallLinecompanyService mallLinecompanyService;
   
   /**
    * @Title: ajaxInsert 
    * @Description: 插入
    * @param @param lineBean    设定文件 
    * @return void    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/linecompany/insert")
   public @ResponseBody Integer ajaxInsert(MallLinecompanyBean lineBean){
	  return this.mallLinecompanyService.insert(lineBean);
   }
   
   
   /**
    * @Title: ajaxDelete 
    * @Description:根据id删除
    * @param @param id
    * @param @return    设定文件 
    * @return Integer    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/linecompany/delete")
   public @ResponseBody Integer ajaxDelete(MallLinecompanyBean lineBean){
	   return this.mallLinecompanyService.delete(lineBean);
   }
   
   
   /**
    * @Title: ajaxDelete 
    * @Description:根据id删除
    * @param @param id
    * @param @return    设定文件 
    * @return Integer    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/linecompany/deleteAll")
   public @ResponseBody Integer ajaxDeleteAll(MallLinecompanyBean lineBean){
	   return this.mallLinecompanyService.deletecpy(lineBean);
   }
    
   /**
    * @Title: ajaxInsertAll 
    * @Description: 批量插入
    * @param @param lineBean
    * @param @param request
    * @param @return    设定文件 
    * @return Integer    返回类型 
    * @throws
    */
   @RequestMapping(value = "/mall/linecompany/insertAll")
   public @ResponseBody Integer ajaxInsertAll(HttpServletRequest request){
	   return this.mallLinecompanyService.insertAll(request);
   }
   
   
   @RequestMapping(value = "/mall/linecompany/insertAll_2")
   public @ResponseBody Integer ajaxInsertAll_2(HttpServletRequest request){
	   return this.mallLinecompanyService.insertAll_2(request);
   }
}