package hotelproject;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    
    int roomNumber;
    private String availability;
    private String cleaningStatus;
    private double price;
    private String bedType;

    public Room() {
        // Default constructor required by Hibernate
    }

    public Room(int roomNumber,String availability, String cleaningStatus, double price, String bedType) {
        this.roomNumber = roomNumber;
        this.availability = availability;
        this.cleaningStatus = cleaningStatus;
        this.price = price;
        this.bedType = bedType;
    }

    // Getters and setters for all attributes

  

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String isAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String isCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        return "Room{" +
              
                ", roomNumber=" + roomNumber +
                ", availability=" + availability +
                ", cleaningStatus=" + cleaningStatus +
                ", price=" + price +
                ", bedType='" + bedType + '\'' +
                '}';
    }
}

