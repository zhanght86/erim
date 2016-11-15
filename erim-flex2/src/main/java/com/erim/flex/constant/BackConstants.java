/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BackConstants.java : 2011-10-14 上午12:11:29
 */
package com.erim.flex.constant;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-14 上午12:11:29
 * @description 回调标识用String目的是方便flex端进行匹配
 */
public class BackConstants {

    /**
     * 登入成功后，正常显示，0101
     */
    public static String BACK_LOGIN_SUCCESS_COMMON = "0101";

    /**
     * 登入成功后，富客户端显示，0102
     */
    public static String BACK_LOGIN_SUCCESS_RIA    = "0102";

    /**
     * 前端动作，显示表格，0201
     */
    public static String BACK_DATAGRID_SHOW        = "0201";

    /**
     * 前端动作，弹出窗体，0202
     */
    public static String BACK_PANEL_SHOW           = "0202";

    /**
     * 前端动作，刷新表格，0203
     */
    public static String BACK_DATAGRID_REFRESH     = "0203";

    /**
     * 前端动作，弹出正确提示，0204
     */
    public static String BACK_RIGHT_SHOW           = "0204";

    /**
     * 前端动作，显示表格并刷新全部数据包括按钮和列，0205
     */
    public static String BACK_DATAGRID_SHOW_ALL    = "0205";

    /**
     * 前端动作，弹出正确提示，并刷新表格数据，0206
     */
    public static String BACK_RIGHT_SHOW_DATA      = "0206";

    /**
     * 前端动作，弹出正确提示，显示表格并刷新全部数据包括按钮和列，0207
     */
    public static String BACK_RIGHT_SHOW_ALL       = "0207";

    /**
     * 前端动作，弹出窗体的方式显示报表，0208
     */
    public static String BACK_REPORT_POP           = "0208";

    /**
     * 前端动作，TAB方式显示报表，0209
     */
    public static String BACK_REPORT_TAB           = "0209";

    /**
     * 前端动作，弹出一个超链接
     */
    public static String BACK_LINK                 = "0210";

    /**
     * 前端动作，私有弹出页面
     */
    public static String BACK_PRIVATE_POPPAGE      = "0211";

    /**
     * 工具类动作，pagetool读取页面信息，0301
     **/
    public static String BACK_TOOLS_READ           = "0301";

    /**
     * 工具类动作，pagetool保存页面信息，0302
     **/
    public static String BACK_TOOLS_SAVE           = "0302";

    /**
     * 工具类动作，reporttool读取页面信息，0303
     **/
    public static String BACK_RTOOLS_READ          = "0303";

    /**
     * 工具类动作，reporttool保存页面信息，0304
     **/
    public static String BACK_RTOOLS_SAVE          = "0304";

    /**
     * 前端动作，私有方法回调，0401
     */
    public static String BACK_PRIVATE              = "0401";

}