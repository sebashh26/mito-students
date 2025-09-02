package com.mitocode.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.mitocode.model.Enroll;
import com.mitocode.model.EnrollDetail;
import com.mitocode.repo.IEnrollRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEnrollService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollServiceImpl extends CRUDImpl<Enroll, Integer> implements IEnrollService {

	private final IEnrollRepo repo;

	@Override
	protected IGenericRepo<Enroll, Integer> getRepo() {
		return repo;
	}

	@Override
	public Map<String, List<String>> getStudentGroupByCourse() {

		Stream<Enroll> streamEnroll = repo.findAll().stream();
		// Map<String, List<Team>> mapTeams =
		// teams.stream().collect(Collectors.groupingBy(Team::getSex));
		Stream<List<EnrollDetail>> streamListEnrollDetail = streamEnroll.map(Enroll::getDetails);

		// List<List<EnrollDetail>> list =
		// streamListEnrollDetail.collect(Collectors.toList());
		// System.out.println(list);
//		[[EnrollDetail(idEnrollDetail=2, classRoom=A, course=Course(idCourse=4, nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true))], 
//
//		 [EnrollDetail(idEnrollDetail=3, classRoom=A, course=Course(idCourse=4, nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)), 
//		 EnrollDetail(idEnrollDetail=4, classRoom=B, course=Course(idCourse=6, nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)), 
//		 EnrollDetail(idEnrollDetail=5, classRoom=C, course=Course(idCourse=8, nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true))],
//		  
//		 [EnrollDetail(idEnrollDetail=6, classRoom=A, course=Course(idCourse=4, nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)), 
//		 EnrollDetail(idEnrollDetail=7, classRoom=B, course=Course(idCourse=6, nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)),
//		  EnrollDetail(idEnrollDetail=9, classRoom=D, course=Course(idCourse=7, nameCourse=FULL STACK, acronymCourse=FS, enabledCourse=true)), 
//		  EnrollDetail(idEnrollDetail=8, classRoom=C, course=Course(idCourse=8, nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true))], 
//		  
//		  [EnrollDetail(idEnrollDetail=10, classRoom=A, course=Course(idCourse=4, nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)), 
//		  EnrollDetail(idEnrollDetail=14, classRoom=H, course=Course(idCourse=5, nameCourse=java testing, acronymCourse=JAVAT, enabledCourse=true)), 
//		  EnrollDetail(idEnrollDetail=11, classRoom=B, course=Course(idCourse=6, nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)), 
//		  EnrollDetail(idEnrollDetail=13, classRoom=D, course=Course(idCourse=7, nameCourse=FULL STACK, acronymCourse=FS, enabledCourse=true)), 
//		  EnrollDetail(idEnrollDetail=12, classRoom=C, course=Course(idCourse=8, nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true))],
//
//		  [EnrollDetail(idEnrollDetail=20, classRoom=C, course=Course(idCourse=8, nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true))]]
//		

		Stream<EnrollDetail> streamEnrollDetail = streamListEnrollDetail.flatMap(Collection::stream);

		// List<EnrollDetail> list = streamSaleDetail.collect(Collectors.toList());
		// System.out.println(list);
		// [EnrollDetail(idEnrollDetail=2, classRoom=A, course=Course(idCourse=4,
		// nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=3, classRoom=A, course=Course(idCourse=4,
		// nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=4, classRoom=B, course=Course(idCourse=6,
		// nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=5, classRoom=C, course=Course(idCourse=8,
		// nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=6, classRoom=A, course=Course(idCourse=4,
		// nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=7, classRoom=B, course=Course(idCourse=6,
		// nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=9, classRoom=D, course=Course(idCourse=7,
		// nameCourse=FULL STACK, acronymCourse=FS, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=8, classRoom=C, course=Course(idCourse=8,
		// nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=10, classRoom=A, course=Course(idCourse=4,
		// nameCourse=sping boot, acronymCourse=SPB, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=14, classRoom=H, course=Course(idCourse=5,
		// nameCourse=java testing, acronymCourse=JAVAT, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=11, classRoom=B, course=Course(idCourse=6,
		// nameCourse=java AWS, acronymCourse=JAWS, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=13, classRoom=D, course=Course(idCourse=7,
		// nameCourse=FULL STACK, acronymCourse=FS, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=12, classRoom=C, course=Course(idCourse=8,
		// nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true)),
		// EnrollDetail(idEnrollDetail=20, classRoom=C, course=Course(idCourse=8,
		// nameCourse=ARQ HEXAGONAL, acronymCourse=ARQHEX, enabledCourse=true))]

//		for (EnrollDetail enrollDetail : list) {
//			System.out.println(enrollDetail.getEnroll().getStudent());
//			
//		}
		Map<String, List<String>> studentsBycourse = streamEnrollDetail
				.collect(
						Collectors.groupingBy(e -> e.getCourse().getNameCourse(),
								Collectors.mapping(
										p -> p.getEnroll().getStudent().getNameCompleteStudent() + " "
												+ p.getEnroll().getStudent().getLastNameStudent(),
										Collectors.toList())));
		// System.out.println(bycourse);

		return studentsBycourse;
	}

	@Override
	public Map<Enroll, List<EnrollDetail>> getStudentNotes() {
		Stream<Enroll> streamEnroll = repo.findAll().stream();
		Stream<List<EnrollDetail>> streamListEnrollDetail = streamEnroll.map(Enroll::getDetails);
		Stream<EnrollDetail> streamEnrollDetail = streamListEnrollDetail.flatMap(Collection::stream);		
		 //List<EnrollDetail> list = streamEnrollDetail.collect(Collectors.toList());
		Map<Enroll, List<EnrollDetail>> mapCourses = streamEnrollDetail.collect(Collectors.groupingBy(d -> d.getEnroll()));
		
		mapCourses.forEach((k,v) -> {
			v.forEach(ed -> {
				ed.setNotesAverage(ed.getNotes().stream().mapToDouble(s -> s.getScore()).average().orElse(0.0) );	
			});
		});
		return mapCourses;
	}
}
