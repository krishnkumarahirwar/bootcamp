package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaremanagementsystem.entity.Test;

public interface TestDao extends JpaRepository<Test, Long> {

}
