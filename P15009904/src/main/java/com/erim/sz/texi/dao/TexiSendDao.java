package com.erim.sz.texi.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiSendBean;

/**
 * @ClassName:   TexitransportlDao 
 * @Description: 租车固定接送列表
 * @author 	         王赛
 * @date 		2015年10月1日 下午4:05:15 
 */
@Repository("texiSendDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiSendDao extends BaseDao{

	/**
	 * @描述: 根据条件查询固定接送数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午9:05:09
	 * @param bean
	 * @param model
	 * @return
	 */
    public List<TexiSendBean> selectTexiSendList(TexiSendBean bean, ModelMap model) {
		return getSqlSession().selectList("texisend.selectTexiSendList", bean);
	}
    
    /**
 	 * @Title: 		 deleteTexi
 	 * @Description: 租车固定删除
 	 * @param @param id 设定文件
 	 * @return       void 返回类型
 	 * @throws
 	 */
 	public void delete(int id){
		getSqlSession().delete("texisend.delete",id);
	}
 	
 	/**
 	 * @方法名: insertTexi
 	 * @描述: 线路信息增加
 	 * @作者: 宁晓强
 	 * @创建时间: 2015年10月11日 下午6:13:08 
 	 * @param bean
 	 * @return
 	 */
 	public Integer insertTexi(TexiSendBean bean) {
        return getSqlSession().insert("texisend.insert", bean);
    }
 	
 	/**
 	 * @方法名: updateCode
 	 * @描述: 修改产品编码
 	 * @作者: 宁晓强
 	 * @创建时间: 2015年10月11日 下午6:43:39 
 	 * @param bean
 	 * @return
 	 */
 	public Integer updateCode(TexiSendBean bean) {
 		
 		Integer result = getSqlSession().update("texisend.updateCode", bean);
 		return result;
 	}
 	
 	/**
	 * @Title: 		 update 
	 * @Description: 修改
	 * @param @param TexiSendBean 设定文件 
	 * @return       void  返回类型 
	 * @throws
	 */
	public Integer update(TexiSendBean bean){
		return getSqlSession().update("texisend.update", bean);
	}
	
 	/**
 	 * @方法名: selectTexisend
 	 * @描述: 根据ID查询一条固定接送线路信息
 	 * @作者: 宁晓强
 	 * @创建时间: 2015年10月12日 上午10:20:36 
 	 * @param bean
 	 * @return
 	 */
 	 public TexiSendBean getTexiSendById(TexiSendBean bean) {
         return this.getSqlSession().selectOne("texisend.getTexiSendById", bean);
     } 
}
