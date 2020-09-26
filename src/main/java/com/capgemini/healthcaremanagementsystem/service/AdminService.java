package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;

import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.TestIdAlreadyExistsException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

public interface AdminService {
	/** 
	 * Name___________:adminLogin
	 * Description____:Authenticating the Admin credentials.
	 * Parameter(s)___:String,String
	 * Returns________:Admin 
	 * Last Modified__:24/09/2020
	 * */
	Admin adminLogin(String adminName, String adminPassword);
	
	public Test addTest(Test test) throws TestIdAlreadyExistsException;
	boolean deleteTestById(Long testId) throws TestNotFoundException;
	public Test findTestById(Long testId) throws TestIdDoesNotExistException;
	public Test updateTest(Test test) throws TestNotFoundException ;
	
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter center);
	public boolean removeDiagnosticCenter(long centerId);
	public DiagnosticCenter findDiagnosticCenterById(long centerId);
	public List<DiagnosticCenter> viewAllDiagnosticCenter();

}
