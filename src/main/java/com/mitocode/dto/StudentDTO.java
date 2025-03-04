package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
	
	private Integer idStudent;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nameStudent;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String lastNameStudent;
	
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 10)
	private String dni;
	
	@NotNull
	@Max(150)
	private int age;

}
