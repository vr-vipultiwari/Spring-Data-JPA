package com.spring.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String firstName);
	List<Student> findByFirstNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	
	// JPQL Query 
	@Query("select s from Student s where s.emailId =?1")
	Student getStudentByEmailAddress(String email) ;
	
	// Native Query 
	@Query(value = "select * from tbl_student tb where tb.student_id =?1" , nativeQuery = true ) 
	Student getStudentByIdNativeQuery(long id);
	
	
	@Modifying
	@Transactional
	@Query(value="update tbl_student set first_name=?1 where email_address=?2",nativeQuery=true)
	void updateTheFirstNameByEmailId(String firstName,String emailId);
} 
