package com.aixin999.util;


import org.apache.commons.lang.CharEncoding;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * 通联支付工具类
 *
 * @author 柳阳
 * 2017.9.1
 *
 */
public class AllinpayUtil {
    /**
     * MD5 加密数据
     * @param data
     * @return
     * @throws IOException
     */
    public static byte[] encryptMD5(String data) throws Exception {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes(CharEncoding.UTF_8));
        } catch (GeneralSecurityException gse) {
            throw new Exception(gse);
        }
        return bytes;
    }

    /**
     * 把二进制转化为大写的十六进制
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * DES加密
     * @param datasource 数据源
     * @param password  数据密钥
     * @return
     */
    public static byte[] desCrypto(byte[] datasource, String password) {
        try{
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(password.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成参数排序字符串
     * @param params
     * @return
     */
    private static Map<String, Object> sortMap(Map<String, Object> params) {
        Map<String, Object> sortMap = new TreeMap<String, Object>(new MapKeyComparator());
        sortMap.putAll(params);
        return sortMap;
    }

    /**
     * 比较类
     */
    private static class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * 生成密码加密后的字符串
     * @param password 密码
     * @param secretKey 数据密钥
     * @return 时间戳+aop+原始密码，再进行DES加密，再进行BASE64加密得到字符串
     */
    public static String passwordCrypto(String password, String secretKey) {
        try {
            String timestamp = DateTools.dateToNum14(new Date());
            password = timestamp + "aop" + password;
            return Base64Util.encode(desCrypto(password.getBytes(), secretKey));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成签名字符串
     * @param params 参数列表
     * @return 签名字符串，byte2hex(md5(secretkey1value1key2value2...secret))
     */
    public static String buildSignature(Map<String, Object> params) throws Exception {
        String appKey = (String) params.get("app_key");
        if(appKey == null) return null;
        params = sortMap(params);
        StringBuilder signString = new StringBuilder(appKey);
        for(Map.Entry<String, Object> entry : params.entrySet()) {
            signString.append(entry.getKey() + entry.getValue());
        }
        signString.append(appKey);
        System.out.println(signString.toString());
        return byte2hex(encryptMD5(signString.toString()));
    }

    /**
     * 参数拼装
     * @param params 参数列表
     * @return 按规则拼接好的字符串
     */
    public static String buildParams(Map<String, Object> params) throws Exception {
        StringBuilder ret = new StringBuilder();
        for(Map.Entry<String, Object> entry : params.entrySet()) {
            ret.append(entry.getKey() + "=" + URLEncoder.encode((String) entry.getValue(), "utf-8") + "&");
        }
        //加签名
        ret.append("sign=" + URLEncoder.encode(buildSignature(params), "utf-8"));
        return ret.toString();
    }

}
