package com.bfxy.springcloud.api;

import com.bfxy.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bfxy.springcloud.entity.User;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/retry")
    public String retry() {
        User user = restTemplate.getForObject("http://provider-service/getUser?id={1}", User.class, "001");
        System.err.println("username: " + user.getName());
        return "retry success!" + user.getName();
    }

    @RequestMapping(value = "/retryService")
    public String retryService() {
        try {
            userService.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "retry success!";
    }


}
