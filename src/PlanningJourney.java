

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PlanningJourney {
    private String source;
    private String destination;
    private LocalDate date;
    private double ticketprice;
    private int NoofPassengers;
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate( LocalDate date) {
        this.date = date;
    }
    public double getTicketprice() {
        return ticketprice;
    }
    public void setTicketprice(double ticketprice) {
        this.ticketprice = ticketprice;
    }
    public int getNoofPassengers() {
        return NoofPassengers;
    }
    public void setNoofPassengers(int noofPassengers) {
        NoofPassengers = noofPassengers;
    }
    public PlanningJourney(String source, String destination, LocalDate date, double ticketprice, int noofPassengers) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.ticketprice = ticketprice;
        this.NoofPassengers = noofPassengers;
    }

    @Override
    public String toString() {
        return "PlanningJourney{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", ticketprice=" + ticketprice +
                ", NoofPassengers=" + NoofPassengers +
                '}';
    }
    PlanningJourney()
    {

    }
}
