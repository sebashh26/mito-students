package com.mitocode.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idEnroll;
	
	@NotNull
	private LocalDateTime dateEnroll;
	
	@NotNull
	private boolean enabled;
	
	@NotNull
	private StudentDTO student;
	
	@NotNull
	@JsonManagedReference
	private List<EnrollDetailDTO> details;
}
