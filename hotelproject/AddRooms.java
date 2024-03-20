package hotelproject;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddRooms {
	public static void addRoom() {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter room number:");
        int roomNumber = scanner.nextInt();

        System.out.println("Is the room available? (true/false):");
        boolean availability = scanner.nextBoolean();

        System.out.println("Is the room cleaning status? (true/false):");
        boolean cleaningStatus = scanner.nextBoolean();

        System.out.println("Enter room price:");
        double price = scanner.nextDouble();

        System.out.println("Enter bed type:");
        String bedType = scanner.next();

        Room room = new Room(roomNumber, availability, cleaningStatus, price, bedType);

        persistRoom(room);

        System.out.println("Room details added successfully: " + room);
		
	}


    public static void main(String[] args) {
        addRoom();
    }

    private static void persistRoom(Room room) {
    	Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 // Create SessionFactory
		 SessionFactory factory = config.buildSessionFactory();
		 // Create Session
		 Session session = factory.openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		

		 session.save(room);
		 
		 // Commit the transaction
		 transaction.commit();
		 // Retrieve data
		
		 session.close();
		 factory.close();
    
    }
}

        // Commit
