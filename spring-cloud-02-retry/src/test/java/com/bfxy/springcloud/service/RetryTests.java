package com.bfxy.springcloud.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bfxy.springcloud.ApplicationDay2Retry;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationDay2Retry.class)
public class RetryTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void retryTest() throws Exception {
		//userService.call();
	}
	
}
