package org.example.LLDUseCase.parkinglot.models;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entrytime;
    private  long exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, long entrytime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entrytime = entrytime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntrytime() {
        return entrytime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
