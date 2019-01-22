package com.lunzi.spiderboy.task;

import com.google.common.collect.Lists;
import com.lunzi.spiderboy.client.IpProxyClient;
import com.lunzi.spiderboy.factory.IpProxyFactory;
import com.lunzi.spiderboy.util.CommonConstant;

import java.io.IOException;
import java.util.List;

/**
 * ip代理解析任务
 * Created by lunzi on 2018/12/22 10:27 PM
 */
public class IpProxyParseTask implements Runnable {
    private Integer pageIndex;
    private static IpProxyClient ipProxyClient=IpProxyFactory.getInstance();
    public IpProxyParseTask(Integer pageIndex){
        this.pageIndex=pageIndex;
    }
    @Override
    public void run() {
        //构建需要解析的代理列表
        List<String> urlList=Lists.newLinkedList();
        for(int i=1;i<=4;i++){
            urlList.add(CommonConstant.XICIDAILI_NN+(pageIndex*i));
        }
        try {
            ipProxyClient.parse(urlList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
