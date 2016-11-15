package com.erim.utils.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.EntityUtils;

import com.erim.core.exception.ErimException;

/**
 * 页面访问工具
 * 
 * @author songz
 */
@SuppressWarnings("deprecation")
public class HttpClientUtils {

    /**
     * 不带参数的Get请求
     * 
     * @param url 请求地址
     * 
     * @return request返回信息
     */
    public static String httpGet(String url, String charset) throws ErimException {

        String result = "";

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httppost = new HttpGet(url);

        try {
            HttpResponse response;
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
        } catch (ClientProtocolException e) {
            throw new ErimException("远程服务错误：ClientProtocolException");
        } catch (UnsupportedEncodingException e) {
            throw new ErimException("远程服务错误：UnsupportedEncodingException");
        } catch (IOException e) {
            throw new ErimException("远程服务错误：IOException");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return result;
    }
    
    /**
     * 不带参数的POST请求
     * 
     * @param url 请求地址
     * 
     * @return request返回信息
     */
    public static String httpPost(String url, String charset) throws ErimException {

        String result = "";

        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost(url);

        try {
            HttpResponse response;
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
        } catch (ClientProtocolException e) {
            throw new ErimException("远程服务错误：ClientProtocolException");
        } catch (UnsupportedEncodingException e) {
            throw new ErimException("远程服务错误：UnsupportedEncodingException");
        } catch (IOException e) {
            throw new ErimException("远程服务错误：IOException");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return result;
    }

    /**
     * 带参数的POST请求
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @return request返回信息
     */
    @SuppressWarnings("rawtypes")
    public static String httpPost(String url, String charset, HashMap<String, String> params) throws ErimException {

        String result = "";

        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        Set entries = params.entrySet();
        Iterator iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            formparams.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, charset);
            httppost.setEntity(uefEntity);
            HttpResponse response;
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
        } catch (ClientProtocolException e) {
            throw new ErimException("远程服务错误：ClientProtocolException");
        } catch (UnsupportedEncodingException e) {
            throw new ErimException("远程服务错误：UnsupportedEncodingException");
        } catch (IOException e) {
            throw new ErimException("远程服务错误：IOException");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return result;
    }

    /**
     * 带参数的POST请求
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @return request返回信息
     */
    @SuppressWarnings("rawtypes")
    public static void httpPostNoResponse(String url, String charset, HashMap<String, String> params) throws ErimException {

        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        Set entries = params.entrySet();
        Iterator iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            formparams.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, charset);
            httppost.setEntity(uefEntity);
            httpclient.execute(httppost);
        } catch (ClientProtocolException e) {
            throw new ErimException("远程服务错误：ClientProtocolException");
        } catch (UnsupportedEncodingException e) {
            throw new ErimException("远程服务错误：UnsupportedEncodingException");
        } catch (IOException e) {
            throw new ErimException("远程服务错误：IOException");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    /**
     * 获取远程访问页面全部信息，不进行任何处理
     * 
     * @param httpHost 获取地址的根域名
     * @param httpUrl 获取地址
     * @param charset 获取地址页面字符集
     * @return
     * @throws ErimException
     */
    public static String httpHtml(String httpHost, String httpUrl, String charset) throws ErimException {
        String result = "";

        HttpParams params = new BasicHttpParams();
        // HTTP 协议的版本,1.1/1.0/0.9
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        // 字符集
        HttpProtocolParams.setContentCharset(params, "UTF-8");
        HttpProtocolParams.setUserAgent(params, "HttpComponents/1.1");
        HttpProtocolParams.setUseExpectContinue(params, true);
        BasicHttpProcessor httpproc = new BasicHttpProcessor();
        httpproc.addInterceptor(new RequestContent());
        httpproc.addInterceptor(new RequestTargetHost());
        httpproc.addInterceptor(new RequestConnControl());
        httpproc.addInterceptor(new RequestUserAgent());
        httpproc.addInterceptor(new RequestExpectContinue());
        HttpRequestExecutor httpexecutor = new HttpRequestExecutor();
        HttpContext context = new BasicHttpContext(null);
        HttpHost host = new HttpHost(httpHost, 80);
        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();
        ConnectionReuseStrategy connStrategy = new DefaultConnectionReuseStrategy();
        context.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);
        context.setAttribute(ExecutionContext.HTTP_TARGET_HOST, host);

        if (!conn.isOpen()) {
            Socket socket = null;
            try {
                socket = new Socket(host.getHostName(), host.getPort());
                conn.bind(socket, params);
            } catch (UnknownHostException e) {
                throw new ErimException("远程服务错误：UnknownHostException");
            } catch (IOException e) {
                throw new ErimException("远程服务错误：IOException");
            }
        }

        BasicHttpRequest request = new BasicHttpRequest("GET", httpUrl);

        context.setAttribute(ExecutionContext.HTTP_REQUEST, request);
        request.setParams(params);
        try {
            httpexecutor.preProcess(request, httpproc, context);
            HttpResponse response = httpexecutor.execute(request, conn, context);
            response.setParams(params);
            httpexecutor.postProcess(response, httpproc, context);
            result = EntityUtils.toString(response.getEntity(), "gb2312");
            if (!connStrategy.keepAlive(response, context)) {
                conn.close();
            } else {
                System.out.println("Connection kept alive...");
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取远程访问页面全部信息，删除获取html中的script和style标签内容
     * 
     * @param httpHost 获取地址的根域名
     * @param httpUrl 获取地址
     * @param charset 获取地址页面字符集
     * @return
     * @throws ErimException
     */
    public static String httpHtmlAndDeal(String httpHost, String httpUrl, String charset) throws ErimException {
        String result = httpHtml(httpHost, httpUrl, charset);
        result = result.replaceAll("<script[^>]*>[\\S\\s]*?</script[^>]*>", "");
        result = result.replaceAll("<style[^>]*>[\\S\\s]*?</style[^>]*>", "");
        return result;
    }
}