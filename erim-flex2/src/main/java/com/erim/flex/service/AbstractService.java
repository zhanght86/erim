/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * AbstrServer.java : 2011-10-8 下午12:59:42
 */
package com.erim.flex.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.erim.core.bean.PageLinkBean;
import com.erim.core.exception.ErimException;
import com.erim.core.exception.SystemException;
import com.erim.core.lang.ExtHashMap;
import com.erim.core.service.BaseService;
import com.erim.flex.bean.FileBean;
import com.erim.flex.bean.FlexBean;
import com.erim.flex.bean.OperateLogBean;
import com.erim.flex.bean.PageBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.constant.PageConstants;
import com.erim.flex.dispatch.DispatchService;
import com.erim.flex.util.ErimUtils;
import com.erim.flex.util.ParseUtils;
import com.erim.utils.file.FileUtils;
import com.erim.utils.ip.IP4;
import com.erim.utils.lang.DateUtils;
import com.erim.utils.lang.ObjectUtils;
import com.erim.utils.properties.PropertiesUtils;

import flex.messaging.FlexContext;
import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-8 下午12:59:42
 * @description 所有业务类基类
 */
@SuppressWarnings("unchecked")
public abstract class AbstractService<T> extends BaseService {

    // --------------------------------------------------------------------------
    //
    // Variables
    //
    // --------------------------------------------------------------------------

    /**
     * 由Flex端传入的参数，参数集合类型为HashMap
     */
    protected ExtHashMap<String, Object> _inHashMap     = new ExtHashMap<String, Object>();

    /**
     * 由Java端传出的参数，参数集合类型为HashMap
     */
    protected HashMap<String, Object>    _outHashMap    = new HashMap<String, Object>();

    /**
     * 由Java端返回的回掉标志，类型为String，默认为"0"
     */
    protected String                     _backFlag      = "0000";

    /**
     * 由Java端传出的数据
     * @see FlexBean
     */
    protected FlexBean                   _flexBean      = new FlexBean();

    /**
     * 日志数据，子类可更改其属性
     * @see OperateLogBean
     */
    protected OperateLogBean             operateLogBean = new OperateLogBean();

    /**
     * 获取sqlsession后操作的数据库语句对应的命名空间
     */
    protected String                     namespace      = "";

    /**
     * beanname
     */
    protected String                     beanname       = "";

    /**
     * taskname
     */
    protected String                     taskname       = "";

    // --------------------------------------------------------------------------
    //
    // DispatchService直接调用的非Task方法
    //
    // --------------------------------------------------------------------------

    /**
     * 服务类初始化调用，于DispatchService中经由Spring获取的ServiceBean直接调用
     * @throws ErimException
     * @see DispatchService
     */
    public FlexBean initArgs(ASObject args) throws ErimException {
        _inHashMap.putAll(args);
        namespace = getNameSpace();
        taskname = _inHashMap.getString("taskname");
        beanname = _inHashMap.getString("beanname");
        return _flexBean;
    }

    /**
     * DispatchService获取Spring管理的bean后，调用对应的服务之前调用
     * @see DispatchService
     */
    public void before() {
    }

    /**
     * DispatchService获取Spring管理的bean后，调用对应的服务之后调用
     * @see DispatchService
     */
    public void after() {
        _flexBean.setBackFlag(_backFlag);
        _flexBean.setAsObject(_outHashMap);
    }

    /**
     * 服务类执行完毕调用，插入一条记录数据
     * @throws ErimException
     * @see DispatchService
     */
    public void insertOperateLog() throws ErimException {
        operateLogBean.setFuncId(ErimUtils.getFuncIdByAuth(beanname + "_" + taskname).toString());
        operateLogBean.setOperateIp(IP4.getIP4(FlexContext.getHttpRequest()));
        operateLogBean.setOperateTime(DateUtils.getCurrentDate());
        operateLogBean.setUserId(getSessionString("userId"));
        getSqlSession().insert("operatelog.insert", operateLogBean);
    }

    /**
     * 获取注入的mapper
     * 
     * @return
     * @throws ErimException
     */
    public abstract String getNameSpace();

    /**
     * 为数据源清空时utils方法反射调用
     */
    public void clearAll() {

    }

    // --------------------------------------------------------------------------
    //
    // DispatchService直接调用的Task方法，子类可重写
    //
    // --------------------------------------------------------------------------

