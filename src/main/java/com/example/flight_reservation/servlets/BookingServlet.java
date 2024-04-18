package com.example.flight_reservation.servlets;

import com.example.flight_reservation.Model.Booking;
import com.example.flight_reservation.utils.XMLParser;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BookingServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve booking details from the form
        String flightNumber = request.getParameter("flightNumber");
        String passengerName = request.getParameter("passengerName");

        // Generate booking ID (you can implement your own logic here)
        String bookingId = generateBookingId();

        // Create a new booking
        Booking booking = new Booking(bookingId, flightNumber, passengerName);

        // Save the booking to the XML file
        boolean success = XMLParser.addBooking(booking);

        // Forward to confirmation page or error page
        if (success) {
            request.setAttribute("booking", booking);
            RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle error
            // You can redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }

    // Sample method to generate booking ID (replace with your logic)
    private String generateBookingId() {
        // Implement your logic to generate a unique booking ID
        return "B" + System.currentTimeMillis(); // Example: B1618877662212
    }
}
