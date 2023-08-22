package com.gl.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.gl.entity.Teacher;


public class Test {
	public static void main(String[] args) {
		System.out.println("Connecting to database");
		Session session=null;
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		System.out.println("created");

       
//		Teacher t1 = new Teacher("Shalini", "Garg", "Shalini@gl.com");
//		Teacher t2 = new Teacher("Sheetu", "Kapoor", "Sheetu@gl.com");
//		Teacher t3 = new Teacher("Ria", "Dhopte", "ria@gmail.com");
//		Teacher t4 = new Teacher("Jenny", "Joe", "Jenny@gl.com");
//		Transaction tx = null;
		try {
			session=factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
// Below code is used to Insert rows into the table			
//			session.save(t1);
//			session.save(t2);
//			session.save(t3);
//			session.save(t4);
// Below code is used to get a single  row from the table
	
//		Teacher teacher1 = session.get(Teacher.class,4);
	    List<Teacher> teachers = session.createQuery("from Teacher").list();
	    for (Teacher teacher:teachers) 
		     System.out.println("teacher= "+teacher );		
			
// Below Query can be used to get the multiple row
//		teachers = session.createQuery("from Teacher").list();
	
//// Below Query can be used to updated a row
//		Teacher teachers = session.get(Teacher.class,2);	
//		System.out.println("teachers= "+ teachers );		
//		teachers.setF_name("Sheetal");
//			
		tx.commit();
	
				
		}
		catch(Exception e) {
			
			System.out.println("Error"+e.getMessage());
//       Below code is used while inserting the rows			
//			System.out.println("Error");
//			e.printStackTrace();
//			tx.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
//		for (Teacher teacher:teachers) {
//			System.out.println(teacher);
//		}
		
	}

}
