package com.greatlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
