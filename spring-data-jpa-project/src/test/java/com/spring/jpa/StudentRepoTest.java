package com.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa.entity.Student;
import com.spring.jpa.repository.StudentRepository;

@SpringBootTest
public class StudentRepoTest {

	@Autowired
	StudentRepository studentRepository ;
	
	@Test
	 void testSave() {
	Student student  = Student.builder()
			             .emailId("yesboss@gmail.com")
			             .firstName("shokken")
			             .lastName("Shah")
			             .guardianName("Nikhil")
			             .guardianEmail("nikhil@gmail.com")
			             .guardianMobile("8889761500")
			             .build();
	studentRepository.save(student);
		
	}
	@Test
	 void printAllStudent() {
		List<Student> students  = studentRepository.findAll();
		System.out.println(students);
	}
	
}
