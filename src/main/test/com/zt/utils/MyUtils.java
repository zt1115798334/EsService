package com.zt.utils;

import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

public class MyUtils {

    public static String randomGetString(List<String> source) {
        int index = (new Random().nextInt(source.size()));
        return source.get(index);
    }

    public static Double randomGetDouble(List<Double> source) {
        int index = (new Random().nextInt(source.size()));
        return source.get(index);
    }

    private static MessageDigest md5 = null;
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用于获取一个String的md5值
     * @param str
     * @return
     */
    public static String getMd5(String str) {
        byte[] bs = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for(byte x:bs) {
            if((x & 0xff)>>4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }
}
