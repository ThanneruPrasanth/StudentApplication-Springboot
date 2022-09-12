package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;
import com.student.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);

	}

	@GetMapping(value = "/getall")
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {

		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {

		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted succcessfully...", HttpStatus.OK);

	}

	@GetMapping("/getbyclass/{s_class}")
	public ResponseEntity<List<Student>> findStudentswithClass(@PathVariable("s_class") int s_class) {
		List<Student> students = studentService.getStudentByClass(s_class);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

}
