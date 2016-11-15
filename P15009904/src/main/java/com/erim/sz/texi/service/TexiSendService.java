package com.erim.sz.texi.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.texi.dao.TexiDetailDao;
import com.erim.sz.texi.dao.TexiSendDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName:   TexiPriceService 
 * @Description: 租车固定接送
 * @author		王赛
 * @date 		2015年8月20日 上午1:02:24 
 */
@Service("texiSendService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiSendService {
	
	@Autowired
	private TexiSendDao texiSendDao;
	@Autowired
	private TexiDetailDao texiDetailDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	/**
	 * @Title: showtrantTexi 
	 * @Description: 租车管理固定接送线路信息列表 
	 * @param model
	 * @param bean
	 * @return 
	 */
	public void showtrantTexi(ModelMap model, TexiSendBean bean) {
		List<TexiSendBean> list = null;
		// 出租车ID
		Integer tdlID = bean.getTdlId();
		if(tdlID != null && !"".equals(tdlID)) {
			// 存进Session
			SecurityUtils.getSubject().getSession().setAttribute("texiID", tdlID);
		} else {
			tdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("texiID");
			bean.setTdlId(tdlID);
		}
		TexiDetailBean detailBean = texiDetailDao.getTexiDetialById(tdlID);
		//出租车名字
		String tdlName = detailBean.getTdlName();
		if(tdlName != null && !"".equals(tdlName)){
			// 存进Session
			SecurityUtils.getSubject().getSession().setAttribute("tdlName", tdlName);
		} else {
			tdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("tdlName");
			bean.setTdlName(tdlName);
		}
		// 查询数据
		list = texiSendDao.selectTexiSendList(bean, model);
		//回传信息
		model.put("texisendlist", list);
		//获取汽车名字，以便于展示到固定接送列表页头部
    	model.addAttribute("Texisend", tdlName);
	}
	
	/**
	 * @Title: 		 delete
	 * @Description: 固定接送删除
	 * @param @param id 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public int delete(Integer id) {
		try{
			texiSendDao.delete(id);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: 		 insert
	 * @Description: 添加
	 * @param @param id 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, TexiSendBean bean){
		
		Integer result = CommonUtil.ERROR;
		// 线路ID
		Integer sendID = bean.getId();
		// 当ID为空时，为新增
		if(sendID == null || "".equals(sendID)){
			// 新增时默认为下架
			bean.setGdlDelStatus(ErimConstants.YESORNO_NO);
			//获取汽车的id
			Integer tdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("texiID");
			bean.setTdlId(tdlID);
			//获取汽车的名称
			String tdlName =(String) SecurityUtils.getSubject().getSession().getAttribute("tdlName");
			bean.setTdlName(tdlName);
			// 执行新增
			result = texiSendDao.insertTexi(bean);
			if (result == CommonUtil.SUCCESS) {
				// 公司ID
				Integer cpyID = CommonUtil.getCpyId();
				Integer ID = bean.getId();
				// 执行新增成功后，修改产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_TEXI, cpyID, ID);
				bean.setGdlCode(code);
				texiSendDao.updateCode(bean);
			}
		} else {
			// 执行修改
			result = texiSendDao.update(bean);
		}
		return result;
	}
	
	/**
	 * @方法名: selectTexiSendById
	 * @描述: 根据ID查询一条固定接送线路信息ID
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 上午10:24:25 
	 * @param model
	 * @param bean
	 */
	public void getTexiSendById(ModelMap model,TexiSendBean bean){
		
		TexiSendBean sendModel = texiSendDao.getTexiSendById(bean);
		
		model.addAttribute("texiSend1", sendModel);
	}
	
	/**
	 * @Title: 		 setCode
	 * @Description: 查询字典
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model){
		//固定接送类型
		model.addAttribute("sendtype",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SENDTYPE));
		//省市
		model.addAttribute("provinces",   this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
}