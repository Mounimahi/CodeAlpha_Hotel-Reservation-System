import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    static class Room {
        int roomNumber;
        String category;
        double pricePerNight;
        boolean isAvailable;

        public Room(int roomNumber, String category, double pricePerNight, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.category = category;
            this.pricePerNight = pricePerNight;
            this.isAvailable = isAvailable;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<String> bookings = new ArrayList<>();

        // Sample room data
        rooms.add(new Room(101, "Single", 50.0, true));
        rooms.add(new Room(102, "Double", 80.0, true));
        rooms.add(new Room(103, "Suite", 120.0, true));
        rooms.add(new Room(104, "Single", 50.0, false)); // Already booked

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // View available rooms
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (room.isAvailable) {
                            System.out.println("Room " + room.roomNumber + " - " + room.category + " - $" + room.pricePerNight + " per night");
                        }
                    }
                    break;

                case 2:
                    // Make a reservation
                    System.out.println("\nEnter the room number you want to book:");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean found = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == roomNumber) {
                            found = true;
                            if (room.isAvailable) {
                                room.isAvailable = false;
                                bookings.add("Room " + room.roomNumber + " - " + room.category + " - $" + room.pricePerNight + " per night");
                                System.out.println("Room " + roomNumber + " booked successfully!");
                            } else {
                                System.out.println("Sorry, Room " + roomNumber + " is already booked.");
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Room not found.");
                    }
                    break;

                case 3:
                    // View booking details
                    if (bookings.isEmpty()) {
                        System.out.println("\nNo bookings made yet.");
                    } else {
                        System.out.println("\nBooking Details:");
                        for (String booking : bookings) {
                            System.out.println(booking);
                        }
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}