package b8_lld_parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import b8_lld_parking_lot.fee.FeeStrategy;
import b8_lld_parking_lot.fee.FlatRateFeeStrategy;
import b8_lld_parking_lot.parkingspot.ParkingSpot;
import b8_lld_parking_lot.vehicle.Vehicle;

public class ParkingLot {
	private static final ParkingLot INSTANCE = new ParkingLot();
	private final List<ParkingFloor> floors = new ArrayList<>();
	private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
	private FeeStrategy feeStrategy;

	private ParkingLot() {
		feeStrategy = new FlatRateFeeStrategy();
	}

	public static synchronized ParkingLot getInstance() {
		return INSTANCE;
	}

	public void addFloor(ParkingFloor floor) {
		floors.add(floor);
	}

	public void setFeeStrategy(FeeStrategy feeStrategy) {
		this.feeStrategy = feeStrategy;
	}

	public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
		for (ParkingFloor floor : floors) {
			Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle);
			if (spotOpt.isPresent()) {
				ParkingSpot spot = spotOpt.get();
				if (spot.assignVehicle(vehicle)) {
					ParkingTicket ticket = new ParkingTicket(vehicle, spot);
					activeTickets.put(vehicle.getLicenseNumber(), ticket);
					return ticket;
				}
			}
		}
		throw new Exception("No available spot for " + vehicle.getType());
	}

	public synchronized double unparkVehicle(String license) throws Exception {
		ParkingTicket ticket = activeTickets.remove(license);
		if (ticket == null)
			throw new Exception("Ticket not found");

		ticket.getSpot().removeVehicle();

		ticket.setExitTimestamp();
		return feeStrategy.calculateFee(ticket);
	}
}
