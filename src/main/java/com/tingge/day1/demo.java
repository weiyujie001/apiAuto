package com.tingge.day1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class demo {

    public static void main(String[] args) throws Exception {
        // 接口地址
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        //请求方式
        HttpPost Post = new HttpPost(url);

        String mobilphone = "1557366209";
        String password = "123456";

        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("mobilphone",mobilphone));
        parameters.add(new BasicNameValuePair("password",password));
        // 设置字符编码，并且以表单形式
        Post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));

        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(Post);

        int code = response.getStatusLine().getStatusCode();
        // 响应报文， EntityUntils.toString    json 转换为字符串
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }
    public static String doPost(String url, Map<String,String >params) throws Exception {
        // 接口地址
        //请求方式
        HttpPost Post = new HttpPost(url);

        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            String value = params.get(key);
            parameters.add(new BasicNameValuePair(key,value));
        }

        // 设置字符编码，并且以表单形式
        Post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));

        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(Post);

        int code = response.getStatusLine().getStatusCode();
        // 响应报文， EntityUntils.toString    json 转换为字符串
        String result = EntityUtils.toString(response.getEntity());
//        System.out.println(result);
        return result;

    }
}
