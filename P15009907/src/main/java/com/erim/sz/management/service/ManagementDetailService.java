package com.erim.sz.management.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementMaterialBean;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.management.dao.ManagementDetailDao;
import com.erim.sz.management.dao.ManagementMaterialDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: ManagementDetailService
 * @Description: 签证接口
 * @author 龙龙
 * @date 2015年7月29日 下午4:58:49
 *
 */
@Service("managementService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ManagementDetailService {

	@Autowired
	private ManagementDetailDao		     managementDao;
	@Autowired
	private ManagementMaterialDao		 managementMaterialDao;
	@Autowired
	private CodeService 			     codeService;
	/**
	 * @方法名：showManagementTown 
	 * @描述:  同城同业
	 * @创建时间：2015年11月13日 下午4:13:27
	 * @param model
	 * @param bean
	 */
	
	public void showManagementTown(ModelMap model,ManagementDetailBean bean){
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		// 时间
		String mdlDate = bean.getMdlDate();
		if (mdlDate == null || "".equals(mdlDate)) {
			bean.setMdlDate(DateUtil.getCuurentDate());
		}
		// 分页查询
		List<ManagementDetailBean> list = managementDao.selectPageTown(bean, model);
		for (int i = 0; i < list.size(); i++) {
			ManagementDetailBean detail = list.get(i);
			
			// 签证类型
			String mdlNtype = detail.getMdlNtype();
			if (mdlNtype != null && !"".equals(mdlNtype)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.NTYPE, mdlNtype);
				detail.setMdlNtype(str);
			}
			// 入境次数
			String mdlNum = detail.getMdlNum();
			if (mdlNum != null && !"".equals(mdlNum)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.ENTRYNUM, mdlNum);
				detail.setMdlNum(str);
			}
			//送签地
			String mdlSend = detail.getMdlSend();
			if (mdlSend != null&& !"".equals(mdlSend)) {
				String Str = codeService.getValueByCodeKeys(DictionaryUtil.SEND, mdlSend);
				detail.setMdlSend(Str);
		    }
			//国家
			String mdlAddress = detail.getMdlAddress();
			if (mdlAddress != null&& !"".equals(mdlAddress)){
				String str =codeService.getValueByCodeKeys(DictionaryUtil.COUNTRY,mdlAddress);
				detail.setMdlAddress(str);
			}
		}
		// 回传信息
		model.put("managementList", list);
	}
	
	
	/**
	 * @Title: deleteMaterial 
	 * @Description: 删除材料
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 上午4:23:31 
	 * @throws
	 */
	public Integer deleteMaterial(Integer id){
		this.managementMaterialDao.deleteById(id);
		return CommonUtil.SUCCESS;
	}
	
	/**
	 * @方法名：showManagement 
	 * @描述: 签证列表
	 * @作者：  贺渊博
	 * @创建时间：2015年11月11日 下午3:22:52
	 * @param model
	 * @param bean
	 */
	public void showManagement(ModelMap model,ManagementDetailBean bean) {
		//公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		// 分页查询
		List<ManagementDetailBean> list = managementDao.selectPageManagement(bean, model);
		for (int i = 0; i < list.size(); i++) {
			ManagementDetailBean detail = list.get(i);
			
			// 签证类型
			String mdlNtype = detail.getMdlNtype();
			if (mdlNtype != null && !"".equals(mdlNtype)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.NTYPE, mdlNtype);
				detail.setMdlNtype(str);
			}
			// 入境次数
			String mdlNum = detail.getMdlNum();
			if (mdlNum != null && !"".equals(mdlNum)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.ENTRYNUM, mdlNum);
				detail.setMdlNum(str);
			}
			//送签地
			String mdlSend = detail.getMdlSend();
			if (mdlSend != null&& !"".equals(mdlSend)) {
				String Str = codeService.getValueByCodeKeys(DictionaryUtil.SEND, mdlSend);
				detail.setMdlSend(Str);
		    }
		}
		// 回传信息
		model.put("managementList", list);
	}

	/**
	 * @描述: 新增签证信息
	 * @作者: 
	 * @创建时间: 2015年11月30日 下午9:18:55
	 * @param model
	 * @param bean
	 * @param request
	 * @return
	 */
	public int insert(ModelMap model, ManagementDetailBean bean, HttpServletRequest request) {
		
		try {
			// 添加时上下架默认添加为下架，0代表下架
			bean.setMdlIsDelStatus("0");
			bean.setMdlCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			bean.setMdlCreateuser(CommonUtil.getLoginName());
			bean.setCpyId(CommonUtil.getCpyId());
			// 插入数据
			Integer result = managementDao.insertManagement(bean);
			
			// 当新增成功，返回ID，更新编码
			if(result == CommonUtil.SUCCESS) {
				Integer ID = bean.getId();//该条数据ID
				Integer cpyID = bean.getCpyId();//公司ID
				//获取产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_MANAGEMENT, cpyID,ID);
				bean.setMdlCode(code);
				//更新编码
				result = managementDao.updatecode(bean);
				
				// 更新材料
				updateMaterial(request, ID);
			}
			return CommonUtil.SUCCESS;
		} catch(Exception e) {
			return CommonUtil.error(getClass(),e);
		}
	}
	
	/**
	 * @描述: 公共
	 * @作者: maoxian
	 * @创建时间: 2015年11月23日 上午1:45:24 
	 * @param request
	 * @param mdlId
	 */
	public void updateMaterial(HttpServletRequest request,Integer mdlId){
		
		//类别
		String[] ammlNtype    = request.getParameterValues("mmlNtype");
		//名称
		String[] ammlMaterial = request.getParameterValues("mmlMaterial");
		//说明
		String[] ammlKnow     = request.getParameterValues("mmlKnow");
		//图片
		String[] ammlImg      = request.getParameterValues("mmlImg");
		//文本
		String[] ammlText     = request.getParameterValues("mmlText");
		//ID
		String[] ammlid		  = request.getParameterValues("mmlId");
		
		//如果类别大于0
		if(null != ammlNtype && ammlNtype.length > 0) {
			//数组
			List<ManagementMaterialBean> list = new ArrayList<ManagementMaterialBean>();
			
			for(int i = 0 ;i< ammlNtype.length ;i++) {
				
				// 判断材料类型和材料名称是否为空
				if(StringUtils.isEmpty(ammlNtype[i]) && StringUtils.isEmpty(ammlMaterial[i])) continue;
				
				// 材料bean
				ManagementMaterialBean m = new  ManagementMaterialBean();
				m.setMmlNtype(ammlNtype[i]);
				m.setMmlMaterial(ammlMaterial[i]);
				m.setMmlKnow(ammlKnow[i]);
				m.setMmlImg(ammlImg[i]);
				m.setMmlText(ammlText[i]);
				m.setMmlCreatetime(new Date());
				m.setCpyId(CommonUtil.getCpyId());
				m.setMdlId(mdlId);
				
				// 判断材料ID是否为空
				if(null != ammlid && ammlid.length > 0) {
					// 材料ID
					String ammId = ammlid[i];
					if(StringUtils.isNotBlank(ammId)) {
						m.setId(Integer.parseInt(ammId));
						managementMaterialDao.update(m);
					} else {
						// ID为null，则添加到list
						list.add(m);
					}
				} else {
					// ID为null
					list.add(m);
				}
			}
			if(null != list && list.size() > 0) {
				// 批量新增
				managementMaterialDao.insertListBean(list);
			}
		}
	}

	/**
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, ManagementDetailBean bean,HttpServletRequest request) {
		
		try {
			// 执行修改签证基础信息
			managementDao.updateManagement(bean);
			// 执行更新材料
			updateMaterial(request, bean.getId());
			
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名：     updatePrice 
	 * @描述:   修改签证价格
	 * @作者：       贺渊博
	 * @创建时间：2015年10月27日 下午4:12:47
	 * @param model
	 * @param bean
	 * @return int  返回类型
	 *
	 */
	public int updatePrice(ModelMap model,ManagementDetailBean bean){
		try {
			
			managementDao.updatePrice(bean);
			return CommonUtil.SUCCESS;
		}catch (Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public int delete(ManagementDetailBean managementDetailBean) {
		try{
			managementDao.deleteManagement(managementDetailBean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model) {
		//签证类型
		model.addAttribute("models",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.NTYPE)); 
		//签证人
		model.addAttribute("attestor",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTESTOR));
		//入境次数
		model.addAttribute("entry",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ENTRYNUM));
		//面签需要
		model.addAttribute("face",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.INTERVIEW));
		//国家
		model.addAttribute("guojia",this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.COUNTRY));
		//预定方式
	    model.addAttribute("scheduled",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULE));
		//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
		//送签地
		model.addAttribute("send",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEND));
	}
	
	/**
	 * @描述: 根据主键查询指定的实体
	 * @作者: 
	 * @创建时间: 2015年11月30日 下午9:46:54
	 * @param model
	 * @param id
	 * @return 返回签证实体对象
	 */
	public ManagementDetailBean selectManagement(ModelMap model, Integer id) {
		
		// 执行查询签证基础信息
		ManagementDetailBean detail = managementDao.selectManagement(id);
		
		// 在职List
		List<ManagementMaterialBean> l1 = new ArrayList<ManagementMaterialBean>();
		// 自由职业List
		List<ManagementMaterialBean> l2 = new ArrayList<ManagementMaterialBean>();
		// 在校学生List
		List<ManagementMaterialBean> l3 = new ArrayList<ManagementMaterialBean>();
		// 退休人员List
		List<ManagementMaterialBean> l4 = new ArrayList<ManagementMaterialBean>();
		// 学龄前儿童List
		List<ManagementMaterialBean> l5 = new ArrayList<ManagementMaterialBean>();
		
		// 根据签证基础信息ID查询所有签证材料信息
		List<ManagementMaterialBean> list = managementMaterialDao.selectListByMdlId(detail.getId());
		
		for(ManagementMaterialBean bean : list){
			if("在职".equals(bean.getMmlNtype())) l1.add(bean);
			if("自由职业".equals(bean.getMmlNtype())) l2.add(bean);
			if("在校学生".equals(bean.getMmlNtype())) l3.add(bean);
			if("退休人员".equals(bean.getMmlNtype())) l4.add(bean);
			if("学龄前儿童".equals(bean.getMmlNtype())) l5.add(bean);
		}
		
		// 签证材料存进map
		Map<String, List<ManagementMaterialBean>> map = new HashMap<String, List<ManagementMaterialBean>>();
		map.put("1", l1);
		map.put("2", l2);
		map.put("3", l3);
		map.put("4", l4);
		map.put("5", l5);
		model.addAttribute("mapMaterial", map);
		
		return detail;
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
	public int update1(ModelMap model, ManagementDetailBean bean) {
		try {
			managementDao.scheduledManagement(bean);
			
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * 
	 * @Title: selectManagement
	 * @Description: 根据主键查询指定的实体- 查看
	 * @param @param id
	 * @param @return    设定文件
	 * @return ManagementDetailBean    返回签证实体对象
	 * @throws
	 */
	public ManagementDetailBean selectManagementUpdate(int id){
		
		ManagementDetailBean bean = managementDao.selectManagement(id);
		
		String mdlNtype = bean.getMdlNtype();
		if (mdlNtype != null && !"".equals(mdlNtype)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.NTYPE, mdlNtype);
			bean.setMdlNtype(str);
		}
		return bean;
	}
	
	public String getGuojiaForQuery(ExtHashMap map){
	    Iterator iter = map.entrySet().iterator();
	    String s = "";
	    while(iter.hasNext()){
	       Entry entry = (Entry) iter.next();
	       Object a = entry.getValue();
	       s += a.toString()+",";
	    }
	    return s;
	}
	
}