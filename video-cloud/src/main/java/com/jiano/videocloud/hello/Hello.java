package com.jiano.videocloud.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @RequestMapping("/main")
    public String hello(){
        return "welcome";
    }
}
