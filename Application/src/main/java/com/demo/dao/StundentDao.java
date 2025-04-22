package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StundentDao extends JpaRepository<Student, Integer>{
	
	Student save(Student s);//insert And update 
	List<Student> findAll();
	
	@Query(value = "select image from Student where id=?1",nativeQuery = true)
	byte[] findImageByid(int id);
	
	@Query(value = "select docs from Student where id=?1",nativeQuery = true)
	byte[] findDocsByid(int id);
	
	@Query(value = "delete from Student where id=?1", nativeQuery = true) 
	@Modifying 
	int deleteById(int id); 
	
	Student findById(int id);
	
//	@Query(value = "select * from Student where id like %?1% or name like %?1% or city like %?1% or percentage like %?1%", nativeQuery = true) 
//	List<Student> searchByAny (String s1); 
}
