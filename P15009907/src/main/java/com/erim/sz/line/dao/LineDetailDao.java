package com.erim.sz.line.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineDetailBean;

/**
 * 
 * @类名: LineDetailDao
 * @描述: 专线详细控制
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:15:07
 *
 */
@Repository("lineDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineDetailDao extends BaseDao{

	/**
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
    public List<LineDetailBean> selectPageLine(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("linedetail.selectPageLine", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectLine 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return LineDetailBean    返回类型 
     * @throws
     */
    public LineDetailBean selectLine(LineDetailBean bean) {
        return getSqlSession().selectOne("linedetail.selectBeanByPriId", bean);
    }
    

    /**
     * 
     * @Title: insertLine 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertLine(LineDetailBean bean) {
        return getSqlSession().insert("linedetail.insert", bean);
    }
    
   /**
    * 
    * @Title: updateLine 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateLine(LineDetailBean bean){
    	getSqlSession().update("linedetail.update", bean);
    }
    /**
     * 
     * @描述: 修改行程中的剩余字段
     * @作者: （李庆）
     * @创建时间: 2015年12月1日 下午12:12:14
     * @param bean
     * @return
     */
     public int updateTrip(LineDetailBean bean){
     	return getSqlSession().update("linedetail.updatetrip", bean);
     }
    /**
     * 
     * @Title: deleteLine 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteLine(int id){
    	getSqlSession().update("linedetail.delete", id);
    }
    /**
 	 * 
 	 * @Title: deletePlaneticket
 	 * @Description: 上下架
 	 * @param @param id 设定文件
 	 * @return void 返回类型
 	 * @throws
 	 */
 	public void deletePlaneticket(LineDetailBean bean) {
 		getSqlSession().update("linedetail.delet", bean);
 	}
 	/**
 	 * 
 	 * @方法名: Lineupdatecode
 	 * @描述:编码自动生成 
 	 * @作者: 李庆
 	 * @创建时间: 2015年10月16日 下午3:52:33 
 	 * @param bean
 	 * @return
 	 *
 	 */
	public Integer Lineupdatecode(LineDetailBean bean) {
		
		return getSqlSession().update("linedetail.lineupdatecode",bean);
	}
	 /**
	  * 
	  * @描述: 复制完成后更改部分字段
	  * @作者: （李庆）
	  * @创建时间: 2015年12月1日 下午5:33:06
	  * @param bean
	  * @return
	  */
//     public Integer updateCopyGround(LineDetailBean bean) {
//    	return getSqlSession().update("linedetail.updateCopyGround", bean);
//    }
         /**
          * 
          * @描述: 根据当地游基础信息ID复制一条当地游基础信息
          * @作者: （李庆）
          * @创建时间: 2015年12月1日 下午5:33:16
          * @param bean
          * @return
          */
//     	 public Integer copyGroundDetail(LineDetailBean bean) {
//     		return getSqlSession().insert("linedetail.copyLineDetail", bean);
//     	}
     	 
     	 /**
          * @Title: 		updateGround 
          * @Description: 修改
          * @param @param bean  设定文件 
          * @return 		void  返回类型 
          * @throws
          */
      public void updateLine1(LineDetailBean bean){
        getSqlSession().update("linedetail.update1", bean);
    }
}
