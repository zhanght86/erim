package com.erim.sz.cus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cus.bean.CusSystemFuncBean;
import com.erim.sz.cus.bean.CusSystemFuncRescourceBean;
import com.erim.sz.cus.dao.CusSystemFuncDao;

/**
 * @ClassName: CusSystemFuncService 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:17:50
 */
@Service("cusSystemFuncService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemFuncService {

	@Autowired
	private CusSystemFuncDao cusSystemFuncDao;
	@Autowired
	private CusSystemFuncRescourceService cusSystemFuncRescourceService;
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询所有菜单
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncBean> selectAll(){
		return this.cusSystemFuncDao.selectAll();
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code值获取权限列表
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncBean> selectFuncByCode(String[] code,HttpServletRequest request){
		List<CusSystemFuncBean> newList = new ArrayList<CusSystemFuncBean>();
		//得到所有代码集合
    	List<CusSystemFuncBean> allList = (List<CusSystemFuncBean>)request.getSession().getAttribute("allList");
    	if(!(null != allList && allList.size()>0)){
    		//得到所有代码集合
        	allList = this.selectAll();
        	request.getSession().setAttribute("allList", allList);
    	}
    	//循环所欲数组
    	for(CusSystemFuncBean func : allList){
    		String funccode = func.getCusFuncCode();
    		if(Arrays.asList(code).contains(funccode)){
    			newList.add(func);
    		}
    	}
    	return newList;
		//return this.cusSystemFuncDao.selectFuncByCode(code);
	}
	
	/**
	 * 
	 * @Title: selectFuncList 
	 * @Description: 获取权限列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public void selectFuncList(ModelMap model,String ntype){
		//所有功能列表
		List<CusSystemFuncRescourceBean> listCusSystemFuncRescourceBean = this.cusSystemFuncRescourceService.selectAll();
		
		//查询所有权限
		List<CusSystemFuncBean> listAllFunc = this.selectAll();
		//返回func
		List<CusSystemFuncBean> listParentFunc = new ArrayList<CusSystemFuncBean>();
		
		//遍历所有权限
		for(CusSystemFuncBean allFunc : listAllFunc){
			String parentcode = allFunc.getCusFuncParentcode();
			if("0".equals(parentcode)){
				listParentFunc.add(allFunc);
			}
		}
		
		for(CusSystemFuncBean parentFunc : listParentFunc){
			
			//子级个数
			int childSize = 1;
			//子集集合
			List<CusSystemFuncBean> listChildFunc = new ArrayList<CusSystemFuncBean>();
			for(CusSystemFuncBean allFunc : listAllFunc){
				
				if(StringUtils.isNotBlank(ntype)){
					if(!allFunc.getCusFuncCode().contains("_"+ntype) || allFunc.getCusFuncCode().contains("LOG") || allFunc.getCusFuncCode().contains("SAMETOWN")) continue;
				}
				
				//判断是否是子集
				if(parentFunc.getCusFuncCode().equals(allFunc.getCusFuncParentcode())){
					//子功能列表
					List<CusSystemFuncRescourceBean> childRescource = new ArrayList<CusSystemFuncRescourceBean>();
					//遍历功能列表
					for(CusSystemFuncRescourceBean rescource : listCusSystemFuncRescourceBean){
						if(rescource.getCusFuncCode().equals(allFunc.getCusFuncCode())){
							childRescource.add(rescource);
						}
					}
					
					allFunc.setChildListCusSystemFuncRescourceBean(childRescource);
					listChildFunc.add(allFunc);
					parentFunc.setChildSize(childSize++);
				}
			}
			parentFunc.setChildListCusSystemFuncBean(listChildFunc);
		}
		model.addAttribute("listFunc",listParentFunc);
	}
}