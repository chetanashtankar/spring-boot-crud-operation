package com.te.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	/*
	    interaction for CRUD operation performing it....!
	 */
}
