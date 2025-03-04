package com.mitocode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idStudent;
	
	@Column(nullable = false,length = 50)
	private String nameCompleteStudent;
	
	@Column(nullable = false,length = 50)
	private String lastNameStudent;
	
	@Column(length = 10, nullable = false, unique = true)
	private String dni;
	
	@Column(nullable = false,length = 3)
	private int age;
	

}
