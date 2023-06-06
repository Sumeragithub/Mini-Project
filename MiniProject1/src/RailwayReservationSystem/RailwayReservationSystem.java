package RailwayReservationSystem;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class RailwayReservationSystem {
	public static void main(String[]arg) {
	ReservationSystem reservationSystem = new ReservationSystem();

    // Add some trains to the reservation system
    reservationSystem.addTrain(new Train(123, "Express Train",5));
    reservationSystem.addTrain(new Train(456, "Superfast Train",7));
    reservationSystem.addTrain(new Train(789, "Local Train",10));

    Scanner scanner = new Scanner(System.in);
    int choice;
    System.out.println("\nWELCOME TO RAILWAY RESERVATION SYSTEM!");

    do {
        
        System.out.println("1. Display available trains");
        System.out.println("2. Book Tickets");
        System.out.println("3. Display Ticket Details");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
       
            case 1:
                reservationSystem.displayTrains();
                break;
            case 2:
                System.out.print("Enter train number: ");
                int trainNumber = scanner.nextInt();
                Train train = reservationSystem.findTrain(trainNumber);
            
                if (train != null) {
                    System.out.print("Enter number of passengers: ");
                    int numPassengers = scanner.nextInt();
                    
                    List<Passenger>passengers=new ArrayList<>();
                    for(int i=0;i<numPassengers;i++) {
                    	 System.out.print("Enter passenger name: ");
                         String name = scanner.next();
                         System.out.print("Enter passenger age: ");
                         int age = scanner.nextInt();
                         passengers.add(new Passenger(name, age));
                    }
                    reservationSystem.bookTicket(train,passengers);
                    
                } else {
                    System.out.println("Train not found.");
                }
                break;
            case 3:
                System.out.print("Enter ticket number: ");
                int ticketNumber = scanner.nextInt();
                reservationSystem.displayTicketDetails(ticketNumber);
                break;
            case 4:
            	System.out.print("Enter train number: ");
                trainNumber = scanner.nextInt();
                train = reservationSystem.findTrain(trainNumber);
                if (train != null) {
                    System.out.print("Enter number of seats to cancel: ");
                    int seatsToCancel = scanner.nextInt();
                    train.cancelSeats(seatsToCancel);
                } else {
                    System.out.println("Train not found.");
                }
                break;
            case 5:
            	
                System.out.println("THANK YOU FOR USING RAILWAY RESERVATION!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 5);

    scanner.close();



}

				}