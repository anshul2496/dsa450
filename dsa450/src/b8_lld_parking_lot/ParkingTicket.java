package b8_lld_parking_lot;

import java.util.Date;
import java.util.UUID;

import b8_lld_parking_lot.parkingspot.ParkingSpot;
import b8_lld_parking_lot.vehicle.Vehicle;

public class ParkingTicket {
	private final String ticketId;
	private final Vehicle vehicle;
	private final ParkingSpot spot;
	private final long entryTimestamp;
	private long exitTimestamp;

	public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
		this.ticketId = UUID.randomUUID().toString();
		this.vehicle = vehicle;
		this.spot = spot;
		this.entryTimestamp = new Date().getTime();
	}

	public String getTicketId() {
		return ticketId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public ParkingSpot getSpot() {
		return spot;
	}

	public long getEntryTimestamp() {
		return entryTimestamp;
	}

	public long getExitTimestamp() {
		return exitTimestamp;
	}

	public void setExitTimestamp() {
		this.exitTimestamp = new Date().getTime();
	}
}
