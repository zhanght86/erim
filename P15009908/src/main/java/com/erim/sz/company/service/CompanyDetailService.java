package com.erim.sz.company.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cafeteria.dao.CafeteriaDetailDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.CompanyContactPersonBean;
import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.PubSametownBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TransticketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.mail.MailUtil;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.company.dao.CompanyContactPersonDao;
import com.erim.sz.company.dao.CompanyDetailDao;
import com.erim.sz.cus.bean.CusSystemFuncRescourceBean;
import com.erim.sz.cus.bean.CusSystemRoleBean;
import com.erim.sz.cus.bean.CusSystemRoleFuncBean;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.dao.CusSystemRoleDao;
import com.erim.sz.cus.dao.CusSystemUserDao;
import com.erim.sz.cus.service.CusSystemFuncRescourceService;
import com.erim.sz.cus.service.CusSystemRoleFuncService;
import com.erim.sz.ground.dao.GroundDetailDao;
import com.erim.sz.guide.dao.GuideDetailDao;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.planeticket.dao.PlaneticketDetailDao;
import com.erim.sz.sameTown.dao.PubSametownDao;
import com.erim.sz.texi.dao.TexiDetailDao;
import com.erim.sz.ticket.dao.TicketDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.transticket.dao.TransticketDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.utils.ip.IP4;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CompanyDetailService
 * @Description: 
 * @Author: 宁晓强
 * @Date: 2015年10月1日 下午3:58:11
 */
