package com.lunzi.spiderboy.client;

import com.lunzi.spiderboy.bean.WebPage;
import com.lunzi.spiderboy.factory.Parse;
import com.lunzi.spiderboy.task.IpProxyParseTask;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ip代理
 * Created by lunzi on 2018/12/16 9:27 PM
 */
public class IpProxyClient extends AbstractHttpClient {
    //暂时写成八个线程
    private final static ExecutorService EXECUTOR_SERVICE=Executors.newFixedThreadPool(8);
    /**
     * 开始获取ip代理
     */
    public static void startGetIpProcxy(){
        //使用多线程抓取
        EXECUTOR_SERVICE.execute(new IpProxyParseTask());
    }

    public Object parse(String url) throws IOException {
        WebPage webPage=this.getWebPage(url);
        String content=webPage.getContent();
        if(!StringUtils.isEmpty(content)){
            processParseHtml(content);
        }
        return null;

    }

    /**
     * 解析html
     * @param content
     */
    private void processParseHtml(String content) {

    }
}
