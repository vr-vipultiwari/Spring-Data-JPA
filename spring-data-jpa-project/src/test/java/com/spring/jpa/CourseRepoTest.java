package com.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.jpa.entity.Course;
import com.spring.jpa.entity.Guardian;
import com.spring.jpa.entity.Student;
import com.spring.jpa.entity.Student.StudentBuilder;
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
	 
	 @Test
	 void findAllPagination() {
		
		 Pageable firstPageWithOneRecord = PageRequest.of(0,2);
		 Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
		 
		 List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		 System.out.println(courses); 
		 Long totalElements = courseRepository
				               .findAll(secondPageWithTwoRecords)
				               .getTotalElements();
		 System.out.println("total elements "+ totalElements);		 
		 int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		 System.out.println("total pages "+totalPages);
	 }
	 
	 @Test
	 public void findAllSorting() {
		 
		Pageable pageWith2Records = PageRequest.of(0, 2,Sort.by("courseTitle"));
		
		Pageable pageWith1Record = PageRequest.of(1,1,Sort.by("credit").descending());
		
		Pageable pageWith1RecordAndSort = PageRequest.of(1,1,Sort.by("courseTitle").descending().and(Sort.by("credit")));
		
		Page<Course> pageSortByTitle = courseRepository.findAll(pageWith2Records);
		Page<Course> pageSortByCreditDesc = courseRepository.findAll(pageWith1Record);
		Page<Course> PageSortByTitleAndCredit= courseRepository.findAll(pageWith1RecordAndSort);
		
		System.out.println("Content of page one in sorted order " + pageSortByTitle.getContent() );
		System.out.println("Content of page sort by credit decending  " + pageSortByCreditDesc.getContent() );
		System.out.println("Content of page sort by decending tite and credit " + PageSortByTitleAndCredit.getContent() );
		
		
	 }
	 
	 @Test
     void getCourseContainingGivenTitle() {
    	 
		 Pageable pageable = PageRequest.of(0, 1);
		 
    	 Page<Course> allRecords = courseRepository.findByCourseTitleContaining("Py", pageable);
    	 System.out.println(allRecords.getContent());
    	  
     } 
	 
	 @Test  
	 void saveCourseWithStudentAndTeacher(){
		 
		 Teacher teacher = Teacher.builder().firstName("Saurabh").lastName("Raj").build();
		 
		 Student student = Student.builder().firstName("chunnu").lastName("Singh").emailId("chunnu@gmail.com")
		 .guardian(Guardian.builder().name("Yash").email("yashVerma@gmail.com").mobile("8889761500").build()).build();
		 
		 Course course = Course.builder().teacher(teacher).students(List.of(student)).courseTitle("System Design").credit(10).build();
		 
		 courseRepository.save(course);
	 }
}
