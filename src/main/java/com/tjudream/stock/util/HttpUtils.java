package com.tjudream.stock.util;

import com.tjudream.stock.model.HttpResult;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.http.Consts.*;

/**
 * Created by mengxiansen on 2017/6/18.
 * @author mengxs@lenovocloud.com
 */
public class HttpUtils {

    private HttpUtils() {
    }
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static CloseableHttpClient getHttpClient()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        //指定信任密钥存储对象和连接套接字工厂
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        //信任任何链接
        TrustStrategy anyTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        };
        SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
        LayeredConnectionSocketFactory sslSF =
                new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        registryBuilder.register(Constant.HTTPS, sslSF);
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        //构建客户端
        return HttpClientBuilder.create().setConnectionManager(connManager).build();
    }

    public static HttpResult doMultipart(String url, File file)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        logger.info("url : [{}], filename : [{}]", url, file.getName());
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置浏览器兼容模式
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        FileBody fileBody = new FileBody(file);
        builder.addPart("fileField", fileBody);
        HttpEntity entity = builder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }

    /*  public static HttpResult doMultipart(String url, MultipartFile filedata)
              throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
          logger.info("url : [{}], filename : [{}]", url, filedata.getName());
          CloseableHttpClient httpClient = HttpClientBuilder.create().build();
          if (url.contains(Constant.HTTPS)) {
              httpClient = getHttpClient();
          }

          MultipartEntityBuilder builder = MultipartEntityBuilder.create();
          //设置浏览器兼容模式
          builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
          IdtFileBody fileBody = new IdtFileBody(filedata.getBytes(), filedata.getName());
          builder.addPart("fileField", fileBody);
          HttpEntity entity = builder.build();
          HttpPost httpPost = new HttpPost(url);
          httpPost.setEntity(entity);

          HttpResponse httpResponse = httpClient.execute(httpPost);
          HttpEntity httpEntity = httpResponse.getEntity();
          int httpCode = httpResponse.getStatusLine().getStatusCode();
          String result = EntityUtils.toString(httpEntity, UTF_8);
          logger.info("httpcode : [{}], result : [{}]", httpCode, result);
          HttpResult httpResult = new HttpResult();
          httpResult.setHttpCode(httpCode);
          httpResult.setResult(result);
          return httpResult;
      }
  */
    public static HttpResult doMultipartWithSession(String url, File file, String session, String s)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        logger.info("url : [{}], filename : [{}]", url, file.getName());
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        FileBody fileBody = new FileBody(file);
        builder.addPart("fileField", fileBody);
        HttpEntity entity = builder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        httpPost.setHeader(new BasicHeader("Cookie", "X-LENOVO-SESS-ID=" + session));
        httpPost.setHeader(new BasicHeader("Cookie", "S=" + s));

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }
    public static HttpResult doMultipartWithSession1(String url, File file, String session, String s)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        logger.info("url : [{}], filename : [{}]", url, file.getName());
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        FileBody fileBody = new FileBody(file);
        builder.addPart("file_field", fileBody);
        HttpEntity entity = builder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        httpPost.setHeader(new BasicHeader("Cookie", "X-LENOVO-SESS-ID=" + session));
        httpPost.setHeader(new BasicHeader("Cookie", "S=" + s));

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }

    public static InputStream doGetForFile(String url)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("http get begin, url={}", url);
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("headers is {}", headerMap);
        logger.info("http get end, httpcode={}, url={}", httpCode, url);

        return httpEntity.getContent();
    }


    public static HttpResponse doGetForFileNew(String url, String session)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("http get begin, url={}", url);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(new BasicHeader("Cookie", "X-LENOVO-SESS-ID=" + session));
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;

//        HttpEntity httpEntity = httpResponse.getEntity();
//        int httpCode = httpResponse.getStatusLine().getStatusCode();
//        Header[] headers = httpResponse.getAllHeaders();
//        Map<String,String> headerMap = new HashMap<>(headers.length);
//        if (headers != null && headers.length > 0) {
//            for (Header header : headers) {
//                if (headerMap.containsKey(header.getName())) {
//                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
//                    headerMap.put(header.getName(), value);
//                } else {
//                    headerMap.put(header.getName(), header.getValue());
//                }
//            }
//        }
//        logger.info("headers is {}", headerMap);
//        logger.info("http get end, httpcode={}, url={}", httpCode, url);
//
//        return httpEntity.getContent();
    }

    public static HttpResponse doPostForFile(String url, Map<String,String> params, List<NameValuePair> paramArray ,String session)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        url += "&X-LENOVO-SESS-ID="+session;
        logger.info("begin doPost, url is {}, params is {}", url, params);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(new BasicHeader("Cookie", "X-LENOVO-SESS-ID=" + session));
        if (params != null && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }

        if(null!=paramArray){
            httpPost.setEntity(new UrlEncodedFormEntity(paramArray, UTF_8));
        }

        HttpResponse httpResponse = httpClient.execute(httpPost);
        return httpResponse;

