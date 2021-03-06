package com.syl.tb.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoPOST {

    public static final String WEB = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36";


    public static void main(String[] args) throws Exception {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求http://www.oschina.net/
        HttpPost httpPost = new HttpPost("http://localhost:8082/item/cache/1474391940.html");
        httpPost.setHeader("User-Agent",WEB);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 204) {
                if (response.getEntity() != null){
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println("-------------");
                    System.out.println(content);
                }else {
                    System.out.println("******************");
                }

            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
