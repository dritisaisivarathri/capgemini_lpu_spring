package com.capgemini.assignment3_27feb.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String name;
    private String location;
    private String contactNumber;
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public LibraryBranch(Long branchId, String name, String location, String contactNumber) {
		this.branchId = branchId;
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "LibraryBranch [branchId=" + branchId + ", name=" + name + ", location=" + location + ", contactNumber="
				+ contactNumber + "]";
	}
    
}