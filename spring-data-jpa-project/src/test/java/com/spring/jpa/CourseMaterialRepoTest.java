package com.spring.jpa;

import java.util.List;

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
    	
		Course course = Course.builder().courseTitle("Digital Marketing Course").credit(8).build();
		
      CourseMaterial courseMaterial   = CourseMaterial.builder()
		             .courseMaterialUrl("https://sun.micro.system/course1")
		             .course(course)
		             .build();
    	
    	courseMaterialRepository.save(courseMaterial);
    }
	
	@Test
	void printAllCourseMaterial() {
		
		  List<CourseMaterial> allCourseMaterial = courseMaterialRepository.findAll();
		  System.out.println(allCourseMaterial);
	}
	
}
