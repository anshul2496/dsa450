package c2_lld_book_my_show.observer;

import c2_lld_book_my_show.entities.Movie;
import c2_lld_book_my_show.entities.User;

public class UserObserver implements MovieObserver {
	private final User user;

	public UserObserver(User user) {
		this.user = user;
	}

	@Override
	public void update(Movie movie) {
		System.out.println("Movie is now available for booking!" + movie.getTitle());
	}
}
