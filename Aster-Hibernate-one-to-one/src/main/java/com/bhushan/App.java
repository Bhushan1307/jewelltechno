package com.bhushan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhushan.model.Address;
import com.bhushan.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure()
    			.addAnnotatedClass(Student.class)
    			.addAnnotatedClass(Address.class);
    	
    	SessionFactory sf =	cfg.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	//------------
//    	Student std = new Student();
//    	std.setRollNo(105);
//    	std.setName("Bhushan");
//    	std.setMobile(333);
//    	
//    	session.save(std);
    	
    	Student std = session.get(Student.class, 102);
    	
    	Address add = new Address();
    	
    	add.setId(4);
    	add.setCity("surat");
    	add.setPin(2222);
    	add.setStudent(std);
    	
    	session.save(add);
    	
    	
     	
    	//-----------
    	session.getTransaction().commit();
    	session.close();
    }
}
