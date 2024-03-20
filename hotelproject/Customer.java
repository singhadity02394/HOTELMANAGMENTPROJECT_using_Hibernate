package hotelproject;
import javax.persistence.*;

import java.util.Date;
@Entity


public class Customer {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	private String id;
    private String name;
    private String contactNumber;
    private String email;
    private Date checkInDate;
    private Date checkOutDate;
    private int roomNumber; // Assuming each customer is associated with a single room

    // Constructor
    public Customer(String name, String contactNumber, String email, Date checkInDate, Date checkOutDate, int roomNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNumber = roomNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", roomNumber=" + roomNumber
				+ "]";
	}
}

    // toString method
   
