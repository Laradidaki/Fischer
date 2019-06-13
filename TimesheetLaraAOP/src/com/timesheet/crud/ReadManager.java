package com.timesheet.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.timesheet.entity.Manager;

public class ReadManager {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Manager.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//get the manager object
			int theId=2;
			Manager tempManager=session.get(Manager.class, theId);
			
			//print the manager detail
			System.out.println("Manager: "+tempManager);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
