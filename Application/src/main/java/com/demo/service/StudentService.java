package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {

	Student save(Student s);
	List<Student> findAll();
	byte[] findImageByid(int id);
	byte[] findDocsByid(int id);
	int deleteById(int id); 
	Student findById(int id);
	
}