@Service("companyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyDetailService {

	@Autowired
	private CompanyDetailDao 			  companyDetailDao;
	@Autowired
	private CodeService 			      codeService;
	@Autowired
	private CompanyContactPersonService   companyContactPersonService;
	@Autowired
	private CusSystemRoleDao 			  cusSystemRoleDao;
	@Autowired
	private CusSystemUserDao 			  cusSystemUserDao;
	@Autowired
	private TmSystemRegionService 		  tmSystemRegionService;
	@Autowired
	private CompanyContactPersonDao 	  companyContactPersonDao;
	@Autowired
	private CusSystemFuncRescourceService cusSystemFuncRescourceService;
	@Autowired
	private CusSystemRoleFuncService  	  cusSystemRoleFuncService;
	@Autowired
	private CompanyBusinessDao	 		  companyBusinessDao;
	@Autowired
	private HotelDetailDao			      hotelDetailDao;
	@Autowired
	private TicketDetailDao				  ticketDetailDao;
	@Autowired
	private TexiDetailDao				  texiDetailDao;
	@Autowired
	private GroundDetailDao  			  groundDetailDao;
	@Autowired
	private GuideDetailDao				  guideDetailDao;
	@Autowired
	private CafeteriaDetailDao			  cafeteriaDetailDao; 
	@Autowired
	private TransticketDetailDao		  transticketDetailDao;
	@Autowired
	private PubSametownDao				  pubSametownDao;
	@Autowired
	private PlaneticketDetailDao		  planeticketDetailDao;
	
	
	/**
	 * @Title: selectBeanById 
	 * @Description: 根据企业id查询企业基础信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @throws
	 */
	public CompanyDetailBean selectBeanById(int id){
		return companyDetailDao.selectBeanById(id);
	}
	
	/**
	 * @描述: 销售资源 数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月3日 下午4:27:56
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<CompanyDetailBean> selectPage(CompanyDetailBean baseBean, ModelMap model) {
		
		List<CompanyDetailBean> list = companyDetailDao.selectPage(baseBean, model);
		//转码
		for(int i = 0;i < list.size(); i++) {
			CompanyDetailBean detail = list.get(i);
			
			// 获取公司ID
			Integer cpyId = detail.getId();
			// 根据公司ID获取一条公司联系人信息
			CompanyContactPersonBean person = companyContactPersonDao.getPersonById(cpyId);
			if (person != null) {
				// 公司负责人
				detail.setCcpName(person.getCcpName());
				// 负责人电话
				detail.setCcpTelephone(person.getCcpTelephone());
			}
			
			// 根据公司ID获取业务范围信息
			CompanyBusinessBean businessBean = companyBusinessDao.getBusinessById(cpyId);
			if (businessBean != null) {
				// 计调
				detail.setCbsOperator(businessBean.getCbsOperator());
				// 计调电话
				detail.setCbsOperatorPhone(businessBean.getCbsOperatorPhone());
			}
			
			//省
			String Province = detail.getCpyProvince();
			if (Province != null && !"".equals(Province)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(Province));
				detail.setCpyProvince(str);
			}
			//市
			String City = detail.getCpyCity();
			if (City != null && !"".equals(City)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(City));
				detail.setCpyCity(str);
			}
		}
		//省市县
		//model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		return list;
    }
	
	/**
	 * @Title: insert
	 * @Description: 插入方法 -废弃
	 * @param companyDetailBean
	 * @param companyContactPersonBean
	 * @param cusSystemUserBean
	 * @param request
	 * @return
	 *	
	 */
	public Integer insert(CompanyDetailBean companyDetailBean,
	           CompanyContactPersonBean companyContactPersonBean,
			   CusSystemUserBean cusSystemUserBean,
			   HttpServletRequest request){
		
		try{
			
			////////////////////////////////////////插入公司表///////////////////////////////////////////////////////////
			//获取当前时间
			companyDetailBean.setCpyCreatedate(new Date());
			//是否审核为否
			companyDetailBean.setCpyIsThrough(ErimConstants.YESORNO_NO);
			//获取当前ip
			companyDetailBean.setCpyCreateip(IP4.getIP4(request));
			this.companyDetailDao.insert(companyDetailBean);
			
			////////////////////////////////////////插入联系人表//////////////////////////////////////////////////////////
			
			companyContactPersonBean.setCpyId(companyDetailBean.getId());
			this.companyContactPersonService.insert(companyContactPersonBean);
			
			////////////////////////////////////////插入角色表///////////////////////////////////////////////////////////
			
			CusSystemRoleBean roleBean = new CusSystemRoleBean();
			roleBean.setCusRoleName("主账号");
			roleBean.setCpyId(companyDetailBean.getId());
			// this.cusSystemRoleService.insert(roleBean);
			
			////////////////////////////////////////插入用户表///////////////////////////////////////////////////////////
			
			cusSystemUserBean.setCusRoleId(roleBean.getId());
			cusSystemUserBean.setCpyId(companyDetailBean.getId());
			cusSystemUserBean.setCusIsThrough(ErimConstants.YESORNO_NO);
			cusSystemUserBean.setCusUserPassword(DigestUtils.md5Hex(cusSystemUserBean.getCusUserPassword()));
			// this.cusSystemUserService.insert(cusSystemUserBean);
			
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名: insertCompany
	 * @描述: 新增公司信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午3:03:39 
	 * @param bean
	 * @return
	 */
	public Integer insertCompany(CompanyDetailBean companyBean, 
			CompanyContactPersonBean personBean, ModelMap map, HttpServletRequest request) {
		
		try {
			Integer id = companyBean.getId();
			
			// 保存前，先清空应为空的字段
			// 是否国内
			String cpyIsInland = companyBean.getCpyIsInland();
			// 是国内
			if (ErimConstants.YESORNO_YES.equals(cpyIsInland)) {
				// 清楚港澳台
				companyBean.setCpyExternal(null);
				// 国际
				companyBean.setCpyForeign(null);
				// 国际城市
				companyBean.setCpyForeignCity(null);
			} else if (ErimConstants.YESORNO_NO.equals(cpyIsInland)) { // 是国际
				// 清空省市县
				companyBean.setCpyProvince(null);
				companyBean.setCpyCity(null);
				companyBean.setCpyCounty(null);
				if (!"04".equals(companyBean.getCpyExternal())) {
					// 国际
					companyBean.setCpyForeign(null);
					// 国际城市
					companyBean.setCpyForeignCity(null);
				}
			}
			
			// 当ID不等于null时则为修改
			if (id != null && !"".equals(id)) {
				// 执行修改公司基础信息
				companyDetailDao.updateInfo(companyBean);
				personBean.setCpyId(id);
				// 执行修改公司联系人信息
				companyContactPersonService.update(personBean);
				SecurityUtils.getSubject().getSession().setAttribute("cpyId", id);
				return CommonUtil.SUCCESS;
			}
			/*
			 * 公司基础信息
			 */
			//获取当前时间
			companyBean.setCpyCreatedate(new Date());
			//是否审核为否
			companyBean.setCpyIsThrough(ErimConstants.YESORNO_NO);
			//获取当前ip
			companyBean.setCpyCreateip(IP4.getIP4(request));
			// 公司类型-生产商
			companyBean.setCpyRoe(ErimConstants.COMPANYROLE_CREATER);
			companyDetailDao.insertInfo(companyBean);
			/*if (CommonUtil.SUCCESS.equals(reuslt)) {
				Integer cpyId = companyBean.getId();
				String cpyLogo = companyBean.getCpyImg();
				cpyLogo = cpyLogo.replace("$cpyId", cpyId.toString());
				companyBean.setCpyImg(cpyLogo);
				// 执行修改Logo
				companyDetailDao.updateCpyLogo(companyBean);
			}*/
			
			/*
			 * 联系人信息
			 */
			Integer cpyId = companyBean.getId();
			personBean.setCpyId(cpyId);
			companyContactPersonDao.insert(personBean);
			
			SecurityUtils.getSubject().getSession().setAttribute("cpyId", cpyId);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名: insertLoginUser
	 * @描述: 新增登陆信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 上午11:19:15 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertLoginUser(ModelMap map, CusSystemUserBean bean, Integer cpyId) {
		
		Integer result = CommonUtil.ERROR;
		/**
		 * 验证登录名是否存在
		 */
		CusSystemUserBean userBean = new CusSystemUserBean();
		// 登录名
		String userName = bean.getCusUserLoginname();
		userBean = cusSystemUserDao.selectUserByLoginname(userName);
		// 当登录名已存在时，直接返回失败。
		if (userBean != null) {
			return  CommonUtil.USERREPETITION;
		}
				
		try {
			// 公司ID
			cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
			
			/**
			 * 插入角色
			 */
			CusSystemRoleBean roleBean = new CusSystemRoleBean();
			roleBean.setCusRoleName("主账号");
			roleBean.setCpyId(cpyId);
			cusSystemRoleDao.insert(roleBean);
			
			/**
			 * 插入权限
			 */
			List<CusSystemFuncRescourceBean> listFunc = this.cusSystemFuncRescourceService.selectAll();
			List<CusSystemRoleFuncBean> listRoleFuncBean = new ArrayList<CusSystemRoleFuncBean>();
			for(CusSystemFuncRescourceBean res : listFunc){
				CusSystemRoleFuncBean rolefunbean = new CusSystemRoleFuncBean();
				rolefunbean.setCusRoleId(roleBean.getId());
				rolefunbean.setCusFuncCode(res.getCusFuncRescourceCode());
				listRoleFuncBean.add(rolefunbean);
			}
			this.cusSystemRoleFuncService.insertList(listRoleFuncBean);;
			
			/**
			 * 插入用户
			 */
			bean.setCusRoleId(roleBean.getId());
			bean.setCpyId(cpyId);
			bean.setCusIsThrough(ErimConstants.YESORNO_NO);
			bean.setCusUserPassword(DigestUtils.md5Hex(bean.getCusUserPassword()));
			
			// 保存前，先清空该企业ID下面所有用户，防止重复
			cusSystemUserDao.deleteUserByCpyId(bean);
			// 执行新增
			cusSystemUserDao.insert(bean);
			
			// 发送邮件
			sendMail(cpyId);
			
			result = CommonUtil.SUCCESS;
		} catch (Exception e) {
			result = CommonUtil.ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @描述: 发送邮件
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月2日 下午5:25:07
	 * @param cpyId
	 */
	public void sendMail(Integer cpyId) {
		
		// 根据ID获取一条公司信息
		CompanyDetailBean company = selectById(cpyId);
		// 邮箱
		String cpyEmail = company.getCpyEmail();
		
		// 发送邮件
		MailUtil.sendMail(cpyEmail);
	}
	
	/**
	 * @Title: selectById 
	 * @Description: 获取公司id
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @throws
	 */
	public CompanyDetailBean selectById(Integer id){
		return companyDetailDao.getDetailbyId(id);
	}
	
	/**
	 * @方法名: getDetailById
	 * @描述: 公司基础信息修改页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午2:06:14 
	 * @param bean
	 * @return
	 */
	public CompanyDetailBean showInfoPage(ModelMap map, CompanyBusinessBean bean) {
		CompanyDetailBean model = new CompanyDetailBean();
		// 公司ID
		Integer id = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
		// 根据ID获取一条公司基础信息
		model = companyDetailDao.getDetailbyId(id);
		map.addAttribute("companyDetail", model);
		
		// 根据公司ID获取一条联系人信息
		CompanyContactPersonBean person = new CompanyContactPersonBean();
		person.setCpyId(id);
		CompanyContactPersonBean personModel = companyContactPersonService.getPersonById(person);
		map.addAttribute("personDetail", personModel);
		
		return model;
	}
	
	/**
	 * @Title: insertAll 
	 * @Description: 同城同业选择所有
	 * @param @param ntype
	 * @param @param cid
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insertAll(String ntype,Integer cid){
		//同城同业只能当前省 获取服务范围
		CompanyBusinessBean bussinessBean =  this.companyBusinessDao.getBusinessById(CommonUtil.getCpyId());
		if(null != bussinessBean){
			CompanyDetailBean bean = this.getBean(bussinessBean, new CompanyDetailBean(), ntype, cid);
			if(null != bean){
				//查询
				List<CompanyDetailBean> list = this.companyDetailDao.selectSameTownList(bean);
				
				List<PubSametownBean> listSame = new ArrayList<PubSametownBean>();
				for(CompanyDetailBean company : list){
					PubSametownBean be = new PubSametownBean();
					be.setCpyidFrom(CommonUtil.getCpyId());
					be.setCpyidTo(company.getId());
					be.setCid(cid);
					be.setNtype(ntype);
					listSame.add(be);
				}
				return null!=listSame?this.pubSametownDao.insertList(listSame):0;
			}
			return 0;
		}
		return 0;
	}
	
	/**
	 * @描述: 没写注释？
	 * @作者: 
	 * @创建时间: 
	 * @param bussinessBean
	 * @param baseBean
	 * @param ntype
	 * @param cid
	 * @return
	 */
	public CompanyDetailBean getBean(CompanyBusinessBean bussinessBean,CompanyDetailBean baseBean,String ntype,Integer cid){
		// 业务范围 01组团社 02国际专线商 03地接社 04产品直营
		String cbsService = bussinessBean.getCbsService();
		
		// 如果直营查询本省用户
		if("04".equals(cbsService)){
			CompanyDetailBean companyDetai = (CompanyDetailBean)SecurityUtils.getSubject().getSession().getAttribute("userCommpany");
			baseBean.setCpyProvince(companyDetai.getCpyProvince());
		}else if("03".equals(cbsService)){
			
			//酒店
			if(ErimConstants.TOWN_HOTEL.equals(ntype)){
				HotelDetailBean bean =  this.hotelDetailDao.getHotelDetailById(cid);
				
				baseBean.setTownProvince(bean.getHdlProvince());
				baseBean.setTownCity(bean.getHdlCity());
				baseBean.setTownTown(bean.getHdlCounty());
				//港澳台
				baseBean.setTownRanInterna(bean.getHdlExternal());
				//国家
				baseBean.setTownRanState(bean.getHdlForeign());
				
				baseBean.setTownNtype(ErimConstants.TOWN_HOTEL);
			}
			
			//门票
			if(ErimConstants.TOWN_TICKET.equals(ntype)){
				TicketDetailBean bean = this.ticketDetailDao.getTicketById(cid);
				
				baseBean.setTownProvince(bean.getTdlProvince());
				baseBean.setTownCity(bean.getTdlCity());
				baseBean.setTownTown(bean.getTdlCounty());
				//港澳台
				baseBean.setTownRanInterna(bean.getTdlNation());
				
				//国家
				baseBean.setTownRanState(bean.getTdlCountyone());
				baseBean.setTownNtype(ErimConstants.TOWN_TICKET);
			}
			//租车
			if(ErimConstants.TOWN_TEXI.equals(ntype)){
				TexiDetailBean bean =  this.texiDetailDao.getTexiDetialById(cid);
				
				baseBean.setTownProvince(bean.getTdlProvince());
				baseBean.setTownCity(bean.getTdlCity());
				baseBean.setTownTown(bean.getTdlCounty());
				
				//港澳台
				baseBean.setTownRanInterna(bean.getTdlExternal());
				//国家
				baseBean.setTownRanState(bean.getTdlForeign());
				
				baseBean.setTownNtype(ErimConstants.TOWN_TEXI);
			}
			//当地旅游
			if(ErimConstants.TOWN_GROUND.equals(ntype)){
				GroundDetailBean bean =  this.groundDetailDao.selectById(cid);
				baseBean.setTownProvince(bean.getGddProvice());
				baseBean.setTownCity(bean.getGddCity());
				baseBean.setTownTown(bean.getGddCounty());
				//港澳台
				baseBean.setTownRanInterna(bean.getGddCountylocation());
				//国家
				baseBean.setTownRanState(bean.getGddMajorcountries());
				baseBean.setTownNtype(ErimConstants.TOWN_GROUND);
			}
			//特色餐
			if(ErimConstants.TOWN_CAFETERIA.equals(ntype)){
				CafeteriaDetailBean bean =  this.cafeteriaDetailDao.selectCafeteria(cid);
				
				baseBean.setTownProvince(bean.getCdlProvince());
				baseBean.setTownCity(bean.getCdlCity());
				baseBean.setTownTown(bean.getCdlCounty());
				
				//港澳台
				baseBean.setTownRanInterna(bean.getCdlExternal());
				//国家
				baseBean.setTownRanState(bean.getCdlForeign());
				baseBean.setTownNtype(ErimConstants.TOWN_CAFETERIA);
			}
			//飞机
			if(ErimConstants.TOWN_PLANETICKET.equals(ntype)){
				PlaneticketDetailBean bean =  this.planeticketDetailDao.selectPlaneticket(cid);
				
				baseBean.setTownProvince(bean.getPtdStartProvince());
				baseBean.setTownCity(bean.getPtdStartCity());
				baseBean.setTownTown(bean.getPtdStartTown());
				
				//港澳台
				//baseBean.setTownRanInterna(bean.get);
				baseBean.setTownNtype(ErimConstants.TOWN_PLANETICKET);
			}
			//导游
			if(ErimConstants.TOWN_GUIDE.equals(ntype)){
				GuideDetailBean bean =  this.guideDetailDao.selectById(cid);
				// 省
				baseBean.setaTownProvince(StringUtils.isNotBlank(bean.getGdlLocalProvince()) && !",".equals(bean.getGdlLocalProvince())?bean.getGdlLocalProvince().split(","):null);
				// 市
				baseBean.setaTownCity(StringUtils.isNotBlank(bean.getGdlLocalCity()) && !",".equals(bean.getGdlLocalCity())?bean.getGdlLocalCity().split(","):null);
				// 县
				String county = bean.getGdlLocalCounty();
				if (county != null && !"".equals(county)) {
					String[] aTownTown = county.split(",");
					if (aTownTown.length > 0) { // 当有县时
						baseBean.setaTownTown(aTownTown);
					} else {
						baseBean.setaTownTown(null);
					}
				}
				//港澳台
				if(StringUtils.isNotBlank(bean.getGdlGaidLokal())){
					baseBean.setaTownRanInterna(bean.getGdlGaidLokal().split(","));
				}
				//国家
				baseBean.setTownRanState(bean.getGdlGaidCountry());
				baseBean.setTownNtype(ErimConstants.TOWN_GUIDE);
			}
			//火车
			if(ErimConstants.TOWN_TRANSTICKET.equals(ntype)){
				TransticketDetailBean bean =  this.transticketDetailDao.selectTransticket(cid);
				
				baseBean.setTownProvince(bean.getTtdStartProvinces());
				baseBean.setTownCity(bean.getTtdStartCity());
				baseBean.setTownTown(bean.getTtdStartTown());
				baseBean.setTownNtype(ErimConstants.TOWN_TRANSTICKET);
			}
		}
		baseBean.setId(CommonUtil.getCpyId());
		return baseBean;
	}
	
	/**
	 * @描述: 企业列表
	 * @作者: 
	 * @创建时间: 2015年12月3日 下午4:25:12
	 * @param baseBean
	 * @param model
	 * @param ntype
	 * @param cid
	 */
	public void selectPageCafeteria(CompanyDetailBean baseBean, ModelMap model,String ntype,Integer cid){
		//分页
		baseBean.setN(10);
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_CREATER);
		
		//同城同业只能当前省 获取服务范围
		CompanyBusinessBean bussinessBean =  this.companyBusinessDao.getBusinessById(CommonUtil.getCpyId());
		
		if(null != bussinessBean){
			//设置
			baseBean = getBean(bussinessBean, baseBean, ntype, cid);
			
			// 查询同城列表
			List<CompanyDetailBean> list =  companyDetailDao.selectPageCafeteria(baseBean, model);

			model.addAttribute("companyList", list);
		}
	}
	
	/**
	 * @方法名: setCode
	 * @描述: 设置字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月29日 上午9:44:43 
	 * @param map
	 */
	public void setCode(ModelMap map) {
		// 省
		map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//国家
		map.addAttribute("guojia", codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY));
	}
	
	
	/**
	 * @Title: lockCpy 
	 * @Description: 用户锁定
	 * @param @param cpyid    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午11:37:54 
	 * @throws
	 */
	public void lockCpy(Integer cpyid){
		this.companyDetailDao.lockCpy(cpyid);
	}
	
	/**
	 * @Title: unlock 
	 * @Description: 解除锁定
	 * @param @param cpyid    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午12:29:23 
	 * @throws
	 */
	public void unlock(Integer cpyid){
		this.companyDetailDao.unlock(cpyid);
	}
}
