package com.erim.sz.web.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.bean.TexiDrivePriceBean;

@Repository("texidrivedao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiDriveDao extends BaseDao{
	
	/**
	 * @方法名：selectDriveTexi 
	 * @描述: 自驾查询
	 * @作者： 贺渊博
	 * @创建时间：2015年11月23日 下午4:36:19
	 * @param id
	 * @return
	 *
	 */
	public TexiDriveBean selectDriveTexi(Integer id){
		return getSqlSession().selectOne("texidrive.selectByDriveId",id);
	}
	public List<TexiDriveBean> selectTexiDrive(TexiDriveBean bean){
		return getSqlSession().selectList("texidrive.selectList",bean);
	}
	public List<TexiDrivePriceBean> selectTexiDrivePriceBeanList(TexiDrivePriceBean bean){
		return getSqlSession().selectList("texidriveprice.selectPageTexiDrivePrice",bean);
	}
}
