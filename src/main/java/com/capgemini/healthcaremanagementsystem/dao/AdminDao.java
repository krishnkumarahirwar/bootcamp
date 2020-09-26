package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaremanagementsystem.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Long> {
	
	/**
	 * QueryByMethod 
	 */
	public Admin findAdminByAdminName(String adminName);

}
