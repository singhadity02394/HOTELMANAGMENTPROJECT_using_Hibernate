package hotelproject;

import java.util.Scanner;

public class MainHotelClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu
        System.out.println("Welcome to the Hotel Management System");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Driver");
        System.out.println("3. Add Employee");
        System.out.println("4. Add Room");
        System.out.println("5. Show Customer Details");
        System.out.println("6. Show Driver Details");
        System.out.println("7. Show Employee Details");
        System.out.println("8. Show Room Details");
        System.out.println("9. Exit");

        // Get user choice
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                AddCustomer.addCustomer(); // You need to implement the addCustomer method to persist customer using Hibernate
                break;
            case 2:
                AddDriver.addDriver(); // You need to implement the addDriver method to persist driver using Hibernate
                break;
            case 3:
                AddEmployee.addEmployee(); // You need to implement the addEmployee method to persist employee using Hibernate
                break;
            case 4:
                AddRooms.addRoom(); // You need to implement the addRoom method to persist room using Hibernate
                break;
            case 5:
                ShowCustomerDetails.showCustomerDetails(); // You need to implement the showCustomerDetails method to retrieve customer using Hibernate
                break;
            case 6:
                ShowDriverDetails.showDriverDetails(); // You need to implement the showDriverDetails method to retrieve driver using Hibernate
                break;
            case 7:
                ShowEmployeeDetails.showEmployeeDetails(); // You need to implement the showEmployeeDetails method to retrieve employee using Hibernate
                break;
            case 8:
                ShowRoomDetails.showRoomDetails(); // You need to implement the showRoomDetails method to retrieve room using Hibernate
                break;
            case 9:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
