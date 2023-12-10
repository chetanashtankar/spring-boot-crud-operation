package com.te.exceptionhandle;

import java.time.LocalDateTime;
import static com.te.constant.StudentConstant.EXCEPTIONHANDLE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.exception.StudentException;
import com.te.response.ErrorResponse;

@RestControllerAdvice /* Handle The Exception Globally...!! */
public class StudentExceptionHandle {

	@ExceptionHandler(value = StudentException.class)
	public ResponseEntity<ErrorResponse> handler(RuntimeException runtimeException) {

		return ResponseEntity.<ErrorResponse>ok()
				.body(ErrorResponse.builder().message(EXCEPTIONHANDLE).timestamp(LocalDateTime.now()).build());
	}
}
