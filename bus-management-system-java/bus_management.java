import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBusTicketBookingSystem {
    // Interface for common methods in different transportation modes
    interface Transportation {
        void displayInfo();
    }

    // Abstract class for common properties of all vehicles
    abstract static class Vehicle implements Transportation {
        String name;
        String route;
        String time;

        public Vehicle(String name, String route, String time) {
            this.name = name;
            this.route = route;
            this.time = time;
        }
    }

    // Bus class extending Vehicle
    static class Bus extends Vehicle {
        int totalSeats;
        int availableSeats;

        public Bus(String name, String route, String time, int totalSeats) {
            super(name, route, time);
            this.totalSeats = totalSeats;
            this.availableSeats = totalSeats;
        }

        @Override
        public void displayInfo() {
            System.out.println("Bus Name: " + name);
            System.out.println("Route: " + route);
            System.out.println("Departure Time: " + time);
            System.out.println("Total Seats: " + totalSeats);
            System.out.println("Available Seats: " + availableSeats);
        }

        // Method for booking a seat
        public void bookSeat() {
            if (availableSeats > 0) {
                System.out.println("Seat booked successfully!");
                availableSeats--;
            } else {
                System.out.println("Sorry, no seats available.");
            }
        }
    }

    // BusTicketBookingSystem class to manage buses and bookings
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a list of buses
        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus("Bus A", "Dhaka to Chittagong", "10:00 AM", 30));
        buses.add(new Bus("Bus B", "Dhaka to Sylhet", "12:00 PM", 40));
        buses.add(new Bus("Bus C", "Dhaka to Rajshahi", "02:00 PM", 35));

        // Displaying available buses
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            bus.displayInfo();
            System.out.println("--------------");
        }

        // Booking a seat
        System.out.print("Enter the bus name to book a seat: ");
        String selectedBus = scanner.nextLine();

        for (Bus bus : buses) {
            if (bus.name.equalsIgnoreCase(selectedBus)) {
                bus.bookSeat();
                break;
            }
        }

        scanner.close();
    }
}
