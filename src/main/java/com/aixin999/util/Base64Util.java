package com.aixin999.util;


import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
    public Base64Util() {
    }

    public static String encode(byte[] bstr) {
        return (new BASE64Encoder()).encode(bstr);
    }

    public static byte[] decode(String str) {
        byte[] bt = null;

        try {
            BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return bt;
    }
}
