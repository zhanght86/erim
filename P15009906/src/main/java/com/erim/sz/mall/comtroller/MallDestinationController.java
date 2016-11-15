package com.erim.sz.mall.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.MallDestinationBean;
import com.erim.sz.mall.service.MallDestinationService;

/**
 * @ClassName: MallDestinationController 
 * @Description: 目的地旅游推荐
 * @author maoxian
 * @date 2015年11月11日 下午7:48:16 
 *
 */
@Controller
public class MallDestinationController {

    @Autowired
    private MallDestinationService mallDestinationService;
    
    /**
     * @Title: show 
     * @Description: 目的地旅游推荐
     * @param @param model
     * @param @param mallDestinationBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/mall/destination/show")
    public String show(ModelMap model,MallDestinationBean mallDestinationBean){
    	this.mallDestinationService.selectAll(mallDestinationBean,model);
    	return "/mall/destination/show";
    }
    
    /**
     * @Title: insert 
     * @Description: 插入
     * @param @param model
     * @param @param bean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @RequestMapping(value = "/mall/destination/insert")
    public @ResponseBody Integer insert(ModelMap model,MallDestinationBean bean){
    	return this.mallDestinationService.insert(bean);
    }
    
    /**
     * @Title: delete 
     * @Description: 删除
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @RequestMapping(value = "/mall/destination/delete")
    public @ResponseBody Integer delete(Integer id){
    	return this.mallDestinationService.delete(id);
    }
}