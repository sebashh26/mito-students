package com.mitocode.service;

import java.util.List;
import java.util.Map;

import com.mitocode.model.Enroll;

public interface IEnrollService extends ICRUD<Enroll, Integer> {

	Map<String, List<String>> getStudentGroupByCourse();
}
