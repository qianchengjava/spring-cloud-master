package com.bfxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer		//开启配置中心服务
@SpringBootApplication	//SpringBoot 核心配置
public class BusApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BusApplication.class, args);
	}
	
}
