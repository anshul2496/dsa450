package c3_hotel_booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import c3_hotel_booking.decorator.Bookable;
import c3_hotel_booking.decorator.RoomBooking;
import c3_hotel_booking.enums.RoomStyle;
import c3_hotel_booking.enums.RoomType;
import c3_hotel_booking.model.Booking;
import c3_hotel_booking.model.Guest;
import c3_hotel_booking.model.Room;
import c3_hotel_booking.payment.CreditCardPayment;
import c3_hotel_booking.payment.Payment;

public class BookingManager {
    private final RoomService roomService;
    private final BookingService bookingService;
    private final CreditCardPayment paymentService;

    public BookingManager(RoomService roomService, BookingService bookingService, CreditCardPayment paymentService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    public Booking bookRoom(Guest guest, RoomType type, RoomStyle style, LocalDate start, LocalDate end) {

        Optional<Room> availableRoom = roomService.findRooms(type,style).stream().findFirst();

        if (availableRoom.isPresent()) {
            Room room = availableRoom.get();

            // 2. Create a booking
            Booking booking = bookingService.createBooking(guest, room, start, end);

            // 3. Use Decorator pattern to calculate total cost with amenities
            Bookable bookable = new RoomBooking(room);
            System.out.println("Total Cost: " + bookable.getCost());

            // 4. Process payment
            paymentService.processPayment(bookable.getCost());

            return booking;
        } else {
            System.out.println("Sorry, no rooms available matching your criteria.");
            return null;
        }
    }

    public void checkIn(String bookingId) {
        // In a real system, you'd fetch the booking by ID
        // For this demo, we'll find a room and check it in
        System.out.println("Check-in process for booking ID (not implemented for demo): " + bookingId);
    }

    public void checkOut(String roomNumber) {
        Room room = roomService.findRoomByNumber(roomNumber);
        if(room != null) {
            room.checkOut();
        } else {
            System.out.println("Room " + roomNumber + " not found.");
        }
    }
}
