package com.erim.sz.guide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GuideScheduleBean;
import com.erim.sz.guide.service.GuideScheduleService;

/***
 * 
* @ClassName: GuideScheduleController 
* @Description: 导游档期详细控制
* @author 龙龙
* @date 2015年7月30日 下午5:27:14 
*
 */
@Controller
public class GuideScheduleController {

    @Autowired
    private GuideScheduleService guideScheduleService;

    /**
     * 
     * @Description: 导游档期列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/guide/schedule/list")
    public String showList(ModelMap model, @ModelAttribute("guideSchedule") GuideScheduleBean guideScheduleBean) throws ErimException {
    	this.guideScheduleService.showGuide(model, guideScheduleBean);
        return "/guide/schedule/list";
    }

    

}