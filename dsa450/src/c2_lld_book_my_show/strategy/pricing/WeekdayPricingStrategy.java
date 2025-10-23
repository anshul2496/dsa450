package c2_lld_book_my_show.strategy.pricing;

import java.util.List;

import c2_lld_book_my_show.entities.Seat;

public class WeekdayPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<Seat> seats) {
        return seats.stream().mapToDouble(seat -> seat.getType().getPrice()).sum();
    }
}
