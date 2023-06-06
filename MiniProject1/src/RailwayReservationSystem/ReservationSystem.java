package RailwayReservationSystem;
import java.util.ArrayList;
import java.util.List;


public class ReservationSystem {
	 private List<Train> trains;
	 private List<Ticket> tickets;
	 private int nextTicketNumber;

	 

	    public ReservationSystem() {
	        trains = new ArrayList<>();
	        tickets = new ArrayList<>();
	        nextTicketNumber = 1;
	    }

	    public void addTrain(Train train) {
	        trains.add(train);
	    }

	    public void displayTrains() {
	        System.out.println("Available trains:");
	        for (Train train : trains) {
	            System.out.println(train.getTrainNumber() + " - " + train.getTrainName());
	        }
	    }

	    public Train findTrain(int trainNumber) {
	        for (Train train : trains) {
	            if (train.getTrainNumber() == trainNumber) {
	                return train;
	            }
	        }
	        return null;
	    }
	    public Ticket bookTicket(Train train, List<Passenger> passengers) {
	        int numPassengers = passengers.size();
	        if (numPassengers > train.getAvailableSeats()) {
	            System.out.println("Insufficient seats available.");
	            return null;
	        }

	        Ticket ticket = new Ticket(nextTicketNumber++, train);
	        for (Passenger passenger : passengers) {
	            ticket.addPassenger(passenger);
	        }

	        train.bookSeats(numPassengers);
	        tickets.add(ticket);

	        System.out.println("Ticket booked successfully!");
	        return ticket;
	    }

	    public void displayTicketDetails(int ticketNumber) {
	        Ticket ticket = findTicket(ticketNumber);
	        if (ticket != null) {
	            System.out.println("Ticket Number: " + ticket.getTicketNumber());
	            System.out.println("Train Name: " + ticket.getTrain().getTrainName());
	            System.out.println("Passenger Details:");
	            for (Passenger passenger : ticket.getPassengers()) {
	                System.out.println("Name: " + passenger.getName() + ", Age: " + passenger.getAge());
	            }
	        } else {
	            System.out.println("Ticket not found.");
	        }
	    }

	    private Ticket findTicket(int ticketNumber) {
	        for (Ticket ticket : tickets) {
	            if (ticket.getTicketNumber() == ticketNumber) {
	                return ticket;
	            }
	        }
	        return null;
	    }
	}




