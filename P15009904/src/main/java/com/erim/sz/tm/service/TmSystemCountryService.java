package com.erim.sz.tm.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.tm.bean.TmSystemCountryBean;
import com.erim.sz.tm.dao.TmSystemCountryDao;

/**
 * @ClassName: TmSystemCountryService 
 * @Description: 国家 市
 * @author maoxian
 * @date 2015年10月23日 下午1:05:23
 */
@Service("tmSystemcountryService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TmSystemCountryService {

	@Autowired
	private TmSystemCountryDao  							   countryDao;
	
	/** 代码信息键值对{代码序号:代码对应的数据源，用于便捷获取与数据源} */
    private ExtHashMap<Integer, ExtHashMap<Integer, String>>   codeHashMap;
    
    @PostConstruct
    public void initCodeService() {
        // 代码
        codeHashMap = getSystemCode();
    }

    /**
	 * 
	 * @Title: getSystemcountryById
	 * @Description: 根据区划ID获取区划名称
	 * @param id
	 * @return
	 *
	 */
	public String getSystemcountryById(Integer id) {
		
		String name = "";
		TmSystemCountryBean bean = countryDao.getSystemCountryById(id);
		
		if (bean != null) {
			name = bean.getCountryName();
		}
		return name;
	}
	
    /**
     * 便捷获取，获取代码信息键值对，键为代码序号，获取内容格式：{codeid,ExtHashMap<key,value>}
     * 
     * @return
     */
    public ExtHashMap<Integer, ExtHashMap<Integer, String>> getSystemCode() {
        if (codeHashMap == null) {
            codeHashMap = new ExtHashMap<Integer, ExtHashMap<Integer, String>>();

            // 查询全部code数据
            List<TmSystemCountryBean> list = countryDao.selectAllCode();
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (codeHashMap.get(list.get(i).getCountryPid()) == null) {
                    codeHashMap.put(list.get(i).getCountryPid(), new ExtHashMap<Integer, String>());
                }

                // 填充新的键值对到对应数据源中
                codeHashMap.get(list.get(i).getCountryPid()).put(list.get(i).getCountryId(), list.get(i).getCountryName());
            }
        }
        return codeHashMap;
    }

    /**
     * 根据代码序号获取该代码的键值对信息
     * 
     * @param codeNo 代码序号
     * 
     * @return 代码键值对
     */
    public ExtHashMap<Integer, String> getSystemCodeByCodeNo(Integer codeNo) {
        return getSystemCode().get(codeNo);
    }

    /**
     * 根据代码序号及代码键返回代码值
     * 
     * @param codeNo 代码序号
     * @param key 代码键
     * 
     * @return value 代码值
     */
    public String getValueByCodeNoAndKey(String codeNo, String key) {

        // 若key为null则直接返回null
        if (key == null) {
            return null;
        }

        // 若codeNo不存在，则返回key
        if (codeHashMap.get(codeNo) == null) {
            return key;
        } else {
            // 若codeNo下key对应的valye不存在，则返回key
            if (codeHashMap.get(codeNo).get(key) == null) {
                return key;
            } else {
                return codeHashMap.get(codeNo).get(key);
            }
        }

    }
}
