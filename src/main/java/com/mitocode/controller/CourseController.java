package com.mitocode.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.CourseDTO;
import com.mitocode.model.Course;
import com.mitocode.service.ICourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

	private final ICourseService service;
	
	@Qualifier("defaultMapper")
	private final ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
		
		List<CourseDTO> list = this.service.readAll().stream().map(e -> convertToDto(e)).toList();//cambio a referencia matodos
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception {
		Course course = service.readById(id);
		return new ResponseEntity<>(this.convertToDto(course), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CourseDTO> create (@Valid @RequestBody CourseDTO dto) throws Exception {
		Course course = service.save(this.convertToEntity(dto));
		return new ResponseEntity<>(this.convertToDto(course), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CourseDTO> update(@Valid @PathVariable Integer id, @RequestBody CourseDTO dto) throws Exception {
		Course course = service.update(this.convertToEntity(dto), id);
		return new ResponseEntity<>(this.convertToDto(course), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable("id") Integer id ) throws Exception{
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	private CourseDTO convertToDto(Course Course) {
		return mapper.map(Course, CourseDTO.class);
	}

	private Course convertToEntity(CourseDTO CourseDTO) {
		return mapper.map(CourseDTO, Course.class);
	}
}
