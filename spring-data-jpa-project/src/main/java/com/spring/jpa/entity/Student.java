package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tbl_student",
       uniqueConstraints =  @UniqueConstraint(
    		   name="emailid_unique",
    		   columnNames = "email_address"
    		)
		)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName = "student_sequence",
			allocationSize =1
)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
	private long studentId;
	private String firstName;
	private String lastName;
	@Column(name="email_address",nullable = false)
	private String emailId;
	private String guardianName;
	private String guardianEmail;
	private String guardianMobile;
	
}
