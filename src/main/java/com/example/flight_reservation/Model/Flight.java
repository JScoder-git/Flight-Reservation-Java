package com.example.flight_reservation.Model;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private int availableSeats;

    // Constructor with parameters
    public Flight(String flightNumber, String origin, String destination, int capacity, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    // Getters and setters
    // You should also provide getters and setters for the private fields
    // Omitted for brevity
}
