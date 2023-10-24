package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.StudentRepository;
import com.greatlearning.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {		
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student findById(Long studentId) {
		
		Optional<Student> result = studentRepository.findById(studentId);
		
		Student student = null;
		
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new RuntimeException("Not able to find the record of student " + studentId);
		}
				
		return student;
	}

	@Override
	@Transactional
	public void addRecord(Student student) {
		studentRepository.save(student);		
	}

	@Override
	@Transactional
	public void deleteStudentRecord(Long studentId) {
		studentRepository.deleteById(studentId);		
	}
	

}
