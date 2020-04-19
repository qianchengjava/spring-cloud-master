package com.bfxy.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfxy.springcloud.entity.User;

@RestController
public class UserController {

    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(@RequestParam("id") String id) throws InterruptedException {
        System.err.println("provider-2 ----> id: " + id);
        Long sleepMills = 1000L;
        Thread.sleep(sleepMills);
        return new User(id, "张三provider2 sleepMills:" + sleepMills);
    }

    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(@RequestParam("id") String id) throws InterruptedException {
        System.err.println("provider-2 ----> id: " + id);
//		Thread.sleep(1000);
        return new User(id, "could02-provider-2");
    }

}
