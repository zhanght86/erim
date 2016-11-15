package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallLinecompanyBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: MallShopDao 
 * @Description: 合作用户
 * @author maoxian
 * @date 2015年9月16日 下午6:56:04 
 *
 */
@Repository("mallLinecompanyDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallLinecompanyDao extends BaseDao {

	
	/**
	 * @Title: listMallLineCompany 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<MallLinecompanyBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午2:49:54 
	 * @throws
	 */
	public String[] getArrayCpyId(){
		MallLinecompanyBean bean = new MallLinecompanyBean();
		bean.setCpyId(CommonUtil.getCpyId());
		List<MallLinecompanyBean> selectList = this.selectList(bean);
		StringBuffer sb = new StringBuffer();
		if(null != selectList && selectList.size()>0){
			for(MallLinecompanyBean b : selectList){
				sb.append(b.getMspCpyId()).append(",");
			}
			if(sb.lastIndexOf(",") == sb.length()-1){
				sb.deleteCharAt(sb.length()-1);
			}
			return sb.toString().split(",");
		}
		return null;
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallLinecompanyBean bean){
		return this.getSqlSession().insert("malllinecompany.insert", bean);
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 插入数组 
	 * @param @param listBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insertList(List<MallLinecompanyBean> listBean){
		return this.getSqlSession().insert("malllinecompany.insertList", listBean);
	}
	

	
	/**
	 * @Title: deletecpy 
	 * @Description: 删除
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer deletecpy(MallLinecompanyBean bean){
		return this.getSqlSession().delete("malllinecompany.deletecpy", bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(MallLinecompanyBean bean){
		return this.getSqlSession().delete("malllinecompany.delete", bean);
	}
	
	/**
	 * @Title: selectList 
	 * @Description: 根据实体查询list
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallLinecompanyBean>    返回类型 
	 * @throws
	 */
	public List<MallLinecompanyBean> selectList(MallLinecompanyBean bean){
		return this.getSqlSession().selectList("malllinecompany.selectList", bean);
	}
}