    /**
     * 初始化弹出窗口信息
     * 
     * @return
     * @throws ErimException
     */
    public void init() throws ErimException {

        // 获取页面名称
        String pagename = _inHashMap.getString("pagename");

        // 获取所要跳转页面的信息
        PageBean pageinfo = ErimUtils.getPageBeanByPageName(pagename);

        // 检测页面是否存在
        if (pageinfo == null) {
            throw new SystemException("查询页面不存在，功能动作URL配置错误！");
        }

        // 获取所要跳转页面的详细信息
        List<PageDetailBean> pagedetail = commonGetPageDetail(pagename);

        // 设置参数
        _outHashMap.put("pageinfo", pageinfo);
        _outHashMap.put("pagedetail", pagedetail);
        _backFlag = BackConstants.BACK_PANEL_SHOW;
    }

    /**
     * 列表显示
     * 
     * @return 抽象类的FlexBean
     * @throws ErimException
     */
    public void list() throws ErimException {

        // 获取页面名称
        String pagename = _inHashMap.getString("pagename");

        // 获取所要跳转页面的信息
        PageBean pageinfo = ErimUtils.getPageBeanByPageName(pagename);

        // 检测页面是否存在
        if (pageinfo == null) {
            throw new SystemException("查询页面不存在，功能动作URL配置错误！");
        }

        // 获取所要跳转页面的详细信息
        List<PageDetailBean> pagedetail = commonGetPageDetail(pagename);

        // 更改翻页信息,用于直接翻页
        if (_inHashMap.get("qrysize") == null) {
        } else {
            int qrysize = _inHashMap.getInt("qrysize");
            int qrylimit = _inHashMap.getInt("qrylimit");
            _inHashMap.put("qrystart", String.valueOf(qrysize * qrylimit));
        }

        // 验证起始行号
        if (_inHashMap.get("qrystart") == null) {
            _inHashMap.put("qrystart", "0");
        }

        // 验证每页显示行数
        if (_inHashMap.get("qrylimit") == null) {
            _inHashMap.put("qrylimit", "100");
        }

        List<T> pageBusiData = commonGetListData();
        int start = _inHashMap.getInt("qrystart");
        int limit = _inHashMap.getInt("qrylimit");
        int count = commonGetCount();
        int pageCount = pageBusiData.size();
        int size = 0;
        if (count % limit == 0) {
            size = count / limit;
        } else {
            size = count / limit + 1;
        }
        int pageSize = start / limit + 1;

        // 翻页信息
        PageLinkBean pagelink = new PageLinkBean();
        pagelink.setStart(start);
        pagelink.setLimit(limit);
        pagelink.setCount(count);
        pagelink.setPageCount(pageCount);
        pagelink.setSize(size);
        pagelink.setPageSize(pageSize);

        // 画页面使用
        _outHashMap.put("pageinfo", pageinfo);

        // 画页面明细使用
        _outHashMap.put("pagedetail", pagedetail);

        // 刷新业务数据使用
        _outHashMap.put("datainfo", pageBusiData);

        // 翻页信息
        _outHashMap.put("pagelink", pagelink);

        // 入参 用于翻页查询条件带入
        _outHashMap.put("inhashmap", _inHashMap);
        _backFlag = BackConstants.BACK_DATAGRID_SHOW;
    }

    /**
     * 公共查询方法，可复写
     * 
     * @return
     * @throws ErimException
     */
    public void query() throws ErimException {
        list();
    }

