package com.te.controller;

import java.time.LocalDateTime;
import static com.te.constant.StudentConstant.UPDATESUCESFULLY;
import static com.te.constant.StudentConstant.REMOVESUCESFULLY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.te.constant.StudentConstant.SAVESUCCEFULLY;
import com.te.dto.StudentDTO;
import com.te.response.SuccessResponse;
import com.te.service.StudentService;

@RequestMapping(path = "api/v1/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/students")
	public ResponseEntity<SuccessResponse> addStudent(@RequestBody StudentDTO studentDTO) {

		Integer addStudent = studentService.addStudent(studentDTO);

		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(addStudent)
				.message(SAVESUCCEFULLY).timestamp(LocalDateTime.now()).build());

	}

	@GetMapping(path = "/students")
	public ResponseEntity<SuccessResponse> getStudent(@RequestParam(name = "id") Integer studentId) {

		StudentDTO student = studentService.getStudent(studentId);

		return ResponseEntity.<SuccessResponse>ok().body(
				SuccessResponse.builder().message(SAVESUCCEFULLY).data(student).timestamp(LocalDateTime.now()).build());

	}

	@PutMapping(path = "/students")
	public ResponseEntity<SuccessResponse> updateStudent(@RequestParam(name = "id") Integer studentId,
			@RequestBody StudentDTO studentDTO) {

		StudentDTO updateStudent = studentService.updateStudent(studentId, studentDTO);

		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(updateStudent)
				.message(UPDATESUCESFULLY).timestamp(LocalDateTime.now()).build());

	}

	@DeleteMapping(path = "/students/{id}")
	public ResponseEntity<SuccessResponse> removeStudent(@PathVariable(name = "id") Integer studentId) {

		studentService.deleteStudent(studentId);

		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder()

				.message(REMOVESUCESFULLY).timestamp(LocalDateTime.now()).build());

	}

}
