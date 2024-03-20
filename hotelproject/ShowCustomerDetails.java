package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import java.util.Scanner;

public class ShowCustomerDetails {
	
	public static void showCustomerDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter customer ID:");
		String customerId = scanner.nextLine();

		Customer customer = getCustomerById(customerId);

		if (customer != null) {
			System.out.println("Customer details:");
			System.out.println("ID: " + customer.getId());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
			// Print other details as needed
		} else {
			System.out.println("Customer with ID " + customerId + " not found.");
		}

	}
	
	public static void main(String[] args) {
		showCustomerDetails();
	}

	private static Customer getCustomerById(String customerId) {
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// Create Session
		Session session = factory.openSession();

		// Begin transaction
		session.beginTransaction();
		
		
		Customer customer = session.get(Customer.class, customerId);
		
		// Commit transaction
		session.getTransaction().commit();

		// Close session
		session.close();

		// Close SessionFactory (optional, recommended)
		factory.close();

		return customer;
	}
}
