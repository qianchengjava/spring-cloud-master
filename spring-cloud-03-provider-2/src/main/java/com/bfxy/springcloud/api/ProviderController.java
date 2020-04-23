package com.bfxy.springcloud.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfxy.springcloud.entity.User;

@RestController
public class ProviderController {

    private int num = 0;

    @RequestMapping(value = "/hello")
    public String hello() throws InterruptedException {
        System.err.println("--------provider2 : say hello!----------");
        return "--------provider2 : say hello!----------" + num++;
    }

    @RequestMapping(value = "/hi")
    public String hi() throws Exception {
        int a = 1 / 0;
        System.err.println("--------provider2 : say hi!----------");
        return "--------provider2 : say hi!----------";
    }

    /**
     * 单独查询User接口
     * 使用rest风格path传递参数
     *
     * @param id
     * @return
     * @throws Exception
     */
    // http://localhost:7001/users/1
    @RequestMapping(value = "/users/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        System.err.println("start provider-2 单独查询-------> " + id + "|" + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.err.println("end provider-2 单独查询-------> " + id + "|" + Thread.currentThread().getName());
        return new User("1", "张三");
    }

    /**
     * 批量查询users接口
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/my-users")
    public List<User> getUsers(@RequestParam("ids") String ids) throws Exception {
        System.err.println("start provider-2 批量查询-------> " + ids + "|" + Thread.currentThread().getName());
        Thread.sleep(1000);
        List<User> users = new ArrayList<>();
        for (String id : ids.split(",")) {
            users.add(new User(id, "张老" + id));
        }
        System.err.println("end provider-2 批量查询-------> " + ids + "|" + Thread.currentThread().getName());
        return users;
    }


    @RequestMapping(value = "/thread")
    public String thread() throws Exception {
        System.err.println("provider2: ---------> thread");
        Thread.sleep(RandomUtils.nextInt(100, 500));
        return "provider2";
    }

    @RequestMapping(value = "/semaphore")
    public String semaphore() throws Exception {
        System.err.println("provider2: ---------> semaphore");
        Thread.sleep(RandomUtils.nextInt(100, 500));
        return "provider2";
    }

}
