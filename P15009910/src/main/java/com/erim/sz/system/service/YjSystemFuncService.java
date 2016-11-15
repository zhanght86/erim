package com.erim.sz.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.YjSystemFuncBean;
import com.erim.sz.system.bean.YjSystemFuncRescourceBean;
import com.erim.sz.system.dao.YjSystemFuncDao;

/**
 * @ClassName: YjSystemFuncService 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:17:50
 */
@Service("yjSystemFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class YjSystemFuncService {

	@Autowired
	private YjSystemFuncDao yjSystemFuncDao;
	@Autowired
	private YjSystemFuncRescourceService yjSystemFuncRescourceService;
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有菜单
	 * @param @return    设定文件 
	 * @return List<YjSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<YjSystemFuncBean> selectAll(){
		return this.yjSystemFuncDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code值获取权限列表
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<YjSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<YjSystemFuncBean> selectFuncByCode(String[] code){
		return this.yjSystemFuncDao.selectFuncByCode(code);
	}
	
	/**
	 * 
	 * @Title: selectFuncList 
	 * @Description: 获取权限列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<YjSystemFuncBean>    返回类型 
	 * @throws
	 */
	public void selectFuncList(ModelMap model){
		//所有功能列表
		List<YjSystemFuncRescourceBean> listYjSystemFuncRescourceBean = this.yjSystemFuncRescourceService.selectAll();
		
		//查询所有权限
		List<YjSystemFuncBean> listAllFunc = this.selectAll();
		//返回func
		List<YjSystemFuncBean> listParentFunc = new ArrayList<YjSystemFuncBean>();
		
		//遍历所有权限
		for(YjSystemFuncBean allFunc : listAllFunc){
			String parentcode = allFunc.getYjFuncParentcode();
			if("0".equals(parentcode)){
				listParentFunc.add(allFunc);
			}
		}
		
		for(YjSystemFuncBean parentFunc : listParentFunc){
			//子级个数
			int childSize = 1;
			//子集集合
			List<YjSystemFuncBean> listChildFunc = new ArrayList<YjSystemFuncBean>();
			for(YjSystemFuncBean allFunc : listAllFunc){
				//判断是否是子集
				if(parentFunc.getYjFuncCode().equals(allFunc.getYjFuncParentcode())){
					//子功能列表
					List<YjSystemFuncRescourceBean> childRescource = new ArrayList<YjSystemFuncRescourceBean>();
					//遍历功能列表
					for(YjSystemFuncRescourceBean rescource : listYjSystemFuncRescourceBean){
						if(rescource.getYjFuncCode().equals(allFunc.getYjFuncCode())){
							childRescource.add(rescource);
						}
					}
					
					allFunc.setChildListYjSystemFuncRescourceBean(childRescource);
					listChildFunc.add(allFunc);
					parentFunc.setChildSize(childSize++);
				}
			}
			parentFunc.setChildListYjSystemFuncBean(listChildFunc);
		}
		model.addAttribute("listFunc",listParentFunc);
	}
}