package com.capgemini.healthcaremanagementsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaremanagementsystem.dao.AdminDao;
import com.capgemini.healthcaremanagementsystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdAlreadyExistsException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;
import com.capgemini.healthcaremanagementsystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private Admin admin;
		
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private DiagnosticCenterDao diagnosticDao;
		
	/** 
	 * Name___________:adminLogin
	 * Description____:Authenticating the Admin credentials
	 * Parameter(s)___:String,String
	 * Returns________:Customer 
	 * Last Modified__:24/09/2020
	 * */
	@Override
	public Admin adminLogin(String adminName, String adminPassword) throws AdminNotFoundException{
		Admin admin = adminDao.findAdminByAdminName(adminName);
		if ((admin!=null && admin.getAdminPassword().equals(adminPassword) && admin.getAdminName().equals(adminName)))
			return admin;
		throw new AdminNotFoundException(
				"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
	}
	
	@Override
	public Test addTest(Test test) throws TestIdAlreadyExistsException {
		if(testDao.existsById(test.getTestId()))
		{
		throw new TestIdAlreadyExistsException("Test with testId" +test.getTestId()+" alreadyExists");	
		}
		Test  addtest = testDao.save(test);
	     return addtest;
	}
	
	@Override
	public boolean deleteTestById(Long testId) throws TestNotFoundException {
		boolean isExist = testDao.existsById(testId);
		if (isExist) {
			testDao.deleteById(testId);
			return true;
		}
		throw new TestNotFoundException("Test not found...");
	}

	
	@Override
	public Test updateTest(Test test) throws TestNotFoundException {
		boolean exists = testDao.existsById(test.getTestId());
		if (exists) {
			testDao.save(test);
			return test;
		}

		throw new TestNotFoundException("Test Id does not exists = ");
	}

	@Override
	public Test findTestById(Long testId) throws TestIdDoesNotExistException {
		if( ! testDao.existsById(testId))
		{
			throw new TestIdDoesNotExistException("TestId does Not Exists");
		}
		return testDao.findById(testId).get();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter center) {
		Optional<DiagnosticCenter> optional=diagnosticDao.findById(center.getCenterId());
		if(optional.isPresent()) {
			throw new CenterAlreadyExistException("center is already exist with given details");
		}
		else
		 return diagnosticDao.save(center);
	}

	@Override
	public boolean removeDiagnosticCenter(long centerId) {
		Optional<DiagnosticCenter> optional = diagnosticDao.findById(centerId);
		if (optional.isPresent()) {
			DiagnosticCenter center = optional.get();
			diagnosticDao.delete(center);
			return true;
		}

		throw new CenterNotFoundException("No center with given details" + centerId);
	}

	@Override
	public DiagnosticCenter findDiagnosticCenterById(long centerId) {
		Optional<DiagnosticCenter> optional=diagnosticDao.findById(centerId);
		if(optional.isPresent()) {
			DiagnosticCenter center=optional.get();
			return center;
		}
		else 
			throw new CenterNotFoundException("No center with given id"+centerId);
	}

	@Override
	public List<DiagnosticCenter> viewAllDiagnosticCenter() {
		return diagnosticDao.findAll();
	}


}
