package com.lunzi.spiderboy.parse;


import com.lunzi.spiderboy.bean.IpProxy;
import com.lunzi.spiderboy.bean.XiciIpProxy;
import com.lunzi.spiderboy.enums.AnonymousTypeEnum;
import com.lunzi.spiderboy.enums.ProtocolTypeEnum;
import com.lunzi.spiderboy.parse.Parse;
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

public class IpProxyHtmlParse implements Parse {

    @Override
    public Object parse(String html) throws IOException {
        //获取文档
        Document document=Jsoup.parse(html);
        //根据id获取取对应元素
        Elements elements=document.select("#ip_list tr[class]");
        //循环获取需要的数据
        elements.forEach(element -> {
            String ip=element.select("td:eq(1)").first().text();
            Integer port=Integer.valueOf(element.select("td:eq(2)").first().text());
            Integer anonymousType=AnonymousTypeEnum.getCodeByDesc(element.select("td:eq(4)").first().text());
            Integer protocolType=ProtocolTypeEnum.getCodeByDesc(element.select("td:eq(5)").first().text());
            Double speed=Double.valueOf(element.select("td:eq(6)").first().selectFirst("div").attr("title").replace("秒",""));
            Double connectTime=Double.valueOf(element.select("td:eq(7)").first().selectFirst("div").attr("title").replace("秒",""));
            String surviveTime=element.select("td:eq(8)").first().text();
            XiciIpProxy xiciIpProxy=XiciIpProxy.builder()
                    .anonymousType(anonymousType)
                    .protocolType(protocolType)
                    .speed(speed)
                    .connectTime(connectTime)
                    .ip(ip)
                    .port(port)
                    .surviveTime(surviveTime)
                    .build();
            System.out.println(xiciIpProxy.toString());
        });
        return null;
    }
}
