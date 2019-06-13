package com.timesheet.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.timesheet.entity.Manager;

public class DeleteManager {

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
			
			//get manager by primary key / id
			int theId=2;
			Manager tempManager= session.get(Manager.class,theId);
			
			System.out.println("Find manager: "+tempManager);
			
			//delete the manager
			if(tempManager != null) {
				System.out.println("Deleting: "+tempManager);
				
				
				session.delete(tempManager);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
