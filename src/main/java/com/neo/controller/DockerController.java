package com.neo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
    @RequestMapping("/")
    public String index() {
        return "Hello Docker!";
    }


        public static void main(String[] args) {
            System.out.println("第二次测试");
            String str1 = "计算机" + "软件";

// String str3= new StringBuilder("计算机软件").toString();

            System.out.println(str1.equals(str1.intern()));

            String str2 = "Java(TM) SE sssssssssss";

            System.out.println(str2.intern().equals(str2));

        }

}