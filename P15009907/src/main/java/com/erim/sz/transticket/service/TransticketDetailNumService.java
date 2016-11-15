package com.erim.sz.transticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.TransticketDetailNumBean;
import com.erim.sz.transticket.dao.TransticketDetailNumDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: TransticketDetailNumService 
 * @Description: 火车车次
 * @author maoxian
 * @date 2015年11月9日 上午12:37:37
 */
@Service("transticketDetailNumService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TransticketDetailNumService {

	
	@Autowired
	private TransticketDetailNumDao transticketDetailNumDao;
	
	/**
	 * @Title: showList 
	 * @Description: 查询
	 * @param @return    设定文件 
	 * @return List<TransticketDetailNumBean>    返回类型 
	 * @throws
	 */
	public List<TransticketDetailNumBean> showList(TransticketDetailNumBean bean){
		return this.transticketDetailNumDao.showList(bean);
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
		bean.setTdlCreatetime(new Date());
		bean.setTdlCreateuser(CommonUtil.getLoginName());
		bean.setTdlIsDelStatus("02");
		return this.transticketDetailNumDao.insert(bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月21日 下午2:34:04 
	 * @throws
	 */
	public Integer update(TransticketDetailNumBean bean){
		
		return this.transticketDetailNumDao.update(bean);
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
		return this.transticketDetailNumDao.delete(id);
	}
	
	
	/**
	 * @Title: xj 
	 * @Description: 上下架
	 * @param @param id
	 * @param @param tdlIsDelStatus
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer xj(Integer id,String tdlIsDelStatus){
		TransticketDetailNumBean parm = new TransticketDetailNumBean();
		parm.setId(id);
		parm.setTdlIsDelStatus(tdlIsDelStatus);
		return this.transticketDetailNumDao.xj(parm);
	}
}