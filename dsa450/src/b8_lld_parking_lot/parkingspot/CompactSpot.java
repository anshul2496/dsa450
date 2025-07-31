package b8_lld_parking_lot.parkingspot;

import b8_lld_parking_lot.vehicle.Vehicle;
import b8_lld_parking_lot.vehicle.VehicleType;

public class CompactSpot extends ParkingSpot {
    public CompactSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        return type == VehicleType.CAR;
    }
}
