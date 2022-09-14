package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.CourseMaterial;


@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
	
	

}
