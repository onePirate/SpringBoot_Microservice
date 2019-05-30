package com.configmng;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 * @author gaodw
 * @createTime 2019-05-24 22:49
 * @description
 */
@Service("config")
public class ConfigCenter {
    private static final Logger log = LoggerFactory.getLogger(ConfigCenter.class);
    public static final int STATUS_OK = 200;
    public static final int STATUS_NOT_FOUND = 404;
    @Value("127.0.0.1:8080")
    private String ip;

    public ConfigCenter() {
    }

    public String get(String key) {
        String hostIp = System.getProperty("hostIp");
        if (hostIp != null) {
            ip = hostIp;
        }
        String data = this.doGet("http://" + this.ip + "/get?key=" + key);
        if (data != null && !data.equals("null")) {
            return data;
        } else {
            throw new RuntimeException("can not find key:" + key);
        }
    }

    public String doGet(String url) {
        try {
            CloseableHttpClient client =  HttpClients.createDefault();
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == STATUS_OK) {
                String strResult = EntityUtils.toString(response.getEntity());
                return strResult;
            }

            if (response.getStatusLine().getStatusCode() == STATUS_NOT_FOUND) {
                throw new RuntimeException("can not find config center,host:" + this.ip);
            }
        } catch (Exception var6) {
            log.error("doGet failed url : " + url, var6);
        }

        return null;
    }
}
