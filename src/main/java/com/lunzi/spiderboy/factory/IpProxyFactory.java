package com.lunzi.spiderboy.factory;

import com.lunzi.spiderboy.client.ProxyHttpClient;

/**
 * Created by lunzi on 2018/12/16 9:25 PM
 */
public class ProxyHttpFactory {
    private static volatile ProxyHttpClient proxyHttpClient;
    public static ProxyHttpClient getInstance() {
        if(proxyHttpClient==null){
            synchronized (ProxyHttpFactory.class){
                if(proxyHttpClient==null){
                    proxyHttpClient=new ProxyHttpClient();
                }
            }
        }
        return proxyHttpClient;
    }
}
