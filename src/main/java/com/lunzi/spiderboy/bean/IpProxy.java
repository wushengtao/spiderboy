package com.lunzi.spiderboy.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by lunzi on 2018/12/27 3:25 PM
 */
@Data
@Builder
@ToString
public class IpProxy {
    private String ip;//代理ip
    private Integer port;//代理端口
    private Integer anonymousType;//匿名
    private Integer protocolType;//http,https
    private Double speed;//速度
    private Double connectTime;//连接时间
    private Double surviveTime;//存活时间

}
