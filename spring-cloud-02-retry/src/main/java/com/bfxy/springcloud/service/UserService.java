package com.bfxy.springcloud.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    int callNum = 0;

    //需要进行重试的方法
    @Retryable(value = {RemoteAccessException.class, NullPointerException.class},    //需要在捕获什么异常的情况下进行重试
            maxAttempts = 6, //重试的次数
            backoff = @Backoff(delay = 100, multiplier = 1)
    )
    public void call() throws Exception {
        callNum++;
        System.err.println("do something........." + callNum);

        throw new NullPointerException("空指针异常.."+callNum);
        //throw new RemoteAccessException("RPC调用异常..");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.err.println("最终处理的结果1: " + e.getMessage());
    }

    @Recover
    public void recover(NullPointerException e) {
        System.err.println("最终处理的结果2: " + e.getMessage());
    }

}
