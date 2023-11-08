package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;

@Component
public interface StudentService {

	
	public Student getStudentById(int id);
	public List<Student> getAllStudents();
	public Student addStudent(Student s);
	public void deleteStudentById(int id);
	public void updateStudent(Student student, int id);
}
