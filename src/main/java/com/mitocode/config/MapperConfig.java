package com.mitocode.config;



import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Student;

@Configuration
public class MapperConfig {

	
	@Bean("studentMapper")
	public ModelMapper studentMapper() {
		ModelMapper mapper = new ModelMapper();
		//read
		
		//write
		TypeMap<StudentDTO, Student> typeMapDtoToEntity = mapper.createTypeMap(StudentDTO.class, Student.class);
		typeMapDtoToEntity.addMapping(StudentDTO::getNameStudent, (destination, value) -> destination.setNameCompleteStudent((String) value));
		
		return mapper;
	}
	
	@Bean("defaultMapper")
	public ModelMapper defaultMapper() {
		return new ModelMapper();
	}
	
}
