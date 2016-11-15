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
 * 
 * @ClassName: CompanyDetailDao 
 * @Description: 企业
 * @author maoxian
 * @date 2015年8月1日 上午11:51:17
 */
@Repository("companyDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyDetailDao extends BaseDao {

	
	/**
	 * @Title: selectPageCafeteria 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CompanyDetailBean>    返回类型 
	 * @throws
	 */
	 public List<CompanyDetailBean> selectPageSell(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("companydetail.selectPageSell", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }

	/**
	 * 
	 * @Title: insert 
	 * @Description: 公司注册
	 * @param @param companyDetailBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(CompanyDetailBean companyDetailBean) {
		return getSqlSession().insert("companydetail.insert", companyDetailBean);
	}
	
	
	/**
	 * @Title: getDetailbyId 
	 * @Description: 根据企业id判断企业是否存在
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年11月29日 上午10:53:25 
	 * @throws
	 */
	public CompanyDetailBean getDetailbyId(Integer id){
		return this.getSqlSession().selectOne("companydetail.selectBeanById", id);
	}
	
	/**
	 * @Title: ListSellByBusiness 
	 * @Description: 根据专线的地接范围捕捉所对应的组团社
	 * @param @param city
	 * @param @return    设定文件 
	 * @return List<CompanyDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午10:02:30 
	 * @throws
	 */
	public List<CompanyDetailBean> ListSellByBusiness(String[] city){
		return this.getSqlSession().selectList("companydetail.selectSellByBusiness", city);
	}
	
	/**
	 * 
	 * @方法名: update
	 * @描述: 修改公司信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午10:37:17 
	 * @param bean
	 * @return
	 *
	 */
	public Integer update(CompanyDetailBean bean) {
		return getSqlSession().update("companydetail.update", bean);
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
	public CompanyDetailBean getBeanById(Integer id){
		return this.getSqlSession().selectOne("companydetail.selectBeanById", id);
	}
	
	/**
	 * 
	 * @Title: selectPageCafeteria 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CompanyDetailBean>    返回类型 
	 * @throws
	 */
	 public List<CompanyDetailBean> selectPageCafeteria(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("companydetail.selectPageCafeteria", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
	 
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
	 * @Description: 支付过后 解除公司锁定
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午12:30:00 
	 * @throws
	 */
	public void unlock(Integer cpyId){
		this.getSqlSession().update("companydetail.unlock", cpyId);
	}
}
