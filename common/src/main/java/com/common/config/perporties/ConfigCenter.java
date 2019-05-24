package com.common.config.perporties;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
    @Value("${config.center.ip:127.0.0.1:8080}")
    private String ip;

    public ConfigCenter() {
    }

    public String get(String key) {
        String data = this.doGet("http://" + this.ip + "/get?key=" + key);
        if (data != null && !data.equals("null")) {
            return data;
        } else {
            throw new RuntimeException("can not find key:" + key);
        }
    }

    public String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                String strResult = EntityUtils.toString(response.getEntity());
                return strResult;
            }

            if (response.getStatusLine().getStatusCode() == 404) {
                throw new RuntimeException("can not find config center,host:" + this.ip);
            }
        } catch (Exception var6) {
            log.error("doGet failed url : " + url, var6);
        }

        return null;
    }
}
