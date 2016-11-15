package com.erim.sz.zy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.zy.bean.ZySystemFuncBean;
import com.erim.sz.zy.bean.ZySystemFuncRescourceBean;
import com.erim.sz.zy.dao.ZySystemFuncDao;

/**
 * @ClassName: ZySystemFuncService 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:17:50
 */
@Service("zySystemFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemFuncService {

	@Autowired
	private ZySystemFuncDao zySystemFuncDao;
	@Autowired
	private ZySystemFuncRescourceService zySystemFuncRescourceService;
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有菜单
	 * @param @return    设定文件 
	 * @return List<ZySystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemFuncBean> selectAll(){
		return this.zySystemFuncDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code值获取权限列表
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<ZySystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemFuncBean> selectFuncByCode(String[] code,HttpServletRequest request){
		List<ZySystemFuncBean> newList = new ArrayList<ZySystemFuncBean>();
		//得到所有代码集合
    	List<ZySystemFuncBean> allList = (List<ZySystemFuncBean>)request.getSession().getAttribute("allList");
    	if(!(null != allList && allList.size()>0)){
    		//得到所有代码集合
        	allList = this.selectAll();
        	request.getSession().setAttribute("allList", allList);
    	}
    	//循环所欲数组
    	for(ZySystemFuncBean func : allList){
    		String funccode = func.getZyFuncCode();
    		if(Arrays.asList(code).contains(funccode)){
    			newList.add(func);
    		}
    	}
    	return newList;
		//return this.zySystemFuncDao.selectFuncByCode(code);
	}
	
	/**
	 * 
	 * @Title: selectFuncList 
	 * @Description: 获取权限列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZySystemFuncBean>    返回类型 
	 * @throws
	 */
	public void selectFuncList(ModelMap model,String ntype){
		//所有功能列表
		List<ZySystemFuncRescourceBean> listZySystemFuncRescourceBean = this.zySystemFuncRescourceService.selectAll();
		
		//查询所有权限
		List<ZySystemFuncBean> listAllFunc = this.selectAll();
		//返回func
		List<ZySystemFuncBean> listParentFunc = new ArrayList<ZySystemFuncBean>();
		
		//遍历所有权限
		for(ZySystemFuncBean allFunc : listAllFunc){
			String parentcode = allFunc.getZyFuncParentcode();
			if("0".equals(parentcode)){
				listParentFunc.add(allFunc);
			}
		}
		
		for(ZySystemFuncBean parentFunc : listParentFunc){
			
			//子级个数
			int childSize = 1;
			//子集集合
			List<ZySystemFuncBean> listChildFunc = new ArrayList<ZySystemFuncBean>();
			for(ZySystemFuncBean allFunc : listAllFunc){
				
				//判断是否是子集
				if(parentFunc.getZyFuncCode().equals(allFunc.getZyFuncParentcode())){
					//子功能列表
					List<ZySystemFuncRescourceBean> childRescource = new ArrayList<ZySystemFuncRescourceBean>();
					//遍历功能列表
					for(ZySystemFuncRescourceBean rescource : listZySystemFuncRescourceBean){
						if(rescource.getZyFuncCode().equals(allFunc.getZyFuncCode())){
							childRescource.add(rescource);
						}
					}
					
					allFunc.setChildListZySystemFuncRescourceBean(childRescource);
					listChildFunc.add(allFunc);
					parentFunc.setChildSize(childSize++);
				}
			}
			parentFunc.setChildListZySystemFuncBean(listChildFunc);
		}
		model.addAttribute("listFunc",listParentFunc);
	}
}