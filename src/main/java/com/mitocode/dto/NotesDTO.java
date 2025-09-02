package com.mitocode.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idNotes;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String descriptionNotes;

	@NotNull(message = "The note cant be null")
    @DecimalMin(value = "0.00", message = "The note should be equal o major than 0")
    @DecimalMax(value = "10.00", message = "The note should be equal o minor than 10")
    @Digits(integer = 2, fraction = 2) // Hasta 2 dígitos enteros y 2 decimales	
	private BigDecimal score;
	
	@JsonBackReference
	@ToString.Exclude
	private EnrollDetailDTO enrollDetail;

}
