package com.erim.sz.texi.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDriveBean;

/**
 * @ClassName: TexiDetailDao 
 * @Description: 租车自驾
 * @author 贺渊博
 * @date 2015年10月01日 下午4:05:15 
 */
@Repository("texidriveDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiDriveDao extends BaseDao{

	/**
	 * @Title: insert 
	 * @Description: 新增 
	 * @param texiDriveBean
	 * @param 设定文件 
	 * @return Integer 返回类型 
	 */
	public Integer insert(TexiDriveBean bean){
		return getSqlSession().insert("texidrive.insert", bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param texiDriveBean 设定文件 
	 * @return void 返回类型 
	 */
	public Integer update(TexiDriveBean bean) {
		return getSqlSession().update("texidrive.update", bean);
	}
	
	/**
	 * @Title: getTextDriveById 
	 * @Description: 根据产品ID查询自驾信息
	 * @param tdlId
	 * @return TexiPriceBean 返回类型 
	 */
	public TexiDriveBean getTextDriveById(Integer tdlId) {
		
		return getSqlSession().selectOne("texidrive.getTextDriveById", tdlId);
	}
}
