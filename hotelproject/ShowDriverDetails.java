package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ShowDriverDetails {
	public static void showDriverDetails() {
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter driver ID:");
	        Long driverId = scanner.nextLong();
	        scanner.nextLine(); // Consume newline character

	        Driver driver = getDriverById(driverId);

	        if (driver != null) {
	            System.out.println("Driver details:");
	            System.out.println(driver);
	        } else {
	            System.out.println("Driver with ID " + driverId + " not found.");
	        }
	        System.out.println("Enter the choise mainClass(1),Contitnue(2)");
	        int choice = scanner.nextInt();
	        switch(choice) {
	        case 1:
	        	 MainHotelClass.mainM();
	            break;
	        case 2:
	        	showDriverDetails();
	        	
	        }
		
		
		
	}
    public static void main(String[] args) {
       
    }

    private static Driver getDriverById(Long driverId) {
    	// Create SessionFactory
    			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    			// Create Session
    			Session session = factory.openSession();

    			// Begin transaction
    			session.beginTransaction();
    			
    			// Retrieve customer by ID
    			Driver driver = session.get(Driver.class, driverId);
    			
    			// Commit transaction
    			session.getTransaction().commit();

    			// Close session
    			session.close();

    			// Close SessionFactory (optional, recommended)
    			factory.close();

    			return driver;
        
    }
}
