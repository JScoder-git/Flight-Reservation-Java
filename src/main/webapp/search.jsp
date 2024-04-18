<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
<h2>Search Results</h2>
<table border="1">
    <tr>
        <th>Flight Number</th>
        <th>Origin</th>
        <th>Destination</th>
        <th>Capacity</th>
        <th>Available Seats</th>
    </tr>
    <% for (Flight flight : (List<Flight>) request.getAttribute("flights")) { %>
    <tr>
        <td><%= flight.getFlightNumber() %></td>
        <td><%= flight.getOrigin() %></td>
        <td><%= flight.getDestination() %></td>
        <td><%= flight.getCapacity() %></td>
        <td><%= flight.getAvailableSeats() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
