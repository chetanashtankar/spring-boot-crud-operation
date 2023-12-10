package com.te.service;

import org.springframework.beans.factory.annotation.Autowired;
import static com.te.constant.StudentConstant.REMOVESUCESFULLY;
import org.springframework.stereotype.Service;
import static com.te.constant.StudentConstant.notFOUND;
import com.te.dto.StudentDTO;
import com.te.entity.Student;
import com.te.exception.StudentException;
import com.te.repository.StudentRepository;
import com.te.utils.StudentUtils;

@Service /* Responsible For Handling The Business Logic.....!! */
public class StudentService {

	@Autowired
	private StudentUtils studentUtils;

	@Autowired
	private StudentRepository studentRepository;

	
	public Integer addStudent(StudentDTO studentDTO) {

		Student student = studentUtils.dtoToEntity(studentDTO);

		Student save = studentRepository.save(student);

		return save.getStudentId();
	}
	
	
	public StudentDTO getStudent(Integer studentId) {

		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentException(notFOUND));

		return studentUtils.entityToDto(student);
	}
	
	public StudentDTO updateStudent(Integer studentId, StudentDTO studentDTO) {

		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentException(notFOUND));

		student.setStudentName(studentDTO.getStudentName());
		student.setStudentEmailId(studentDTO.getStudentEmailId());
		student.setStudentMobileNumber(studentDTO.getStudentMobileNumber());

		Student updateStudent = studentRepository.save(student);

		return studentUtils.entityToDto(updateStudent);
	}
	
	public void deleteStudent(Integer studentId) {

		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentException(REMOVESUCESFULLY));

		studentRepository.delete(student);
	}

}
