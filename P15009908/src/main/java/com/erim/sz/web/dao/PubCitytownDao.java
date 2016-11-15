package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PubCityshopBean;

/**
 * @ClassName: PubCitytownDao 
 * @Description: 社会商圈
 * @author maoxian
 * @date 2015年10月3日 下午10:11:46
 */
@Repository("pubCitytownDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PubCitytownDao extends BaseDao{
	

	/**
	 * @Title: selectAllCode 
	 * @Description: 查询所有城市
	 * @param @return    设定文件 
	 * @return List<TmSystemRegionBean>    返回类型 
	 * @throws
	 */
	public List<PubCityshopBean> selectAllCode(){
		return this.getSqlSession().selectList("pubcitytown.selectList");
	}
	
	
	public void delete(Integer id){
		this.getSqlSession().delete("pubcitytown.delete", id);
	}
}
