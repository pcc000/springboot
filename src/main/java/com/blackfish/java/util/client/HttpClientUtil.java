package com.blackfish.java.util.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by stefanxu on 2018/8/24.
 */

public class HttpClientUtil {

    private static Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

    private static Registry<ConnectionSocketFactory> socketFactoryRegistry;

    private static PoolingHttpClientConnectionManager poolManager;

    private static RequestConfig requestConfig;

    private static SSLContext sslContext;

    private static final int POOL_MAX_TOTAL = 50;

    private static final int POOL_MAX_PER_ROUTE = 10;

    private static final int SOCKET_TIMEOUT = 60000;

    private static final int CONNECT_TIMEOUT = 60000;

    private static final int CONNECTION_REQUEST_TIMEOUT = 60000;

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static final Charset CHARSET = Charset.forName(DEFAULT_CHARSET);

    static {
        try {
            initSSLContext();
        } catch (Exception e) {
            LOG.error("创建sslContext异常");
        }
        initSocketFactory();
        initPool();
        initConfig();
    }

    private static void initSSLContext() throws NoSuchAlgorithmException, KeyManagementException {
        sslContext = SSLContext.getInstance("TLS");
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法，信任所有的证书
        X509TrustManager trustManager = new X509TrustManager() {

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }
        };
        sslContext.init(null, new TrustManager[]{trustManager}, null);
    }

    private static void initSocketFactory() {
        socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslContext)).build();
    }

    private static void initPool() {
        poolManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        // 最大连接数
        poolManager.setMaxTotal(POOL_MAX_TOTAL);
        // 每个路由的最大连接数
        poolManager.setDefaultMaxPerRoute(POOL_MAX_PER_ROUTE);
    }

    private static void initConfig() {
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT).build();
    }

    private static void setHeardInfo(HttpRequestBase requestBase, Map<String, String> headers) {
        headers.forEach((k, v) -> requestBase.setHeader(k, v));
    }

    private static CloseableHttpClient getHttpClient() {
        if (poolManager == null) {
            initPool();
        }
        return HttpClients.custom()
                .setConnectionManager(poolManager)
                .setDefaultRequestConfig(requestConfig).build();
    }

    public static ClientResultDTO requestGet(String url, HttpEntity httpEntity) throws IOException {
        return requestGet(url, httpEntity, null);
    }

    /**
     * uri 带参数
     * @param uri
     * @param httpEntity
     * @return
     * @throws IOException
     */
    public static ClientResultDTO requestGet(URI uri, HttpEntity httpEntity) throws IOException {
        return requestGet(uri, (Map<String, String>) null);
    }

    /**
     * url 不带参数
     * @param url
     * @param httpEntity
     * @param headers
     * @return
     * @throws IOException
     */
    public static ClientResultDTO requestGet(String url, HttpEntity httpEntity, Map<String, String> headers) throws IOException {
        String params = EntityUtils.toString(httpEntity, DEFAULT_CHARSET);
        HttpGet httpGet = new HttpGet(url + "?" + params);
        if (!CollectionUtils.isEmpty(headers)) {
            setHeardInfo(httpGet, headers);
        }
        return executeRequest(httpGet);
    }

    public static ClientResultDTO requestGet(URI rui, Map<String, String> headers) {
        HttpGet httpGet = new HttpGet(rui);
        if (!CollectionUtils.isEmpty(headers)) {
            setHeardInfo(httpGet, headers);
        }
        return executeRequest(httpGet);
    }

    public static ClientResultDTO requestPost(String url, HttpEntity httpEntity) {
        return requestPost(url, httpEntity, null);
    }

    public static ClientResultDTO requestPost(URI uri, HttpEntity httpEntity) {
        return requestPost(uri, httpEntity, null);
    }

    public static ClientResultDTO requestPost(String url, HttpEntity httpEntity, Map<String, String> headers) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(httpEntity);
        if (!CollectionUtils.isEmpty(headers)) {
            setHeardInfo(httpPost, headers);
        }
        return executeRequest(httpPost);
    }

    public static ClientResultDTO requestPost(URI url, HttpEntity httpEntity, Map<String, String> headers) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(httpEntity);
        if (!CollectionUtils.isEmpty(headers)) {
            setHeardInfo(httpPost, headers);
        }
        return executeRequest(httpPost);
    }

    private static ClientResultDTO executeRequest(HttpRequestBase requestBase) {
        ClientResultDTO result = null;
        CloseableHttpClient httpClient = getHttpClient();
        try (CloseableHttpResponse httpResponse = httpClient.execute(requestBase);) {
            HttpEntity entity = httpResponse.getEntity();
            result = new ClientResultDTO();
            result.setResult(EntityUtils.toString(entity, DEFAULT_CHARSET));
            result.setStatusLine(httpResponse.getStatusLine());
            EntityUtils.consume(entity);
        } catch (IOException e) {
            LOG.error("httpClient execute error ", e);
        }
        return result;
    }
}
