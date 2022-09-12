package com.student.demo.service;

import java.util.List;

import com.student.demo.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int id);

	Student updateStudent(Student student, int id);

	void deleteStudent(int id);
	
	List<Student> getStudentByClass(int s_class);


}
