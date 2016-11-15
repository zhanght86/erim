package com.erim.sz.sameTown.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PubSametownBean;
import com.erim.sz.sameTown.dao.PubSametownDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: PubSametownService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年9月18日 上午11:34:05 
 *
 */
@Service("pubSametownService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PubSametownService {

	@Autowired
	private PubSametownDao pubSametownDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入方法
	 * @param @param listPubSametownBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer insert(String ntype,Integer cid){
		try{
			//同城同业
			PubSametownBean sametownBean = new PubSametownBean();
			sametownBean.setCpyidFrom(CommonUtil.getCpyId());
			sametownBean.setNtype(ntype);
			sametownBean.setCid(cid);
			this.pubSametownDao.insertAll(sametownBean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.ERROR;
		}
	}
	
	/**
	 * @Title: deleteAll 
	 * @Description: 删除所有
	 * @param @param type
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer deleteAll(String type,Integer cid){
		try{
			PubSametownBean sametownBean = new PubSametownBean();
			sametownBean.setCpyidFrom(CommonUtil.getCpyId());
			sametownBean.setNtype(type);
			sametownBean.setCid(cid);
			this.pubSametownDao.delAll(sametownBean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(this.getClass(), e);
		}
	}
	
	/**
	 * 
	 * @Title: del 
	 * @Description: 删除方法
	 * @param @param cpyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(String type,String cpyid,String ntype,Integer cid){
		try{
			if(null != cid && cid > 0){
				PubSametownBean sametownBean = new PubSametownBean();
				sametownBean.setCpyidFrom(CommonUtil.getCpyId());
				sametownBean.setNtype(ntype);
				sametownBean.setCpyidTo(Integer.parseInt(cpyid));
				sametownBean.setCid(cid);
				//选择
				if("true".equals(type)){
					this.pubSametownDao.insert(sametownBean);
				}else{
					this.pubSametownDao.del(sametownBean);
				}
				return CommonUtil.SUCCESS;
			}else{
				return CommonUtil.ERROR;
			}
		}catch(Exception e){
			return CommonUtil.ERROR;
		}
	}
	
	/**
	 * @Title: selectList 
	 * @Description: set 一个值
	 * @param @param cid
	 * @param @param ntype
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectList(Integer cid,String ntype,ModelMap model){
		PubSametownBean param = new PubSametownBean();
		param.setCid(cid);
		param.setNtype(ntype);
		param.setCpyidFrom(CommonUtil.getCpyId());
		model.addAttribute("listsametown", this.pubSametownDao.showList(param));
	}
}