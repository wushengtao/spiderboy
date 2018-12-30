package com.lunzi.spiderboy;


import com.lunzi.spiderboy.factory.IpProxyFactory;

/**
 * 开始数据爬取的旅行吧！
 * Created by lunzi on 2018/12/16 9:14 PM
 */
public class StartTravel {
    public static void main(String[] args) {
        //爬取网页上的ip代理
        IpProxyFactory.getInstance().startGetIpProxy();

    }
}
