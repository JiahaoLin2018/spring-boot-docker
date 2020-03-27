package com.neo.controller;

import java.util.HashMap;
import java.util.Map;

public class TestMain3 {

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
        // 字符串转换为字符数组
        char[] char1 = A.toCharArray();
        char[] char2 = B.toCharArray();
        // 获取要替换的字符
        char m = char2[index];
        // 获取被替换的字符
        char f = char1[index];
        // 遍历原字符数组
        for (int i = 0; i < char1.length; i++) {
            // 如果是和需要替换的字符相同
            if (char1[i] == f) {
                char1[i] = m;
            }
        }

        A = arrayToString(char1);
        B = arrayToString(char2);

        // 判断是否到了最后一位
        if ((index == A.length() - 1)) {
            if (A.trim().equals(B.trim())) {
                return true;
            } else {
                return false;
            }
        }
        return isConvert(A, B, index + 1);

    }

    public static String arrayToString(char[] c) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            stringBuilder.append(c[i]);
        }
        return stringBuilder.toString();
    }

}
