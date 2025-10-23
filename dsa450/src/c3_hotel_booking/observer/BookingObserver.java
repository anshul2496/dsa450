package c3_hotel_booking.observer;

import c3_hotel_booking.model.Booking;

public interface BookingObserver {
    void update(Booking booking);
}
