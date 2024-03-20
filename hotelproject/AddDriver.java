package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddDriver {
	public static void addDriver() {
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Enter driver id:");
	        long id = scanner.nextLong();

	        System.out.println("Enter driver name:");
	        String name = scanner.next();
	        scanner.nextLine();

	        System.out.println("Enter driver age:");
	        int age = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        System.out.println("Enter driver gender:");
	        String gender = scanner.nextLine();

	        System.out.println("Enter driver company:");
	        String company = scanner.nextLine();

	        System.out.println("Enter driver car name:");
	        String carName = scanner.nextLine();

	        System.out.println("Is driver available? (true/false):");
	        boolean available = scanner.nextBoolean();

	        Driver driver = new Driver(id,name, age, gender, company, carName, available);

	        persistDriver(driver);
	        System.out.println("Driver details added successfully: " + driver);
	        
	        System.out.println("Enter the choise mainClass(1),Contitnue(2)");
	        int choice = scanner.nextInt();
	        switch(choice) {
	        case 1:
	        	 MainHotelClass.mainM();
	            break;
	        case 2:
	        	addDriver();
	        	
	        }
	}
	

	       
	        private static void persistDriver(Driver driver) {
	        	Configuration config = new Configuration().configure("hibernate.cfg.xml");
				 // Create SessionFactory
				 SessionFactory factory = config.buildSessionFactory();
				 // Create Session
				 Session session = factory.openSession();
				 
				 Transaction transaction = session.beginTransaction();
				 
				

				 session.save(driver);
				 
				 // Commit the transaction
				 transaction.commit();
				 // Retrieve data
				
				 session.close();
				 factory.close();
	        }
		
	

    public static void main(String[] args) {
    	addDriver();
       
    }

   
}
