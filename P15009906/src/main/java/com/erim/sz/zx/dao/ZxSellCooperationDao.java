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
	 * @Title: updateList 
	 * @Description: 批量更新
	 * @param @param list
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月10日 下午11:50:52 
	 * @throws
	 */
	public Integer update(ZxSellCooperationBean bean){
		return this.getSqlSession().update("zxsellcooperation.update", bean);
	}
	
	/**
	 * @Title: deleteAll 
	 * @Description: 初始化已合作列表为未合作
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月11日 上午12:10:25 
	 * @throws
	 */
	public Integer deleteAll(ZxSellCooperationBean bean){
		return this.getSqlSession().update("zxsellcooperation.deleteALl", bean);
	}
}
