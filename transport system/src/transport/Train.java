package transport;

/**
 * Concrete class representing a Train
 */
public class Train extends Vehicle {
    // Instance variables
    private int numberOfCoaches;
    private int totalCapacity;
    private String trainType; // Express, Local, etc.
    
    // Class variable
    private static final double FARE_PER_KM = 1.5;
    
    // Constructor
    public Train(String vehicleId, String manufacturer, int yearOfManufacture,
                 int numberOfCoaches, String trainType) {
        super(vehicleId, manufacturer, yearOfManufacture);
        this.numberOfCoaches = numberOfCoaches;
        this.trainType = trainType;
        this.totalCapacity = numberOfCoaches * 80; // 80 passengers per coach
    }
    
    @Override
    public double calculateFare(double distance) {
        double fare = distance * FARE_PER_KM;
        // Express trains have 20% surcharge
        if (trainType.equalsIgnoreCase("Express")) {
            fare *= 1.2;
        }
        return fare;
    }
    
    @Override
    public String getVehicleInfo() {
        return String.format("Train[ID: %s, Type: %s, Coaches: %d, Capacity: %d]",
                           vehicleId, trainType, numberOfCoaches, totalCapacity);
    }
    
    @Override
    public void accelerate(double speed) {
        if (isRunning && currentSpeed + speed <= 200) { // Max speed 200 km/h
            super.accelerate(speed);
        } else {
            System.out.println("Cannot exceed maximum speed of 200 km/h");
        }
    }
    
    // Train-specific method
    public void addCoach() {
        numberOfCoaches++;
        totalCapacity = numberOfCoaches * 80;
        System.out.println("Coach added. Total coaches: " + numberOfCoaches);
    }
}
