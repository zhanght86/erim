package com.erim.sz.line.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.MallShopBean;
import com.erim.sz.line.dao.LineDetailDao;
import com.erim.sz.mall.dao.MallLinecompanyDao;
import com.erim.sz.mall.service.MallShopService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: LineDetailService 
 * @Description: 专线线路
 * @author maoxian
 * @date 2015年9月16日 下午6:08:41 
 *
 */
@Service("lineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineDetailService {

	@Autowired
	private LineDetailDao		     lineDao;
	@Autowired
	private CodeService              codeService;
	@Autowired
	private LineTripService		     lineTripService;
	@Autowired
	private TmSystemRegionService    tmSystemRegionService;
	@Autowired
	private MallLinecompanyDao       mallLinecompanyDao;
	@Autowired
	private MallShopService			 mallShopService;

	
	/**
	 * @Title: selectAllListBean 
	 * @Description: 根据选择的供应商展示专线
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午2:44:30 
	 * @throws
	 */
	public void selectAllListBean(ModelMap model,LineDetailBean line){
		String[] atrCpyid = this.mallLinecompanyDao.getArrayCpyId();
		//this.zxSellCooperationService.se
		if(null != atrCpyid && atrCpyid.length>0){
			model.addAttribute("lineList", this.lineDao.selectLineByaCpyid(atrCpyid,line));
			
			this.mallShopService.selectList(new MallShopBean(), model,this.lineDao.selectLineByaCpyid(atrCpyid,new LineDetailBean()));
		}
	}

	/**
	 * @Title: selectAllListIsCooper 
	 * @Description: 以合作
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月11日 上午4:06:34 
	 * @throws
	 */
	public void selectAllListIsCooper(ModelMap model,String Themetype){
		String[] atrCpyid = this.mallLinecompanyDao.getArrayCpyId();
		//this.zxSellCooperationService.se
		if(null != atrCpyid && atrCpyid.length>0){
			model.addAttribute("lineList", this.lineDao.selectLineByaCpyidIsCooper(atrCpyid,Themetype));
			
		}
	}
	
	/**
	 * 
	 * @方法名: selectAllListIsCooperAndNation
	 * @描述: 根据
	 * @作者: 国亚文
	 * @创建时间: 2015年12月30日 下午4:07:08 
	 * @param model
	 * @param linebean
	 */
	  
	public void selectAllListIsCooperAndNation(ModelMap model,LineDetailBean linebean){
		String[] atrCpyid = this.mallLinecompanyDao.getArrayCpyId();
		//this.zxSellCooperationService.se
		if(null != atrCpyid && atrCpyid.length>0){
			model.addAttribute("lineList", this.lineDao.selectLineByaCpyidIsCooperAndNation(atrCpyid,linebean));
		}
	}
	
	/**
	 * @Title: showLine 
	 * @Description: 分页查询专线
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午2:43:52 
	 * @throws
	 */
	public void showLine(ModelMap model, LineDetailBean bean) {

		// 分页查询
		List<LineDetailBean> lineList = lineDao.selectPageLine(bean, model);
		// 遍历专线 查询行程
		for (LineDetailBean detail :  lineList) {
			detail.setListTripBean(lineTripService.getTripByTdlId(detail.getId()));
		}
		// 回传信息
		model.put("lineList", lineList);
	}

	/**
	 * @Title: selectLineDetialById 
	 * @Description: 根据ID查询实体 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return LineDetailBean    返回类型 
	 * @throws
	 */
	public void selectLineDetialById(ModelMap model,Integer id){
		
		model.addAttribute("lineDetail", this.lineDao.selectLine(id));
	}
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//学生活动
    	model.addAttribute("game",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
    	//产品形态
    	model.addAttribute("product",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
    	//产品标准
    	model.addAttribute("standard",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARD));
    	//大交通
    	model.addAttribute("traffic",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TRAFFIC));
    	//主题
    	model.addAttribute("scenic",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCENIC));
    	//省市县
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
    	
	}

	/**
	 * @Title: selectLineByCpyid 
	 * @Description: 根据企业id查询所有专线信息
	 * @param @param cpyid
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
	public List<LineDetailBean> selectLineByCpyid(Integer cpyId){
		return this.lineDao.selectLineByCpyid(cpyId);
	}
	
	/**
     * @Title: selectListByBean 
     * @Description: 根据bean进行查询 
     * @param @param bean
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @throws
     */
    public List<LineDetailBean> selectListByBean(LineDetailBean bean){
    	return this.lineDao.selectListByBean(bean);
    }
}