package com.erim.sz.transticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TransticketDetailNumBean;
import com.erim.sz.transticket.service.TransticketDetailNumService;

/**
 * @ClassName: TransticketDetailNumController 
 * @Description: 火车车次
 * @author maoxian
 * @date 2015年11月9日 上午12:43:47
 */
@Controller
public class TransticketDetailNumController {

	@Autowired
	private TransticketDetailNumService detailNumService;
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/transticket/num/insert")
    public @ResponseBody Integer insert(TransticketDetailNumBean bean){
    	return this.detailNumService.insert(bean);
    }
	
	/**
	 * @Title: delete 
	 * @Description: 删除方法
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/transticket/num/delete")
	public @ResponseBody Integer delete(Integer id){
		return this.detailNumService.delete(id);
	}
	
	/**
	 * @Title: xj 
	 * @Description: 下架
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value=  "/transticket/num/xj")
	public String xj(TransticketDetailNumBean bean){
		this.detailNumService.xj(bean.getId(), bean.getTdlIsDelStatus());
		return "redirect:/transticket/detail/list";
	}
}