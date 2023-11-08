package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private static List<Student> list=new ArrayList<>();
//	static {list.add(new Student(101,"Chetan","Thane"));  // Setting values in list
//	list.add(new Student(102,"Sunny","Lonavala"));   // Setting values in list
//	list.add(new Student(103,"Vinay","Aurangabad"));   // Setting values in list
//	
//	}
	// Method for get the data by ID
	
	@Autowired
	private StudentRepository studentRepository;
	public Student getStudentById(int id)
	{
//		Student st= null;
//		st=list.stream().filter(e->e.getId()==id).findFirst().get();
//		return st;
		Student student=this.studentRepository.findById(id);
		return(student);
	}
	public List<Student> getAllStudents()
	{
//		return list;
//		
//		Student student=this.studentRepository.findById(id);
//		return(student);
		//return list;
		List<Student>list=(List<Student>)this.studentRepository.findAll();
		return list;
	}
	
	// Method for insert the value
	public Student addStudent(Student s) {
//		list.add(s);
//		return s;
		Student st=this.studentRepository.save(s);
		return st;
	}
	
	// Method for delete particular data
	public void deleteStudentById(int id) {
//		list=list.stream().filter(student->(student.getId()!=id))
//				.collect(Collectors.toList());
		
		this.studentRepository.deleteById(id);
		
	}
	
	// Method for update the data
	public void updateStudent(Student student, int id) {
//		list.stream().map(s->
//		{
//			if(s.getId()==id)
//			{
//				s.setCity(student.getCity());
//				s.setName(student.getName());
//			}
//			return s;
//		}).collect(Collectors.toList());
		
		student.setId(id);
		this.studentRepository.save(student);
		
	}
	
	
}
