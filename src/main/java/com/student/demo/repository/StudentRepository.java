package com.student.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select s from Student s where s.s_class like ?1")
	public List<Student> findStudentsByClass(int s_class);
}

