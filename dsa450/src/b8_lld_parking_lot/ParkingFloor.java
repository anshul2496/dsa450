package b8_lld_parking_lot;

import java.util.List;
import java.util.Optional;

import b8_lld_parking_lot.parkingspot.ParkingSpot;
import b8_lld_parking_lot.vehicle.Vehicle;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = spots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .findFirst();
    }

    public int getFloorNumber() { return floorNumber; }
}