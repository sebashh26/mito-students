package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Enroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idEnroll;
	
	@Column(nullable = false)//iso calnedadr yyy mmm dd
	private LocalDateTime dateEnroll;
	
	@Column(nullable = false)
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLL_STUD"))
	private Student student;
	
	@OneToMany(mappedBy = "enroll", cascade = CascadeType.ALL)
	private List<EnrollDetail> details;
	

}
