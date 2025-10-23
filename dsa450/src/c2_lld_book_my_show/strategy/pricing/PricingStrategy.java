package c2_lld_book_my_show.strategy.pricing;

import java.util.List;

import c2_lld_book_my_show.entities.Seat;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
