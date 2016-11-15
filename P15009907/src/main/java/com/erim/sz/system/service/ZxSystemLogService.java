package com.erim.sz.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.system.bean.ZxSystemLogBean;
import com.erim.sz.system.dao.ZxSystemLogDao;

/**
 * 
 * @ClassName: ZxSystemLogService 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午8:00:32
 */
@Service("zxSystemLogService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemLogService {

	@Autowired
	private ZxSystemLogDao zxSystemLogDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param zxSystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void save(ZxSystemLogBean zxSystemLogBean){
		this.zxSystemLogDao.insert(zxSystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据父级日志编码查询
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<ZxSystemLogBean>    返回类型 
	 * @throws
	 */
	public void selectByLogFuncCode(ZxSystemLogBean zxSystemLogBean,ModelMap model){
		zxSystemLogBean.setN(10);
		
		List<ZxSystemLogBean> logList = this.zxSystemLogDao.selectPageByLogFuncCode(zxSystemLogBean,model);
		model.addAttribute("logList", logList);
	}
	
}