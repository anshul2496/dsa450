package b8_lld_parking_lot.fee;

import b8_lld_parking_lot.ParkingTicket;

public interface FeeStrategy {
	double calculateFee(ParkingTicket parkingTicket);
}
