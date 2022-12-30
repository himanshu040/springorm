package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class Studentdao {
	
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student)
	{
		Integer i =(Integer)this.hibernateTemplate.save(student);
		return 1;
	}
	
	public Student getStudent(int stdId)
	{
		Student student=this.hibernateTemplate.get(Student.class,stdId);
		return student;
	}
	
	public List<Student> getAllStudent()
	{
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void delete(int stdId)
	{
		Student student=this.hibernateTemplate.get(Student.class,stdId);
		this.hibernateTemplate.delete(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Studentdao() {
		super();
		// TODO Auto-generated constructor stub
	}
       
}
