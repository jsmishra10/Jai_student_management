package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.entity.Student;
import com.greatlearning.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	

	@Autowired
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {		
		this.studentService = studentService;
	}
	
	@GetMapping("/list")
	public String listStudents(Model model) {		
		
		List<Student> students = studentService.findAll();
		
		model.addAttribute("student", students);
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAddingRecord(Model model) {
		
		Student student = new Student();		
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@PostMapping("/addStudent")
	public String addStudentRecord(@ModelAttribute("student") Student student) {
		
		studentService.addRecord(student);
		
		return "redirect:/list-students";
	}
	

}
