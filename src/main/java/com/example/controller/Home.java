package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/3.
 */
@RestController
@EnableAutoConfiguration
public class Home {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("178771232@qq.com");
        message.setTo("a060116@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);

        return "Hello, this is a test";
    }


    @RequestMapping("hello/{Name}")
    public String helloName(@PathVariable String Name){
        return "hello " + Name;
    }
}
