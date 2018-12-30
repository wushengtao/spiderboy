package com.lunzi.spiderboy.client;


import com.lunzi.spiderboy.bean.WebPage;
import com.lunzi.spiderboy.parse.IpProxyHtmlParse;
import com.lunzi.spiderboy.task.IpProxyParseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ip代理
 * Created by lunzi on 2018/12/16 9:27 PM
 */
public class IpProxyClient extends AbstractHttpClient {
    //四个线程
    private final static ExecutorService EXECUTOR_SERVICE=Executors.newFixedThreadPool(16);
    private IpProxyHtmlParse ipProxyHtmlParse=new IpProxyHtmlParse();
    /**
     * 开始获取ip代理
     */
    public static void startGetIpProxy(){
        //使用多线程抓取-4个
        for(int pageIndex=1;pageIndex<=4;pageIndex++){
            EXECUTOR_SERVICE.execute(new IpProxyParseTask(pageIndex));
        }
    }

    public Object parse(List<String> urlList) {
        urlList.forEach(url->{
            WebPage webPage= null;
            try {
                webPage = this.getWebPage(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String content=webPage.getContent();
            if(!StringUtils.isEmpty(content)){
                processParseHtml(content);
            }
        });

        return null;

    }

    /**
     * 解析html
     * @param content
     */
    private void processParseHtml(String content) {
        try{
            ipProxyHtmlParse.parse(content);
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
