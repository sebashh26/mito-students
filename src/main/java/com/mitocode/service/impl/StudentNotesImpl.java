package com.mitocode.service.impl;

import org.springframework.stereotype.Service;

import com.mitocode.model.Notes;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.INotesRepo;
import com.mitocode.service.INotesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentNotesImpl extends CRUDImpl<Notes, Integer> implements INotesService {

	private final INotesRepo repo;

	@Override
	protected IGenericRepo<Notes, Integer> getRepo() {
		return repo;
	}

}
