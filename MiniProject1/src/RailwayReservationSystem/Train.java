package RailwayReservationSystem;


public class Train {
	private int trainNumber;
    private String trainName;
    private int totalSeats;
    private int availableSeats;

    public Train(int trainNumber, String trainName, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println("Seats booked successfully!");
        } else {
            System.out.println("seats unavailable.");
        }
    }

    public void cancelSeats(int seats) {
        if (seats <= (totalSeats - availableSeats)) {
            availableSeats += seats;
            System.out.println("Seats canceled successfully!");
        } else {
            System.out.println("Invalid number of seats to cancel.");
        }
    }
}


