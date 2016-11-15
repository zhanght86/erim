package com.erim.sz.mall.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.MallLinecompanyBean;
import com.erim.sz.mall.dao.MallLinecompanyDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: MallShopDao 
 * @Description: 合作用户
 * @author maoxian
 * @date 2015年9月16日 下午6:56:04 
 *
 */
@Service("mallLinecompanyService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallLinecompanyService {
	
	
	@Autowired
	private MallLinecompanyDao mallLinecompanyDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallLinecompanyBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setMspCreatetime(new Date());
		bean.setMspCreateuser(CommonUtil.getLoginName());
		return this.mallLinecompanyDao.insert(bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(MallLinecompanyBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.mallLinecompanyDao.delete(bean);
	}
	
	/**
	 * @Title: selectList 
	 * @Description: 根据实体查询list
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallLinecompanyBean>    返回类型 
	 * @throws
	 */
	public List<MallLinecompanyBean> selectList(MallLinecompanyBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.mallLinecompanyDao.selectList(bean);
	}
	
	/**
	 * @Title: deletecpy 
	 * @Description: 删除企业一部分
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer deletecpy(MallLinecompanyBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.mallLinecompanyDao.deletecpy(bean);
	}
	
	/**
	 * @Title: insertAll 
	 * @Description: 批量插入
	 * @param @param bean
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insertAll(HttpServletRequest request){
		String cpyid="";
			
		//增加选中的记录
		cpyid       = request.getParameter("mspCpyId");
		//企业
		if(StringUtils.isNotBlank(cpyid)){
			//声明
			MallLinecompanyBean bean = new MallLinecompanyBean();
			bean.setCpyId(CommonUtil.getCpyId());
			
			String[] amspCpyId = cpyid.split(",");
			//数组
			List<MallLinecompanyBean> list = new ArrayList<MallLinecompanyBean>();
			
			this.mallLinecompanyDao.deletecpy(bean);
			
			for(String mspCpyid : amspCpyId){
				MallLinecompanyBean param = new MallLinecompanyBean();
				param.setMspCpyId(Integer.parseInt(mspCpyid));
				param.setCpyId(CommonUtil.getCpyId());
				param.setMspCreatetime(new Date());
				param.setMspCreateuser(CommonUtil.getLoginName());
				list.add(param);
			}
			System.out.println("insertall");
			return this.mallLinecompanyDao.insertList(list);
		}
		return 1;
	}
	
	public Integer insertAll_2(HttpServletRequest request){
		String cpyid="";
		//删除所有本页的记录
		cpyid       = request.getParameter("AllmspCpyId");
		if(StringUtils.isNotBlank(cpyid)){
			//声明
			MallLinecompanyBean bean = new MallLinecompanyBean();
			bean.setCpyId(CommonUtil.getCpyId());			
			String[] amspCpyId = cpyid.split(",");
			//数组
			List<MallLinecompanyBean> list = new ArrayList<MallLinecompanyBean>();
			MallLinecompanyBean param = new MallLinecompanyBean();			
			for(String mspCpyid : amspCpyId){
				param.setMspCpyId(Integer.parseInt(mspCpyid));
				param.setCpyId(CommonUtil.getCpyId());
				this.mallLinecompanyDao.delete(param);
			}
			
		}
		
		
		//增加选中的记录
		cpyid       = request.getParameter("mspCpyId");
		//企业
		if(StringUtils.isNotBlank(cpyid)){
			//声明
			MallLinecompanyBean bean = new MallLinecompanyBean();
			bean.setCpyId(CommonUtil.getCpyId());
			
			String[] amspCpyId = cpyid.split(",");
			//数组
			List<MallLinecompanyBean> list = new ArrayList<MallLinecompanyBean>();
			
			//this.mallLinecompanyDao.deletecpy(bean);
			
			for(String mspCpyid : amspCpyId){
				MallLinecompanyBean param = new MallLinecompanyBean();
				param.setMspCpyId(Integer.parseInt(mspCpyid));
				param.setCpyId(CommonUtil.getCpyId());
				param.setMspCreatetime(new Date());
				param.setMspCreateuser(CommonUtil.getLoginName());
				list.add(param);
			}
			this.mallLinecompanyDao.insertList(list);
		}
		System.out.println("insertall2");
		return 1;
	}
	
}