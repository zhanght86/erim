package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.web.bean.VSearchAnyBean;
import com.erim.sz.web.dao.VSearchAnyDao;

/**
 * @ClassName: VSearchAnyService 
 * @Description: 首页视图检索 
 * @author maoxian
 * @date 2016年1月3日 下午2:56:33
 */
@Service("vSearchAnyService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VSearchAnyService {

	@Autowired
	private VSearchAnyDao vSearchAnyDao;
	
	/**
	 * @Title: selectSearchResult 
	 * @Description: 根据输入名称进行检索 
	 * @param @param name
	 * @param @return    设定文件 
	 * @return List<VSearchAnyBean>    返回类型 
	 * @author maoxian
	 * @date 2016年1月3日 下午2:57:01 
	 * @throws
	 */
	public List<VSearchAnyBean> selectSearchResult(VSearchAnyBean bean){
		return this.vSearchAnyDao.selectSearchResult(bean);
	}
}
