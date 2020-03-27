package com.neo.controller;

import java.util.HashMap;
import java.util.Map;

public class TestMain2 {

    /**
     * 服务端测试：给定一个字符串A，字符串由所有数字和字母组成，求这个字符串里面所出现的数字和字母，同时统计这些数字和字母的出现次数。
     * 例如INPUT:A="aaaBBBaaA23"....OUTPUT:{A:1,B:3,a:5,2:1,3:1}
     * @param args
     */
    public static void main(String[] args) {
        String inputStr = "aaaBBBaaA23";
        System.out.println(getAllInfo(inputStr));
    }

    private static String getAllInfo(String inputStr){
        Map<Character, Integer> rtnMap = new HashMap<Character, Integer>();
        for (int i = 0; i < inputStr.length(); i++) {
            Character c = inputStr.charAt(i);
            if(rtnMap.containsKey(c)){
                rtnMap.put(c, rtnMap.get(c) + 1 );
            }
            else{
                rtnMap.put(c, 1);
            }
        }
        return rtnMap.toString().replaceAll("=",":");
    }
}
