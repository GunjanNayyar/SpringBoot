package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Student_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Id   // Primary key
	private int id;
	@NotBlank
	private String name;
	private String city;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Project project;
	

}
