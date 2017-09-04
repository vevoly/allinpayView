package com.aixin999.util;

import static org.junit.Assert.*;

/**
 * Created by borong on 2017/9/1.
 */
public class HttpClientUtilTest {
    @org.junit.Test
    public void sendGet() throws Exception {
        String url = "http://116.228.64.55:8080/aop/rest";
        String params = "app_key=test&card_id=8668083660000002247&format=json&method=allinpay.card.cardinfo.get&password=4uT7zULtmpQ3SOVfdIpjLOpk9UwgX2rs&sign=0186622F17C5C82FD0B56F476E44EA75&sign_v=1&timestamp=20170904161948&v=1.0";
        System.out.println(HttpClientUtil.sendGet(url, params));
    }

    @org.junit.Test
    public void sendPost() throws Exception {
    }

}