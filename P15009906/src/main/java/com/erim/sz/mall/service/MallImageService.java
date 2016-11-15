package com.erim.sz.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.MallImageBean;
import com.erim.sz.mall.dao.MallImageDao;

/**
 * @ClassName: MallImageService 
 * @Description: 首页大图
 * @author maoxian
 * @date 2015年12月3日 下午8:55:28
 */
@Service("mallImageService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallImageService {
	
	@Autowired
	private MallImageDao mallImageDao;
	
	/**
	 * @Title: selectAll 
	 * @Description: 查询所有图片
	 * @param @return    设定文件 
	 * @return List<MallImageBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月3日 下午8:56:19 
	 * @throws
	 */
	public List<MallImageBean> selectAll(){
		return this.mallImageDao.selectAll();
	}
}