/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageConstants.java : 2014-03-28
 */
package com.erim.sz.common.constant;

/**
 * @author 宋哲
 * @version 创建时间：2014-03-28
 * @description 常用常量
 */
public class ErimConstants {

    /** 是 */
    public static String YESORNO_YES             = "02";

    /** 否 */
    public static String YESORNO_NO              = "01";

    /** 男 */
    public static String SEX_MALE                = "01";

    /** 女 */
    public static String SEX_FEMALE              = "02";

    /** 正常 */
    public static String STATE_NORMAL            = "01";

    /** 禁用 */
    public static String STATE_FORBIDDEN         = "02";

    /** 企业角色 - 生产商 */
  	public static String COMPANYROLE_CREATER     = "1";
  	
  	/** 企业角色 - 销售商 */
  	public static String COMPANYROLE_SELLER      = "2";
  	
  	/** 企业角色 - 专线商 */
  	public static String COMPANYROLE_LINE        = "3";
  	
  	/** 企业角色 - 直营 */
  	public static String COMPANYROLE_ZY			 = "4";

  	/** 企业角色 - 佣金 */
  	public static String COMPANYROLE_YJ			 = "5";
  	
  	/** 同城 - 酒店 */
  	public static String TOWN_HOTEL				 = "HOTEL";
  	
  	/** 同城 - 特色餐 */
  	public static String TOWN_CAFETERIA			 = "CAFETERIA";

  	/** 同城 - 导游 */
  	public static String TOWN_GUIDE				 = "GUIDE";
  	
  	/** 同城 - 签证 */
  	public static String TOWN_MANAGEMENT		 = "MANAGEMENT";
  	
  	/** 同城 - 当地旅游 */
  	public static String TOWN_GROUND			 = "GROUND";
  	
  	/** 同城 - 飞机票 */
  	public static String TOWN_PLANETICKET		 = "PLANETICKET";
  	
  	/** 同城 - 租车 */
  	public static String TOWN_TEXI				 = "TEXI";

  	/** 同城 - 火车 */
  	public static String TOWN_TRANSTICKET		 = "TRANSTICKET";

  	/** 同城 - 专线 */
  	public static String TOWN_LINE		 		 = "LINE";
  	
  	/** 同城 - 门票 */
  	public static String TOWN_TICKET		     = "TICKET";
  	
  	/** 飞机 单程直飞 */
  	public static String TRANSNTYPE_DCZF		 = "1";
  	
  	/** 飞机 单程中转 */
  	public static String TRANSNTYPE_DCZZ		 = "2";
  	
  	/** 导游 - 服务类型 - 国内地陪 */
  	public static String GUIDE_SERVICE_LOCAL	 = "01";
  	
  	/** 导游 - 服务类型 - 国内全陪 */
  	public static String GUIDE_SERVICE_NATIONAL	 = "02";
  	
  	/** 导游 - 服务类型 - 国际/港澳台领队 */
  	public static String GUIDE_SERVICE_LEADER	 = "03";
  	
  	/** 导游 - 服务类型 - 国际地陪 */
  	public static String GUIDE_SERVICE_GAID	 	 = "04";
  	
  	/** 租车 - 使用类型 - 固定接送 */
  	public static String TEXI_APPLY_SEND 		 = "01";
  	
  	/** 租车 - 使用类型 - 包车 */
  	public static String TEXI_APPLY_CAR 		 = "02";
  	
  	/** 租车 - 使用类型 - 自驾 */
  	public static String TEXI_APPLY_DRIVE 		 = "03";
  	
  	/** 租车 - 固定接送 - 接机 */
  	public static String TEXI_SEND_JIEJI		 = "01";
  	
  	/** 租车 - 固定接送 - 送机 */
  	public static String TEXI_SEND_SONGJI		 = "02";
  	
  	/** 租车 - 固定接送 - 接站 */
  	public static String TEXI_SEND_JIEZHAN		 = "03";
  	
  	/** 租车 - 固定接送 - 送站 */
  	public static String TEXI_SEND_SONGZHAN		 = "04";
  	
  	/** 租车 - 固定接送 - 固定线路 */
  	public static String TEXI_SEND_GUDING		 = "05";
  	
  	/** 机票 - 舱位类型 - 经济舱 */
  	public static String PLANE_CALSS_ECONOMY 	 = "01";
  	
  	/** 机票 - 舱位类型 - 商务舱 */
  	public static String PLANE_CALSS_BUSINESS 	 = "02";
  	
  	/** 机票 - 舱位类型 - 头等舱 */
  	public static String PLANE_CALSS_FIRST 		 = "03";
  	
  	/** 锁定用户 */
  	public static String LOCK_USER_YES			 = "1";
  	/** 测试用户 */
  	public static String LOCK_USER_TEST			 = "2";
  	/** 付费用户 */
  	public static String LOCK_USER_PAY			 = "3";
}
