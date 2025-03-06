package com.mitocode.service.impl;

import org.springframework.stereotype.Service;

import com.mitocode.model.Enroll;
import com.mitocode.repo.IEnrollRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEnrollService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollServiceImpl extends CRUDImpl<Enroll, Integer> implements IEnrollService{

	private final IEnrollRepo repo;
	
	@Override
	protected IGenericRepo<Enroll, Integer> getRepo() {
		return repo;
	}

}
