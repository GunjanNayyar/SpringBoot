package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="project_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Project {

	@Id
	@Column(name="product_Id")
	private int pid;
	@Column(name="product_name")
	private String pname;
	@OneToOne(mappedBy="project")
	@JsonBackReference
	private Student student;
	
	
	
}
