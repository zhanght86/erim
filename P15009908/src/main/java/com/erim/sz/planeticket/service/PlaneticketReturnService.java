package com.erim.sz.planeticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.PlaneticketReturnBean;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.planeticket.dao.PlaneticketReturnDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: PlaneticketReturnService 
 * @Description: 往返机票 
 * @author maoxian
 * @date 2015年10月29日 下午12:00:41
 */
@Service("planeticketReturnService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketReturnService {

	@Autowired
	private PlaneticketDetailService planeticketDetailService;
	@Autowired
	private PlaneticketReturnDao     planeticketReturnDao;

	/**
	 * @Title: setList 
	 * @Description: 设置所有数组
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setList(PlaneticketDetailBean planeticketDetailBean,ModelMap model){
		model.addAttribute("planeticketList", this.planeticketDetailService.listPlaneTicketDetail(planeticketDetailBean));
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(PlaneticketReturnBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setPtrCreatetime(new Date());
		bean.setPtrCreateuser(CommonUtil.getLoginName());
		
		Integer result = planeticketReturnDao.insert(bean);
		Integer pdlid    = bean.getId();
		if(result == CommonUtil.SUCCESS){
			Integer ID = bean.getId(); //该条数据ID
			Integer cpyID = bean.getCpyId();//公司ID
			//获取产品编号
			String code = CodeUtil.getShopCode(CodeUtil.NTYPE_PLANETICKET, cpyID,ID);
			bean.setPtdNo(code);
			//更新编码
			result = planeticketReturnDao.updatecode(bean);
		}
		return this.planeticketReturnDao.insert(bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月24日 上午12:11:06 
	 * @throws
	 */
	public Integer update(PlaneticketReturnBean bean){
		return this.planeticketReturnDao.update(bean);
	}
	
	/**
	 * @Title: listPlaneticketDetailBean 
	 * @Description: 根据bean 查询相应的飞机飘
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
	public List<PlaneticketDetailBean> listPlaneticketDetailBean(PlaneticketDetailBean bean){
		return this.planeticketDetailService.listPlaneTicketDetail(bean);
	}
	
	
	/**
	 * @Title: selectById 
	 * @Description: 根据id 查询单程 往返飞机
	 * @param @param id
	 * @param @return    设定文件 
	 * @return PlaneticketReturnBean    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 下午11:40:45 
	 * @throws
	 */
	public PlaneticketReturnBean selectById(Integer id){
		return this.planeticketReturnDao.selectPlaneticket(id);
	}
	
	/**
	 * @Title: showPlaneticket 
	 * @Description: 分页查询 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showPlaneticket(ModelMap model, PlaneticketReturnBean bean) {

		// 分页查询
		List<PlaneticketReturnBean> planeticketList = planeticketReturnDao.selectPagePlaneticket(bean, model);
		for(PlaneticketReturnBean rebean : planeticketList){
			if(null != rebean.getPtrStartPtdid()){
				rebean.setPriStartBean(this.planeticketDetailService.selectPlaneticket(rebean.getPtrStartPtdid()));
			}
			if(null != rebean.getPtrStartZzid()){
				rebean.setPriStartBean(this.planeticketDetailService.selectPlaneticket(rebean.getPtrStartZzid()));
			}
			
			if(null != rebean.getPtrEndPtdid()){
				rebean.setPriEndBean(this.planeticketDetailService.selectPlaneticket(rebean.getPtrEndPtdid()));
			}
			if(null != rebean.getPtrEndZzid()){
				rebean.setPriEndBean(this.planeticketDetailService.selectPlaneticket(rebean.getPtrEndZzid()));
			}
		}
		// 回传信息
		model.put("planeticketReturnList", planeticketList);
	}
}
