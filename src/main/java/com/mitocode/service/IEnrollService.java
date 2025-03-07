package com.mitocode.service;

import java.util.Map;
import java.util.Set;

import com.mitocode.model.Course;
import com.mitocode.model.Enroll;

public interface IEnrollService extends ICRUD<Enroll, Integer> {

	Map<String, Set<String>> getStudentGroupByCourse();
}
