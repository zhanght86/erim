package com.erim.sz.zy.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.zy.bean.ZySystemCooperationBean;

/**
 * 
 * @ClassName: ZySystemCooperationDao 
 * @Description: 共享用户权限
 * @author maoxian
 * @date 2015年11月5日 上午2:06:14
 */
@Repository("zySystemCooperationDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZySystemCooperationDao extends BaseDao {


    /**
     * @Title: selectCooperationByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<ZySystemCooperationBean>    返回类型 
     * @throws
     */
    public List<ZySystemCooperationBean> selectCooperation(ZySystemCooperationBean zySystemCooperationBean){
    	return this.getSqlSession().selectList("zysystemcooperation.selectCooperation", zySystemCooperationBean);
    }
    
    /**
     * @Title: selectOneCooperation 
     * @Description: 查询实体
     * @param @param bean
     * @param @return    设定文件 
     * @return ZySystemCooperationBean    返回类型 
     * @throws
     */
    public List<ZySystemCooperationBean> selectOneCooperation(ZySystemCooperationBean bean){
    	return this.getSqlSession().selectList("zysystemcooperation.selectOneCooperation", bean);
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param zySystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(ZySystemCooperationBean zySystemCooperationBean){
    	this.getSqlSession().insert("zysystemcooperation.insert", zySystemCooperationBean);
    }
    
    /**
     * @Title: delete 
     * @Description: 删除
     * @param @param zySystemCooperationBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void delete(ZySystemCooperationBean zySystemCooperationBean){
    	this.getSqlSession().delete("zysystemcooperation.delete", zySystemCooperationBean);
    }
}