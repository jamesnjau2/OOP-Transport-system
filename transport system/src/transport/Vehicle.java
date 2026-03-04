package transport;

/**
 * Abstract base class for all vehicles
 * Provides common functionality and enforces structure
 */
public abstract class Vehicle implements IVehicle {
    // Instance variables
    protected String vehicleId;
    protected String manufacturer;
    protected int yearOfManufacture;
    protected double currentSpeed;
    protected boolean isRunning;
    
    // Class variable - tracks total vehicles created
    protected static int totalVehicles = 0;
    
    // Constructor
    public Vehicle(String vehicleId, String manufacturer, int yearOfManufacture) {
        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.currentSpeed = 0.0;
        this.isRunning = false;
        totalVehicles++;
    }
    
    // Implemented interface methods
    @Override
    public void start() {
        isRunning = true;
        System.out.println(vehicleId + " started.");
    }
    
    @Override
    public void stop() {
        isRunning = false;
        currentSpeed = 0.0;
        System.out.println(vehicleId + " stopped.");
    }
    
    @Override
    public void accelerate(double speed) {
        if (isRunning) {
            currentSpeed += speed;
            System.out.println(vehicleId + " accelerating to " + currentSpeed + " km/h");
        }
    }
    
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateFare(double distance);
    
    // Static method
    public static int getTotalVehicles() {
        return totalVehicles;
    }
    
    // Getters
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
}
