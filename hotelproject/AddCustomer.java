package hotelproject;



import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.model.domain.spi.DomainModelHelper;

import com.becoder.TableSunny;

import java.util.Date;
import java.util.Scanner;

public class AddCustomer {
	
	public static void addCustomer() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the customer id:");
		 String id = scanner.next();
		 scanner.nextLine();

	        System.out.println("Enter customer name:");
	        String name = scanner.nextLine();

	        System.out.println("Enter contact number:");
	        String contactNumber = scanner.nextLine();

	        System.out.println("Enter email:");
	        String email = scanner.nextLine();

	        // Assuming date input format as "YYYY-MM-DD"
	        System.out.println("Enter check-in date (YYYY-MM-DD):");
	        String checkInDateString = scanner.nextLine();
	        Date checkInDate = java.sql.Date.valueOf(checkInDateString);

	        System.out.println("Enter check-out date (YYYY-MM-DD):");
	        String checkOutDateString = scanner.nextLine();
	        Date checkOutDate = java.sql.Date.valueOf(checkOutDateString);

	        System.out.println("Enter room number:");
	        int roomNumber = scanner.nextInt();

	        Customer customer = new Customer( id,name, contactNumber, email, checkInDate, checkOutDate, roomNumber);

	        persistCustomer(customer);
	        UpdateRoom.roomUpdate(roomNumber);

	        System.out.println("Customer details added successfully: " + customer);
	        
	        
	        
	        System.out.println("Enter the choise MainClass(1),Contitnue(2)");
	        int choice = scanner.nextInt();
	        switch(choice) {
	        case 1:
	           MainHotelClass.mainM();
	            break;
	        case 2:
	        	addCustomer();
	        	
	        }
	    }

	    private static void persistCustomer(Customer customer) {
	    	
	    	Configuration config = new Configuration().configure("hibernate.cfg.xml");
			 // Create SessionFactory
			 SessionFactory factory = config.buildSessionFactory();
			 // Create Session
			 Session session = factory.openSession();
			 
			 Transaction transaction = session.beginTransaction();

			 session.save(customer);
				
			 
			 // Commit the transaction
			 transaction.commit();
			 // Retrieve data
			
			 session.close();
			 factory.close();
			 }

	
    public static void main(String[] args) {
    	addCustomer();
    }
}
