package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.Studentdao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
       Studentdao studentdao=context.getBean("studentDao",Studentdao.class);
       Student student=new Student(2324,"himanshu","Delhi");
       
       int r=studentdao.insert(student);
       System.out.println(r);
    }
}
