/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tausicoachjourney;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TausiCoachJourney {

    public static void main(String[] args) {
        // Constants
        int totalDistance = 10000; // in km
        int passengerStopInterval = 150; // in km
        int refuelStopInterval = 200; // in km
        int stopTimeMinutes = 5; // in minutes
        int speedKmPerHour = 250; // train speed in km/hr
        double speedMetersPerSecond = 225.5; // second coach speed in m/s

        // (i) Calculate the number of stops
        int passengerStops = totalDistance / passengerStopInterval;
        int refuelStops = totalDistance / refuelStopInterval;
        if (totalDistance % passengerStopInterval == 0) {
            passengerStops--;
        }
        if (totalDistance % refuelStopInterval == 0) {
            refuelStops--;
        }
        int totalStops = passengerStops + refuelStops;
        System.out.println("Total number of stops: " + totalStops);

        // (ii) Compute total time including stops
        double travelTimeHours = (double) totalDistance / speedKmPerHour;
        double totalStopTimeHours = (totalStops * stopTimeMinutes) / 60.0;
        double totalTimeHours = travelTimeHours + totalStopTimeHours;
        System.out.println("Total time taken including stops: " + totalTimeHours + " hours");

        // (iii) Compute time for return journey (only refueling stops)
        int returnRefuelStops = totalDistance / refuelStopInterval;
        if (totalDistance % refuelStopInterval == 0) {
            returnRefuelStops--;
        }
        double returnStopTimeHours = (returnRefuelStops * stopTimeMinutes) / 60.0;
        double returnJourneyTimeHours = travelTimeHours + returnStopTimeHours;
        System.out.println("Total time taken for return journey including refuel stops: " + returnJourneyTimeHours + " hours");

        // (iv) Determine arrival time of the second coach
        double speedKmPerHour2 = speedMetersPerSecond * 3.6; // convert m/s to km/hr
        double travelTimeHours2 = (double) totalDistance / speedKmPerHour2;
        LocalTime departureTime = LocalTime.of(9, 0); // Departure time 09:00
        LocalTime arrivalTime = departureTime.plusHours((long) travelTimeHours2);
        arrivalTime = arrivalTime.plusMinutes((long) ((travelTimeHours2 - (long) travelTimeHours2) * 60));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Approximate arrival time: " + arrivalTime.format(formatter));
    }
}
