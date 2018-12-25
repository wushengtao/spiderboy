package com.lunzi.spiderboy.factory;

import com.lunzi.spiderboy.client.IpProxyClient;

/**
 * Created by lunzi on 2018/12/16 9:25 PM
 */
public class IpProxyFactory {
    private static volatile IpProxyClient ipProxyClient;
    //dlc单例
    public static IpProxyClient getInstance() {
        if(ipProxyClient==null){
            synchronized (IpProxyFactory.class){
                if(ipProxyClient==null){
                    ipProxyClient=new IpProxyClient();
                }
            }
        }
        return ipProxyClient;
    }

}
