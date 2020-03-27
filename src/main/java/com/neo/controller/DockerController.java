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

            String str1 = new StringBuilder("计算机").append("软件").toString();

// String str3= new StringBuilder("计算机软件").toString();

            System.out.println(str1.intern() == str1);

            String str2 = new StringBuilder("Java(TM) SE sssssssssss").toString();

            System.out.println(str2.intern() == str2);

        }

}