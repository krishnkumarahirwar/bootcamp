package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;

public interface DiagnosticCenterDao extends JpaRepository<DiagnosticCenter, Long> {
	
	

}
