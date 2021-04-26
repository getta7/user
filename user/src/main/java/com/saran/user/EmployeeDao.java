package com.saran.user;

import org.springframework.data.repository.CrudRepository;

import com.saran.user.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public Employee findByEmail(String email);
}
