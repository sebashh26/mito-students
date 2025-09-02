package com.mitocode.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollDetailDTO {

	@JsonBackReference
	@ToString.Exclude
	private EnrollDTO enroll;
	
	@NotNull
	private CourseDTO course;
	
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 3)
	private String classRoom;
	
	@NotNull
	@JsonManagedReference
	private List<NotesDTO> notes;
}
