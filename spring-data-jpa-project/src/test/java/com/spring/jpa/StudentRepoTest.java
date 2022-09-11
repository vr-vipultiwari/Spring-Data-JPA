package com.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa.entity.Guardian;
import com.spring.jpa.entity.Student;
import com.spring.jpa.entity.Student.StudentBuilder;
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
			             //.guardianName("Nikhil")
			             //.guardianEmail("nikhil@gmail.com")
			             //.guardianMobile("8889761500")
			             .build();
	studentRepository.save(student);
		
	}
	
	@Test
	 void printAllStudent() {
		List<Student> students  = studentRepository.findAll();
		System.out.println(students);
	}
	
	@Test
	void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder().name("Raj").email("RajVerma@gmail.com").mobile("8889761500").build();
		Student stuGaurdian = Student.builder()
				            .firstName("Shivam")
				            .lastName("agrawal")
				            .emailId("shivam@gmail.com")
				            .guardian(guardian)
				            .build();
		
	studentRepository.save(stuGaurdian);
	}

	@Test 
	void getStudentByFirstName(){
		
			List<Student> studentList = studentRepository.findByFirstName("shokken");
			System.out.println(studentList);
	}
	
	@Test 
	void getStudentByFirstNameContaining(){
		
			List<Student> studentList = studentRepository.findByFirstNameContaining("iv");
			System.out.println("Containing-->"+ studentList);
	}
	
	@Test 
	void getStudentWhoseFirstNameNotNull(){
		
			List<Student> studentList = studentRepository.findByFirstNameNotNull();
			System.out.println("Containing-->"+ studentList);
	}
	

	@Test 
	void getStudentByGuardianName(){
		
			List<Student> studentList = studentRepository.findByGuardianName("raj");
			System.out.println("Containing-->"+ studentList);
	}
}
