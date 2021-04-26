package com.saran.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.saran.user.entity.Address;
import com.saran.user.entity.Department;
import com.saran.user.entity.Employee;

public class EmployeeUtility {

	public static Employee createUserObj(Map<String, String> pMap){
		Employee emp = new Employee();
		Address address = new Address();
		Department dept = new Department();
		address.setAddress1(pMap.get("address1"));
		address.setAddress2(pMap.get("address2"));
		address.setAddressType(pMap.get("type"));
		address.setCity(pMap.get("city"));
		address.setCountry(pMap.get("country"));
		address.setState(pMap.get("state"));
		address.setZip(pMap.get("zip"));
		emp.setUsername(pMap.get("username"));
		emp.setPassword(pMap.get("password"));
		emp.setFullname(pMap.get("fullname"));
		emp.setProject(pMap.get("project"));
		emp.setEmail(pMap.get("email"));
		dept.setDeptId(Integer.valueOf(pMap.get("deptId")));
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		emp.setAddress(addressList);
		emp.setDepartment(dept);
		return emp;
	}
	
	
}
