package com.aixin999.util;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by borong on 2017/9/1.
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

    @Test
    public void testSign() throws Exception {
        String str="testapp_keytestcard_id8668083660000002247formatjsonmethodallinpay.card.cardinfo.getpassword4uT7zULtmpQ3SOVfdIpjLOpk9UwgX2rssign_v1timestamp20170904161948v1.0test";
        System.out.println(AllinpayUtil.byte2hex(AllinpayUtil.encryptMD5(str)));
    }
}