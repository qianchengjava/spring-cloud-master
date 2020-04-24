package com.bfxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
//@EnableKafkaStreams		//用这个注解会提示缺少kafka jar
@SpringBootApplication	//SpringBoot 核心配置
public class StreamApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}
	
}
