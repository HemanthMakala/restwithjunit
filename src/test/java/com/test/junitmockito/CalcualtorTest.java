package com.test.junitmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.junitmockito.calc.Calculator;


@ExtendWith(MockitoExtension.class)
public class CalcualtorTest {
	
	@InjectMocks
	Calculator calcualtor;

	@Test
	void squareTest() {
		
		int exp = 16;
		
		int act = calcualtor.square(4);
		
		System.out.println(act);

		assertEquals(exp, act);

	}

}
