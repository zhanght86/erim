package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementMaterialBean;

/**
 * @描述: 查询签证材料信息
 * @作者: （heyuanbo）
 * @创建时间: 2015年11月25日 上午10:50:15
 */
@Repository("managementMaterialDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementMaterialDao extends BaseDao{
	/**
	 * @描述: 根据签证id查询材料
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月25日 上午10:56:39
	 * @param mdlId
	 * @return 返回类型  ManagementMaterialBean
	 */
	public List<ManagementMaterialBean> selectListByMdlId(Integer mdlId){
		return this.getSqlSession().selectList("managementmaterial.selectListByMdlId",mdlId);
		
	}
	/**
	 * 
	 * @描述: 根据签证id和材料分类（mmlNtype）查询材料
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 下午4:40:47
	 * @param mdlId
	 * @return
	 */
	public List<ManagementMaterialBean> selectListByMdlIdAndType(Integer mdlId,String mmlNtype){
		ManagementMaterialBean bean = new ManagementMaterialBean();
		bean.setMdlId(mdlId);;
		bean.setMmlNtype(mmlNtype);
		return this.getSqlSession().selectList("managementmaterial.selectListByMdlIdAndType",bean);
		
	}

}
