package com.mitocode.service.impl;

import org.springframework.stereotype.Service;

import com.mitocode.model.Course;
import com.mitocode.repo.ICourseRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

	private final ICourseRepo repo;
	
	@Override
	protected IGenericRepo<Course, Integer> getRepo() {
		return repo;
	}

}
