package c5_lld_payment_gateway.paymentgateway;

import c5_lld_payment_gateway.PaymentRequest;
import c5_lld_payment_gateway.bankingsystem.BankingSystem;

//----------------------------
//Abstract base class for Payment Gateway (Template Method Pattern)
//----------------------------
public abstract class PaymentGateway {
    protected BankingSystem bankingSystem;

    public PaymentGateway() {
        this.bankingSystem = null;
    }

    // Template method defining the standard payment flow
    public boolean processPayment(PaymentRequest request) {
        if (!validatePayment(request)) {
            System.out.println("[PaymentGateway] Validation failed for " + request.sender + ".");
            return false;
        }
        if (!initiatePayment(request)) {
            System.out.println("[PaymentGateway] Initiation failed for " + request.sender + ".");
            return false;
        }
        if (!confirmPayment(request)) {
            System.out.println("[PaymentGateway] Confirmation failed for " + request.sender + ".");
            return false;
        }
        return true;
    }

    // Steps to be implemented by concrete gateways
    public abstract boolean validatePayment(PaymentRequest request);
    public abstract boolean initiatePayment(PaymentRequest request);
    public abstract boolean confirmPayment(PaymentRequest request);
}
