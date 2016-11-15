package com.erim.sz.zy.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemCooperationBean;
import com.erim.sz.zy.dao.ZySystemCooperationDao;

/**
 * @ClassName: ZySystemCooperationService 
 * @Description: 共享用户权限分类
 * @author maoxian
 * @date 2015年11月5日 上午2:08:45
 */
@Service("zySystemCooperationService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemCooperationService {

	@Autowired
	private ZySystemCooperationDao zySystemCooperationDao;
	
	/**
     * @Title: selectCooperationByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<ZySystemCooperationBean>    返回类型 
     * @throws
     */
    public void selectCooperation(ModelMap model, String ntype,String cid){
    	ZySystemCooperationBean zySystemCooperationBean = new ZySystemCooperationBean();
    	zySystemCooperationBean.setCooNtype(ntype);
    	zySystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	
    	if(StringUtils.isNotBlank(cid)) zySystemCooperationBean.setCooCid(Integer.parseInt(cid));
    	model.addAttribute("listCooperation", this.zySystemCooperationDao.selectCooperation(zySystemCooperationBean));
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
    	ZySystemCooperationBean zySystemCooperationBean = new ZySystemCooperationBean();
    	zySystemCooperationBean.setCooNtype(ntype);
    	zySystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	zySystemCooperationBean.setRoleId(CommonUtil.getRoleId());
    	List<ZySystemCooperationBean> listBean =  this.zySystemCooperationDao.selectCooperation(zySystemCooperationBean);
    	if(null != listBean && listBean.size()>0){
    		ZySystemCooperationBean bean = listBean.get(0);
    		return bean.getCooCid();
    	}
    	return 0;
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param zySystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(ZySystemCooperationBean zySystemCooperationBean){
    	zySystemCooperationBean.setCooCreatetime(new Date());
    	zySystemCooperationBean.setCooCreateuser(CommonUtil.getLoginName());
    	zySystemCooperationBean.setCpyId(CommonUtil.getCpyId());
    	//删除重复权限
    	this.zySystemCooperationDao.delete(zySystemCooperationBean);
    	//添加现有权限
    	this.zySystemCooperationDao.insert(zySystemCooperationBean);
    }
	
}