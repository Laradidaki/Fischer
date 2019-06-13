package com.timesheet.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.timesheet.entity.Employee;
import com.timesheet.entity.Manager;
import com.timesheet.entity.Ticket;

public class CreateTicketAndEmployee {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Manager.class)
								.addAnnotatedClass(Ticket.class)
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
						
			// create a course
			Ticket tempTicket = new Ticket();
						
			// save the course
			System.out.println("\nSaving the ticket ...");
			session.save(tempTicket);
			System.out.println("Saved the ticket: " + tempTicket);
			
			// create the students
			Employee tempEmployee1 = new Employee("Lara", "Corona", "Conad", 55.5);
			Employee tempEmployee2 = new Employee("Angelo", "Babbeo", "Lidl", 89.0);
						
			// add students to the course
			tempTicket.addEmployee(tempEmployee1);
			tempTicket.addEmployee(tempEmployee2);
			
			// save the students
			System.out.println("\nSaving employees ...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			System.out.println("Saved employees: " + tempTicket.getEmployees());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





