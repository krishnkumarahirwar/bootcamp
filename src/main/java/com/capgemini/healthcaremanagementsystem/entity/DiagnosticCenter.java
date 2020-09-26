package com.capgemini.healthcaremanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DiagnosticCenter {
	private String centerName;
	@Id
	@GeneratedValue()
	private long centerId;
	private String contactNumber;
	private String location;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Test> listOfTest = new ArrayList<Test>();

	public DiagnosticCenter() {
	}

public DiagnosticCenter(String centerName, long centerId, String contactNumber, String location) {
	this.centerName = centerName;
	this.centerId = centerId;
	this.contactNumber = contactNumber;
	this.location = location;
}

public String getCenterName() {
	return centerName;
}

public void setCenterName(String centerName) {
	this.centerName = centerName;
}

public long getCenterId() {
	return centerId;
}

public void setCenterId(long centerId) {
	this.centerId = centerId;
}

public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

@Override
public String toString() {
	return "DiagnosticCenter [centerName=" + centerName + ", centerId=" + centerId + ", contactNumber=" + contactNumber
			+ ", location=" + location + "]";
}

	

	
}
