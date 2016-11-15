package com.erim.sz.cus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cus.bean.CusSystemLogBean;
import com.erim.sz.cus.dao.CusSystemLogDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CusSystemLogService 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午8:00:32
 */
@Service("cusSystemLogService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemLogService {

	@Autowired
	private CusSystemLogDao cusSystemLogDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param cusSystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void save(CusSystemLogBean cusSystemLogBean){
		this.cusSystemLogDao.insert(cusSystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据父级日志编码查询
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<CusSystemLogBean>    返回类型 
	 * @throws
	 */
	public void selectByLogFuncCode(CusSystemLogBean cusSystemLogBean,ModelMap model){
		cusSystemLogBean.setN(10);
		cusSystemLogBean.setLogUsercpyid(CommonUtil.getCpyId());
		List<CusSystemLogBean> logList = this.cusSystemLogDao.selectPageByLogFuncCode(cusSystemLogBean,model);
		model.addAttribute("logList", logList);
	}
	
}