package com.spring.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterial {

	@Id
	@SequenceGenerator(
			name="course_material_sequnece",
			sequenceName="course_material_sequence",
			allocationSize=1			
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "course_material_sequence")
	private long courseMaterialId;
	private String courseMaterialUrl;
	
	@OneToOne(
		 cascade = CascadeType.ALL	
	  )
	@JoinColumn(
			name="course_id",
			referencedColumnName = "courseId"
	)
	private Course course ;
	
}
