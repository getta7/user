package com.saran.user;

import org.springframework.data.repository.CrudRepository;

import com.saran.user.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, Integer>{
}
