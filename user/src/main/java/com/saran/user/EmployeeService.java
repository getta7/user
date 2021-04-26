package com.saran.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.user.entity.Address;
import com.saran.user.entity.Department;
import com.saran.user.entity.Employee;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	AddressDao aDao;
	

	public Employee getUser(Integer empId ) {
		Employee user = dao.findById(empId).orElse(new Employee());
		System.out.println("-----------------Fetched Employee-----------------");
		System.out.println(user);
		System.out.println("--------------------------------------------------");
		return user;
	}
	public List<Employee> getAllUsers(){
		List<Employee> userList = (List<Employee>) dao.findAll();
		return userList;
	}
	public void addUser(Employee employee,Address address,Department dept) {
		System.out.println("-----------------Added Employee-------------------");
		System.out.println(employee);
		System.out.println("--------------------------------------------------");
		employee.setDepartment(dept);
		dao.save(employee);
		address.setEmployee(employee);
		aDao.save(address);
		
	}
	public void deleteUser(Employee employee) {
		System.out.println("----------------Deleted Employee----------------");
		System.out.println(employee.getId());
		System.out.println("------------------------------------------------");
		Employee emp = dao.findById(employee.getId()).orElse(new Employee());
		dao.delete(emp);
		aDao.deleteAll(emp.getAddress());
	}
	
	public void updateUser(Employee employee,Address address,Department dept) {
		System.out.println("----------------Updated Employee----------------");
		System.out.println(employee);
		System.out.println("------------------------------------------------");
		employee.setDepartment(dept);
		dao.save(employee);
		address.setEmployee(employee);
		aDao.save(address);
		
	}
	
	public Employee getUserByEmail(String email) {
		Employee emp = dao.findByEmail(email);
		return emp;
	}
	public Address getUserByEmployeeId(Integer id) {
		Address address = aDao.findByEmployeeId(id);
		return address;
	}
	
}
