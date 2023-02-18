package com.bhushan;

import java.sql.Time;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
    	
    	SessionFactory sf =	cfg.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
//    	
//    	Employee emp = new Employee();
//    	
//    	emp.setName("Ramesh");
//    	emp.setAddress("Kolhapur");
//    	emp.setGender("Male");
//    	emp.setDob(new Date());
//    	emp.setPunch_in(new Date());
//    	
//    	session.save(emp);

    	
    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
}
