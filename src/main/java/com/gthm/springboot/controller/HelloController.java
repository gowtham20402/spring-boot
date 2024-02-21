package com.gthm.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/say")
    public String sayHello(){
        return "Hello, Everyone!!";
    }
}
