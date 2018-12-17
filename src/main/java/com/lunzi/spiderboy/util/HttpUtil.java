package com.lunzi.spiderboy.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;

/**
 * http工具类 这里封装了okHttp
 * Created by lunzi on 2018/12/16 9:43 PM
 */
@Slf4j
public class HttpUtil {
    private static OkHttpClient okHttpClient=new OkHttpClient();

    static {
        initOkHttpClient();
    }

    /**
     * okHttpClient的初始化，包括以下
     * 绕过https认证
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
            OkHttpClient.Builder builder=okHttpClient.newBuilder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((s, sslSession) -> true);
            okHttpClient=builder.build();
        }catch (Exception e){
            log.error("pass https fail！e=",e);
        }

    }

    public static Response getReponse(Request request) throws IOException {
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }


    public static String getWebContent(String url) throws IOException {
        Request request = new Request.Builder().url(url).addHeader("User-Agent",CommonConstant.USER_AGENT).build();
        Response response = getReponse(request);
        return response.body().string();
    }


}
