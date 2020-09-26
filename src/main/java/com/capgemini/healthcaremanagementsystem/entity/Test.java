package com.capgemini.healthcaremanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Test {
	@Id
	@GeneratedValue()
	private long testId;
	private String testName;
	private int testPrice;
	private long centerId;

	//@ManyToOne
	//private DiagnosticCenter diagnosticCenter;
	
	
	@OneToMany(mappedBy = "test")
	private List<Appointment> listOfAppointments = new ArrayList<Appointment>();

	public Test() {
		super();
	}

	public Test(long testId, String testName, int testPrice, long centerId) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testPrice = testPrice;
		this.centerId = centerId;
		
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}


	
	
}
	