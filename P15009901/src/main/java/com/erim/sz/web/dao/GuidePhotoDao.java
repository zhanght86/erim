package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuidePhotoBean;

/**
 * @类名: GuidePhotoDao
 * @描述: 导游相册信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年12月28日 上午11:22:17
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePhotoDao extends BaseDao {

	/**
	 * @描述: 查询所有导游相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月28日 上午11:24:07
	 * @param bean
	 * @return
	 */
	public List<GuidePhotoBean> selectGuidePhotoList(GuidePhotoBean bean) {
		return getSqlSession().selectList("guidephoto.selectGuidePhotoList", bean);
	}
}
