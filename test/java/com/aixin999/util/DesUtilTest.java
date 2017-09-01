package com.aixin999.util;

import org.junit.Test;

/**
 * Created by borong on 2017/9/1.
 */
public class DesUtilTest {

    String data = "111111";
    String key = "abcdefgh";

    @Test
    public void test() {

        try {
            System.out.println(DesUtil.encrypt(data, key));
            System.out.println(DesUtil.decrypt(DesUtil.encrypt(data, key), key));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}