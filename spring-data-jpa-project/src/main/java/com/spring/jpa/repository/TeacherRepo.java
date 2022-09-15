package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
				
	
	
}
