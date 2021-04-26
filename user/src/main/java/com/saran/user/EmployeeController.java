package com.saran.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.user.entity.Address;
import com.saran.user.entity.Department;
import com.saran.user.entity.Employee;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService userService;
	
	@GetMapping
	public List<Employee> getAllUsers(){
		List<Employee> userList = (List<Employee>) userService.getAllUsers();
		return userList;
	}
	
	@GetMapping(value = "{employeeId}")
	public Employee getUser(@PathVariable("employeeId") Integer employeeId) {
		Employee user = userService.getUser(employeeId);
		return user;
	}
	@GetMapping(value = "{id}/address")
	public Address getAddressById(@PathVariable("id") Integer id) {
		Address address = userService.getUserByEmployeeId(id);
		return address;
	}
	@GetMapping(value = "email/{email}")
	public Employee getUser(@PathVariable("email") String email) {
		Employee user = userService.getUserByEmail(email);
		return user;
	}
	@PostMapping("add")
	public void addUser(@ModelAttribute Employee emp,@ModelAttribute Address address,@ModelAttribute Department dept) {
		userService.addUser(emp,address,dept);
	}
	
	@DeleteMapping("delete/{employeeId}")
	public void deleteUser(@PathVariable("employeeId") Integer employeeId) {
		Employee user = new Employee();
		user.setId(employeeId);
		userService.deleteUser(user);
	}
	
	
	@PatchMapping("update")
	public void update(@ModelAttribute Employee emp,@ModelAttribute Address address,@ModelAttribute Department dept) {
		userService.updateUser(emp,address,dept);
	}
	
	
	
}
