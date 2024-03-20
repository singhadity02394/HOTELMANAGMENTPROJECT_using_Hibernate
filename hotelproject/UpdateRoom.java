package hotelproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateRoom {
    public static void roomUpdate(int roomNumber) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        // Create SessionFactory
        SessionFactory factory = config.buildSessionFactory();
        // Create Session
        Session session = factory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Room room = session.get(Room.class, roomNumber);

            // Update the availability for the customer
            room.setAvailability("booked");

            // Save the updated entity
            session.update(room);

            transaction.commit();
            System.out.println("Room availability updated successfully for room number: " + roomNumber);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
