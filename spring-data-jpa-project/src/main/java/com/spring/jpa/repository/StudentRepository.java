package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


	
}
