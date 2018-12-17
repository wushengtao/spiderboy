package com.lunzi.spiderboy.bean;

import lombok.Builder;
import lombok.Data;

/**
 * http代理实体
 * Created by lunzi on 2018/12/16 10:01 PM
 */
@Data
@Builder
public class HttpProxy {
    private String ip;//代理ip地址
    private int port;//端口
    private boolean isAnonymous;//是否为匿名代理

    public HttpProxy(String ip, int port, boolean isAnonymous) {
        this.ip = ip;
        this.port = port;
        this.isAnonymous = isAnonymous;
    }
}
