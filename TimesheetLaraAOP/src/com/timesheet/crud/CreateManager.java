package com.timesheet.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timesheet.entity.Employee;
import com.timesheet.entity.Manager;
import com.timesheet.entity.Ticket;

public class CreateManager {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Manager.class)
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Ticket.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create the objects
			Manager tempManager= new Manager("Riccardo", "Dicorato");
			Manager tempManager2= new Manager("Francesca", "Fiscone");
		
			
			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//this will also save the details object because of CascadeType.ALL
			System.out.println("Saving manager... "+tempManager);
			System.out.println("Saving manager... "+tempManager2);
			session.save(tempManager);
			session.save(tempManager2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
