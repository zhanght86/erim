package com.erim.sz.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.mall.dao.MallUsersDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: MallUsersService
 * @Description: 导游接口
 * @author 陈鹏
 * @date 2015年7月29日 下午8:03:43
 *
 */
@Service("mallusersService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallUsersService {

	@Autowired
	private MallUsersDao mallusersDao;

	public void showMallUsers(ModelMap model, MallUsersBean bean) {

		// 分页查询
		List<MallUsersBean> mallusersList = mallusersDao.selectPageMallUsers(bean, model);

		// 回传信息
		model.put("mallusersList", mallusersList);
	}
	/**
	 * 
	 * @方法名：upgrade 
	 * @描述: 会员升级
	 * @作者： 贺渊博
	 * @创建时间：2015年11月12日 上午11:34:15
	 * @param bean
	 * @return
	 *
	 */
	public  int upgrade(MallUsersBean bean){
		try{
			mallusersDao.upgrade(bean);
			return CommonUtil.SUCCESS;
		}catch (Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
}