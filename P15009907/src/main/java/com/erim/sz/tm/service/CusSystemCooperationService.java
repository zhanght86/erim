package com.erim.sz.tm.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.tm.bean.CusSystemCooperationBean;
import com.erim.sz.tm.dao.CusSystemCooperationDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: CusSystemCooperationService 
 * @Description: 共享用户权限分类
 * @author maoxian
 * @date 2015年11月5日 上午2:08:45
 */
@Service("cusSystemCooperationService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemCooperationService {

	@Autowired
	private CusSystemCooperationDao cusSystemCooperationDao;
	
	/**
     * @Title: selectCooperationByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<CusSystemCooperationBean>    返回类型 
     * @throws
     */
    public void selectCooperation(ModelMap model, String ntype,String cid){
    	CusSystemCooperationBean cusSystemCooperationBean = new CusSystemCooperationBean();
    	cusSystemCooperationBean.setCooNtype(ntype);
    	cusSystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	
    	if(StringUtils.isNotBlank(cid)) cusSystemCooperationBean.setCooCid(Integer.parseInt(cid));
    	model.addAttribute("listCooperation", this.cusSystemCooperationDao.selectCooperation(cusSystemCooperationBean));
    }
    
    /**
     * @Title: getCpyIdByNtype 
     * @Description: 获取关联产品id
     * @param @param ntype
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    public Integer getCpyIdByNtype(String ntype){
    	CusSystemCooperationBean cusSystemCooperationBean = new CusSystemCooperationBean();
    	cusSystemCooperationBean.setCooNtype(ntype);
    	cusSystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	cusSystemCooperationBean.setRoleId(CommonUtil.getRoleId());
    	List<CusSystemCooperationBean> listBean =  this.cusSystemCooperationDao.selectCooperation(cusSystemCooperationBean);
    	if(null != listBean && listBean.size()>0){
    		CusSystemCooperationBean bean = listBean.get(0);
    		return bean.getCooCid();
    	}
    	return 0;
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param cusSystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(CusSystemCooperationBean cusSystemCooperationBean){
    	cusSystemCooperationBean.setCooCreatetime(new Date());
    	cusSystemCooperationBean.setCooCreateuser(CommonUtil.getLoginName());
    	cusSystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	//删除重复权限
    	this.cusSystemCooperationDao.delete(cusSystemCooperationBean);
    	//添加现有权限
    	this.cusSystemCooperationDao.insert(cusSystemCooperationBean);
    }
	
}