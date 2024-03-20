package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ShowEmployeeDetails {
	public static void showEmployeeDetails() {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee ID:");
        Long employeeId = scanner.nextLong();
        scanner.nextLine(); // Consume newline character

        Employee employee = getEmployeeById(employeeId);

        if (employee != null) {
            System.out.println("Employee details:");
            System.out.println(employee);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
        
        System.out.println("Enter the choise mainClass(1),Contitnue(2)");
        int choice = scanner.nextInt();
        switch(choice) {
        case 1:
        	 MainHotelClass.mainM();
            break;
        case 2:
        	showEmployeeDetails();
        	
        }
		
		
	}
    public static void main(String[] args) {
        
    }

    private static Employee getEmployeeById(Long employeeId) {
    	// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// Create Session
		Session session = factory.openSession();

		// Begin transaction
		session.beginTransaction();
		
		
		Employee emp = session.get(Employee.class, employeeId);
		
		// Commit transaction
		session.getTransaction().commit();

		// Close session
		session.close();

		// Close SessionFactory (optional, recommended)
		factory.close();

		return emp;

    }
}
