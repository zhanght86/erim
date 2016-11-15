package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuidePhotoBean;

/**
 * @ClassName: GuidePhotoDao 
 * @Description: 导游相册管理 
 * @author maoxian
 * @date 2015年9月10日 下午7:20:37 
 */
@Repository("guidePhotoDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePhotoDao extends BaseDao {

	/**
	 * @描述: 根据导游ID查询该导游所有照片
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午6:19:43
	 * @param guidePhotoBean
	 * @return
	 */
	public List<GuidePhotoBean> selectGuidePhotoByGuide(GuidePhotoBean guidePhotoBean){
		return this.getSqlSession().selectList("guidephoto.selectGuidePhotoByGuide", guidePhotoBean);
	}
	
	/**
	 * @描述: 新增照片
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午6:20:32
	 * @param bean
	 * @return
	 */
	public Integer insertPhoto(GuidePhotoBean bean) {
		return getSqlSession().insert("guidephoto.insert", bean);
	}
	
	/**
	 * @描述: 删除一张相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月27日 上午10:40:04
	 * @param bean
	 * @return
	 */
	public Integer deletePhoto(GuidePhotoBean bean) {
		return getSqlSession().delete("guidephoto.deletePhoto", bean);
	}
}
