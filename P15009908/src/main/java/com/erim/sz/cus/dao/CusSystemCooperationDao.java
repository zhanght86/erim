package com.erim.sz.cus.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.cus.bean.CusSystemCooperationBean;

/**
 * 
 * @ClassName: CusSystemCooperationDao 
 * @Description: 共享用户权限
 * @author maoxian
 * @date 2015年11月5日 上午2:06:14
 */
@Repository("cusSystemCooperationDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CusSystemCooperationDao extends BaseDao {


    /**
     * @Title: selectCooperationByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<CusSystemCooperationBean>    返回类型 
     * @throws
     */
    public List<CusSystemCooperationBean> selectCooperation(CusSystemCooperationBean cusSystemCooperationBean){
    	return this.getSqlSession().selectList("cussystemcooperation.selectCooperation", cusSystemCooperationBean);
    }
    
    /**
     * @Title: selectOneCooperation 
     * @Description: 查询实体
     * @param @param bean
     * @param @return    设定文件 
     * @return CusSystemCooperationBean    返回类型 
     * @throws
     */
    public List<CusSystemCooperationBean> selectOneCooperation(CusSystemCooperationBean bean){
    	return this.getSqlSession().selectList("cussystemcooperation.selectOneCooperation", bean);
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param cusSystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(CusSystemCooperationBean cusSystemCooperationBean){
    	this.getSqlSession().insert("cussystemcooperation.insert", cusSystemCooperationBean);
    }
    
    /**
     * @Title: delete 
     * @Description: 删除
     * @param @param cusSystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void delete(CusSystemCooperationBean cusSystemCooperationBean){
    	this.getSqlSession().delete("cussystemcooperation.delete", cusSystemCooperationBean);
    }
}