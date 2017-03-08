package com.example.controller;

import com.example.model.Menu;
import com.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by stevenfu on 07/03/2017.
 */
@RestController
@RequestMapping(value = "/security")
public class SecurityController {
    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping("/menus")
    public @ResponseBody  Iterable<Menu> getMenus(){
        return menuRepository.findAll();
    }

}
