package com.aixin999.util;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 柳阳 on 2017/9/1.
 * 测试
 */
public class AllinpayUtilTest {

    String data = "20110312192443aop111111";

    String key = "abcdefgh";

    //文档中的栗子加密测试
    //oBvgoDKgIN6/Moy4DKioZoL6XdLndk0k
    @Test
    public void test() {
        try {
            System.out.println(Base64Util.encode(AllinpayUtil.desCrypto(data.getBytes(), key)));
            String timeNow = DateTools.dateToNum14(new Date());
            data = timeNow + "aop111111";
            System.out.println(timeNow);
            System.out.println(Base64Util.encode(AllinpayUtil.desCrypto(data.getBytes(), key)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 参数排序测试
     */
    /*@Test
    public void testBuildParamString() {
        String timestamp = DateTools.dateToNum14(new Date());
        String password = "111111";
        String secretKey = "abcdefgh";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", "allinpay.card.cardinfo.get");
        params.put("format", "json");
        params.put("v", "1.0");
        params.put("app_key", "test");
        params.put("card_id", "8668083660000002247");
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", "1");
        Map<String, Object> sortParams = AllinpayUtil.sortMap(params);
        for(Map.Entry<String, Object> entry : sortParams.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }*/
    @Test
    public void testSign() throws Exception {
        String str="testapp_keytestcard_id8668083660000002247formatjsonmethodallinpay.card.cardinfo.getpassword4uT7zULtmpQ3SOVfdIpjLOpk9UwgX2rssign_v1timestamp20170904161948v1.0test";
        System.out.println(AllinpayUtil.byte2hex(AllinpayUtil.encryptMD5(str)));
    }
    /**
     * 签名测试
     */
    @Test
    public void testSignature() throws Exception {
        String timestamp = DateTools.dateToNum14(new Date());
        String password = "111111";
        String secretKey = "abcdefgh";
        String appKey = "test";
        String sign = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", "allinpay.card.cardinfo.get");
        params.put("format", "json");
        params.put("v", "1.0");
        params.put("app_key", appKey);
        params.put("card_id", "8668083660000002247");
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", "1");

        try {
            sign = AllinpayUtil.buildSignature(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sign);

    }

    /**
     * 拼装参数测试
     * @throws Exception
     */
    @Test
    public void testBuildParams() throws Exception {
        String timestamp = DateTools.dateToNum14(new Date());
        String password = "111111";
        String secretKey = "abcdefgh";
        String appKey = "test";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", "allinpay.card.cardinfo.get");
        params.put("format", "json");
        params.put("v", "1.0");
        params.put("app_key", appKey);
        params.put("card_id", "8668083660000002247");
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", "1");

        System.out.println(AllinpayUtil.buildParams(params));
    }

    @Test
    public void httpSendGetCardInfoTest() throws Exception {
        String cfg = "cfg.properties";
        String url = PropertyUtil.getValueByKey(cfg, "http_url");
        String timestamp = DateTools.dateToNum14(new Date());
        String password = "111111";
        String secretKey = PropertyUtil.getValueByKey(cfg, "secret_key");
        String appKey = PropertyUtil.getValueByKey(cfg, "app_key");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", "allinpay.card.cardinfo.get");
        params.put("format", "json");
        params.put("v", "1.0");
        params.put("app_key", appKey);
        params.put("card_id", "8668083660000002247");
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", "1");

        String paramString = AllinpayUtil.buildParams(params);
        System.out.println(HttpClientUtil.sendGet(url, paramString));

    }

    @Test
    public void dateStringTest() {
        String timestamp = DateTools.dateToNum14(new Date());
        String endDate = DateTools.dateToNum8(DateTools.getBeforeSomeOneDay(90));
        System.out.println(endDate);
    }

    @Test
    public void httpSendPostCardLogTest() throws Exception {
        String cfg = "cfg.properties";
        String url = PropertyUtil.getValueByKey(cfg, "http_url");
        String timestamp = DateTools.dateToNum14(new Date());
        String password = "111111";
        String secretKey = PropertyUtil.getValueByKey(cfg, "secret_key");
        String appKey = PropertyUtil.getValueByKey(cfg, "app_key");

        String endDate = DateTools.dateToNum8(new Date());
        String beginDate = DateTools.dateToNum8(DateTools.getBeforeSomeOneDay(90));


        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", PropertyUtil.getValueByKey(cfg, "method.get_card_log"));
        params.put("format", "json");
        params.put("v", "1.0");
        params.put("app_key", appKey);
        params.put("card_id", "8668083660000002247");
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", "1");

        params.put("page_no", "1");
        params.put("page_size", "30");
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);

        String paramString = AllinpayUtil.buildParams(params);
        System.out.println(HttpClientUtil.sendPost(url, paramString));

    }


}