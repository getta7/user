package com.saran.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id")
	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String project;
	private String email;

	@ManyToOne
	private Department department;
	
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> address;

	public Employee() {

	}

	public Employee(String username, String password, String fullname, String email, String project) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.project = project;
	}

	public Employee(String username, String password, String fullname, String email, String project,
			Integer id) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.project = project;
		this.id = id;
	}

	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer employeeId) {
		this.id = employeeId;
	}

	@Override
	public String toString() {
		return "User_info [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email="
				+ email + ", employeeId=" + id + "]";
	}
}
