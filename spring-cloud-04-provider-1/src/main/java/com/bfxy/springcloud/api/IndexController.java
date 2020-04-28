package com.bfxy.springcloud.api;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    public static void main(String[] args) {
        List<Integer> a = Lists.newArrayList(1,2,3,4);
        List<Integer> a2 = a.stream().filter(n->{return n==2 || n==3;}).collect(Collectors.toList());
        List<Integer> a3 = a.stream().filter(n->{return n==1 || n==3;}).collect(Collectors.toList());
        System.out.println(a2);
        System.out.println(a3);
        Map a33= Maps.newHashMap();
        a33.put(null,2);
    }
}
