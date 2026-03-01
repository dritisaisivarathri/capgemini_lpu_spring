package com.capgemini.assignment3_27feb.dao;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String email;
    private String phone;
    private LocalDate memberSince;
    private String status;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Member(Long memberId, String name, String email, String phone, LocalDate memberSince, String status) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.memberSince = memberSince;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", memberSince=" + memberSince + ", status=" + status + "]";
	}
    
}
