package com.test.junitmockito.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.junitmockito.entity.EmployeeDetails;
import com.test.junitmockito.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<EmployeeDetails> getAllEmp() {

		return employeeRepo.findAll();

	}

	@Override
	public long getCountOfEmp() {
		// TODO Auto-generated method stub
		return employeeRepo.count();
	}

	@Override
	public EmployeeDetails getEmpById(Long id) {
		return employeeRepo.findByEmployeeId(id);
	}

	@Override
	public EmployeeDetails getEmpWithMaxSalary() {
		List<EmployeeDetails> empList = this.getAllEmp();

		return empList.stream().max((a, b) -> a.getSalary().compareTo(b.getSalary())).get();
	}

	@Override
	public List<EmployeeDetails> getEmpSortedInReverse() {
		List<EmployeeDetails> empList = this.getAllEmp();

		return empList.stream()
				.sorted((a, b) -> b.getName()
				.compareTo(a.getName()))
				.collect(Collectors.toList());
	}

}
