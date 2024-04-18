package com.example.flight_reservation.servlets;

import com.example.flight_reservation.Model.Flight;
import com.example.flight_reservation.utils.XMLParser;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class FlightSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve search parameters from request
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");

        try {
            // Perform search operation
            List<Flight> flights = XMLParser.searchFlights(origin, destination);

            // Forward the results to a JSP page for display
            request.setAttribute("flights", flights);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace(); // Print the exception for debugging
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }
}
