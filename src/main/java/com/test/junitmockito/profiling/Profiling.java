package com.test.junitmockito.profiling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.test.junitmockito.EmployeeController;

import jakarta.annotation.PostConstruct;

@Component
public class Profiling{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Value("${phone.number}")
	private String phoneNumber;

	@Value("${message}")
	private String message;
	
	@PostConstruct
	public void printPhoneNumber() {
		logger.info("The phone number value is: ===================================>" + this.phoneNumber);
		logger.info("The message is: ---------------------------------------------->" + this.message);
	}

}
