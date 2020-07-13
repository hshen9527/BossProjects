package org.boss.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class helloController {

    @ResponseBody
    @RequestMapping("/test")
    public String hello(){
        return "Hello World";
    }

}
