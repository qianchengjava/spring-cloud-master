package com.bfxy.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String hello() throws Exception {
        System.out.println("provider-1 ");
        //int a = 1/0;
        return "Hello World!";
    }

    int num = 0;

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() throws InterruptedException {
        num++;
        System.out.println("start provider-1 " + num);
        Thread.sleep(900);
        System.out.println("end provider-1 " + num);
        num = 0;
        return "Hi Feign!";
    }

}
