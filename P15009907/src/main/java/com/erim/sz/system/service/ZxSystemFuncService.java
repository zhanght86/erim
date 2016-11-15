package com.erim.sz.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.ZxSystemFuncBean;
import com.erim.sz.system.bean.ZxSystemFuncRescourceBean;
import com.erim.sz.system.dao.ZxSystemFuncDao;

/**
 * @ClassName: ZxSystemFuncService 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:17:50
 */
@Service("zxSystemFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemFuncService {

	@Autowired
	private ZxSystemFuncDao zxSystemFuncDao;
	@Autowired
	private ZxSystemFuncRescourceService zxSystemFuncRescourceService;
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有菜单
	 * @param @return    设定文件 
	 * @return List<ZxSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemFuncBean> selectAll(){
		return this.zxSystemFuncDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code值获取权限列表
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<ZxSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemFuncBean> selectFuncByCode(String[] code){
		return this.zxSystemFuncDao.selectFuncByCode(code);
	}
	
	/**
	 * 
	 * @Title: selectFuncList 
	 * @Description: 获取权限列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZxSystemFuncBean>    返回类型 
	 * @throws
	 */
	public void selectFuncList(ModelMap model){
		//所有功能列表
		List<ZxSystemFuncRescourceBean> listZxSystemFuncRescourceBean = this.zxSystemFuncRescourceService.selectAll();
		
		//查询所有权限
		List<ZxSystemFuncBean> listAllFunc = this.selectAll();
		//返回func
		List<ZxSystemFuncBean> listParentFunc = new ArrayList<ZxSystemFuncBean>();
		
		//遍历所有权限
		for(ZxSystemFuncBean allFunc : listAllFunc){
			String parentcode = allFunc.getZxFuncParentcode();
			if("0".equals(parentcode)){
				listParentFunc.add(allFunc);
			}
		}
		
		for(ZxSystemFuncBean parentFunc : listParentFunc){
			//子级个数
			int childSize = 1;
			//子集集合
			List<ZxSystemFuncBean> listChildFunc = new ArrayList<ZxSystemFuncBean>();
			for(ZxSystemFuncBean allFunc : listAllFunc){
				//判断是否是子集
				if(parentFunc.getZxFuncCode().equals(allFunc.getZxFuncParentcode())){
					//子功能列表
					List<ZxSystemFuncRescourceBean> childRescource = new ArrayList<ZxSystemFuncRescourceBean>();
					//遍历功能列表
					for(ZxSystemFuncRescourceBean rescource : listZxSystemFuncRescourceBean){
						if(rescource.getZxFuncCode().equals(allFunc.getZxFuncCode())){
							childRescource.add(rescource);
						}
					}
					
					allFunc.setChildListZxSystemFuncRescourceBean(childRescource);
					listChildFunc.add(allFunc);
					parentFunc.setChildSize(childSize++);
				}
			}
			parentFunc.setChildListZxSystemFuncBean(listChildFunc);
		}
		model.addAttribute("listFunc",listParentFunc);
	}
}