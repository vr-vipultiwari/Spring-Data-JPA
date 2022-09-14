package com.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.sound.midi.Sequence;

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
	
}
