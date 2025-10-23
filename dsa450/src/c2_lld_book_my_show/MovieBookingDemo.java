package c2_lld_book_my_show;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import c2_lld_book_my_show.entities.Booking;
import c2_lld_book_my_show.entities.Cinema;
import c2_lld_book_my_show.entities.City;
import c2_lld_book_my_show.entities.Movie;
import c2_lld_book_my_show.entities.Screen;
import c2_lld_book_my_show.entities.Seat;
import c2_lld_book_my_show.entities.Show;
import c2_lld_book_my_show.entities.User;
import c2_lld_book_my_show.enums.SeatStatus;
import c2_lld_book_my_show.enums.SeatType;
import c2_lld_book_my_show.observer.UserObserver;
import c2_lld_book_my_show.strategy.payment.CreditCardPaymentStrategy;
import c2_lld_book_my_show.strategy.pricing.WeekdayPricingStrategy;

// https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/movieticketbookingsystem
public class MovieBookingDemo {
	public static void main(String[] args) {
		// Setup
		MovieBookingService service = MovieBookingService.getInstance();

		City nyc = service.addCity("city1", "New York");
		City la = service.addCity("city2", "Los Angeles");

		// 2. Add movies
		Movie matrix = new Movie("M1", "The Matrix", 120);
		Movie avengers = new Movie("M2", "Avengers: Endgame", 170);
		service.addMovie(matrix);
		service.addMovie(avengers);

		// Add Seats for a Screen
		Screen screen1 = new Screen("S1");

		for (int i = 1; i <= 10; i++) {
			screen1.addSeat(new Seat("A" + i, 1, i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM));
			screen1.addSeat(new Seat("B" + i, 2, i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM));
		}

		// Add Cinemas
		Cinema amcNYC = service.addCinema("cinema1", "AMC Times Square", nyc.getId(), List.of(screen1));

		// Add Shows
		Show matrixShow = service.addShow("show1", matrix, screen1, LocalDateTime.now().plusHours(2),
				new WeekdayPricingStrategy());
		Show avengersShow = service.addShow("show2", avengers, screen1, LocalDateTime.now().plusHours(5),
				new WeekdayPricingStrategy());

		// --- User and Observer Setup ---
		User alice = service.createUser("Alice", "alice@example.com");
		UserObserver aliceObserver = new UserObserver(alice);
		avengers.addObserver(aliceObserver);

		// Simulate movie release
		System.out.println("\n--- Notifying Observers about Movie Release ---");
		avengers.notifyObservers();

		// --- User Story: Alice books tickets ---
		System.out.println("\n--- Alice's Booking Flow ---");
		String cityName = "New York";
		String movieTitle = "Avengers: Endgame";

		// 1. Search for shows
		List<Show> availableShows = service.findShows(movieTitle, cityName);
		if (availableShows.isEmpty()) {
			System.out.println("No shows found for " + movieTitle + " in " + cityName);
			return;
		}
		Show selectedShow = availableShows.get(0); // Alice selects the first show

		// 2. View available seats
		List<Seat> availableSeats = selectedShow.getScreen().getSeats().stream()
				.filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE).collect(Collectors.toList());
		System.out.println(
				"Available seats for" + selectedShow.getMovie().getTitle() + " startTime " + selectedShow.getStartTime()
						+ " are " + availableSeats.stream().map(Seat::getId).collect(Collectors.toList()));

		// 3. Select seats
		List<Seat> desiredSeats = List.of(availableSeats.get(2), availableSeats.get(3));
		System.out
				.println("Alice selects seats: " + desiredSeats.stream().map(Seat::getId).collect(Collectors.toList()));

		// 4. Book Tickets
		Optional<Booking> bookingOpt = service.bookTickets(alice.getId(), selectedShow.getId(), desiredSeats,
				new CreditCardPaymentStrategy("1234-5678-9876-5432", "123"));

		if (bookingOpt.isPresent()) {
			Booking booking = bookingOpt.get();
			System.out.println("\n--- Booking Successful! ---");
			System.out.println("Booking ID: " + booking.getId());
			System.out.println("User: " + booking.getUser().getName());
			System.out.println("Movie: " + booking.getShow().getMovie().getTitle());
			System.out.println("Seats: " + booking.getSeats().stream().map(Seat::getId).collect(Collectors.toList()));
			System.out.println("Total Amount: $" + booking.getTotalAmount());
			System.out.println("Payment Status: " + booking.getPayment().getStatus());
		} else {
			System.out.println("Booking failed.");
		}

		// 5. Verify seat status after booking
		System.out.println("\nSeat status after Alice's booking:");
		desiredSeats.forEach(seat -> System.out.println("Seat " + seat.getId() + " status " + seat.getStatus()));

		// 6. Shut down the system to release resources like the scheduler.
		service.shutdown();
	}
}
