package com.spring.jpa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Page<Course> findByCourseTitleContaining(String title,Pageable pageRequest) ;
	
}
