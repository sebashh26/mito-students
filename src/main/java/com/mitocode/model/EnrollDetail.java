package com.mitocode.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idEnrollDetail;
	
	@Column(length = 3, nullable = false)
	private String classRoom;
	
	@ManyToOne
	@JoinColumn(name = "id_enroll", nullable = false, foreignKey = @ForeignKey(name="FK_ENRDET_ENROLL"))
	@ToString.Exclude
	@JsonBackReference
	private Enroll enroll;
	
	@ManyToOne
	@JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name="FK_ENRDET_COURSE"))
	//@ToString.Exclude
	private Course course;
	
	@OneToMany(mappedBy = "enrollDetail", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Notes> notes;
	
	@Transient
	private Double notesAverage;
}
