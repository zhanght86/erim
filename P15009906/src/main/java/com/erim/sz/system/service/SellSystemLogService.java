package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.SellSystemLogBean;
import com.erim.sz.system.dao.SellSystemLogDao;

/**
 * 
 * @ClassName: SellSystemLogService 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午8:00:32
 */
@Service("sellSystemLogService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemLogService {

	@Autowired
	private SellSystemLogDao sellSystemLogDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param sellSystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void save(SellSystemLogBean sellSystemLogBean){
		this.sellSystemLogDao.insert(sellSystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据父级日志编码查询
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<SellSystemLogBean>    返回类型 
	 * @throws
	 */
	public void selectByLogFuncCode(SellSystemLogBean sellSystemLogBean,ModelMap model){
		sellSystemLogBean.setN(10);
		
		List<SellSystemLogBean> logList = this.sellSystemLogDao.selectPageByLogFuncCode(sellSystemLogBean,model);
		model.addAttribute("logList", logList);
	}
	
}