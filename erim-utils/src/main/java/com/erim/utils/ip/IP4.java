package com.erim.utils.ip;

import javax.servlet.http.HttpServletRequest;

public class IP4 {

    public static final long a1 = getIpNum("10.0.0.0");
    public static final long a2 = getIpNum("10.255.255.255");
    public static final long b1 = getIpNum("172.16.0.0");
    public static final long b2 = getIpNum("172.31.255.255");
    public static final long c1 = getIpNum("192.168.0.0");
    public static final long c2 = getIpNum("192.168.255.255");
    public static final long d1 = getIpNum("10.44.0.0");
    public static final long d2 = getIpNum("10.69.0.255");

    /**
     * 获取客户端IP地址
     * 
     * @param request
     * @return
     */
    public static String getIP4(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 转换字符型IP为long型
     * @param ipAddress 字符型IP
     * @return long型IP
     */
    private static long getIpNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);
        return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
    }

    /**
     * 判断IP是否为内网IP
     * 
     * @param ip
     * 
     * @return
     */
    public static boolean isInnerIP(String ip) {
        long n = getIpNum(ip);
        return (n >= a1 && n <= a2) || (n >= b1 && n <= b2) || (n >= c1 && n <= c2) || (n >= d1 && n <= d2);
    }

    /**
     * 判断IP是否为内网IP
     * 
     * @param ip
     * 
     * @return
     */
    public static boolean isInnerIP(HttpServletRequest request) {
        long n = getIpNum(getIP4(request));
        return (n >= a1 && n <= a2) || (n >= b1 && n <= b2) || (n >= c1 && n <= c2) || (n >= d1 && n <= d2);
    }

}