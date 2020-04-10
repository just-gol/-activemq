package com.qsqx.activemqdemo.controller;

import com.qsqx.activemqdemo.config.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveDemoController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Person person;

    @RequestMapping(value = "text")
    public String get(){
        System.out.println(person.getGender());
        return null;
    }
}