package com.lunzi.spiderboy.client;

import com.lunzi.spiderboy.bean.WebPage;
import com.lunzi.spiderboy.util.HttpUtil;

/**
 * 抽象httpclient，包含了一些通用的操作
 * Created by lunzi on 2018/12/16 9:35 PM
 */
public abstract class AbstractHttpClient {
    /**
     *
     * @param url 页面的地址
     * @param charset 编码类型
     * @return
     */
    public WebPage getWebPage(String url,String charset){
        return null;
    }
}
