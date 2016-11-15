package com.erim.sz.management.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementMaterialBean;

/**
 * @ClassName: ManagementMaterialDao 
 * @Description: 签证上传材料
 * @author maoxian
 * @date 2015年11月23日 上午2:02:46
 */
@Repository("managementMaterialDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementMaterialDao extends BaseDao {
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 上午2:03:46 
	 * @throws
	 */
	public Integer insert(ManagementMaterialBean bean){
		return this.getSqlSession().insert("managementmaterial.insert", bean);
	}
	
	/**
	 * @描述: 修改签证材料
	 * @作者: maoxian
	 * @创建时间: 2015年11月23日 上午2:04:28 
	 * @param bean
	 * @return
	 */
	public Integer update(ManagementMaterialBean bean){
		return this.getSqlSession().update("managementmaterial.update", bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 根据id进行删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 上午2:05:19 
	 * @throws
	 */
	public Integer deleteById(Integer id){
		return this.getSqlSession().delete("managementmaterial.deleteById", id);
	}
	
	/**
	 * @Title: getListByMdlId 
	 * @Description: 根据签证id查询所有材料
	 * @param @param mdlId
	 * @param @return    设定文件 
	 * @return List<ManagementMaterialBean>    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 上午2:06:45 
	 * @throws
	 */
	public List<ManagementMaterialBean> selectListByMdlId(Integer mdlId){
		return this.getSqlSession().selectList("managementmaterial.selectListByMdlId", mdlId);
	}
	
	/**
	 * @Title: insertListBean 
	 * @Description: 插入list集合 
	 * @param @param listManagementMaterialBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月23日 上午2:08:10 
	 * @throws
	 */
	public Integer insertListBean(List<ManagementMaterialBean> list){
		return getSqlSession().insert("managementmaterial.insertListMaterial", list);
	}
}
