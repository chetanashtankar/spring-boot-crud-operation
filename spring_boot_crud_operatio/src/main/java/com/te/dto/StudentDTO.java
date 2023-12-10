package com.te.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
public class StudentDTO {

	@Id
	private int studentId;
	private String studentName;
	private long studentMobileNumber;
	private String studentEmailId;
}
