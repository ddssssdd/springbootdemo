package com.example.controller;

import com.example.config.ConfigBean;
import com.example.config.ConfigTest;
import com.example.model.Menu;
import com.example.model.User;
import com.example.repository.MenuRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

@Controller
@EnableAutoConfiguration
public class UserController {
    @Value("${com.demo4.name}")
    private String testName;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private ConfigTest test;

    @RequestMapping(value="/user",method = RequestMethod.GET)
    public String index(Model model)
    {
        List<String> lists = new ArrayList<>();
        lists.add("a1");
        lists.add("b2");
        lists.add("c3");
        model.addAttribute("list", lists);
        model.addAttribute("hello","michael");
        configBean.setName(testName+test.getCompany());
        model.addAttribute("settings", configBean);
        model.addAttribute("autoload","Yes");
        return "index";
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

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

    @GetMapping(path="/addMenu")
    public String addMenu(Model model){
        model.addAttribute("menus",menuRepository.findAll());
        return "admin/AddMenu";
    }
    @PostMapping(path="/addMenu")
    public String postMenu(Menu menu){
        menuRepository.save(menu);
        return "admin/AddMenu";
    }
}
