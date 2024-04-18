package com.example.flight_reservation.utils;

import com.example.flight_reservation.Model.Booking;
import com.example.flight_reservation.Model.Flight;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private static final String FLIGHTS_FILE = "/WEB-INF/flights.xml";
    private static final String BOOKINGS_FILE = "/WEB-INF/bookings.xml";

    public static List<Flight> searchFlights(String origin, String destination) {
        List<Flight> flights = new ArrayList<>();
        try {
            File file = new File(XMLParser.class.getResource(FLIGHTS_FILE).toURI());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("flight");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String flightNumber = element.getAttribute("number");
                    String originCode = element.getElementsByTagName("origin").item(0).getTextContent();
                    String destinationCode = element.getElementsByTagName("destination").item(0).getTextContent();

                    if (originCode.equals(origin) && destinationCode.equals(destination)) {
                        String capacityStr = element.getElementsByTagName("capacity").item(0).getTextContent();
                        int capacity = Integer.parseInt(capacityStr);
                        String availableSeatsStr = element.getElementsByTagName("availableSeats").item(0).getTextContent();
                        int availableSeats = Integer.parseInt(availableSeatsStr);
                        flights.add(new Flight(flightNumber, origin, destination, capacity, availableSeats));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public static boolean addBooking(Booking booking) {
        try {
            File file = new File(XMLParser.class.getResource(BOOKINGS_FILE).toURI());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            Element root = doc.getDocumentElement();
            Element bookingElement = doc.createElement("booking");
            bookingElement.setAttribute("id", booking.getBookingId());

            Element flightElement = doc.createElement("flight");
            flightElement.setTextContent(booking.getFlightNumber());

            Element passengerElement = doc.createElement("passenger");
            passengerElement.setTextContent(booking.getPassengerName());

            bookingElement.appendChild(flightElement);
            bookingElement.appendChild(passengerElement);
            root.appendChild(bookingElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(XMLParser.class.getResource(BOOKINGS_FILE).toURI()));
            transformer.transform(source, result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
