package com.erim.sz.company.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: CompanyBusinessService
 * @描述: 公司业务范围信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月27日 下午8:05:09
 */
@Service("companyBusinessService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyBusinessService {

	@Autowired
	private CompanyBusinessDao companyBusinessDao;

	/**
	 * @方法名: insertBusinewss
	 * @描述: 保存公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午8:04:55
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertBusinewss(ModelMap map, CompanyBusinessBean bean) {

		// 公司ID
		Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
		bean.setCpyId(cpyId);

		// 业务范围ID
		Integer id = bean.getId();
		// 当ID不为空时，执行修改方法
		if (id != null && !"".equals(id)) {
			// 执行修改
			companyBusinessDao.updateBusiness(bean);
			return CommonUtil.SUCCESS;
		}
		// 执行新增前，先预删除该企业ID相关的业务信息，防止重复。
		companyBusinessDao.deleteBusinessByCpyId(bean);
		// 执行新增
		companyBusinessDao.insertBusiness(bean);
		return CommonUtil.SUCCESS;
	}

	/**
	 * @方法名: showBusinessPage
	 * @描述: 根据企业ID获取一条数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午5:49:14
	 * @param map
	 * @param bean
	 * @return
	 */
	public void getBusinessById(ModelMap map, CusSystemUserBean bean) {
		Integer cpyId = bean.getCpyId();
		CompanyBusinessBean model = new CompanyBusinessBean();
		// 根据ID获取一条信息
		model = companyBusinessDao.getBusinessById(cpyId);
		map.addAttribute("business", model);
		map.addAttribute("cpyId", cpyId);
	}

	/**
	 * 
	 * @Title: getProcitytown 
	 * @Description: 获取地接可服务区域
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年11月20日 下午10:28:26 
	 * @throws
	 */
//	public void getProcitytown(ModelMap model) {
//		model.addAttribute("busbean", this.companyBusinessDao.getBusinessById(CommonUtil.getCpyId()));
//	}
}
