package com.erim.sz.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelOrderBean;


/**
 * 
 * @ClassName: HotelOrderDao 
 * @Description: 酒店订单
 * @author maoxian
 * @date 2015年8月8日 下午3:51:51
 */
@Repository("hotelOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelOrderDao extends BaseDao {

	/**
	 * @Title: selectPageOrder 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<HotelOrderBean>    返回类型 
	 * @throws
	 */
	public List<HotelOrderBean> selectPageOrder(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList("hotelorder.selectPageOrder",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	 /**
     * 
     * @Title: selectHotel 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return HotelOrderBean    返回类型 
     * @throws
     */
    public HotelOrderBean selectGuide(Integer id) {
        return getSqlSession().selectOne("hotelorder.selectBeanByPriId", id);
    }
    /**
     * 
     * @Title: insertHotel 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertHotel(HotelOrderBean bean) {
        return getSqlSession().insert("hotelorder.insert", bean);
    }
    /**
     * 
     * @Title: updateHotel 
     * @Description: 修改为接单或拒接状态
     * @param @param bean    设定文件 
     * @return void    返回类型 
     * @throws
     */
     public int updateHotel(HotelOrderBean bean){
    	 System.out.println("bean ::::::"+bean.getId()+"   ddd:"+bean.getHldIsThrough());
      return getSqlSession().update("hotelorder.receiveOrRefuse", bean);
     }
     /**
      * 
      * @Title: deleteHotel 
      * @Description: 删除
      * @param @param id    设定文件 
      * @return void    返回类型 
      * @throws
      */
     public void deleteHotel(int id){
     	getSqlSession().update("hotelorder.delete", id);
     }
 
     
}
