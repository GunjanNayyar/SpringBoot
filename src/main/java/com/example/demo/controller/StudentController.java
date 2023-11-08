package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {
	@Autowired  // For auto connection
	private StudentService studentservice;
	
	
	// get the list of all student
	@GetMapping("/findAll")	
	public ResponseEntity<List<Student>> getStudent()  // Object of list
	{	
		List<Student> list=studentservice.getAllStudents();
		if(list.size()<=0)
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	
	}
	
	
	//to get the data of id that is passed
		@GetMapping("/student/{id}")
		public ResponseEntity<Student> getStudent(@PathVariable("id") int id)
		{
			Student student=studentservice.getStudentById(id);
			if(student==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(student));
			
		}
		
		
	//to insert the data
		@PostMapping("/add")
		public ResponseEntity<Student> addStudent(@RequestBody Student student)
		{
			Student s=null;
			try {
			s=this.studentservice.addStudent(student);
			System.out.println("The student is inserted");
			return ResponseEntity.of(Optional.of(s));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		//to delete a particular data 
		@DeleteMapping("/student/{id}")
		public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id)
		{
			try {
			this.studentservice.deleteStudentById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		
		//to update the data in the list
		@PutMapping("/student/{id}")
		public ResponseEntity<Student> updateStudent(@RequestBody Student student,
				@PathVariable("id") int id)
		{
			try
			{
				
			this.studentservice.updateStudent(student,id);
			return ResponseEntity.ok().body(student);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
}
