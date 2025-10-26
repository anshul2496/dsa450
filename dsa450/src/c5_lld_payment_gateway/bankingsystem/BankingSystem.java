package c5_lld_payment_gateway.bankingsystem;

//----------------------------
//Banking System interface and implementations (Strategy for actual payment logic)
//----------------------------
public interface BankingSystem {
    boolean processPayment(double amount);
}