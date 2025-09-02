package com.mitocode.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Notes {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idNotes;	
	
	private String descriptionNotes;
	
	private Double score;	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_enroll_detail", nullable = false, foreignKey = @ForeignKey(name="FK_DETEN_NOTE"))
	@ToString.Exclude
	private EnrollDetail enrollDetail;
	
	
	

	
	

}
