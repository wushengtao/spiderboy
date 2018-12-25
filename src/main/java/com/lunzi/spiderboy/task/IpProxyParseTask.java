package com.lunzi.spiderboy.task;

import com.lunzi.spiderboy.client.IpProxyClient;
import com.lunzi.spiderboy.factory.IpProxyFactory;

import java.io.IOException;

/**
 * Created by lunzi on 2018/12/22 10:27 PM
 */
public class IpProxyParseTask implements Runnable {
    private String url;
    private static IpProxyClient ipProxyClient=IpProxyFactory.getInstance();
    @Override
    public void run() {
        try {
            ipProxyClient.parse(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
