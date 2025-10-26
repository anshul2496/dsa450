package c5_lld_payment_gateway.bankingsystem;

import java.util.Random;

public class PaytmBankingSystem implements BankingSystem {
    private Random rand = new Random();

    public PaytmBankingSystem() {}

    @Override
    public boolean processPayment(double amount) {
        // Simulate 80% success
        int r = rand.nextInt(100);
        return r < 80;
    }
}
