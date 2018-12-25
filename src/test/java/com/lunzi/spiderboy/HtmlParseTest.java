package com.lunzi.spiderboy;

import com.lunzi.spiderboy.factory.IpProxyHtmlParse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by lunzi on 2018/12/24 11:52 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlParseTest {
    @Autowired
    IpProxyHtmlParse ipProxyHtmlParse;

    @Test
    public void testProseParse() throws Exception {
        //读取测试网页
        FileInputStream is=new FileInputStream(ResourceUtils.getFile("classpath:test/a.html"));
        byte [] b=new byte[is.available()];
        is.read(b);
        String html=new String(b);
        ipProxyHtmlParse.parse(html);

    }
}
