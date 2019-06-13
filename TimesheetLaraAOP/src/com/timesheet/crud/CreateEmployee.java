package com.timesheet.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timesheet.entity.Employee;
import com.timesheet.entity.Manager;
import com.timesheet.entity.Ticket;

public class CreateEmployee {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Manager.class)
								.addAnnotatedClass(Ticket.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a employee object
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee("Lara", "Corona", "Consoft", 15.0);
			Employee tempEmployee2 = new Employee("Gabriele", "Pasinati", "Consoft", 25.0);
			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving the employees...");
			session.save(tempEmployee);
			session.save(tempEmployee2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





