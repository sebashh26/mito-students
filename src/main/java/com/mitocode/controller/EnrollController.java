package com.mitocode.controller;

import java.util.List;
import java.util.Map;

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

import com.mitocode.dto.EnrollDTO;
import com.mitocode.model.Enroll;
import com.mitocode.service.IEnrollService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrolls")
@RequiredArgsConstructor
public class EnrollController {

	private final IEnrollService service;

	@Qualifier("defaultMapper")
	private final ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<EnrollDTO>> readAll() throws Exception {
		List<EnrollDTO> list = service.readAll().stream().map(this::convertToDto).toList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnrollDTO> readById(@PathVariable("id") Integer id) throws Exception {
		Enroll sale = service.readById(id);
		return new ResponseEntity<>(this.convertToDto(sale), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EnrollDTO> create(@RequestBody EnrollDTO dto) throws Exception {
		System.out.println(dto);
		Enroll obj = service.save(this.convertToEntity(dto));
		return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EnrollDTO> update(@Valid @RequestBody EnrollDTO dto, @PathVariable("id") Integer id)
			throws Exception {
		Enroll obj = service.update(convertToEntity(dto), id);

		return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/studentsbycourse")
	public ResponseEntity<Map<String, List<String>>> getStudentsByCourse(){
		Map<String, List<String>> map = service.getStudentGroupByCourse();
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	private EnrollDTO convertToDto(Enroll sale) {
		return mapper.map(sale, EnrollDTO.class);
	}

	private Enroll convertToEntity(EnrollDTO saleDTO) {
		return mapper.map(saleDTO, Enroll.class);
	}

}
