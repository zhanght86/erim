package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.AboutUsBean;
import com.erim.sz.web.dao.SellAboutUsDetailDao;

/**
 * 
 * @ClassName: NewsDetailService
 * @Description: 新闻资讯实体操作业务类
 * @Author 宁晓强
 * @Date 2015年9月21日 下午1:52:49
 *
 */
@Repository("sellAboutUsDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellAboutUsDetailService {

	@Autowired
	private SellAboutUsDetailDao sellAboutUsDetailDao;
	@Autowired
	private CompanyDetailService companyDetailService;
	
	
	public void selectNewsBean(ModelMap map, String cpyno) {
		int cpyid = this.companyDetailService.getCpyId(cpyno);
		if(0 != cpyid){
			// 查询一条数据
			AboutUsBean bean = new AboutUsBean();
			bean.setCpyId(cpyid);
			map.addAttribute("aboutus", sellAboutUsDetailDao.selectAboutUsBeanByCpyId(bean));
		}
	}
}
