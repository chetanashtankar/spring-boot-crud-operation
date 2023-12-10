package com.te.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.te.dto.StudentDTO;
import com.te.entity.Student;
import com.te.repository.StudentRepository;

@Component
public class StudentUtils {

	@Autowired
	private StudentRepository studentRepository;

	public Student dtoToEntity(StudentDTO studentDTO) {

		return Student.builder().studentEmailId(studentDTO.getStudentEmailId())
				.studentMobileNumber(studentDTO.getStudentMobileNumber()).studentName(studentDTO.getStudentName())
				.build();

	}
	public StudentDTO entityToDto(Student student) {
		
		StudentDTO studentDTO = StudentDTO.builder().build();
	
		BeanUtils.copyProperties(student, studentDTO);
	
		return studentDTO;
	}
}
