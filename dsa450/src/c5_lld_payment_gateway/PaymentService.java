package c5_lld_payment_gateway;

import c5_lld_payment_gateway.paymentgateway.PaymentGateway;

class PaymentService {
    private static final PaymentService instance = new PaymentService();
    private PaymentGateway gateway;

    private PaymentService() {
        this.gateway = null;
    }

    public static PaymentService getInstance() {
        return instance;
    }

    public void setGateway(PaymentGateway g) {
        this.gateway = g;
    }

    public boolean processPayment(PaymentRequest request) {
        if (gateway == null) {
            System.out.println("[PaymentService] No payment gateway selected.");
            return false;
        }
        return gateway.processPayment(request);
    }
}
