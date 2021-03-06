package com.pss.securty;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
import sun.misc.BASE64Encoder;
 
public class Md5Base64 {
    public static String encode(String s)  {
        if (s == null) return null; 
        String encodeStr = "";
        byte[] utfBytes = s.getBytes();
        MessageDigest mdTemp;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(utfBytes);
            byte[] md5Bytes = mdTemp.digest();
            BASE64Encoder b64Encoder = new BASE64Encoder();
            encodeStr = b64Encoder.encode(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return encodeStr;
    }
    public static void main(String[] args) {
        System.out.println(Md5Base64.encode("庄严"));
        System.out.println(Md5Base64.encode("123456"));
        System.out.println(Md5Base64.encode("www.zhuangling.com"));
    }
}