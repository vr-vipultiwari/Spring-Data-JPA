package com.spring.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Teacher;
import com.spring.jpa.repository.TeacherRepo;

@SpringBootTest
public class TeacherRepoTest {

	@Autowired
	TeacherRepo teacherRepo ;
	
	
	

	private List<Course> createCourses() {
		List<Course> courses = new ArrayList<>();
		
		Course course1 = Course.builder().courseTitle("Stock Trading").credit(10).build();
		Course course2 = Course.builder().courseTitle("Digital Ads").credit(20).build();
		
		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
}
