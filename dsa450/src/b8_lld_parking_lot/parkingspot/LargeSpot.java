package b8_lld_parking_lot.parkingspot;

import b8_lld_parking_lot.vehicle.Vehicle;
import b8_lld_parking_lot.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.TRUCK;
    }
}
