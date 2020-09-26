package com.capgemini.healthcaremanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Admin {
	@Id
	@GeneratedValue()
	private long adminId;
	private String adminPassword;
	private String adminName;
			
	public Admin() {
		super();
	}

	public Admin(long adminId, String adminPassword, String adminName) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName + "]";
	}
	
	

}
