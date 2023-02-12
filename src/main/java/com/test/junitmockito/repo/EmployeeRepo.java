package com.test.junitmockito.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.junitmockito.entity.EmployeeDetails;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long>{
	
	List<EmployeeDetails> findAll();
	
	EmployeeDetails findByEmployeeId(Long employeeId);
	
	long count();

}
