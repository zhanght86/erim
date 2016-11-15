package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.erim.sz.planeticket.service.PlaneticketDetailService;
import com.erim.sz.planeticket.service.PlaneticketTransitService;
import com.erim.sz.planeticket.service.PlaneticketTurnService;

/**
 * 
 * @ClassName:    PlaneticketTransitController 
 * @Description:  TODO(往返中转航班控制层) 
 * @author        贺渊博 
 * @date          2015年10月10日 下午5:51:00 
 *
 */
@Controller
public class PlaneticketTransitController {
	
	@Autowired
	private PlaneticketTransitService  planeticketTransitService;
	//调用单程直飞航班
	@Autowired
	private PlaneticketDetailService planeticketDetailService;
	//调用单程中转航班
	@Autowired
	private PlaneticketTurnService  planeticketTurnService;
	
}
