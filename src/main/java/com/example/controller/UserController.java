package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

@Controller
@EnableAutoConfiguration
public class UserController {
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public String index(Model model)
    {
        List<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("b");
        lists.add("c");
        model.addAttribute("list", lists);
        model.addAttribute("hello","michael");
        return "index";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/addUser")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "allUsers")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/findByEmail")
    public @ResponseBody Iterable<User> findUsers(@RequestParam String email){
        //return userRepository.findByEmail(email);
        return userRepository.findByQuery2(email);
    }
}
