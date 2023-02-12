package com.test.junitmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.junitmockito.calc.Calculator;
import com.test.junitmockito.entity.EmployeeDetails;
import com.test.junitmockito.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Mock
	Calculator calculator;

	@Mock
	EmployeeDetails employeeDetails;

	@Mock
	List<EmployeeDetails> EmpDetailsList;

	@Test
	public void getAllEmployeeDetailsTest() {

		when(employeeService.getAllEmp()).thenReturn(EmpDetailsList);

		assertEquals(employeeController.getAllEmployeeDetails(), EmpDetailsList);

	}

	@Test
	public void getEmployeeCountTest() {

		when(employeeService.getCountOfEmp()).thenReturn(4l);

		assertEquals(employeeController.getEmployeeCount(), 4l);

	}

	@Test
	public void getEmployeeNotFoundTest() {
		when(employeeService.getEmpById(1000l)).thenReturn(null);
		
		AccountNotFoundException ant = assertThrows(AccountNotFoundException.class,
				() -> employeeController.getEmployeeById(1000l));

		assertEquals(ant.getMessage(), "Employee With Id --> 1000 not found");

	}

}
