package com.capgemini.spingbootbasic.CustomMethodQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	private int id;
	private String phone;
	private String email;
	private String name;
	private int age;
	private String gender;
	private String dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Customer(int id, String phone, String email, String name, int age, String gender, String dob) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", phone=" + phone + ", email=" + email + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	Customer(){
		
	}

}
