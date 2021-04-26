package com.saran.user;

import org.springframework.data.repository.CrudRepository;

import com.saran.user.entity.Address;

public interface AddressDao extends CrudRepository<Address, Integer>{

	public Address findByEmployeeId(Integer EmployeeId);
}
