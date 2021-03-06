package com.lunzi.spiderboy.bean;

import lombok.Data;

/**
 * 页面实体类
 * Created by lunzi on 2018/12/16 9:58 PM
 */
@Data
public class WebPage {
    private String content;//页面内容（html）
    private String url;//请求地址
    private String statusCode;//返回的状态码
    private HttpProxy httpProxy;
}
