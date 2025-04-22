package com.demo.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;
import com.demo.service.StudentService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@MultipartConfig(maxFileSize = 999999999,maxRequestSize = 999999999)
public class StundentController {
	
	@Autowired
	private StudentService ss;

	@GetMapping(value = "/")
	public ModelAndView m1(ModelAndView m)
	{
		m.addObject("students",ss.findAll());
		m.setViewName("index.jsp");
		return m;
	}
	
	@PostMapping(value = "/req1")
	public ModelAndView m2(ModelAndView m,
			int id,
			String name,
			String city,
			double percentage,
			MultipartFile image,
			MultipartFile docs
			,String b1) throws IOException
	{
		if(b1.equalsIgnoreCase("add"))
		{
			Student s = new Student(); 
			s.setId(id); 
			s.setName(name); 
			s.setCity(city); 
			s.setPercentage (percentage); 
			s.setImage(image.getBytes());
			s.setDocs(docs.getBytes());
			s = ss.save(s);
			if(s!=null)
				m.addObject("msg","Stundent inserted Succesfully!");
			else
				m.addObject("msg","Stundent Not inserted Succesfully!");
			
			m1(m); 
		}
		if(b1.equalsIgnoreCase("delete"))
		{
			int check = ss.deleteById(id); 
			if(check!=0) 
				m.addObject("msg", "Student Deleted successfully"); 
			else 
				m.addObject("msg", "Student NOT found!!!"); 
			m1(m); 
		}
		if(b1.equalsIgnoreCase("display"))
		{
			Student s = ss.findById(id); 
			if(s==null) 
			{ 
				m.addObject("msg", "Student NOT found!!!"); 
				m1(m); 
			} 
			else 
			{
				m.addObject("student", s);
				m.setViewName("first.jsp"); 
			} 
		}
		if(b1.equalsIgnoreCase("update"))
		{
			Student s = new Student(); 
			s.setId(id); 
			s.setName(name); 
			s.setCity(city); 
			s.setPercentage (percentage); 
			s.setImage((image.getSize()!=0)?image.getBytes():ss.findImageByid(id));
			s.setDocs((docs.getSize()!=0)?docs.getBytes():ss.findDocsByid(id));
			s = ss.save(s);
			m1(m);
		}
		return m;
	}
	
	@GetMapping(value = "/findimagebyid/{id}") 
	public void m3(@PathVariable int id, HttpServletResponse res) throws IOException 
	{
		byte[] image = ss.findImageByid(id); 
		OutputStream o1 = res.getOutputStream(); 
		res.setContentType("image/jpeg"); 
		o1.write(image); 
		o1.flush(); 
		o1.close();
	
	} 
	
	@GetMapping(value = "/finddocsbyid/{id}") 
	public void m4(@PathVariable int id, HttpServletResponse res) throws IOException 
	{
		byte[] docs = ss.findDocsByid(id); 
		OutputStream o1 = res.getOutputStream(); 
		res.setContentType("application/pdf"); 
		o1.write(docs); 
		o1.flush(); 
		o1.close();
	
	} 
		
}
