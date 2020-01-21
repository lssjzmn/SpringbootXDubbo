package com.lssjzmn.util;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import java.lang.reflect.ParameterizedType;

/**
 * @description: 所有业务模块的HttpInvokerService的抽象基类,
 * 子类只需实现此基类并且实现setServiceUrl()方法并返回相应业务模块的请求地址
 * @author: 框架组
 * @create: 2020-01-16 13:34
 **/
public abstract class AbstractHttpInvokerService<T> {

    public <T> T getHttpInvokerService() {
        HttpInvokerProxyFactoryBean httpInvoker = new HttpInvokerProxyFactoryBean();
        httpInvoker.setServiceInterface((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        httpInvoker.setServiceUrl(setServiceUrl());
        HttpComponentsHttpInvokerRequestExecutor requestExecutor = new HttpComponentsHttpInvokerRequestExecutor();
        requestExecutor.setConnectTimeout(100000);
        requestExecutor.setConnectionRequestTimeout(600000);
        requestExecutor.setHttpClient(createHisHttpClient());
        httpInvoker.setHttpInvokerRequestExecutor(requestExecutor);
        httpInvoker.afterPropertiesSet();
        return (T) httpInvoker.getObject();
    }

    private HttpClient createHisHttpClient() {
        Registry<ConnectionSocketFactory> schemeRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(schemeRegistry);
        connectionManager.setMaxTotal(2000);
        connectionManager.setDefaultMaxPerRoute(100);
        return HttpClientBuilder.create().setConnectionManager(connectionManager).build();
    }

    /**
     * create by: 框架组
     * description: 后端httpInvoker请求地址，对应于applicationHttpInvoker.xml文件
     * create time: 2020/1/16 14:20
     */
    public abstract String setServiceUrl();

}
