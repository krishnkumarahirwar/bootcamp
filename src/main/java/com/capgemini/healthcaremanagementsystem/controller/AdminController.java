package com.capgemini.healthcaremanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.CenterAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdAlreadyExistsException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;
import com.capgemini.healthcaremanagementsystem.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	/** 
	 * Name___________:adminLogin
	 * Description____:Authenticating the Admin credentials.
	 * Parameter(s)___:String,String
	 * Returns________:Admin 
	 * Last Modified__:24/09/2020
	 * */
	
	@PostMapping("/login")
	public Admin adminLogin(@RequestBody Admin admin) {
		String adminName= admin.getAdminName();
		String adminPassword=admin.getAdminPassword();
		return adminService.adminLogin(adminName,adminPassword);
	}
	
	@PostMapping("/addTest")
	public ResponseEntity<Test> addTest(@RequestBody @Valid Test test) throws TestIdAlreadyExistsException {
		test = adminService.addTest(test);
		ResponseEntity<Test> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/deleteTest/{id}")
	public ResponseEntity<Boolean> deletetTest(@PathVariable("id")Long testId) throws TestNotFoundException {
		boolean isDeleted = adminService.deleteTestById(testId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(isDeleted, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/updateTest")
	public ResponseEntity<Test> updateTest(@RequestBody @Valid Test test) throws TestNotFoundException {
		test = adminService.updateTest(test);
		ResponseEntity<Test> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addDiagnosticCenter")
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody @Valid DiagnosticCenter center) throws CenterAlreadyExistException {
		
				center=adminService.addDiagnosticCenter(center);
				ResponseEntity<DiagnosticCenter> response=new ResponseEntity<>(center, HttpStatus.OK);
				return response;
	}
	
	@DeleteMapping("/deleteDiagnosticCenter/{centerId}")
	public ResponseEntity<Boolean> removeDiagnoticCenter(@PathVariable("id") Long centerId) throws CenterNotFoundException{
		boolean isRemove = adminService.removeDiagnosticCenter(centerId);
		ResponseEntity<Boolean> response=new ResponseEntity<>(isRemove , HttpStatus.OK);
		return response;
		
	}
	@GetMapping("/searchDiagnosticCente/{centerId}")
	public ResponseEntity<DiagnosticCenter> findDiagnosticCenterById(@PathVariable("id") Long centerId) throws CenterNotFoundException{
		
		DiagnosticCenter center=adminService.findDiagnosticCenterById(centerId);
		ResponseEntity<DiagnosticCenter> response=new ResponseEntity<>(center , HttpStatus.OK);
		return response;
		
	}
	
	@GetMapping("/viewAllCenters")
	public ResponseEntity<List<DiagnosticCenter>> viewAllDiagnosticCenter() throws CenterNotFoundException {
		List<DiagnosticCenter> listOfDiagnosticCenter= adminService.viewAllDiagnosticCenter();
		ResponseEntity<List<DiagnosticCenter>> response = new ResponseEntity<>(listOfDiagnosticCenter , HttpStatus.OK);
		return response;
	}
}