    /**
     * 公共增加方法，可复写，默认调用对应mapper的insert方法
     * 
     * @return
     * @throws ErimException
     */
    public void insert() throws ErimException {
        getSqlSession().insert(namespace + ".insert", _inHashMap);
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 公共修改方法，可复写，默认调用对应mapper的update方法
     * 
     * @return
     * @throws ErimException
     */
    public void update() throws ErimException {
        getSqlSession().update(namespace + ".update", _inHashMap);
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 公共删除方法，可重写，默认调用对应mapper的delete方法
     * 
     * @return
     * @throws ErimException
     */
    public void delete() throws ErimException {
        getSqlSession().delete(namespace + ".delete", _inHashMap);
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 公共查看方法，可重写，默认调用对应mapper的select方法
     * 
     * @return
     * @throws ErimException
     */
    public void select() throws ErimException {
        init();
    }

    // --------------------------------------------------------------------------
    //
    // 子类可复用或重写的方法
    //
    // --------------------------------------------------------------------------

    /**
     * 获取列表显示数据，用于子类覆写
     * 
     * @return 当前页业务数据
     */
    public List<T> commonGetListData() {
        return getSqlSession().selectList(namespace + ".selectPage", _inHashMap, new RowBounds(_inHashMap.getInt("qrystart"), _inHashMap.getInt("qrylimit")));
    }

    /**
     * 获取查询结果总数，用于子类覆写
     * 
     * @return 总业务数据量
     */
    public Integer commonGetCount() {
        return getSqlSession().selectOne(namespace + ".selectCount", _inHashMap);
    }

    /**
     * 获取当前命名空间全部数据
     * 
     * @return 当前命名空间全部数据
     */
    public List<T> commonGetAll() {
        return getSqlSession().selectList(namespace + ".selectAll");
    }

    /**
     * 获取对应id的对象
     * 
     * @return 对应id的对象
     */
    public T commonGetEntityById() {
        return getSqlSession().selectOne(namespace + ".selectEntityById", _inHashMap);
    }

    /**
     * 获取对应name的对象
     * 
     * @return 对应name的对象
     */
    public T commonGetEntityByName() {
        return getSqlSession().selectOne(namespace + ".selectEntityByName", _inHashMap);
    }

    /**
     * 从前端获取传入数据的第一条
     * 
     * @param key datagrid表头对应键
     * @return
     */
    public String commonGetColumn(String key) {
        if (_inHashMap.get("dataitems") == null) {
            return null;
        }
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) _inHashMap.get("dataitems");
        if (list.get(0).get(key) == null) {
            return null;
        }
        return list.get(0).get(key).toString();
    }

    /**
     * 判断获取数据是否和选中第一行发生变更
     * 
     * @param key
     * @return 是否更改，true变更 false未变更
     */
    public boolean commonColumnIsChange(String key) {

        // 获取值
        String val = commonGetColumn(key);

        // 判断为null的情况相等
        if (val == null) {
            if (_inHashMap.getString(key) == null) {
                return false;
            } else {
                return true;
            }
        }

        // 不为null的情况
        if (val.equals(_inHashMap.getString(key))) {
            return false;
        }
        return true;
    }

    /**
     * 判断获取数据是否为null或者为空，当为null或者""的时候均返回true
     * 
     * @param key
     * @return 是否更改，true变更 false未变更
     */
    public boolean commonColumnIsNull(String key) {

        // 获取值
        String val = commonGetColumn(key);

        // null
        if (val == null) {
            return true;
        }

        // ""
        if ("".equals(val)) {
            return true;
        }
        return false;
    }

    /**
     * 更新session中的key值为value
     * 
     * @param key 键
     * @return 值
     */
    public void setSession(String key, Object value) {
        FlexContext.getFlexSession().setAttribute(key, value);
    }

    /**
     * 根据session中存入的key值获取value
     * 
     * @param key 键
     * @return 值
     */
    public String getSessionString(String key) {
        return FlexContext.getFlexSession().getAttribute(key).toString();
    }

    /**
     * 根据session中存入的key值获取value
     * 
     * @param key 键
     * @return 值
     */
    public Object getSessionObject(String key) {
        return FlexContext.getFlexSession().getAttribute(key);
    }

    // --------------------------------------------------------------------------
    //
    // 页面组件相关的方法
    //
    // --------------------------------------------------------------------------

    /**
     * 获取的页面详细信息
     * 
     * @param pagename
     * @return
     * @throws ErimException
     */
    public List<PageDetailBean> commonGetPageDetail(String pagename) throws ErimException {

        // 单例获取页面详细信息集合
        List<PageDetailBean> pagedetail = ErimUtils.getPageDetailListByPageName(pagename);

        // 待删除明细集合
        List<PageDetailBean> deleteList = new ArrayList<PageDetailBean>();

        // 非空转换，否则前后端显示没有详细内容的页面报错
        if (pagedetail == null) {
            pagedetail = new ArrayList<PageDetailBean>();
        }

        // 深度复制List列表，保证下次处理标签的时候标签不会被冲掉
        pagedetail = (List<PageDetailBean>) ObjectUtils.deepClone(pagedetail);

        // 处理组件，解析数据源并添加
        for (PageDetailBean bean : pagedetail) {

            // 公共处理，返回false则删除该控件
            if (commonDealPageDetail(bean)) {
            } else {
                deleteList.add(bean);
            }

            // 各service类调用私有组件实现，对某一个组件修改数据源等，针对组件CheckTree添加的这个方法
            dealPageDetail(bean);
        }

        // 将待删除的明细组件删除
        pagedetail.removeAll(deleteList);

        return pagedetail;
    }

    /**
     * 处理获取的bean并更新数据源等
     * 
     * @param bean
     * @throws ErimException
     */
    private boolean commonDealPageDetail(PageDetailBean bean) throws ErimException {

        // 解析数据源标签
        if (bean.getData() == null) {
        } else {
            bean.setDataProvider(ParseUtils.parseData(bean, _inHashMap));
        }

        // 解析文本标签
        if (bean.getText() == null) {
        } else {
            bean.setText(ParseUtils.parseText(bean, _inHashMap));
        }

        // 解析动作标签
        if (bean.getAction() == null) {
        } else {
            bean.setAction(ParseUtils.parseAction(bean, _inHashMap));
        }

        // 处理表格列头
        if (PageConstants.PAGE_DETAIL_TYPE_DATAGRID_COLUMN.equals(bean.getType())) {

            // 若列头不存在validator，则不需要验证
            if (bean.getValidator() == null) {
                return true;
            }

            // 若列头存在validator，并且以^开头则为渲染输入验证，不进行权限验证
            if("^".equals(bean.getValidator().substring(0, 1))){
                return true;
            }
            
            // 若列头存在validator，则需要验证权限
            if (ErimUtils.hasAuth(bean.getValidator())) {
                return true;
            } else {
                return false;
            }

        }

        // 处理链接按钮和双击列表，验证是否拥有权限
        if (PageConstants.PAGE_DETAIL_TYPE_LINK_BUTTON.equals(bean.getType()) || PageConstants.PAGE_DETAIL_TYPE_DATAGRID_DOUBLE.equals(bean.getType())) {

            // 若按钮不存在name，则不需要验证
            if (bean.getName() == null) {
                return true;
            }

            // 若按钮存在name，则需要验证权限
            if (ErimUtils.hasAuth(bean.getName())) {
                return true;
            } else {
                return false;
            }
        }

        // 处理文件上传组件
        else if (PageConstants.PAGE_DETAIL_TYPE_FILE_UPLOAD.equals(bean.getType())) {

            // 如果action为null则直接取properties[app.file.url.up]，若不为null则直接取值
            if (bean.getAction() == null) {
                bean.setAction(PropertiesUtils.getPropertyByKey("app.file.url.up"));
            }

            // 如果text为null则直接取properties[app.file.path.default]，若不为null则直接取值
            if (bean.getText() == null) {
                bean.setText(PropertiesUtils.getPropertyByKey("app.file.path.default"));
            }

            // 获取文件的序号，用于后台存储文件
            bean.setData(FileUtils.getFileName());

            return true;
        }

        // 处理文件下载组件
        else if (PageConstants.PAGE_DETAIL_TYPE_FILE_DOWNLOAD.equals(bean.getType())) {

            // 如果action为null则直接取properties[app.file.url.down]，若不为null则直接取值
            if (bean.getAction() == null) {
                bean.setAction(PropertiesUtils.getPropertyByKey("app.file.url.down"));
            }
            List<FileBean> list = new ArrayList<FileBean>();

            // 若text为xx_xx则为通过批次号获取文件
            if (bean.getText().split("_").length == 2) {
                list = getSqlSession().selectList("file.selectEntitysByBatch", bean.getText());
            }

            // 若text为xx_xx_xx则为通过id获取文件
            else {
                list.add((FileBean) getSqlSession().selectOne("file.selectEntityById", bean.getText()));
            }

            // 放到数据源中返回
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("filelist", list);
            bean.setDataProvider(hashMap);

            return true;
        }

        // 处理ueditor文本编辑器
        else if (PageConstants.PAGE_DETAIL_TYPE_RICHTEXT_HTML.equals(bean.getType())) {

            // 如果action为null则直接取properties[app.ueditor.url]，若不为null则直接取值
            if (bean.getAction() == null) {
                bean.setAction(PropertiesUtils.getPropertyByKey("app.ueditor.url"));
            }

            return true;
        }

        return true;
    }

    /**
     * 各service类调用私有组件实现，对某一个组件修改数据源等，针对组件CheckTree添加的这个方法
     * 
     * @param bean
     * @throws ErimException
     */
    public void dealPageDetail(PageDetailBean bean) throws ErimException {

    }

    // --------------------------------------------------------------------------
    //
    // 文件处理相关方法
    //
    // --------------------------------------------------------------------------

    /**
     * 根据表单名获取第一个文件
     * 
     * @param varname 上传组件变量名
     * @return 上传列表中的第一个文件
     */
    private FileBean commonGetFileBean(String varname) {

        // 若为空则直接返回，不进行处理
        Object[] obs = (Object[]) _inHashMap.get(varname);
        if (obs.length == 0) {
            return null;
        }

        // 处理传入值并返回
        ASObject aso = (ASObject) obs[0];
        FileBean bean = new FileBean();
        bean.setId(aso.get("id").toString());
        bean.setName(aso.get("name").toString());
        bean.setBatch(aso.get("batch").toString());
        bean.setPath(aso.get("path").toString());
        bean.setSize(aso.get("size").toString());
        bean.setSuffix(FileUtils.getSuffixByFileName(bean.getName()));

        return bean;
    }

    /**
     * 根据表单名获取文件列表 
     * 
     * @param varname 上传组件变量名
     * @return 上传列表中的所有文件
     */
    private List<FileBean> commonGetFileBeans(String varname) {

        // 若不存在，则不进行处理
        if (_inHashMap.get(varname) == null) {
            return null;
        }

        // 若为空则直接返回，不进行处理
        Object[] obs = (Object[]) _inHashMap.get(varname);
        if (obs.length == 0) {
            return null;
        }

        // 处理传入值并返回
        List<FileBean> list = new ArrayList<FileBean>();
        ASObject aso = null;
        for (Object o : obs) {
            aso = (ASObject) o;
            FileBean bean = new FileBean();
            bean.setId(aso.get("id").toString());
            bean.setName(aso.get("name").toString());
            bean.setBatch(aso.get("batch").toString());
            bean.setPath(aso.get("path").toString());
            bean.setSize(aso.get("size").toString());
            bean.setSuffix(FileUtils.getSuffixByFileName(bean.getName()));
            list.add(bean);
        }

        return list;
    }

    /**
     * 文件上传成功调用，插入数据
     * 
     * @param varname 前台_hashMap中file文件对应的key值，value为数组
     * @return 本批次文件列表
     * @throws ErimException 文件转移IO错误 
     */
    public List<FileBean> commonInsertFile(String varname) throws ErimException {

        List<FileBean> list = null;

        try {

            // 文件处理后返回的文件集合
            list = commonGetFileBeans(varname);

            //　不上传文件的时候返回空列表
            if (list == null) {
                return null;
            }

            // 从配置文件中获取文件上传相关的路径
            String sourceDir = PropertiesUtils.getPropertyByKey("app.file.path.prefix") + File.separator + PropertiesUtils.getPropertyByKey("app.file.path.temp");
            String targetDir = PropertiesUtils.getPropertyByKey("app.file.path.prefix") + File.separator + FileUtils.dealFilePath(list.get(0).getPath());
            File sourceFile;
            File targetFile;

            // 转移文件，从temp中转移到对应的path路径
            for (FileBean bean : list) {
                sourceFile = new File(sourceDir + File.separator + bean.getId());
                targetFile = new File(targetDir + File.separator + bean.getId() + bean.getSuffix());
                //　若目标文件存在，则删除
                if (targetFile.exists()) {
                    org.apache.commons.io.FileUtils.deleteQuietly(targetFile);
                }
                // 将文件从temp路径转移到目标路径
                org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);
                org.apache.commons.io.FileUtils.deleteQuietly(sourceFile);
            }

            // 插入处理后的文件数据
            _inHashMap.put("fileitems", list);

            // 保存新的数据
            getSqlSession().insert("file.insertbatch", _inHashMap);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErimException("文件增加过程中发生错误！");
        }

        return list;
    }

    /**
     * 根据ID修改数据及文件
     * 
     * @param id 原文件ID
     * @param varname 前台_hashMap中file文件对应的key值，value为数组，只有一条数据
     * @return 修改后的文件
     * @throws ErimException
     */
    public FileBean commonUpdateFile(String id, String varname) throws ErimException {

        // 修改后的文件
        FileBean bean = null;

        try {

            bean = commonGetFileBean(varname);

            //　不上传文件的时候返回空列表
            if (bean == null) {
                return null;
            }

            // 从配置文件中获取文件上传相关的路径
            String sourceDir = PropertiesUtils.getPropertyByKey("app.file.path.prefix") + File.separator + PropertiesUtils.getPropertyByKey("app.file.path.temp");
            String targetDir = PropertiesUtils.getPropertyByKey("app.file.path.prefix") + File.separator + FileUtils.dealFilePath(bean.getPath());
            File sourceFile = new File(sourceDir + File.separator + bean.getId());
            File targetFile = new File(targetDir + File.separator + id + bean.getSuffix());

            //　若目标文件存在，则删除 
            if (targetFile.exists()) {
                org.apache.commons.io.FileUtils.deleteQuietly(targetFile);
            }

            // 将文件从temp路径转移到目标路径
            org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);
            org.apache.commons.io.FileUtils.deleteQuietly(sourceFile);

            // 修改数据
            bean.setId(id);
            bean.setBatch(FileUtils.getBatchByFileId(id));
            getSqlSession().update("file.update", bean);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErimException("文件修改过程中发生错误！");
        }

        return bean;
    }

}