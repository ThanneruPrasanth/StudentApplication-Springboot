package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.exception.ResourceNotFoundException;
import com.student.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {

		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}

	}

	@Override
	public Student updateStudent(Student student, int id) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student", "Id", id));

		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setS_class(student.getS_class());
		existingStudent.setDob(student.getDob());
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getStudentByClass(int s_class) {

		List<Student> student = studentRepository.findStudentsByClass(s_class);
		
		return student;
	
	}

}
