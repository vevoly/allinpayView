package com.aixin999.util;

import static org.junit.Assert.*;

/**
 * Created by borong on 2017/9/1.
 */
public class HttpClientUtilTest {
    @org.junit.Test
    public void sendGet() throws Exception {
        String url = "http://218.28.168.11:9072/ecar-upgrade/adddevice";
        System.out.println(HttpClientUtil.sendGet(url, ""));
    }

    @org.junit.Test
    public void sendPost() throws Exception {
    }

}