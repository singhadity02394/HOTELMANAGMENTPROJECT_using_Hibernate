package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ShowRoomDetails {
	public static void showRoomDetails() {
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter room number:");
	        int roomNumber = scanner.nextInt();

	        Room room = getRoomByNumber(roomNumber);

	        if (room != null) {
	            System.out.println("Room details:");
	            System.out.println(room);
	        } else {
	            System.out.println("Room with number " + roomNumber + " not found.");
	        }
	        System.out.println("Enter the choise mainClass(1),Contitnue(2)");
	        int choice = scanner.nextInt();
	        switch(choice) {
	        case 1:
	        	 MainHotelClass.mainM();
	            break;
	        case 2:
	        	showRoomDetails();
	        	
	        }
		
	}
    

    private static Room getRoomByNumber(int roomNumber) {
    	// Create SessionFactory
    			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    			// Create Session
    			Session session = factory.openSession();

    			// Begin transaction
    			session.beginTransaction();
    			
    			
    			Room rm= session.get(Room.class, roomNumber);
    			
    			// Commit transaction
    			session.getTransaction().commit();

    			// Close session
    			session.close();

    			// Close SessionFactory (optional, recommended)
    			factory.close();

    			return rm;    }
}
