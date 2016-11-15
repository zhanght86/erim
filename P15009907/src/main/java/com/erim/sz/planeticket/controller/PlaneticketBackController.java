 package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.erim.sz.planeticket.service.PlaneticketBackService;
import com.erim.sz.planeticket.service.PlaneticketDetailService;
import com.erim.sz.planeticket.service.PlaneticketTurnService;

/**
 * 
 * @ClassName:     PlaneticketBackController 
 * @Description:   TODO(往返直飞航班) 
 * @author         贺渊博 
 * @date           2015年10月10日 下午4:40:57 
 *
 */
@Controller
public class PlaneticketBackController {
	
	@Autowired
	private PlaneticketBackService  planeticketBackService;
    //调用单程直飞航班
	@Autowired
	private PlaneticketDetailService planeticketDetailService;
	//调用单程中转航班
	@Autowired
	private PlaneticketTurnService  planeticketTurnService;
}
