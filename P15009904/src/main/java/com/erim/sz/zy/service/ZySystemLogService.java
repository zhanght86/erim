package com.erim.sz.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemLogBean;
import com.erim.sz.zy.dao.ZySystemLogDao;

/**
 * 
 * @ClassName: ZySystemLogService 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午8:00:32
 */
@Service("zySystemLogService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemLogService {

	@Autowired
	private ZySystemLogDao zySystemLogDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param zySystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void save(ZySystemLogBean zySystemLogBean){
		this.zySystemLogDao.insert(zySystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据父级日志编码查询
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<ZySystemLogBean>    返回类型 
	 * @throws
	 */
	public void selectByLogFuncCode(ZySystemLogBean zySystemLogBean,ModelMap model){
		zySystemLogBean.setN(10);
		zySystemLogBean.setLogUsercpyid(CommonUtil.getCpyId());
		List<ZySystemLogBean> logList = this.zySystemLogDao.selectPageByLogFuncCode(zySystemLogBean,model);
		model.addAttribute("logList", logList);
	}
	
}