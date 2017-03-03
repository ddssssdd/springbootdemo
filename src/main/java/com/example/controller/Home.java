package com.example.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/3.
 */
@RestController
@EnableAutoConfiguration
public class Home {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "Hello, this is a test";
    }
}
