package com.mitocode.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.Student;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IStudentRepo;
import com.mitocode.service.IStudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService{

	private final IStudentRepo repo;
	
	@Override
	protected IGenericRepo<Student, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Student> findAllOrderByAge() {
		
		List<Student> list = repo.findAll();
		//list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
		list = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).toList();
		return list;
		
	}
	}
