package com.lunzi.spiderboy.factory;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ip代理页面的解析
 * 官方文档见 http://www.open-open.com/jsoup/
 * Created by lunzi on 2018/12/21 8:02 PM
 */
@Component
public class IpProxyHtmlParse implements Parse {

    @Override
    public Object parse(String html) throws IOException {
        //获取文档
        Document document=Jsoup.parse(html);
        //根据id获取取对应元素
        Elements elements=document.select("#ip_list tr[class]");
        //循环获取需要的数据 这里理论上elements只有一个
        elements.forEach(element -> {
            String ip=element.select("td:eq(1)").first().text();
            System.out.println(ip);

        });
        return null;
    }
}
