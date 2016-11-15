package com.erim.sz.zx.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ZxSellCooperationBean;

/**
 * @ClassName: ZxSellCooperationDao 
 * @Description: 专线链接组团
 * @author maoxian
 * @date 2015年12月8日 下午3:46:38
 */
@Repository("zxSellCooperationDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZxSellCooperationDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 新增接口
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:47:29 
	 * @throws
	 */
	public Integer insert(ZxSellCooperationBean bean){
		return this.getSqlSession().insert("zxsellcooperation.insert", bean);
	}
	
	
	/**
	 * @Title: delete 
	 * @Description: 删除文件
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:49:35 
	 * @throws
	 */
	public Integer delete(ZxSellCooperationBean bean){
		return this.getSqlSession().delete("zxsellcooperation.delete", bean);
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 批量插入
	 * @param @param list
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午3:53:00 
	 * @throws
	 */
	public Integer insertList(ZxSellCooperationBean bean){
		return this.getSqlSession().insert("zxsellcooperation.insertList", bean);
	}
}
