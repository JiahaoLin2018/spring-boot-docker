package com.neo.controller;

import java.util.HashMap;
import java.util.Map;

public class TestMain4 {

    /**
     * 服务端测试：有一个字符串A，有一个字符串B，想要从A转换到B，只能一次一次转换，每次转换要把字符串A中的一个字符全部转换成另外一个字符。
     * 求字符串A能不能转换成字符串B。
     * 例如： “abc” -> "bbc" -> "ddc" （判断转换是否成立）
     */
    public static void main(String[] args) {
        String A = "abc";
        String B = "xcv";
        boolean suc = isConvert(A, B,0);
        System.out.println("转换 ： " + suc);
    }

    public static boolean isConvert(String A, String B, int index) {
        Character c1 = A.charAt(index);
        Character c2 = B.charAt(index);
        A = A.replaceAll(c1.toString(), c2.toString());
        if ((index == A.length() - 1)) {
            if (A.equals(B)) {
                return true;
            } else {
                return false;
            }
        }
        return isConvert(A, B, index + 1);
    }
}