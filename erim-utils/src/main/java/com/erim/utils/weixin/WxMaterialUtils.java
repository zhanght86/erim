package com.erim.utils.weixin;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.erim.core.exception.ErimException;

/**
 * 微信上传文件工具类
 * @author songz
 */
public class WxMaterialUtils {

    /** 日志 */
    private static Logger       log             = LoggerFactory.getLogger(WxMaterialUtils.class);

    /** 上传永久素材图片路径 */
    private static final String UPLOAD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s";

    /**
     * 微信服务器永久素材上传
     * 
     * @param sfile 素材路径
     * @param token access_token
     * @param type 素材类型image图片voice语音thumb缩略图
     */
    public static JSONObject uploadMaterial(String sfile, String token, String type) throws ErimException {

        // 判断参数
        if (sfile == null || token == null) {
            return null;
        }

        // 检查文件是否存在
        File file = new File(sfile);
        if (!file.exists()) {
            log.info("上传文件不存在,请检查!");
            throw new ErimException(sfile + "==》图片文件不存在！");
        }

        String url = String.format(UPLOAD_MATERIAL, token);
        JSONObject jsonObject = null;

        // 上传文件
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        FileBody fileb = new FileBody(file);
        HttpEntity entity = MultipartEntityBuilder.create().addPart("media", fileb).addTextBody("type", type).build();
        httpPost.setEntity(entity);

        // 返回值判断
        try {
            CloseableHttpResponse reponse = httpClient.execute(httpPost);
            jsonObject = JSONObject.parseObject(EntityUtils.toString(reponse.getEntity()));
        } catch (ClientProtocolException e) {
            log.error("ClientProtocolException", e);
        } catch (IOException e) {
            log.error("IOException", e);
        } catch (Exception e) {
            log.error("Exception", e);
        }

        return jsonObject;
    }
}
