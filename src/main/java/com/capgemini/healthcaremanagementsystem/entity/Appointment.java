package com.capgemini.healthcaremanagementsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue()
	private long appointmentId;
	private long testId;
	private String appointmentStatus;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime dateTime;


	  @ManyToOne
	  private Test test;
	 

	@ManyToOne
	private Customer customer;

	public Appointment(long appointmentId, long testId, String appointmentStatus, LocalDateTime dateTime,
			Customer customer) {
		super();
		this.appointmentId = appointmentId;
		this.testId = testId;
		this.appointmentStatus = appointmentStatus;
		this.dateTime = dateTime;
		this.customer = customer;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", testId=" + testId + ", appointmentStatus="
				+ appointmentStatus + ", dateTime=" + dateTime + ", customer=" + customer + "]";
	}

}
