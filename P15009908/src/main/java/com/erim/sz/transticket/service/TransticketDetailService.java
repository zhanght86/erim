package com.erim.sz.transticket.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TransticketDetailBean;
import com.erim.sz.common.bean.TransticketDetailNumBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.transticket.dao.TransticketDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: TransticketDetailService 
 * @Description: 服务范围
 * @author maoxian
 * @date 2015年10月13日 下午11:55:01 
 *
 */
@Service("transticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TransticketDetailService {

	@Autowired
	private TransticketDetailDao         transticketDao;
	@Autowired
	private TransticketDetailNumService  transticketDetailNumService;
	@Autowired
	private CusSystemCooperationService  cusSystemCooperationService;
	@Autowired
	private TmSystemRegionService 	     tmSystemRegionService;
	@Autowired
    private CodeService             codeService;
	
	public void showTransticketTown(ModelMap model, TransticketDetailBean bean) {
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		// 分页查询
		List<TransticketDetailBean> transticketList = transticketDao.selectPageTown(bean, model);
		
		if(null != transticketList && transticketList.size()>0){
			// 回传信息
			model.put("transticket", transticketList.get(0));
			
			// 查询
			TransticketDetailNumBean numbean = new TransticketDetailNumBean();
			numbean.setTtdId(transticketList.get(0).getId());
			model.addAttribute("listtransticketnum", this.transticketDetailNumService.showList(numbean));
		}
	}
	/**
	 * @方法名：showTransticket 
	 * @描述: 火车票
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午4:22:28
	 * @param model
	 * @param bean
	 */

	public void showTransticket(ModelMap model, TransticketDetailBean bean) {
		//公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_TRANSTICKET);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		// 分页查询
		List<TransticketDetailBean> transticketList = transticketDao.selectPageTransticket(bean, model);
		//转码
		for(int i = 0;i<transticketList.size();i++){
			TransticketDetailBean detail = transticketList.get(i);
			//出发省
			String ttdStartProvinces = detail.getTtdStartProvinces();
			if(null != ttdStartProvinces && !"".equals(ttdStartProvinces)){
			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ttdStartProvinces));
			detail.setTtdStartProvinces(str);
			} 
		
			//出发城市
			String ttdStartCity = detail.getTtdStartCity();
			if(null != ttdStartCity && !"".equals(ttdStartCity)){
			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ttdStartCity));
			detail.setTtdStartCity(str);
			}
			//出发区县
			String ttdStartTown = detail.getTtdStartTown();
			if(null != ttdStartTown && !"".equals(ttdStartTown)){
			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ttdStartTown));
			detail.setTtdStartTown(str);
			}
			//目的省
			String ttdEndProvinces = detail.getTtdEndProvinces();
			if(null != ttdEndProvinces && !"".equals(ttdEndProvinces)){
			String[] arr = ttdEndProvinces.split(",");
			String str = "";
			if(arr.length >0){
				for(int j = 0;j<arr.length;j++){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[j]))+",";
				}
			}
			detail.setTtdEndProvinces(str);
			}
