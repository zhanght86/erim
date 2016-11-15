package com.erim.sz.company.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.system.bean.SellSystemUserBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: CompanyBusinessService
 * @描述: 公司业务范围信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年11月4日 下午1:24:02
 */
@Service("companyBusinessService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyBusinessService {

	@Autowired
	private CompanyBusinessDao companyBusinessDao;
	
	/**
	 * @方法名: insert
	 * @描述: 新增公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:21:08 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insert(ModelMap map, CompanyBusinessBean bean) {
		
		try {
			// 公司ID
			Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
			bean.setCpyId(cpyId);
			// 执行新增前，先预删除该企业ID相关的业务信息，防止重复。
			companyBusinessDao.deleteBusinessByCpyId(bean);
			// 执行新增
			return companyBusinessDao.insert(bean);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonUtil.ERROR;
		}
	}
	
	/**
	 * 
	 * @方法名: showBusinessPage
	 * @描述: 打开修改业务范围信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:22:54 
	 * @param map
	 * @param bean
	 *
	 */
	public void updateBusinessPage(ModelMap map, SellSystemUserBean bean) {
		Integer cpyId = bean.getCpyId();
		CompanyBusinessBean model = new CompanyBusinessBean();
		// 根据ID获取一条信息
		model = companyBusinessDao.getBusinessById(cpyId);
		map.addAttribute("business", model);
		map.addAttribute("cpyId", cpyId);
	}
	
	/**
	 * @Title: getBusinessByCpyId 
	 * @Description: 根据企业id 查询业务范围
	 * @param @param cpyid
	 * @param @return    设定文件 
	 * @return CompanyBusinessBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月9日 上午1:18:28 
	 * @throws
	 */
	public CompanyBusinessBean getBusinessByCpyId(Integer cpyid) {
		return this.companyBusinessDao.getBusinessByCpyId(cpyid);
	}
}
