package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.erim.sz.planeticket.service.PlaneticketTurnService;

/**
 * @ClassName:    PlaneticketTurnController 
 * @Description:  TODO(单程中转航班控制) 
 * @author        贺渊博 
 * @date          2015年10月10日 下午4:21:36 
 */
@Controller
public class PlaneticketTurnController {
	@Autowired
	private PlaneticketTurnService  planeticketTurnService;
	
	
}
