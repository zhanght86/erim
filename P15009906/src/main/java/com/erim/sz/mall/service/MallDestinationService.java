package com.erim.sz.mall.service;

import java.util.Date;
import java.util.List;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MallDestinationBean;
import com.erim.sz.mall.dao.MallDestinationDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: MallDestinationDao 
 * @Description: 目的地旅游
 * @author maoxian
 * @date 2015年11月11日 下午7:33:56 
 *
 */
@Service("mallDestinationService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallDestinationService {
	
	@Autowired
	public MallDestinationDao mallDestinationDao;
	@Autowired
	private CodeService		   	     codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	/**
	 * @Title: insert 
	 * @Description: 插入关联信息
	 * @param @param mallDestinationBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallDestinationBean mallDestinationBean){
		mallDestinationBean.setCpyId(CommonUtil.getCpyId());
		mallDestinationBean.setMdnCreatetime(new Date());
		this.mallDestinationDao.insert(mallDestinationBean);
		return mallDestinationBean.getId();
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除基本信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(Integer id){
		return this.mallDestinationDao.delete(id);
	}
	
	
	/**
	 * @Title: selectAll 
	 * @Description: 根据数据查询;提供模糊查询的地名集合
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallDestinationBean>    返回类型 
	 * @throws
	 */
	public void selectAll(MallDestinationBean bean,ModelMap model){
		bean.setCpyId(CommonUtil.getCpyId());	
		//model.addAttribute("listDestOption", this.mallDestinationDao.selectAllDestName());
		
		//国家列表
		model.addAttribute("countries",	this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.COUNTRY));
		// 省市县
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		model.addAttribute("listDestination", this.mallDestinationDao.selectAll(bean));
	}
}