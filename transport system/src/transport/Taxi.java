package transport;

/**
 * Concrete class representing a Taxi
 */
public class Taxi extends Vehicle {
    // Instance variables
    private boolean isAvailable;
    private String driverName;
    private double meterReading;
    
    // Class variables
    private static final double BASE_FARE = 5.0;
    private static final double FARE_PER_KM = 3.5;
    
    // Constructor
    public Taxi(String vehicleId, String manufacturer, int yearOfManufacture, String driverName) {
        super(vehicleId, manufacturer, yearOfManufacture);
        this.driverName = driverName;
        this.isAvailable = true;
        this.meterReading = 0.0;
    }
    
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * FARE_PER_KM);
    }
    
    @Override
    public String getVehicleInfo() {
        return String.format("Taxi[ID: %s, Driver: %s, Available: %s, Meter: %.2f km]",
                           vehicleId, driverName, isAvailable ? "Yes" : "No", meterReading);
    }
    
    // Taxi-specific methods
    public void pickupPassenger(String passengerName) {
        if (isAvailable) {
            isAvailable = false;
            meterReading = 0.0;
            System.out.println("Picked up passenger: " + passengerName);
        } else {
            System.out.println("Taxi is not available!");
        }
    }
    
    public void dropoffPassenger(double distance) {
        if (!isAvailable) {
            meterReading = distance;
            double fare = calculateFare(distance);
            System.out.println("Trip completed. Distance: " + distance + " km, Fare: $" + fare);
            isAvailable = true;
        }
    }
}
