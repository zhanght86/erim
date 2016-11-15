package com.erim.sz.mall.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallHotBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: MallHotDao 
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月12日 上午2:17:19 
 *
 */
@Repository("mallHotDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallHotDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallHotBean bean){
		return this.getSqlSession().insert("mallhot.insert", bean);
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 插入数组 
	 * @param @param listBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insertList(List<MallHotBean> listBean){
		return this.getSqlSession().insert("mallhot.insertList", listBean);
	}
	
	
	/**
	 * @Title: deletecpy 
	 * @Description: 删除
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer deletecpy(MallHotBean bean){
		return this.getSqlSession().delete("mallhot.deletecpy", bean);
	}
	
	
	/**
	 * @Title: selectList 
	 * @Description: 根据实体查询list
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallHotBean>    返回类型 
	 * @throws
	 */
	public List<MallHotBean> selectList(MallHotBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.getSqlSession().selectList("mallhot.selectList", bean);
	}
}
