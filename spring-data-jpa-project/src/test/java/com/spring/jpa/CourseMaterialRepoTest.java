package com.spring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.CourseMaterial;
import com.spring.jpa.repository.CourseMaterialRepository;

@SpringBootTest
class CourseMaterialRepoTest {

	
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository ;
	
	
	@Test
    void saveCourseMaterail() {
    	
		Course course = Course.builder().courseTitle("DSA").credit(8).build();
		
      CourseMaterial courseMaterial   = CourseMaterial.builder()
		             .courseMaterialUrl("https://local:9090/course1")
		             .course(course).build();
    	
    	courseMaterialRepository.save(courseMaterial);
    }
	
}
