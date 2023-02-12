package com.test.junitmockito;

import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.junitmockito.calc.Calculator;
import com.test.junitmockito.entity.EmployeeDetails;
import com.test.junitmockito.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@Autowired
	Calculator calculator;

	@RequestMapping("/getemployees")
	public List<EmployeeDetails> getAllEmployeeDetails() {
		List<EmployeeDetails> details = employeeService.getAllEmp().stream().map(x -> {
			/*
			 * x.setAddress(null); x.setDepartment(null);
			 */
			System.out.println(x.getDepartment().getName());
			return x;
		}).collect(Collectors.toList());
		System.out.println(details);
		return details;

	}

	@RequestMapping("/getempcnt")
	public long getEmployeeCount() {
		return employeeService.getCountOfEmp();

	}

	@RequestMapping("/getemp/{id}")
	public EmployeeDetails getEmployeeById(@PathVariable("id") Long id) throws Exception {
		try {

			EmployeeDetails ed = employeeService.getEmpById(id);
			if (null == ed) {
				throw new AccountNotFoundException("Employee With Id --> " + id + " not found");
			}
			return ed;

		} catch (Exception ex) {
			throw ex;
		}
	}

	@RequestMapping("/getfact/{value}")
	public Long getFactorial(@PathVariable("value") Long a) {
		return calculator.factorial(a);

	}

	@RequestMapping("/getsqr/{value}")
	public int getSquare(@PathVariable("value") int a) {
		return calculator.square(a);

	}

	@RequestMapping("/getempmax")
	public EmployeeDetails getEmpWithMaxSalary() {
		return employeeService.getEmpWithMaxSalary();

	}

	@RequestMapping("/getempsrtd")
	public List<EmployeeDetails> getEmpSortedSalary() {
		return employeeService.getEmpSortedInReverse();

	}

}
