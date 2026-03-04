package transport;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class managing the entire transport system
 * Demonstrates composition and aggregation
 */
public class TransportSystem {
    // Instance variables
    private String systemName;
    private List<Vehicle> fleet;
    
    // Class variable
    private static int systemCount = 0;
    
    // Constructor
    public TransportSystem(String systemName) {
        this.systemName = systemName;
        this.fleet = new ArrayList<>();
        systemCount++;
    }
    
    // Add vehicle to fleet
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
        System.out.println("Added " + vehicle.getVehicleInfo() + " to " + systemName);
    }
    
    // Display all vehicles
    public void displayFleet() {
        System.out.println("\n=== " + systemName + " Fleet ===");
        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle.getVehicleInfo());
        }
        System.out.println("Total vehicles in system: " + fleet.size());
    }
    
    // Calculate total fare for a distance across all vehicles
    public void calculateAllFares(double distance) {
        System.out.println("\n=== Fare Calculation for " + distance + " km ===");
        for (Vehicle vehicle : fleet) {
            double fare = vehicle.calculateFare(distance);
            System.out.println(vehicle.getVehicleId() + ": $" + String.format("%.2f", fare));
        }
    }
    
    // Static method
    public static int getSystemCount() {
        return systemCount;
    }
}