//        HttpEntity httpEntity = httpResponse.getEntity();
//        int httpCode = httpResponse.getStatusLine().getStatusCode();
//        //String result = EntityUtils.toString(httpEntity, UTF_8);
//        Header[] headers = httpResponse.getAllHeaders();
//        Map<String,String> headerMap = new HashMap<>(headers.length);
//        if (headers != null && headers.length > 0) {
//            for (Header header : headers) {
//                if (headerMap.containsKey(header.getName())) {
//                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
//                    headerMap.put(header.getName(), value);
//                } else {
//                    headerMap.put(header.getName(), header.getValue());
//                }
//            }
//        }
//        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
//        logger.info("headers is {}", headerMap);
//        HttpResult httpResult = new HttpResult();
//        httpResult.setHttpCode(httpCode);
//        httpResult.setResult(result);
//        httpResult.setHeaders(headerMap);
        //return httpEntity.getContent();

    }

    public static HttpResult doPost(String url, Map<String,String> params) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doPost, url is {}, params is {}", url, params);
        HttpPost httpPost = new HttpPost(url);
        if (params != null && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        logger.info("headers is {}", headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }

    public static org.apache.http.cookie.Cookie[] getHttpClientCookies(Cookie[] cookies) {

        int numberOfCookies =0;
        if(cookies!= null){
            numberOfCookies = cookies.length;
        }
        org.apache.http.cookie.Cookie[] httpClientCookies = new org.apache.http.cookie.Cookie[numberOfCookies];
        for (int i = 0; i < numberOfCookies; i++) {
            Cookie c = cookies[i];
            String domain = c.getDomain();
            String name = c.getName();
            String value = c.getValue();
            String path = c.getPath();
            boolean secure = c.getSecure();
            int maxAge = c.getMaxAge();
            org.apache.http.impl.cookie.BasicClientCookie hCookie = new org.apache.http.impl.cookie.BasicClientCookie(name, value);
            hCookie.setDomain(domain);
            hCookie.setPath(path);
            hCookie.setSecure(secure);
            long expireMillion = System.currentTimeMillis() + maxAge*1000;
            hCookie.setExpiryDate(new Date(expireMillion));
            httpClientCookies[i] = hCookie;
        }
        return httpClientCookies;
    }
    public static HttpResult doPostWithCookies(String url, Map<String,String> params, Cookie[] cookies) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String sessionId = null;
        CookieStore cookieStore = new BasicCookieStore();
        if (cookies != null) {
            org.apache.http.cookie.Cookie[] hCookies = getHttpClientCookies(cookies);
            for (org.apache.http.cookie.Cookie cookie : hCookies) {
                logger.info("cookie is {}:{}", cookie.getName(), cookie.getValue());
                cookieStore.addCookie(cookie);
                if ("X-LENOVO-SESS-ID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                }
            }
        }
        if (sessionId != null && !url.contains("X-LENOVO-SESS-ID")) {
            url += "?X-LENOVO-SESS-ID=" + sessionId;
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doPost, url is {}, params is {}", url, params);
        HttpPost httpPost = new HttpPost(url);
        if (params != null && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        logger.info("headers is {}", headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }

    public static HttpResult doPostWithSession(String url, Map<String,String> params,String session) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doPost, url is {}, params is {}", url, params);
        HttpPost httpPost = new HttpPost(url);
        if (params != null && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        logger.info("headers is {}", headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }


    public static HttpResult doPostWithRequest(String url, Map<String,String> params, HttpServletRequest req) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String sessionId = null;

        if (sessionId != null && !url.contains("X-LENOVO-SESS-ID")) {
            url += "?X-LENOVO-SESS-ID=" + sessionId;
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doPost, url is {}, params is {}", url, params);
        HttpPost httpPost = new HttpPost(url);
        if (params != null && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }

        copyHeaders(req,httpPost);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        logger.info("headers is {}", headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }

    private static void copyHeaders(HttpServletRequest req,HttpPost httpPost){
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = req.getHeader(key);
            logger.info("header is {}:{}", key, value);
            if(key.equalsIgnoreCase("User-Agent")){
                httpPost.setHeader(key,value);
            }else if(key.equalsIgnoreCase("x-user-agent")){
                httpPost.setHeader(key,value);
            }else if(key.equalsIgnoreCase("x-forwarded-for")){
                httpPost.setHeader(key,value);
            }else if(key.equalsIgnoreCase("x-client-ip")){
                httpPost.setHeader(key,value);
            }else if(key.equalsIgnoreCase("X-Real-IP")){
                httpPost.setHeader(key,value);
            }else if(key.equalsIgnoreCase("Cookie")){
                httpPost.setHeader(key,value);
            }
        }
    }

    public static HttpResult doGet(String url) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doGet, url is {}", url);
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }
    public static HttpResult doGetwithSession(String url,String session) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doGet, url is {}", url);
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }

    public static HttpResult doGetNotAutoRedirect(String url) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doGet, url is {}", url);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(RequestConfig.custom().setRedirectsEnabled(false).build());
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}], headers : [{}]", httpCode, result, headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }
    public static HttpResult doGetNotAutoRedirectWithSession(String url, String session) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(Constant.HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doGet, url is {}", url);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(RequestConfig.custom().setRedirectsEnabled(false).build());
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        Header[] headers = httpResponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>(headers.length);
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (headerMap.containsKey(header.getName())) {
                    String value = headerMap.get(header.getName()) + ";" + header.getValue();
                    headerMap.put(header.getName(), value);
                } else {
                    headerMap.put(header.getName(), header.getValue());
                }
            }
        }
        logger.info("httpcode : [{}], result : [{}], headers : [{}]", httpCode, result, headerMap);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        httpResult.setHeaders(headerMap);
        return httpResult;
    }

}
