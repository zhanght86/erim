package com.erim.sz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommpanyController {


	@RequestMapping(value = "/{cpyno}/commpany/abouts")
	public String abouts(ModelMap model,String searchModel) {
		model.put("searchModel", searchModel);
		return "/commpany/abouts";
	}
}