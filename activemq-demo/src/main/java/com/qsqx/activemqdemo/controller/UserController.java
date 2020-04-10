package com.qsqx.activemqdemo.controller;

import com.qsqx.activemqdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "test")
    public void test(){
        userService.test();
    }
}