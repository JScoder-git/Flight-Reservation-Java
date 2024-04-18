package com.example.flight_reservation.Model;

public class Booking {
    private String bookingId;
    private String flightNumber;
    private String passengerName;

    // Constructor with parameters
    public Booking(String bookingId, String flightNumber, String passengerName) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    // Getter for bookingId
    public String getBookingId() {
        return bookingId;
    }

    // Getter for flightNumber
    public String getFlightNumber() {
        return flightNumber;
    }

    // Getter for passengerName
    public String getPassengerName() {
        return passengerName;
    }
}
