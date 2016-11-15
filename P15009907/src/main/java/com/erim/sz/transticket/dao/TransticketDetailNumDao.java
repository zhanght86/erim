package com.erim.sz.transticket.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TransticketDetailNumBean;

/**
 * @ClassName: TransticketDetailDao 
 * @Description: 火车票详细
 * @author maoxian
 * @date 2015年10月13日 下午11:54:21 
 *
 */
@Repository("transticketDetailNumDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TransticketDetailNumDao extends BaseDao {

	/**
	 * @Title: showList 
	 * @Description: 查询
	 * @param @return    设定文件 
	 * @return List<TransticketDetailNumBean>    返回类型 
	 * @throws
	 */
	public List<TransticketDetailNumBean> showList(TransticketDetailNumBean bean){
		return this.getSqlSession().selectList("transticketdetailnum.select", bean);
	}
	
	/**
	 * @Title: insert 
	 * @Description: 新增
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(TransticketDetailNumBean bean){
		return this.getSqlSession().insert("transticketdetailnum.insert", bean);
	}
	
	
	/**
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月21日 下午2:36:46 
	 * @throws
	 */
	public Integer update(TransticketDetailNumBean bean){
		return this.getSqlSession().update("transticketdetailnum.update",bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(Integer id){
		return this.getSqlSession().delete("transticketdetailnum.delete", id);
	}
	
	/**
	 * @Title: xj 
	 * @Description: 上下架
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月21日 下午2:35:49 
	 * @throws
	 */
	public Integer xj(TransticketDetailNumBean bean){
		return this.getSqlSession().update("transticketdetailnum.xj", bean);
	}
}
