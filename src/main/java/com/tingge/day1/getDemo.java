package com.tingge.day1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class getDemo {
    public static void main(String[] args) throws IOException {
        // 提供接口地址
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        //准备数据
        String mobilphone = "1557366209";
        String pwd = "123456";
        url +=("?mobilphone=1557366209&pwd=123456");
        //指定接口提交的方式
        HttpGet get = new HttpGet(url);
        // 发送请求,拿到相应报文
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        int code = response.getStatusLine().getStatusCode();
        System.out.println(code);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    public static class HttpUntil {



        public static String doPost(String url, Map<String,String> params){

            HttpPost post = new HttpPost(url);

            ArrayList<BasicNameValuePair> AList = new ArrayList<BasicNameValuePair>();
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                AList.add(new BasicNameValuePair(key,value));
            }
            String result = "";
            try {
                post.setEntity(new UrlEncodedFormEntity(AList,"UTF-8"));
                HttpClient client = HttpClients.createDefault();
    //            addCookiesInRequest(post);
                HttpResponse re = client.execute(post);
    //            getAndStoreCookies(re);
                int code = re.getStatusLine().getStatusCode();
                result = EntityUtils.toString(re.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
            return result;

        }


        public static String doGet(String url, Map<String,String>params){

            HttpGet get = new HttpGet(url);
            Set<String> keys = params.keySet();
            int mark = 1;
            for (String key : keys) {
                String value = params.get(key);
                if (mark ==1){
                    url +=("?"+key+value);
                }else{
                    url += ("&"+key+value);
                }
            }
            String ressult = "";
            HttpClient client = HttpClients.createDefault();
            try {
    //            addCookiesInRequest(get);
                HttpResponse re = client.execute(get);
    //            getAndStoreCookies(re);
                int code = re.getStatusLine().getStatusCode();
                ressult = EntityUtils.toString(re.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ressult;
        }
    }
}
