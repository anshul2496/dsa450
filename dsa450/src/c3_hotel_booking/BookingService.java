package c3_hotel_booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import c3_hotel_booking.model.Booking;
import c3_hotel_booking.model.Guest;
import c3_hotel_booking.model.Room;
import c3_hotel_booking.observer.BookingObserver;

public class BookingService {
	private final List<Booking> bookings = new ArrayList<>();
	private final List<BookingObserver> observers = new ArrayList<>();

	public void addObserver(BookingObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(BookingObserver observer) {
		observers.remove(observer);
	}

	public Booking createBooking(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
		String bookingId = UUID.randomUUID().toString();
		Booking booking = new Booking(bookingId, guest, room, startDate, endDate);

		// Use the State pattern to book the room
		room.book();

		bookings.add(booking);
		notifyObservers(booking);
		return booking;
	}

	private void notifyObservers(Booking booking) {
		for (BookingObserver observer : observers) {
			observer.update(booking);
		}
	}
}
