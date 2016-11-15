package com.erim.utils.weixin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.erim.utils.lang.DateUtils;

import flex.messaging.FlexContext;
import flex.messaging.FlexSession;

/**
 * 微信token工具类
 * @author songz
 */
public class WxTokenUtils {

    /** 日志 */
    private static Logger       log          = LoggerFactory.getLogger(WxTokenUtils.class);

    /** 获取token接口-get */
    private static final String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * 根据常量返回获取token的url
     * 
     * @param appId
     * @param appSecret
     * 
     * @return tokenUrl
     */
    public static String getTokenUrl(String appId, String appSecret) {
        return String.format(ACCESS_TOKEN, appId, appSecret);
    }

    /**
     * 通用接口获取Token凭证
     * 
     * @param appId
     * @param appSecret
     * 
     * @return token
     */
    private static String getToken(String appId, String appSecret) {

        // 判断参数
        if (appId == null || appSecret == null) {
            return null;
        }
        String token = null;

        // 获取token请求地址
        String tockenUrl = WxTokenUtils.getTokenUrl(appId, appSecret);

        // 发送https请求
        String response = WxRequestUtils.httpRequest(tockenUrl, "GET", null);

        // 返回数据处理
        JSONObject jsonObject = JSONObject.parseObject(response);
        if (null != jsonObject) {
            try {
                token = jsonObject.getString("access_token");
            } catch (JSONException e) {
                token = null;
                log.error("get token failed!", e);
            }
        }
        return token;
    }

    /**
     * 通用接口获取Token凭证，每一个小时获取一次，token存放在shiro的session中，用于web项目<br>
     * session存放token的key为access_token，存放token获取时间为access_token_time
     * 
     * @param appId
     * @param appSecret
     * 
     * @return token
     */
    public static String getTokenByShiro(String appId, String appSecret) {

        // 判断参数
        if (appId == null || appSecret == null) {
            return null;
        }
        String token = null;
        Session session = SecurityUtils.getSubject().getSession();

        // 判断session是否有session，没有则获取后set到session里
        if (session.getAttribute("access_token") == null) {
            token = getToken(appId, appSecret);
            session.setAttribute("access_token", token);
            session.setAttribute("access_token_time", DateUtils.getCurrentDate());
            return token;
        } else {
            // 判断时间是否超过1个小时，超过一个小时从新获取
            if (DateUtils.compareDateSeconds(session.getAttribute("access_token_time").toString(), null) > 3600) {
                token = getToken(appId, appSecret);
                session.setAttribute("access_token", token);
                session.setAttribute("access_token_time", DateUtils.getCurrentDate());
                return token;
            } else {
                return session.getAttribute("access_token").toString();
            }
        }
    }

    /**
     * 通用接口获取Token凭证，每一个小时获取一次，token存放在shiro的session中，用于web项目<br>
     * session存放token的key为access_token，存放token获取时间为access_token_time
     * 
     * @param appId
     * @param appSecret
     * 
     * @return token
     */
    public static String getTokenTimeByShiro() {

        // 参数
        Session session = SecurityUtils.getSubject().getSession();

        // 获取
        if (session.getAttribute("access_token") == null) {
            return null;
        }
        return session.getAttribute("access_token_time").toString();
    }

    /**
     * 将存放session中的access_token与access_token_time移除，进行重新获取
     * 
     * @param session Shiro下session
     */
    public static void clearTokenByShiro() {
        Session session = SecurityUtils.getSubject().getSession();
        session.removeAttribute("access_token");
        session.removeAttribute("access_token_time");
    }

    /**
     * 通用接口获取Token凭证，每一个小时获取一次，token存放在shiro的session中，用于web项目<br>
     * session存放token的key为access_token，存放token获取时间为access_token_time
     * 
     * @param appId
     * @param appSecret
     * 
     * @return token
     */
    public static String getTokenByFlex(String appId, String appSecret) {

        // 判断参数
        if (appId == null || appSecret == null) {
            return null;
        }
        String token = null;
        FlexSession session = FlexContext.getFlexSession();

        // 判断session是否有session，没有则获取后set到session里
        if (session.getAttribute("access_token") == null) {
            token = getToken(appId, appSecret);
            session.setAttribute("access_token", token);
            session.setAttribute("access_token_time", DateUtils.getCurrentDate());
            return token;
        } else {
            // 判断时间是否超过1个小时，超过一个小时从新获取
            if (DateUtils.compareDateSeconds(session.getAttribute("access_token_time").toString(), null) > 3600) {
                token = getToken(appId, appSecret);
                session.setAttribute("access_token", token);
                session.setAttribute("access_token_time", DateUtils.getCurrentDate());
                return token;
            } else {
                return session.getAttribute("access_token").toString();
            }
        }
    }

    /**
     * 通用接口获取Token凭证，每一个小时获取一次，token存放在shiro的session中，用于web项目<br>
     * session存放token的key为access_token，存放token获取时间为access_token_time
     * 
     * @param appId
     * @param appSecret
     * 
     * @return token
     */
    public static String getTokenTimeByFlex() {

        // 参数
        FlexSession session = FlexContext.getFlexSession();

        // 获取
        if (session.getAttribute("access_token") == null) {
            return null;
        }
        return session.getAttribute("access_token_time").toString();
    }

    /**
     * 将存放session中的access_token与access_token_time移除，进行重新获取
     * 
     * @param session Shiro下session
     */
    public static void clearTokenByFlex() {
        FlexSession session = FlexContext.getFlexSession();
        session.removeAttribute("access_token");
        session.removeAttribute("access_token_time");
    }
}
