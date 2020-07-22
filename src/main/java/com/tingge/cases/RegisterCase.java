package com.tingge.cases;

import com.tingge.Until.HttpUntil;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterCase {
    //mobilephone:"15573662209" pwd:""
    //mobilephone:"" pwd:"123456"
    //mobilephone:"123" pwd:"123456"
    //mobilephone:"15573662209" pwd:"12345"
    //mobilephone:"15573662209" pwd:"123456"
    //mobilephone:"15573662209" pwd:"123456"
    @Test
    public void test1()  {
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone", "15573662209");
        map.put("pwd", "");
        HttpUntil.doPost(url, map);
    }
    @Test
    public void test2()  {
        String url =  "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone","");
        map.put("pwd","123456");
        HttpUntil.doPost(url,map);

    }
    @Test
    public void test3() {
        String url =  "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone","123");
        map.put("pwd","123456");
        HttpUntil.doPost(url,map);

    }
    @Test
    public void test4()  {
        String url =  "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone","15573662209");
        map.put("pwd","12345");
        HttpUntil.doPost(url,map);

    }
    @Test
    public void test5(){
        String url =  "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone","15573662209");
        map.put("pwd","123456");
        HttpUntil.doPost(url,map);
    }
    @Test
    public void test6(){
        String url =  "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone","15573662209");
        map.put("pwd","123456");
        HttpUntil.doPost(url,map);
    }

}
