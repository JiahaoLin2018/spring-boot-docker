package com.neo.controller;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    /**
     * 存储每一个版本的内容信息
     */
    private final static Map<Integer,String> VERSION_CONTEXT_MAP = new HashMap<Integer,String>(){
        {
            final String versionOne = "ok1 ";
            final String versionTwo = versionOne + " ok2";
            final String versionThree = versionTwo + " ok3";
            final String versionFour = versionThree + " bug4";
            final String versionFive = versionFour + " ok5";
            final String versionSix = versionFive + " ok6";
            put(1,versionOne);
            put(2,versionTwo);
            put(3,versionThree);
            put(4,versionFour);
            put(5,versionFive);
            put(6,versionSix);
        }
    };

    /**
     * 判断当前版本是否有错误
     * @param versionNum
     * @return
     */
    private static boolean isBug(Integer versionNum){
        boolean isContain = VERSION_CONTEXT_MAP.containsKey(versionNum);
        if(!isContain){
            return  false;
        }

        String context = VERSION_CONTEXT_MAP.get(versionNum);
        return context.contains("bug");
    }

    /**
     * 获取出错的第一个版本号
     */
    private static Integer getBugVersion(Integer versionNum){
        if(!isBug(versionNum)){
            return -1;
        }

        Integer bugVersion = getBugVersion(versionNum - 1);
        if(bugVersion == -1){
            return versionNum;
        }
        else{
            return bugVersion;
        }
    }

    /**
     * 服务端测试：目前你正在领导团队开发一款新软件。
     * 你在检查项目的时候发现最后一个版本的测试没有通过，并且你知道只要上一个版本有错误，此版本的每一个下面版本都会是错误的。
     * 假设你有S个版本数组【1,2,3,4...,S】，你想找出最早发生错误的版本。
     * 假设查找版本的API是 IsBug(Sn) 传入版本号就会返回该版本是否有错误。
     * 请使用API写一个函数用尽量少的步骤找出这第一个出错的版本号。（JS或其他语言）
     * @param args
     */
    public static void main(String[] args) {
        Integer versionNum = 3;
        boolean isHaveBug = TestMain.isBug(versionNum);
        System.out.println("isHaveBug : " + isHaveBug);
        if(isHaveBug){
            Integer bugVersion = getBugVersion(versionNum);
            System.out.println("bugVersion : " + bugVersion);
        }
        else{
            System.out.println("versionNum : "+versionNum + ",not Bug!");
        }
    }

}
