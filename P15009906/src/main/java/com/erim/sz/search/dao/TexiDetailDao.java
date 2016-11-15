package com.erim.sz.search.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TexiDetailBean;

    /***
     * 
     * @ClassName: TexiDetailDao 
     * @Description: 租车
     * @author 龙龙
     * @date 2015年7月29日 下午6:05:15 
     *
     */
     @Repository("texiDao")
     @Scope(BeanDefinition.SCOPE_PROTOTYPE)
     public class TexiDetailDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageTexi 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<TexiDetailBean>    返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTexi(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texidetail.selectPageTexi", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
	 * 
	 * @Title: selectPageTexi 
	 * @Description: 同城同业
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<TexiDetailBean>    返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTown(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texidetail.selectPageTown", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * 
     * @Title: selectTexi 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return TexiDetailBean    返回类型 
     * @throws
     */
    public TexiDetailBean selectTexi(Integer id) {
    	
        return getSqlSession().selectOne("texidetail.selectById", id);
    }
    /**
     * 
     * @Title: insertPage 
     * @Description: 新增页面
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/texi/detail/insertPage")
    public String insertPage(ModelMap model) throws ErimException {
    	return "/texi/detail/insert";
    }
    /**
     * 
     * @Title: insertTexi 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertTexi(TexiDetailBean bean) {
        return getSqlSession().insert("texidetail.insert", bean);
    }
    
   
    /**
     * 
     * @Title: updateTexi 
     * @Description: 修改
     * @param @param bean    设定文件 
     * @return void    返回类型 
     * @throws
     */
     public void updateTexi(TexiDetailBean bean){
     	getSqlSession().update("texidetail.update", bean);
     }

     /**
 	 * 
 	 * @Title: deleteTexi
 	 * @Description: 删除
 	 * @param @param id 设定文件
 	 * @return void 返回类型
 	 * @throws
 	 */
 	public void deleteTexi(TexiDetailBean bean) {
 		getSqlSession().update("texidetail.delete", bean);
 	}
 	/**
     * 
     * @Title: deleteLine 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteTexi(int id){
    	getSqlSession().update("texidetail.delet", id);
    }
}
