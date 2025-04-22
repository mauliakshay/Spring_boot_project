package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.StundentDao;
import com.demo.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StundentDao sd;

	@Override
	public Student save(Student s) {
		return sd.save(s);
	}

	@Override
	public List<Student> findAll() {
		return sd.findAll();
	}

	@Override
	public byte[] findImageByid(int id) {
		return sd.findImageByid(id);
	}

	@Override
	public byte[] findDocsByid(int id) {
		return sd.findDocsByid(id);
	}

	@Override
	public int deleteById(int id) {
		return sd.deleteById(id);
	}

	@Override
	public Student findById(int id) {
		return sd.findById(id);
	}
}
