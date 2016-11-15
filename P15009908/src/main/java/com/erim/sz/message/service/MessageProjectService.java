package com.erim.sz.message.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MessageProjectBean;
import com.erim.sz.message.dao.MessageProjectDao;
import com.erim.sz.texi.service.TexiDetailService;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
 * @描述: 
 * 
 * @作者: （李庆）
 * @创建时间: 2015年11月27日 下午10:39:44
 */
@Service("messageService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MessageProjectService {

	@Autowired
	private MessageProjectDao messageProjectDao;
	
	/**
	 * @描述: 列表展示
	 * @创建时间: 2015年11月15日 下午5:07:43
	 * @param model
	 * @param bean
	 */
	public void showGroundTown(ModelMap model,MessageProjectBean bean) {
       bean.setCpyId(CommonUtil.getCpyId());
		// 分页查询
		List<MessageProjectBean> messageList = messageProjectDao.selectPageMessage(bean,model);
		
		model.put("messageList", messageList);
	}

	/**
	 * @Title: 			insert
	 * @Description: 	插入
	 * @param @param 	model
	 * @param @param 	bean 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public Integer insert(ModelMap model, MessageProjectBean bean) {
		
		try{
			// 创建时间
			bean.setMptCreatetime(new Date());
			// 创建用户
			bean.setMptCreateuser(CommonUtil.getLoginName());
			// 公司ID
			bean.setCpyId(CommonUtil.getCpyId());
			// 插入数据
			Integer result = messageProjectDao.insertGround(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(TexiDetailService.class, e);
		}
	
	}
	/**
	 * @Title: 			update
	 * @Description: 	修改
	 * @param @param 	model
	 * @param @param 	bean 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model,MessageProjectBean bean) {
		Integer result = CommonUtil.ERROR;
		try{
			// 创建时间
			bean.setMptCreatetime(new Date());
			result = messageProjectDao.updateGround(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
}