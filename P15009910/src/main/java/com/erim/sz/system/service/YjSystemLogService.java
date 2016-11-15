package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.YjSystemLogBean;
import com.erim.sz.system.dao.YjSystemLogDao;

/**
 * 
 * @ClassName: YjSystemLogService 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午8:00:32
 */
@Service("yjSystemLogService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class YjSystemLogService {

	@Autowired
	private YjSystemLogDao yjSystemLogDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param yjSystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void save(YjSystemLogBean yjSystemLogBean){
		this.yjSystemLogDao.insert(yjSystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据父级日志编码查询
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<YjSystemLogBean>    返回类型 
	 * @throws
	 */
	public void selectByLogFuncCode(YjSystemLogBean yjSystemLogBean,ModelMap model){
		yjSystemLogBean.setN(10);
		
		List<YjSystemLogBean> logList = this.yjSystemLogDao.selectPageByLogFuncCode(yjSystemLogBean,model);
		model.addAttribute("logList", logList);
	}
	
}