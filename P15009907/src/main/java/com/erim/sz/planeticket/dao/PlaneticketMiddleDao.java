package com.erim.sz.planeticket.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketMiddleBean;

/**
 * @ClassName: PlaneticketMiddleDao 
 * @Description: 中转
 * @author maoxian 
 * @date 2015年10月29日 上午10:46:53 
 *
 */
@Repository("planeticketMiddleDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketMiddleDao extends BaseDao {
	/**
	 * 
	 * @Title: selectPlaneticket @Description: 根据id查询 @param @param
	 * id @param @return 设定文件 @return PlaneticketMiddleBean 返回类型 @throws
	 */
	public PlaneticketMiddleBean selectPlaneticket(Integer id) {
		return getSqlSession().selectOne("planeticketmiddle.selectBeanByPriId", id);
	}

	/**
	 * 
	 * @Title: selectPlaneticket @Description: 根据pldid查询 @param @param
	 * id @param @return 设定文件 @return List<PlaneticketMiddleBean> 返回类型 @throws
	 */
	public List<PlaneticketMiddleBean> selectPlaneticketByPldId(Integer id) {
		return getSqlSession().selectList("planeticketmiddle.selectBeanByPldId", id);
	}
	
	/**
	 * 
	 * @Title: insertPlaneticket @Description: 插入 @param @param
	 * bean @param @return 设定文件 @return int 返回类型 @throws
	 */
	public int insertPlaneticket(List<PlaneticketMiddleBean> list) {
		return getSqlSession().insert("planeticketmiddle.insert", list);
	}

	/**
	 * 
	 * @Title: updatePlaneticket @Description: 修改 @param @param bean
	 * 设定文件 @return void 返回类型 @throws
	 */
	public void updatePlaneticket(PlaneticketMiddleBean bean) {
		getSqlSession().update("planeticketmiddle.update", bean);
	}

	/**
	 * 
	 * @Title: deletePlaneticket @Description: 删除 @param @param id 设定文件 @return
	 * void 返回类型 @throws
	 */
	public void deletePlaneticket(int id) {
		getSqlSession().update("planeticketmiddle.delete", id);
	}

}
