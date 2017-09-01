package com.aixin999.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by borong on 2017/9/1.
 */
public class AllinpayUtilTest {

    String data = "20110312192443aop111111";

    String key = "abcdefgh";

    @Test
    public void test() {

        try {
            //data = "20110115010101aop111111";
            //System.out.println(AllinpayUtil.byte2hex(data));
            System.out.println(AllinpayUtil.desCrypto(data.getBytes(), key));
            System.out.println(DesUtil.encrypt(data, key));
            //System.out.println(DesUtil.decrypt(DesUtil.encrypt(data, key), key));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}