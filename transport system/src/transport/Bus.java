package transport;

/**
 * Concrete class representing a Bus
 */
public class Bus extends Vehicle {
    // Instance variables specific to Bus
    private int passengerCapacity;
    private int currentPassengers;
    private String routeNumber;
    
    // Class variable
    private static final double FARE_PER_KM = 2.5;
    
    // Constructor
    public Bus(String vehicleId, String manufacturer, int yearOfManufacture, 
               int passengerCapacity, String routeNumber) {
        super(vehicleId, manufacturer, yearOfManufacture);
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = 0;
        this.routeNumber = routeNumber;
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * FARE_PER_KM;
    }
    
    @Override
    public String getVehicleInfo() {
        return String.format("Bus[ID: %s, Route: %s, Capacity: %d, Passengers: %d]",
                           vehicleId, routeNumber, passengerCapacity, currentPassengers);
    }
    
    // Bus-specific methods
    public void boardPassengers(int count) {
        if (currentPassengers + count <= passengerCapacity) {
            currentPassengers += count;
            System.out.println(count + " passengers boarded. Total: " + currentPassengers);
        } else {
            System.out.println("Cannot board. Capacity exceeded!");
        }
    }
    
    public void alightPassengers(int count) {
        if (currentPassengers >= count) {
            currentPassengers -= count;
            System.out.println(count + " passengers alighted. Remaining: " + currentPassengers);
        }
    }
}
