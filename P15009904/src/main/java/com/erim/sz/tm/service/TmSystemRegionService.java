package com.erim.sz.tm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.tm.bean.TmSystemRegionBean;
import com.erim.sz.tm.dao.TmSystemRegionDao;

/**
 * 
 * @ClassName: RegionService 
 * @Description: 省市县 
 * @author maoxian
 * @date 2015年8月19日 下午4:47:05 
 *
 */
@Service("tmSystemRegionService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TmSystemRegionService {

	@Autowired
	private TmSystemRegionDao  							   			    regionDao;
	
	 /** 代码信息列表 */
    private List<TmSystemRegionBean>                         			codeList;
	
	/** 代码信息键值对{代码序号:代码对应的数据源，用于便捷获取与数据源} */
    private ExtHashMap<Integer, ExtHashMap<Integer, String>> 		    codeHashMap;
    
    /** 代码信息键值对{代码序号:代码对应的数据源，用于普通web项目获取数据源} */
    private ExtHashMap<Integer, List<TmSystemRegionBean>>               codeHashMapList;
    
    @PostConstruct
    public void initCodeService() {
        // 代码
        codeHashMap = getSystemCode();
        codeHashMapList = getSystemCodeList();
    }

    /**
	 * 
	 * @Title: getSystemRegionById
	 * @Description: 根据区划ID获取区划名称
	 * @param id
	 * @return
	 *
	 */
	public String getSystemRegionById(Integer id) {
		
		String name = "";
		TmSystemRegionBean bean = regionDao.getSystemRegionById(id);
		
		if (bean != null) {
			name = bean.getRegionName();
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
            List<TmSystemRegionBean> list = regionDao.selectAllCode();
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (codeHashMap.get(list.get(i).getRegionPid()) == null) {
                    codeHashMap.put(list.get(i).getRegionPid(), new ExtHashMap<Integer, String>());
                }

                // 填充新的键值对到对应数据源中
                codeHashMap.get(list.get(i).getRegionPid()).put(list.get(i).getRegionId(), list.get(i).getRegionName());
            }
        }
        return codeHashMap;
    }

    /**
     * 便捷获取，获取代码信息键值对，键为代码序号，获取内容格式：{codeid,List<CodeBean>}
     * 
     * @return
     */
    public ExtHashMap<Integer, List<TmSystemRegionBean>> getSystemCodeList() {
        if (codeHashMapList == null) {
            codeHashMapList = new ExtHashMap<Integer, List<TmSystemRegionBean>>();

            // 查询全部code数据
            List<TmSystemRegionBean> list = getCodeList();
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (codeHashMapList.get(list.get(i).getRegionPid()) == null) {
                    codeHashMapList.put(list.get(i).getRegionPid(), new ArrayList<TmSystemRegionBean>());
                }

                // 填充新的键值对到对应数据源中
                codeHashMapList.get(list.get(i).getRegionPid()).add(list.get(i));
            }
        }
        return codeHashMapList;
    }
    
    /**
     * 获取代码列表集合
     * 
     * @return
     */
    public List<TmSystemRegionBean> getCodeList() {
        if (codeList == null) {
            codeList = regionDao.selectAllCode();
        }
        return codeList;
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
     * 根据代码序号获取该代码的CodeBean集合信息
     * 
     * @param codeNo 代码序号
     * 
     * @return CodeBean集合
     */
    public List<TmSystemRegionBean> getSystemCodeListByCodeNo(Integer codeNo) {
        return getSystemCodeList().get(codeNo);
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
