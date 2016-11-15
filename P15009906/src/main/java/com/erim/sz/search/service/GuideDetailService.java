package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.search.dao.GuideDetailDao;
import com.erim.sz.search.dao.GuidePriceDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: GuideDetailService
 * @Description: 导游接口
 * @author 陈鹏
 * @date 2015年7月29日 下午8:03:43
 *
 */
@Service("guideService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideDetailService {

	@Autowired
	private GuideDetailDao 		  guideDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private GuidePriceDao		  guidePriceDao;

	public void showGuide(ModelMap model, GuideDetailBean bean) {

		// 分页查询
		List<GuideDetailBean> guideList = guideDao.selectPageGuide(bean, model);
		// 回传信息
		model.put("guideList", guideList);
	}


	
	
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//性别
    	model.addAttribute("sex", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEX));
    	//服务类型
    	model.addAttribute("service", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SERVICE));
    	//语种
    	model.addAttribute("language", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LANGUAGE));
    	//等级
    	model.addAttribute("grade", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GRADE));
    	//国家
        model.addAttribute("guojia",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY));
        //公司评级
        model.addAttribute("rating",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RATING));
    	//省
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
	/**
	 * 
	 * @Title: selectGuide
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return GuideDetailBean    返回签证实体对象
	 * @throws
	 */
	public GuideDetailBean selectGuide(int id){
		return guideDao.selectGuide(id);
	}
	
	/**
	 * @Title: selectPriceList 
	 * @Description: 量价查询 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<GuidePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午11:22:49 
	 * @throws
	 */
	public List<GuidePriceBean> selectPriceList(GuidePriceBean bean){
		return this.guidePriceDao.selectPriceList(bean);
	}
}