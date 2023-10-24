package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Student;

public interface StudentService {
	
		
	public List<Student> findAll();
	
	public Student findById(Long studentId);
	
	public void addRecord(Student student);
	
	public void deleteStudentRecord(Long studentId);
	

	
}
