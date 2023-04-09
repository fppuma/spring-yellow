package com.example.web;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringYellowApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		int count = context.getBeanDefinitionCount();
		logger.info("count of the beans in this context:{}",count);
		for(String name:context.getBeanDefinitionNames()) {
			logger.info("name:{}", name);
		}
	}

}
