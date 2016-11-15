package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.web.bean.VSearchAnyBean;

/**
 * @ClassName: VSearchAnyDao 
 * @Description: 视图检索
 * @author maoxian
 * @date 2016年1月3日 下午2:54:45
 */
@Repository("vSearchAnyDao")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VSearchAnyDao extends BaseDao{

	
    /**
     * @Title: selectSearchResult 
     * @Description: 根据输入内容进行检索
     * @param @param name
     * @param @return    设定文件 
     * @return List<VSearchAnyBean>    返回类型 
     * @author maoxian
     * @date 2016年1月3日 下午2:55:43 
     * @throws
     */
	public List<VSearchAnyBean> selectSearchResult(VSearchAnyBean bean){
		return this.getSqlSession().selectList("vsearchany.selectSearchResult", bean);
	}
}
