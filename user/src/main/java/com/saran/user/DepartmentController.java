package com.saran.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saran.user.entity.Department;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	DepartmentService deptService;
	
	@GetMapping
	public List<Department> getAllDept(){
		List<Department> deptList = (List<Department>) deptService.getAllDepts();
		return deptList;
	}
	
	@GetMapping(value = "{deptId}")
	public Department getDept(@PathVariable("deptId") Integer deptId) {
		Department dept = deptService.getDept(deptId);
		return dept;
	}
	
	@PostMapping("add")
 	public void addDept(@RequestParam(value = "deptname") String deptName) {
		Department dept = new Department(deptName);
		deptService.addDept(dept);
	}
	
	@DeleteMapping("delete/{deptId}")
	public void deleteDept(@PathVariable("deptId") Integer deptId) {
		Department dept = new Department();
		dept.setDeptId(deptId);
		deptService.deleteDept(dept);
	}
	
	@PatchMapping("update")
	public void updateDept(@RequestParam(value = "deptId") Integer deptid,@RequestParam(value = "deptname") String deptName) {
		Department dept = new Department(deptid,deptName);
		deptService.updateDept(dept);
	}
	
	
}
