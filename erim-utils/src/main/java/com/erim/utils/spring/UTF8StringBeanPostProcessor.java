package com.erim.utils.spring;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * Bean实例化之后调用，当bean的类型为StringHttpMessageConverter时，设置@responseBody返回数据编码为utf8类型
 * @author kk
 */
public class UTF8StringBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof StringHttpMessageConverter){
            MediaType mediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));
            List<MediaType> types = new ArrayList<MediaType>();
            types.add(mediaType);
            ((StringHttpMessageConverter) bean).setSupportedMediaTypes(types);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
