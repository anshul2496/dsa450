package c2_lld_book_my_show.strategy.payment;

import c2_lld_book_my_show.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
