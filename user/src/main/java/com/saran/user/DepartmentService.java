package com.saran.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.user.entity.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDao dao;
	

	public Department getDept(Integer deptId ) {
		Department dept = dao.findById(deptId).orElse(new Department());
		System.out.println(dept);
		return dept;
	}
	public List<Department> getAllDepts(){
		List<Department> userList = (List<Department>) dao.findAll();
		return userList;
	}
	public void addDept(Department dept) {
		System.out.println(dept);
		dao.save(dept);
	}
	public void deleteDept(Department dept) {
		System.out.println(dept.getDeptId());
		dao.delete(dept);
	}
	
	public void updateDept(Department dept) {
		System.out.println(dept);
		dao.save(dept);
	}
}
