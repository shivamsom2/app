package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/test/{x}")
	public String testGetController(@PathVariable("x") String x) {
		logger.debug(httpServletRequest.getContentType());
		logger.debug("API KEY FROM HEADER:{}",httpServletRequest.getHeader("x-api-key"));
		logger.debug("This is the value of X: {}",x);
		return x;
	}

}
