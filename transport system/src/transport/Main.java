package transport;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Transport System Demo ===\n");
        
        TransportSystem cityTransport = new TransportSystem("City Metro Transport");
        
        Bus bus1 = new Bus("BUS-001", "Volvo", 2022, 50, "Route-15");
        Bus bus2 = new Bus("BUS-002", "Mercedes", 2023, 40, "Route-22");
        
        Taxi taxi1 = new Taxi("TAXI-001", "Toyota", 2021, "John Smith");
        Taxi taxi2 = new Taxi("TAXI-002", "Honda", 2022, "Jane Doe");
        
        Train train1 = new Train("TRAIN-001", "Siemens", 2020, 8, "Express");
        
        cityTransport.addVehicle(bus1);
        cityTransport.addVehicle(bus2);
        cityTransport.addVehicle(taxi1);
        cityTransport.addVehicle(taxi2);
        cityTransport.addVehicle(train1);
        
        cityTransport.displayFleet();
        
        System.out.println("\n=== Vehicle Operations ===");
        
        bus1.start();
        bus1.boardPassengers(25);
        bus1.accelerate(40);
        bus1.boardPassengers(15);
        
        System.out.println();
        taxi1.start();
        taxi1.pickupPassenger("Alice");
        taxi1.accelerate(60);
        taxi1.dropoffPassenger(15.5);
        
        System.out.println();
        train1.start();
        train1.accelerate(100);
        train1.addCoach();
        
        cityTransport.calculateAllFares(20.0);
        
        System.out.println("\n=== System Statistics ===");
        System.out.println("Total vehicles created: " + Vehicle.getTotalVehicles());
        System.out.println("Transport systems created: " + TransportSystem.getSystemCount());
    }
}
