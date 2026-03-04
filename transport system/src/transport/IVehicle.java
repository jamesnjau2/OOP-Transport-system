package transport;

/**
 * Interface defining the contract for all vehicles in the transport system
 */
public interface IVehicle {
    void start();
    void stop();
    void accelerate(double speed);
    double getCurrentSpeed();
    String getVehicleInfo();
}
