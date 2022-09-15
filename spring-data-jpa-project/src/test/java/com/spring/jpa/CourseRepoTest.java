package com.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Teacher;
import com.spring.jpa.repository.CourseRepository;

@SpringBootTest
public class CourseRepoTest {

	
	@Autowired
	CourseRepository courseRepository ;
	
	 @Test
	 public void getAllCourses(){
		 
		 List<Course> allCourse = courseRepository.findAll();
		 System.out.println(allCourse);
	 }
	 
	 @Test
	 void saveCoursesWithTeacher() {
		 
		 Teacher teacher = Teacher.builder()
				            .firstName("Ram")
				            .lastName("Narayan")
				            .build();
		 
		 Course course = Course.builder()
				          .courseTitle("Python")
				          .credit(7)
				          .teacher(teacher).build();
		 
		 courseRepository.save(course);
 
	 }
	 
	
}
