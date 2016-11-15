package com.erim.sz.news.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.news.dao.PubNewsDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: PubNewsService
 * @描述: 新闻资讯信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月22日 下午3:12:57
 *
 */
@Service("pubNewsService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PubNewsService {

	@Autowired
	public PubNewsDao pubNewsDao;
	@Autowired
	public CodeService codeService;
	
	/**
	 * 
	 * @方法名: insert
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:47:24 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	public Integer insert(ModelMap map, PubNewsBean bean) {
		
		Integer result = CommonUtil.ERROR;
		bean.setNewIsDelstatus("0");
		bean.setNewCreateTime(new Date());// 创建时间
		bean.setNewCreateUser(CommonUtil.getLoginName()); // 创建用户
		bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
		bean.setNewIsShow(ErimConstants.YESORNO_NO);// 是否外网显示
		bean.setNewClick(0); // 点击数默认为0
		bean.setNewIsCheck(ErimConstants.YESORNO_NO); // 默认添加未审核
		// 执行新增
		result = pubNewsDao.insertNews(bean);
		return result;
	}
	
	/**
	 * 
	 * @方法名: setCode
	 * @描述: 设置字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:49:10 
	 * @param map
	 *
	 */
	public void setCode(ModelMap map) {
		// 新闻类型
		map.addAttribute("newsType", codeService.getSystemCodeByCodeNo(DictionaryUtil.NEWSTYPE));
		// 是否门户显示
		map.addAttribute("isShow", codeService.getSystemCodeByCodeNo(DictionaryUtil.YESORNO));
	}
	
	/**
	 * 
	 * @方法名: delete
	 * @描述: 删除
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:50:57 
	 * @param bean
	 * @return
	 *
	 */
	public Integer delete(PubNewsBean bean) {
		Integer result = CommonUtil.ERROR;
		result = pubNewsDao.deleteNews(bean);
		return result;
	}
	
	/**
	 * @方法名: selectPubNewsPageList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:09:36 
	 * @param bean
	 * @param map
	 */
	public void selectPubNewsPageList(PubNewsBean bean, ModelMap map) {
		bean.getPageLinkBean().setLimit(10);
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		
		// 执行查询
		List<PubNewsBean> list = pubNewsDao.selectPageNews(bean, map);
		
		// 转码
		for (int i = 0; i < list.size(); i++) {
			PubNewsBean model = list.get(i);
			// 新闻类型
			String newType = model.getNewType();
			if (newType != null && !"".equals(newType)) {
				String str = codeService.getValueByCodeNoAndKey(DictionaryUtil.NEWSTYPE, newType);
				model.setNewType(str);
			}
			// 是否审核
			String isCheck = model.getNewIsCheck();
			if (ErimConstants.YESORNO_YES.equals(isCheck)) {
				model.setNewIsCheck("已审");
			}
			if (ErimConstants.YESORNO_NO.equals(isCheck)) {
				model.setNewIsCheck("未审");
			}
		}
		map.addAttribute("newsList", list);
	}
	
	/**
	 * @方法名: getPubNewsById
	 * @描述: 查看
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:04:03 
	 * @param map
	 * @param bean
	 */
	public void getPubNewsById(ModelMap map, PubNewsBean bean) {
		PubNewsBean model = new PubNewsBean();
		Integer id = bean.getId();
		if (id != null) {
			model = pubNewsDao.getPubNewsById(id);
		}
		map.addAttribute("pubNews", model);
	}
	
	/**
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:09:01 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer update(ModelMap map, PubNewsBean bean) {
		Integer result = CommonUtil.ERROR;
		result = pubNewsDao.updateNews(bean);
		return result;
	}
	
	/**
	 * 
	 * @方法名: updateIsShow
	 * @描述: 修改是否门户显示状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月23日 上午10:42:06 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsShow(PubNewsBean bean) {
		Integer result = CommonUtil.ERROR;
		result = pubNewsDao.updateIsShow(bean);
		return result;
	}

	/**
	 * 
	 * @描述: 是否审核
	 * @作者: （李庆）
	 * @创建时间: 2015年12月18日 下午4:31:49
	 * @param bean
	 * @return
	 */
	public int newisdel(PubNewsBean bean) {
		try{
			pubNewsDao.newisdel(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
	}
  }
}
