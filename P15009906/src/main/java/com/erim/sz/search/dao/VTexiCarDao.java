package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.VTexiCarBean;

/**
 * @ClassName: VTexiCarDao 
 * @Description: 车辆租车信息
 * @author maoxian
 * @date 2015年12月20日 下午6:45:02
 */
@Repository("vTexiCarDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VTexiCarDao extends BaseDao {

	/**
	 * @Title: selectVTexiCar 
	 * @Description: 根据车辆 查询信息
	 * @param @param tdlId
	 * @param @return    设定文件 
	 * @return List<VTexiCarBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午6:46:20 
	 * @throws
	 */
	public List<VTexiCarBean> selectVTexiCar(Integer tdlId){
		return this.getSqlSession().selectList("vtexicar.selectTexiCar", tdlId);
	}
}
