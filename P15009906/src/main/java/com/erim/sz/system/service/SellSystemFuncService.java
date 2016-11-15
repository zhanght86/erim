package com.erim.sz.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.SellSystemFuncBean;
import com.erim.sz.system.bean.SellSystemFuncRescourceBean;
import com.erim.sz.system.dao.SellSystemFuncDao;

/**
 * @ClassName: SellSystemFuncService 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:17:50
 */
@Service("sellSystemFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemFuncService {

	@Autowired
	private SellSystemFuncDao sellSystemFuncDao;
	@Autowired
	private SellSystemFuncRescourceService sellSystemFuncRescourceService;
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有菜单
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncBean> selectAll(){
		return this.sellSystemFuncDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code值获取权限列表
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncBean> selectFuncByCode(String[] code){
		return this.sellSystemFuncDao.selectFuncByCode(code);
	}
	
	/**
	 * 
	 * @Title: selectFuncList 
	 * @Description: 获取权限列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public void selectFuncList(ModelMap model){
		//所有功能列表
		List<SellSystemFuncRescourceBean> listSellSystemFuncRescourceBean = this.sellSystemFuncRescourceService.selectAll();
		
		//查询所有权限
		List<SellSystemFuncBean> listAllFunc = this.selectAll();
		//返回func
		List<SellSystemFuncBean> listParentFunc = new ArrayList<SellSystemFuncBean>();
		
		//遍历所有权限
		for(SellSystemFuncBean allFunc : listAllFunc){
			String parentcode = allFunc.getSellFuncParentcode();
			if("0".equals(parentcode)){
				listParentFunc.add(allFunc);
			}
		}
		
		for(SellSystemFuncBean parentFunc : listParentFunc){
			//子级个数
			int childSize = 1;
			//子集集合
			List<SellSystemFuncBean> listChildFunc = new ArrayList<SellSystemFuncBean>();
			for(SellSystemFuncBean allFunc : listAllFunc){
				//判断是否是子集
				if(parentFunc.getSellFuncCode().equals(allFunc.getSellFuncParentcode())){
					//子功能列表
					List<SellSystemFuncRescourceBean> childRescource = new ArrayList<SellSystemFuncRescourceBean>();
					//遍历功能列表
					for(SellSystemFuncRescourceBean rescource : listSellSystemFuncRescourceBean){
						if(rescource.getSellFuncCode().equals(allFunc.getSellFuncCode())){
							childRescource.add(rescource);
						}
					}
					
					allFunc.setChildListSellSystemFuncRescourceBean(childRescource);
					listChildFunc.add(allFunc);
					parentFunc.setChildSize(childSize++);
				}
			}
			parentFunc.setChildListSellSystemFuncBean(listChildFunc);
		}
		model.addAttribute("listFunc",listParentFunc);
	}
}