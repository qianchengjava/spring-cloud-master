package com.bfxy.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private int a = 0;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String hello() {
        System.out.println("调到了provider的index方法" + (a++));
        return "Hello World:" + a;
    }


}
