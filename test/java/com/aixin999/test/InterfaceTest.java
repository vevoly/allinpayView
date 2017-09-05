package com.aixin999.test;

import com.aixin999.util.AllinpayUtil;
import com.aixin999.util.DateTools;
import org.junit.Test;

import java.util.Date;

/**
 * Created by borong on 2017/9/1.
 */
public class InterfaceTest {
    //请求地址
    String url = "http://116.228.64.55:8080/aop/rest ";
    //appkey
    String appkey = "test";
    //请求密钥
    String secret = "test";
    //数据密钥
    String datakey = "abcdefgh";

    //卡号
    String idCard = "8668083660000002247";
    //密码
    String password = "111111";
    //机构号
    String orgId = "0229000040";
    //商户号
    String vendorId = "999990053990001";

    @Test
    public void test() {

        //md5加密
    }

    /**
     * 密码加密测试
     * 时间戳+aop+原始密码，DES加密
     */
    @Test
    public void passwordDESTest() throws Exception {
        String timestamp = DateTools.dateToNum14(new Date());
        timestamp = "20110312192443";
        String pwd = timestamp + "aop" + password;
        System.out.println("时间戳：" + timestamp + ", 密码：" + password);
        System.out.println("DES加密结果：" + AllinpayUtil.desCrypto(pwd.getBytes(), datakey));
    }

}
