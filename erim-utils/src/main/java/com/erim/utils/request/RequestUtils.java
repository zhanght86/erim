package com.erim.utils.request;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    /**
     * 根据request获取访问路径
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    }

    /**
     * 根据request判断是否为PC端访问
     * @param request
     * @return
     */
    public static boolean isIphoneOrAndroid(HttpServletRequest request) {

        // 返回标志
        boolean result = false;

        // 获取头信息
        String clientType = request.getHeader("user-agent").toLowerCase();
        
        // 判断头信息
        if (clientType.indexOf("iphone") != -1 || clientType.indexOf("android") != -1) {
            result = true;
        }

        // 返回
        return result;
    }

}