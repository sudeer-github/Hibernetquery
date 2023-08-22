package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gl.entity.Teacher;

public class CreateTeacher {
	public static void main(String[] args) {
	
	//Create session Factory 
	System.out.println("Connecting to databsase"); 	
	SessionFactory factory = new Configuration()
			                .configure("hibernate.cfg.xml")
			                .addAnnotatedClass(Teacher.class)
			                .buildSessionFactory();
	//Create Session
	Session session = factory.getCurrentSession();
	
	try {
	
		//Create Teacher Object
		System.out.println("Creating new Teacher Object");
		Teacher objTeacher1 = new Teacher( "Sharath", "Kumar","Sharath@gmail.com");
		Teacher objTeacher2 = new Teacher( "Roger", "Binny","Roger@yahoo.com");
        
		//Start Transaction
		session.beginTransaction();
		
		//Save the Teacher Object
		session.save(objTeacher1);
		session.save(objTeacher2);	
	}
	finally {
		session.close();
		factory.close();
	}
	
 }
}
