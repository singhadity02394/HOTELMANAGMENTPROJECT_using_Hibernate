package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddEmployee {
	public static void addEmployee() {
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter employee name:");
	        String name = scanner.nextLine();

	        System.out.println("Enter employee position:");
	        String position = scanner.nextLine();

	        System.out.println("Enter employee date of birth (YYYY-MM-DD):");
	        String dob = scanner.nextLine();

	        System.out.println("Enter employee salary:");
	        double salary = scanner.nextDouble();

	        Employee employee = new Employee(name, position, dob, salary);

	        persistEmployee(employee);

	        System.out.println("Employee details added successfully: " + employee);
	    }
	
		
		
		
	
    public static void main(String[] args) {
    	
    	addEmployee();
    }
       

    private static void persistEmployee(Employee employee) {
    	Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 // Create SessionFactory
		 SessionFactory factory = config.buildSessionFactory();
		 // Create Session
		 Session session = factory.openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		

		 session.save(employee);
		 
		 // Commit the transaction
		 transaction.commit();
		 // Retrieve data
		
		 session.close();
		 factory.close();
    }
}
