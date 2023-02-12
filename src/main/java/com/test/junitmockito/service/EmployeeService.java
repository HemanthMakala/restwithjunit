package com.test.junitmockito.service;

import java.util.List;

import com.test.junitmockito.entity.EmployeeDetails;

public interface EmployeeService {
	
	List<EmployeeDetails> getAllEmp();
	
	EmployeeDetails getEmpById(Long id);
	
	long getCountOfEmp();
	
	EmployeeDetails getEmpWithMaxSalary();
	
	List<EmployeeDetails> getEmpSortedInReverse();

}
