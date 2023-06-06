package RailwayReservationSystem;
import java.util.ArrayList;


import java.util.List;

public class Ticket {
	private int ticketNumber;
    private Train train;
    private List<Passenger> passengers;

    public Ticket(int ticketNumber, Train train) {
        this.ticketNumber = ticketNumber;
        this.train = train;
        this.passengers = new ArrayList<>();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Train getTrain() {
        return train;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}


