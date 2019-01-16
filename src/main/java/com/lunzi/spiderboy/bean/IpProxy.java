package com.lunzi.spiderboy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by lunzi on 2018/12/27 3:25 PM
 */
@Data
@ToString
@AllArgsConstructor
public class IpProxy {
    private String ip;//代理ip
    private Integer port;//代理端口
}
