package com.erim.sz.mall.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MallWebBean;
import com.erim.sz.mall.dao.MallImageDao;
import com.erim.sz.mall.dao.MallWebDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: MallWebService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年11月12日 下午3:11:25 
 *
 */
@Service("mallWebService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallWebService {

	@Autowired
	private MallWebDao    mallWebDao;
	@Autowired
	private MallImageDao  mallImageDao;
	
	/**
	 * @Title: insert @Description: 插入 @param @param bean @param @return
	 * 设定文件 @return Integer 返回类型 @throws
	 */
	public Integer insert(MallWebBean bean) {
		return this.mallWebDao.insert(bean);
	}

	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(MallWebBean bean){
		try{
			MallWebBean web = this.mallWebDao.findId(CommonUtil.getCpyId());
			if(null != web){
				bean.setId(web.getId());
				this.mallWebDao.update(bean);
			}else{
				bean.setCpyId(CommonUtil.getCpyId());
				this.mallWebDao.insert(bean);
			}
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: findId 
	 * @Description: 根据id 检索
	 * @param @param id
	 * @param @return    设定文件 
	 * @return MallWebBean    返回类型 
	 * @throws
	 */
	public void getMallWeb(ModelMap model){
		MallWebBean web = this.mallWebDao.findId(CommonUtil.getCpyId());
		
		model.addAttribute("mallweb", web);
		
		if(null != web && StringUtils.isNotBlank(web.getWebQq())){
			model.addAttribute("listQq", web.getWebQq().split(","));
		}
		
		//所有图片
		model.addAttribute("listImage", this.mallImageDao.selectAll());
	}
}