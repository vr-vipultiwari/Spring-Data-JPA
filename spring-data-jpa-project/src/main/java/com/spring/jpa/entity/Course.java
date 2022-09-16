package com.spring.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.sound.midi.Sequence;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {
	
	@SequenceGenerator(
			name ="course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1
			
			)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
	private long courseId;
	private String courseTitle;
	private int credit ;
	
	@OneToOne(
			mappedBy = "course"
	)
	private CourseMaterial courseMaterial ;
	
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
	    name="teacher_id",
	    referencedColumnName = "teacherId"
	)
	private Teacher teacher ;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name =  "course_student",
			joinColumns = @JoinColumn(
					  name="course_id",
					  referencedColumnName = "courseId"
					),
			 inverseJoinColumns = @JoinColumn(
					 name="student_id",
					 referencedColumnName = "studentId"
					 
					 )
			)
	private List<Student> students ;
	
}
