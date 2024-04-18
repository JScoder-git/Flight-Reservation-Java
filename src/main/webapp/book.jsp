<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Flight</title>
</head>
<body>
<h2>Book Flight</h2>
<form action="BookingServlet" method="post">
    <label for="flightNumber">Flight Number:</label>
    <input type="text" id="flightNumber" name="flightNumber" required><br><br>
    <label for="passengerName">Passenger Name:</label>
    <input type="text" id="passengerName" name="passengerName" required><br><br>
    <input type="submit" value="Book Now">
</form>
</body>
</html>
