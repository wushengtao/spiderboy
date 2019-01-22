package com.lunzi.spiderboy.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

/**
 * http工具类 这里封装了okHttp
 * Created by lunzi on 2018/12/16 9:43 PM
 */
@Slf4j
public class HttpUtil {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    public static final int HTTPSTATUS_SUCCESS = 200;

    static {
        initOkHttpClient();
    }

    /**
     * okHttpClient的初始化，包括以下
     * 绕过https认证
     * 设置超时时间
     */
    private static void initOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((s, sslSession) -> true);
            builder.connectTimeout(10, TimeUnit.SECONDS);//默认的链接超时时间
            builder.readTimeout(10, TimeUnit.SECONDS);//默认的读取超时时间
            okHttpClient = builder.build();
        } catch (Exception e) {
            log.error("pass ssl fail！e=", e);
        }

    }

    /**
     * 获取请求的response
     *
     * @param url     url地址
     * @param charset 字符集
     * @return reponse
     * @throws IOException
     */
    public static Response getResponse(String url, String charset) throws IOException {
        Request request = new Request.Builder().url(url).addHeader("User-Agent", CommonConstant.USER_AGENT).build();
        Response response;
        response = okHttpClient.newCall(request).execute();
        //设置字符集 okHttpClient会从ContentType里面获取，ContentType没有设置会默认设置utf-8
        //非utf-8需要指定
        String contentType = response.header("Content-Type");
        Headers headers = response.headers();
        Headers.Builder headerBuilder = headers.newBuilder();
        headerBuilder.removeAll("Content-Type");
        String headCharset = StringUtils.isEmpty(charset) ? "" : ";charset" + charset;
        headerBuilder.add(contentType + headCharset);
        headers = headerBuilder.build();
        //反射设置header
        setHeader(response, headers);
        return response;
    }

    private static void setHeader(Response response, Headers headers){
        Class responseClass = Response.class;
        Field field;
        try {
            field = responseClass.getDeclaredField("headers");
            field.set(response,headers);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("setHeader error!",e);
        }

    }


}
