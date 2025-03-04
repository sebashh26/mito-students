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

import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Student;
import com.mitocode.service.IStudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final IStudentService service;//sin el final no se hace la inyeccion es va nulo
	
	@Qualifier("studentMapper")
	private final ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
		
		List<StudentDTO> list = this.service.readAll().stream().map(e -> convertToDto(e)).toList();//cambio a referencia matodos
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
		Student student = service.readById(id);
		return new ResponseEntity<>(this.convertToDto(student), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<StudentDTO> create (@Valid @RequestBody StudentDTO dto) throws Exception {
		Student student = service.save(this.convertToEntity(dto));
		return new ResponseEntity<>(this.convertToDto(student), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> update(@Valid @PathVariable Integer id, @RequestBody StudentDTO dto) throws Exception {
		Student student = service.update(this.convertToEntity(dto), id);
		return new ResponseEntity<>(this.convertToDto(student), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable("id") Integer id ) throws Exception{
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	private StudentDTO convertToDto(Student student) {
		return mapper.map(student, StudentDTO.class);
	}

	private Student convertToEntity(StudentDTO studentDTO) {
		return mapper.map(studentDTO, Student.class);
	}

}
