package com.bfxy.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfxy.springcloud.entity.User;

@RestController
public class UserController {


    private int counter = 0;

    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(@RequestParam("id") String id) throws InterruptedException {
        System.err.println("provider-1 ----> id: " + id);
        Long sleepMills = 2500L;
        Thread.sleep(sleepMills);
        counter++;//1 + 1
        System.err.println(counter);
        return new User(id, "getUser Provider1 sleepMills:" + sleepMills);
    }

    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(@RequestParam("id") String id) throws InterruptedException {
        System.err.println("provider-1 ----> id: " + id);
//		Thread.sleep(1000);
        return new User(id, "provider1 sleep ");
    }

}
