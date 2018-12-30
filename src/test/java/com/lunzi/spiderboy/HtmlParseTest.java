package com.lunzi.spiderboy;

import com.google.common.collect.Maps;
import com.lunzi.spiderboy.parse.IpProxyHtmlParse;
import com.lunzi.spiderboy.util.CommonConstant;
import com.lunzi.spiderboy.util.HttpUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by lunzi on 2018/12/24 11:52 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlParseTest {
    //@Autowired
    //IpProxyHtmlParse ipProxyHtmlParse;

    @Test
    public void testProseParse() throws Exception {
        //读取测试网页
        FileInputStream is=new FileInputStream(ResourceUtils.getFile("classpath:test/a.html"));
        byte [] b=new byte[is.available()];
        is.read(b);
        String html=new String(b);
        //ipProxyHtmlParse.parse(html);

    }
}
