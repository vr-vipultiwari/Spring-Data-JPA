package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String firstName);
	List<Student> findByFirstNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	
} 
