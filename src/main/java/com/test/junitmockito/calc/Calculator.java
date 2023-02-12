package com.test.junitmockito.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

	public int square(int a) {
		return a * a;

	}

	public Long factorial(Long a) {
		if (a == 0) {
			return 1l;
		} else {
			return a * factorial(a - 1);

		}
	}

}
