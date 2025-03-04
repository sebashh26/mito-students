package com.mitocode.service.impl;

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

}
