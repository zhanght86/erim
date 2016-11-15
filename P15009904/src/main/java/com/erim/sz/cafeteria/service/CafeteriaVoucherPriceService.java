package com.erim.sz.cafeteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.cafeteria.dao.CafeteriaVoucherPriceDao;
import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;

/**
 * @ClassName: CafeteriaVoucherPriceService 
 * @Description: 代金劵管理
 * @author maoxian
 * @date 2015年11月8日 下午12:54:54
 */
@Service("cafeteriaVoucherPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaVoucherPriceService {
	
	@Autowired
	private CafeteriaVoucherPriceDao cafeteriaVoucherPriceDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入方法
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(List<CafeteriaVoucherPriceBean> list){
		return cafeteriaVoucherPriceDao.insert(list);
	}

	/**
	 * @Title: showList 
	 * @Description: 根据代金劵id 查询
	 * @param @param djqId
	 * @param @return    设定文件 
	 * @return List<CafeteriaVoucherPriceBean>    返回类型 
	 * @throws
	 */
	public List<CafeteriaVoucherPriceBean> showList(Integer djqId){
		return this.cafeteriaVoucherPriceDao.showList(djqId);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaVoucherPriceBean bean){
		return this.cafeteriaVoucherPriceDao.update(bean);
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
		return this.cafeteriaVoucherPriceDao.delete(id);
	}
}