package com.bfxy.springcloud.api;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfxy.springcloud.entity.User;
import com.bfxy.springcloud.service.HelloService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hystrix-hello")
    public String hello() throws Exception {
        String res = "init";
        try {
            res = helloService.callhello();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/hystrix-hi")
    public String hi() throws Exception {
        String res = "init hi";
        try {
            res = helloService.callhi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/hystrix-hello-timeout")
    public String hellotimeout() throws Exception {
        return helloService.callhello4timeout();
    }

    int start = 1;

    @RequestMapping(value = "/hystrix-batch")
    public String batch() throws Exception {
        List<Object> userList = Lists.newArrayList();
        HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
        List<Future<User>> futureList = Lists.newArrayList();
        for (int i = start; i < start + 8; i++) {
            Future<User> f = helloService.find(i +"");
            futureList.add(f);
        }

        for (Future<User> f : futureList) {
            Object user = f.get();
            userList.add(user);
            System.err.println(user);
        }


        Thread.sleep(1000);
        System.out.println("sleep   ......");
        Future<User> f5 = helloService.find(5999+"");
        System.err.println(f5.get());

        ctx.close();
//        start += 8;
        return userList.toString();
    }


    @RequestMapping(value = "/hystrix-thread")
    public String thread() throws Exception {
        return this.helloService.thread();
    }


    @RequestMapping(value = "/hystrix-semaphore")
    public String semaphore() throws Exception {
        return this.helloService.semaphore();
    }


}