//			//目的城市 国际
//			String ttdEndCity = detail.getTtdEndCity();
//			if(null != ttdEndCity && !"".equals(ttdEndCity)){
//			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ttdEndCity));
//			detail.setTtdEndCity(str);
//			}
			//目的市
			String ttdEndTown = detail.getTtdEndTown();
			if(null != ttdEndTown && !"".equals(ttdEndTown)){
			String[] arr = ttdEndTown.split(",");
			String str = "";
			if(arr.length >0){
				for(int j = 0;j<arr.length;j++){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[j]))+",";
				}
			}
			detail.setTtdEndTown(str);
			}
		}
		if(null != transticketList && transticketList.size()>0){
			// 回传信息
			model.put("transticket", transticketList.get(0));
			
			// 查询
			TransticketDetailNumBean numbean = new TransticketDetailNumBean();
			numbean.setTtdId(transticketList.get(0).getId());
			model.addAttribute("listtransticketnum", this.transticketDetailNumService.showList(numbean));
		}
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer insert(ModelMap model,TransticketDetailBean bean	) { 
		
			
		try {
			//插入服务范围
			bean.setCpyId(CommonUtil.getCpyId());
			bean.setTtdCreatetime(new Date());
			bean.setTtdCreateuser(CommonUtil.getLoginName());
			bean.setTtdIsDelStatus("0");
			
			//插入数据
			Integer result =transticketDao.insertTransticket(bean);
			//当新增成功，返回ID,更新编码
			if(result == CommonUtil.SUCCESS){
				Integer ID=bean.getId();
				Integer cpyID=bean.getCpyId();
				//获取产品编码
				String code=CodeUtil.getShopCode(CodeUtil.NTYPE_TRANSTICKET, cpyID, ID);
				bean.setTtdNo(code);
				//更新编码
				result =transticketDao.Transupdatecode(bean);
			}
			
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: selecttransticketDetialById
	 * @Description: 根据ID查询实体
	 * @param @param id
	 * @param @return 设定文件
	 * @return transticketDetailBean 返回类型
	 * @throws
	 */
	public void selectTransticketDetialById(ModelMap model, Integer id) {
		model.addAttribute("transticketDetail",this.transticketDao.selectTransticket(id));
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			//获取bean 基础信息
			TransticketDetailBean bean = new TransticketDetailBean();
			bean.setTtdStartProvinces(request.getParameter("ttdStartProvinces"));
			bean.setTtdStartCity(request.getParameter("ttdStartCity"));
			bean.setTtdStartTown(request.getParameter("ttdStartTown"));
			bean.setTtdEndIsDomestic(StringUtils.isNotBlank(request.getParameter("ttdEndIsDomestic"))?request.getParameter("ttdEndIsDomestic"):"");
			bean.setTtdEndIsXg(StringUtils.isNotBlank(request.getParameter("ttdEndIsXg"))?request.getParameter("ttdEndIsXg"):"");
			bean.setTtdEndIsAm(StringUtils.isNotBlank(request.getParameter("ttdEndIsAm"))?request.getParameter("ttdEndIsAm"):"");
			bean.setTtdEndIsTw(StringUtils.isNotBlank(request.getParameter("ttdEndIsTw"))?request.getParameter("ttdEndIsTw"):"");
			
			//多选获取
			bean.setTtdStartStation1(CommonUtil.changetoString(request.getParameterValues("ttdStartStation")));
			bean.setTtdEndProvinces(CommonUtil.changetoString(request.getParameterValues("ttdEndProvinces")));
			bean.setTtdEndTown(CommonUtil.changetoString(request.getParameterValues("ttdEndTown")));
			bean.setTtdEndCountry(CommonUtil.changetoString(request.getParameterValues("ttdEndCountry")));
			bean.setTtdEndCity(CommonUtil.changetoString(request.getParameterValues("ttdEndCity")));
			
			
			//id不为空走修改  为空 走新增
			if(StringUtils.isNotBlank(id)){
				bean.setId(Integer.parseInt(id));
				transticketDao.updateTransticket(bean);
			}else{
				this.insert(model, bean);
			}
			
			//车次
			this.updateTransticketDetailNum(request,bean.getId());
			
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: selectAllTransticketDetail 
	 * @Description: 火车车次
	 * @param @param request
	 * @param @return    设定文件 
	 * @return List<TransticketDetailNumBean>    返回类型 
	 * @author maoxian
	 * @date 2015年11月21日 下午2:05:36 
	 * @throws
	 */
	public void updateTransticketDetailNum(HttpServletRequest request,Integer ttdId){
		//火车车次添加
		String[] atdlid 		    = request.getParameterValues("tdlid");
		String[] atdlNo				= request.getParameterValues("tdlNo");
		String[] atdlStartStation   = request.getParameterValues("tdlStartStation");
		String[] atdlStartTime      = request.getParameterValues("tdlStartTime");
		String[] atdlArrivedStation = request.getParameterValues("tdlArrivedStation");
		String[] atdlArrivedTime	= request.getParameterValues("tdlArrivedTime");
		String[] atdlNtype  		= request.getParameterValues("tdlNtype");
		
		//根据火车情况 修改车次信息
		if(null != atdlid && atdlid.length>0){
			for(int i = 0 ;i<atdlid.length ; i++){
				TransticketDetailNumBean bean = new TransticketDetailNumBean();
				bean.setTdlStartStation(atdlStartStation[i]);
				if(StringUtils.isBlank(atdlStartStation[i])) continue;
				bean.setTdlNo(atdlNo[i]);
				bean.setTdlStartTime(atdlStartTime[i]);
				bean.setTdlArrivedStation(atdlArrivedStation[i]);
				bean.setTdlArrivedTime(atdlArrivedTime[i]);
				bean.setTdlNtype(atdlNtype[i]);
				bean.setTtdId(ttdId);
				
				//如果id不为空 走新增 否则走修改
				if(StringUtils.isNotBlank(atdlid[i])){
					bean.setId(Integer.parseInt(atdlid[i]));
					this.transticketDetailNumService.update(bean);
				}else{
					this.transticketDetailNumService.insert(bean);
				}
			}
		}
	}

	
	/**
	 * 
	 * @Title: selectManagement
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return 设定文件
	 * @return ManagementDetailBean 返回签证实体对象
	 * @throws
	 */
	public TransticketDetailBean selectTransticket(int id) {

		return transticketDao.selectTransticket(id);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 上下架
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public int delete(TransticketDetailBean bean) {
		try {
			transticketDao.deleteTransticket(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
}