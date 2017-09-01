package com.aixin999.util;


import org.apache.commons.lang.CharEncoding;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

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
}
