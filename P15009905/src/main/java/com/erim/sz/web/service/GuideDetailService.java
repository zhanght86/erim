package com.erim.sz.web.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.web.dao.GuideDetailDao;
import com.erim.sz.web.tm.service.TmSystemRegionService;

/**
 * @ClassName: GuideDetailService 
 * @Description: 导游接口 
 * @author maoxian
 * @date 2015年9月10日 上午10:51:56 
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideDetailService {

	@Autowired
	private GuideDetailDao guideDetailDao;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	/**
	 * @Title: selectGuideByGdlCodePwd 
	 * @Description: 根据导游证号获取导游信息
	 * @param @param gdlCode
	 * @param @return    设定文件 
	 * @return GuideDetailBean    返回类型 
	 * @throws
	 */
	public GuideDetailBean selectGuideByGdlCodePwd(String gdlCode){
		return this.guideDetailDao.selectGuideByGdlCodePwd(gdlCode);
	}
	
	/**
	 * @描述: 根据导游id获取一条导游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午2:33:49
	 * @param id
	 * @return
	 */
	public GuideDetailBean getGuideDetailById(Integer id) {
		
		return guideDetailDao.getGuideDetailById(id);
	}
	
	/**
	 * @描述: 获取导游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午4:16:56
	 * @return
	 */
	public void getGuideDetail(ModelMap map) {
		Integer id = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
		GuideDetailBean detailBean = guideDetailDao.getGuideDetailById(id);
		// 处理城市字段
		detailBean = cityUtil(detailBean);
		map.addAttribute("guideInfo", detailBean);
	}
	
	/**
     * @描述: 处理城市字段
     * @作者: 宁晓强
     * @创建时间: 2015年12月22日 上午10:15:20
     * @param bean
     */
    public GuideDetailBean cityUtil(GuideDetailBean bean) {
    	// 国内地陪城市
    	String localCity = bean.getGdlLocalCity();
    	if (localCity != null && !"".equals(localCity)) {
    		String[] acity = localCity.split(",");
    		String str = "";
    		if (acity.length > 1) {
    			for (int j = 0; j < acity.length-1; j++) {
    				if (StringUtils.isEmpty(acity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[acity.length-1]));
    		} else if (acity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[0]));
    		}
    		bean.setGdlLocalCity(str);
    	}
    	// 国内全陪
    	String nationalCity = bean.getGdlNationalCity();
    	if (nationalCity != null && !"".equals(nationalCity)) {
    		String[] anationalCity = nationalCity.split(",");
    		String str = "";
    		if (anationalCity.length > 1) {
    			for (int j = 0; j < anationalCity.length-1; j++) {
    				if (StringUtils.isEmpty(anationalCity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[anationalCity.length-1]));
    		} else if (anationalCity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[0]));
    		}
    		bean.setGdlNationalCity(str);
    	}
    	// 国际港澳台领队
    	String leaderCity = bean.getGdlLeaderCity();
    	if (leaderCity != null && !"".equals(leaderCity)) {
    		String[] aleaderCity = leaderCity.split(",");
    		String str = "";
    		if (aleaderCity.length > 1) {
    			for (int j = 0; j < aleaderCity.length-1; j++) {
    				if (StringUtils.isEmpty(aleaderCity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[aleaderCity.length-1]));
    		} else if (aleaderCity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[0]));
    		}
    		bean.setGdlLeaderCity(str);
    	}
    	return bean;
    }
	
	/**
	 * @描述: 修改密码
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月30日 上午11:17:03
	 * @param request
	 * @return
	 */
	public Integer updatePad(HttpServletRequest request) {
		
		// 原密码
		String oldPassword = request.getParameter("oldPassword");
		if (StringUtils.isNotBlank(oldPassword)) {
			GuideDetailBean bean = (GuideDetailBean) SecurityUtils.getSubject().getSession().getAttribute("guideDetail");
			if (!oldPassword.equals(bean.getGdlPwd())) {
				return 2;
			}
		}
		
		// 新密码
		String gdlPwd = request.getParameter("gdlPwd");
		if (StringUtils.isNotBlank(gdlPwd)) {
			// 获取用户ID
			Integer guideId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
			GuideDetailBean bean = new GuideDetailBean();
			bean.setId(guideId);// id
			bean.setGdlPwd(gdlPwd); // 密码
			// 执行修改
			return guideDetailDao.updateGuidePsd(bean);
		}
		return 2;
	} 
	
	/**
	 * @描述: 保存导游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午4:00:22
	 * @param guideDetailBean
	 */
	public void update(ModelMap map, GuideDetailBean bean){
		// 设置ID
		bean.setId((Integer)SecurityUtils.getSubject().getSession().getAttribute("id"));
		// 执行修改
		guideDetailDao.update(bean);
		// 获取数据
		getGuideDetail(map);
	}
	
	/**
	 * @Title: login 
	 * @Description: 登录方法
	 * @param @param model
	 * @param @param username
	 * @param @param password    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public boolean login(ModelMap model,String username,String password){
		//如果都不为空
    	if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
    		//登录
    		boolean b = this.isLogin(model, username, password);
    		if(!b){
    			model.addAttribute("message", "账号密码错误!");	
    			return false;
    		}
    		else {
    			return true;
    		}
    	}
    	model.addAttribute("message", "账号密码不能为空!");
    	return false;
	}
	
	/**
	 * @Title: isLogin 
	 * @Description: 登录
	 * @param @param model
	 * @param @param username
	 * @param @param password
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean isLogin(ModelMap model,String username,String password){
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			// shiro token
	        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

	        try {
	            SecurityUtils.getSubject().login(token);
	            return true;
	        } catch (AuthenticationException e) {
	            model.put("errorMsg", e.getMessage());
	            return false;
	        }
		}
        return false;
	}
}