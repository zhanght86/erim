package com.erim.sz.company.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyDetailBean;

/**
 * @ClassName: CompanyDetailDao
 * @Description: 企业
 * @Author: 宁晓强
 * @Date: 2015年10月1日 下午4:00:04
 */
@Repository("companyDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyDetailDao extends BaseDao {

	
	/**
	 * @Title: lockCpy 
	 * @Description: 锁定公司
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午11:38:44 
	 * @throws
	 */
	public void lockCpy(Integer cpyId){
		this.getSqlSession().update("companydetail.lockCpy", cpyId);
	}
	
	/**
	 * @Title: unlock 
	 * @Description: 支付完成后解除公司锁定
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午12:31:45 
	 * @throws
	 */
	public void unlock(Integer cpyId){
		this.getSqlSession().update("companydetail.unlock", cpyId);
	}
	
	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询公司信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @throws
	 */
	public CompanyDetailBean selectBeanById(Integer id){
		return getSqlSession().selectOne("companydetail.selectBeanById", id);
	}
	
	
	
	/**
	 * @描述: 企业查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月3日 下午4:29:10
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<CompanyDetailBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("companydetail.selectPage", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
	
	/**
	 * @Title: selectList 
	 * @Description: 同城同业
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CompanyDetailBean>    返回类型 
	 * @throws
	 */
	public List<CompanyDetailBean> selectSameTownList(CompanyDetailBean baseBean) {
        return getSqlSession().selectList("companydetail.selectSameTownList", baseBean);
    }
	
	/**
	 * @Title: insert
	 * @Description: 公司注册
	 * @param companyDetailBean
	 * @return
	 */
	public int insert(CompanyDetailBean companyDetailBean){
		return this.getSqlSession().insert("companydetail.insert", companyDetailBean);
	}
	
	/**
	 * @方法名: insertInfo
	 * @描述: 新增公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午3:02:04 
	 * @param bean
	 * @return
	 */
	public Integer insertInfo(CompanyDetailBean bean) {
		return getSqlSession().insert("companydetail.insertInfo", bean);
	}
	
	/**
	 * @描述: 修改公司Logo
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月7日 下午3:27:40
	 * @param bean
	 * @return
	 */
	public Integer updateCpyLogo(CompanyDetailBean bean) {
		return getSqlSession().update("companydetail.updateCpyLogo", bean);
	}
	
	/**
	 * @方法名: updateInfo
	 * @描述: 修改公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午4:02:39 
	 * @param bean
	 * @return
	 */
	public Integer updateInfo(CompanyDetailBean bean) {
		return getSqlSession().insert("companydetail.updateInfo", bean);
	}
	
	/**
	 * @方法名: getDetailbyId
	 * @描述: 根据公司ID获取一条公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午2:03:50 
	 * @param id
	 * @return
	 */
	public CompanyDetailBean getDetailbyId(Integer id) {
		return getSqlSession().selectOne("companydetail.selectBeanById", id);
	}
	
	/**
	 * @描述: 同业管理分页查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月18日 下午2:20:40
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<CompanyDetailBean> selectPageCafeteria(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("companydetail.selectPageCafeteria", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
}
