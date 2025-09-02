package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CourseDTO {
	
	private Integer idCourse;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nameCourse;
	
	@NotNull
	@Size(min = 1, max = 5)
	private String acronymCourse;
	
	@NotNull
	private boolean enabledCourse;
	
	

}
