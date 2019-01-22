package com.lunzi.spiderboy.client;

import com.lunzi.spiderboy.bean.WebPage;
import com.lunzi.spiderboy.util.HttpUtil;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;


/**
 * Created by lunzi on 2018/12/16 9:35 PM
 */
public class AbstractHttpClient {
    /**
     * 获取网页内容
     * @param url 地址
     * @param charset 字符集 (传入null,默认为utf-8)
     * @return
     * @throws IOException
     */
    private  WebPage getWebPage(String url,String charset) throws IOException {
        Response response=HttpUtil.getResponse(url,"utf-8");
        Integer code=response.code();
        WebPage.WebPageBuilder webPageBuilder =WebPage.builder().statusCode(code).url(url);
        if(Objects.equals(code,HttpUtil.HTTPSTATUS_SUCCESS)){
            String content=response.body().string();
            webPageBuilder.content(content);
        }
        return webPageBuilder.build();
    }

    public WebPage getWebPage(String url) throws IOException {
        return getWebPage(url,"utf-8");
    }

}
