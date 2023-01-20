package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

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
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
      boolean go=true;
      
      while(go)
      {
    	 
    	  System.out.println("Press 1 for add new student");
          System.out.println("Press 2 for display all student");
          System.out.println("Press 3 for get details of single student");
          System.out .println("Press 4 for delete student");
          System.out.println("Press 5 for update student");
          System.out.println("Press 6 for exit");
          
          try
          {
        	  System.out.println("Enter choice:");
        	  int input = Integer.parseInt(br.readLine());
        	 
        	  switch (input) {
			case 1://add
	        	  System.out.println("*****************************************************************************************");

				  Student student=new Student();
	        	  System.out.println("Enter userId:");
	        	  int uid=Integer.parseInt(br.readLine());
	        	  student.setStudentID(uid);
	        	  System.out.println("Enter name:");
	        	  String name=br.readLine();
	        	  student.setStudentName(name);
	        	  System.out.println("Enter city:");
	        	  String address=br.readLine();
	        	  student.setStudentCity(address);
	        	 int r= studentdao.insert(student);
	        	  System.out.println(r+" Student added");
	        	  System.out.println("*****************************************************************************************");

				break;
			case 2://display all
				System.out.println("*****************************************************************************************");
				System.out.println("List of students:");
				List<Student> students=studentdao.getAllStudent();
				for(Student s:students)
				{
					System.out.println("Student id:"+s.getStudentID());
					System.out.println("Student name:"+s.getStudentName());
					System.out.println("Student city:"+s.getStudentCity());
					System.out.println("----------------------------------------------------------------------------------------------");
				}
				System.out.println("*****************************************************************************************");
				break;
			case 3://detail
				System.out.println("*****************************************************************************************");
				System.out.println("Enter student Id to show details:");
				int i=Integer.parseInt(br.readLine());
				Student s=studentdao.getStudent(i);
				if(s!=null)
				{
					 System.out.println("Student details student Id "+i);
						System.out.println("Student id:"+s.getStudentID());
						System.out.println("Student name:"+s.getStudentName());
						System.out.println("Student city:"+s.getStudentCity());
						System.out.println("----------------------------------------------------------------------------------------------");
				}
				else
				{
					System.out.println("No record found with student id "+i);
				}
				  
				System.out.println("*****************************************************************************************");
				break;
			case 4://delete
				System.out.println("*****************************************************************************************");
				System.out.println("Enter student Id to Delete record:");
				int id=Integer.parseInt(br.readLine());
				studentdao.delete(id);
				System.out.println("Delete record with id "+id);
				System.out.println("*****************************************************************************************");
				break;
			case 5://update
				break;
			case 6:
				go=false;
                 break;
				}
        	  
          }
          catch(Exception e)
          {
        	  System.out.println("Invalid choice try again!!");
        	  System.out.println(e.getMessage());
          }
    	  
      }
      System.out.println("Thank you for using!!");
	  System.out.println("See you again!!"); 
      
    }
}
