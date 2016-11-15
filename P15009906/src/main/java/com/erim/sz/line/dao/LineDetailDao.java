package com.erim.sz.line.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;

/**
 * @ClassName: LineDetailDao 
 * @Description: 挑选线路
 * @author maoxian
 * @date 2015年9月16日 下午6:07:55 
 *
 */
@Repository("lineDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineDetailDao extends BaseDao {

	/**
	 * 
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
     * @Title: selectLineByCid 
     * @Description: 根据企业id查询专线
     * @param @param cid
     * @param @return    设定文件 
     * @return LineDetailBean    返回类型 
     * @author maoxian
     * @date 2015年12月4日 上午2:58:22 
     * @throws
     */
    public List<LineDetailBean> selectLineByCid(String[] cid){
    	return this.getSqlSession().selectList("linedetail.selectLineByCid", cid);
    }
    
    /**
     * @Title: selectLineByCpyid 
     * @Description: 根据企业id搜索专线
     * @param @param cpyId
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @author maoxian
     * @date 2015年12月10日 下午11:00:53 
     * @throws
     */
    public List<LineDetailBean> selectLineByaCpyid(String[] cpyId,LineDetailBean bean){
    	bean.setAstrcpyId(cpyId);
    	bean.setSellId(CommonUtil.getCpyId());
    	return this.getSqlSession().selectList("linedetail.selectLineByaCpyid", bean);
    }
    /**
     * @Title: selectLineByaCpyidIsCooper 
     * @Description: 以合作
     * @param @param cpyId
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @author maoxian
     * @date 2015年12月11日 上午4:07:10 
     * @throws
     */
    public List<LineDetailBean> selectLineByaCpyidIsCooper(String[] cpyId,String Themetype){
    	LineDetailBean bean = new LineDetailBean();
    	bean.setAstrcpyId(cpyId);
    	bean.setSellId(CommonUtil.getCpyId());
    	bean.setZscIsCoopertion("1");
    	if(!StringUtils.isBlank(Themetype)){
    	  String s1=Themetype.substring(0,4);	
    	  String s2=Themetype.substring(4);
    	  System.out.print("s1="+s1);
    	  System.out.print("s2="+s2);
    	  if (s1.equals(DictionaryUtil.GAME))
    	  {
    		 bean.setLdlGame(s2); 
    	  }
    	  if (s1.equals(DictionaryUtil.THEME))
    	  {
    		  bean.setLdlProType1(s2);    		  
    	  }   
    		
    	}
    	return this.getSqlSession().selectList("linedetail.selectLineByaCpyid", bean);
    }
    /**
     * 
     * @方法名: selectLineByaCpyidIsCooperAndNation
     * @描述:  根据国家类型获取数据 
     * @作者: 国亚文
     * @创建时间: 2015年12月30日 下午4:01:14 
     * @param cpyId
     * @return
     */
    
    public List<LineDetailBean> selectLineByaCpyidIsCooperAndNation(String[] cpyId,LineDetailBean bean){
    	
    	bean.setAstrcpyId(cpyId);
    	bean.setSellId(CommonUtil.getCpyId());
    	bean.setZscIsCoopertion("1");
    	return this.getSqlSession().selectList("linedetail.selectLineByaCpyidAndNation", bean);
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
    public LineDetailBean selectLine(Integer id) {
        return getSqlSession().selectOne("linedetail.selectBeanByPriId", id);
    }
    
    /**
     * @Title: selectLineByCpyid 
     * @Description: 根据企业id查询企业基础信息
     * @param @param cpyid
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @throws
     */
    public List<LineDetailBean> selectLineByCpyid(Integer cpyId){
    	LineDetailBean detailBean = new LineDetailBean();
    	detailBean.setCpyId(cpyId);
    	detailBean.setSellId(CommonUtil.getCpyId());
    	
    	//return this.getSqlSession().selectList("linedetail.selectPageLine", detailBean);
    	return this.getSqlSession().selectList("linedetail.selectLineByCpyid", detailBean);
    }
    
    /**
     * @Title: selectListByBean 
     * @Description: 根据bean进行查询 
     * @param @param bean
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @throws
     */
    public List<LineDetailBean> selectListByBean(LineDetailBean bean){
    	return this.getSqlSession().selectList("linedetail.select", bean);
    }
    
}
