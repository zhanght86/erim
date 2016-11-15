package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.PubNewsDao;
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
	 * @描述: 查询列表
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月26日 下午2:59:04
	 * @param bean
	 * @param map
	 * @return
	 */
	public List<PubNewsBean> selectPubNewsPageList(PubNewsBean bean, ModelMap map) {
		bean.getPageLinkBean().setLimit(10);
		// 公司ID
		//bean.setCpyId(CommonUtil.getCpyId());
		bean.setNewIsCheck(ErimConstants.YESORNO_YES);
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
		}
		return list;
	}
	
	/**
	 * @方法名: getPubNewsById
	 * @描述: 查看
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:04:03 
	 * @param map
	 * @param id
	 */
	public void getPubNewsById(ModelMap map,Integer id) {
		PubNewsBean model = new PubNewsBean();
		if (id != null) {
			pubNewsDao.click(id);
			model = pubNewsDao.getPubNewsById(id);
		}
		map.addAttribute("newsBean", model);
	}
	
	
}
