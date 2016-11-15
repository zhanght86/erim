package com.erim.sz.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.service.AbstractService;
import com.erim.sz.common.bean.YjSystemUserBean;

/**
 * @ClassName: YjSystemUserService 
 * @Description: 佣金平台
 * @author maoxian
 * @date 2015年12月18日 上午4:41:55
 */

@Service("yjSystemUser")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class YjSystemUserService extends AbstractService<YjSystemUserBean> {
	// --------------------------------------------------------------------------
	//
	// Methods Implements
	//
	// --------------------------------------------------------------------------

	@Override
	public String getNameSpace() {
		// TODO Auto-generated method stub
		return "yjSystemUser";
	}

	// --------------------------------------------------------------------------
	//
	// Methods Extends
	//
	// --------------------------------------------------------------------------

	@Override
	public void dealPageDetail(PageDetailBean bean) throws ErimException {

		// 先执行父类
		super.dealPageDetail(bean);

	}

	/**
	 * 插入佣金平台用户信息
	 */
	public void insert() throws ErimException{
		String yjUserLoginname = _inHashMap.getString("yjUserLoginname").toString();
		
		Integer nameCount = getSqlSession().selectOne(namespace + ".verifyLoginName", yjUserLoginname);
		 // 验证用户名是否存在
        if (nameCount != null && nameCount != 0) {
            throw new BusinessException("该用户名已经存在！");
        }
        _inHashMap.put("cpyId", commonGetColumn("id"));
        _inHashMap.put("yjParentLoginname", this.getSqlSession().selectOne("companyDetail.verifyCpyid", commonGetColumn("id")));
		_inHashMap.put("yjUserPassword", DigestUtils.md5Hex("111111"));
		_inHashMap.put("yjUserCode", DigestUtils.md5Hex(yjUserLoginname));
		_inHashMap.put("yjRoleId", "2");
		super.insert();
	}
}
