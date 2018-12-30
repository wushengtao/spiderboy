package com.lunzi.spiderboy.parse;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by lunzi on 2018/12/27 7:47 PM
 */
public class IpProxyPool {
    public static Map<Integer,Class> proxyAndParseMap= Maps.newConcurrentMap();
    static {
        for(int i=1;i<=16;i++){
            proxyAndParseMap.put(i,IpProxyHtmlParse.class);
        }
    }
}
