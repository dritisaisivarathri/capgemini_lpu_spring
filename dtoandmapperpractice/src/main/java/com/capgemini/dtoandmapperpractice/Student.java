package com.capgemini.dtoandmapperpractice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	//@NotEmpty
	//@NotNull
	private String name;
	@NotBlank
	private String college;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message="Invalid Email")
	private String email;
	@NotBlank
	@Pattern(regexp="^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$",message="Invalid Number")
	private String phone;
	private double marks;
	@NotBlank
	private String gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Student(){
		
	}
	
	public Student(int id, String name, String college, String email, String phone, double marks, String gender) {
		this.id = id;
		this.name = name;
		this.college = college;
		this.email = email;
		this.phone = phone;
		this.marks = marks;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", email=" + email + ", phone=" + phone
				+ ", marks=" + marks + ", gender=" + gender + "]";
	}
	
	
	
	
	

}
