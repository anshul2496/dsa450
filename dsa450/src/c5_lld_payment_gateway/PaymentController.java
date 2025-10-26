package c5_lld_payment_gateway;

import c5_lld_payment_gateway.factory.GatewayFactory;
import c5_lld_payment_gateway.factory.GatewayType;
import c5_lld_payment_gateway.paymentgateway.PaymentGateway;

class PaymentController {
    private static final PaymentController instance = new PaymentController();

    private PaymentController() {}

    public static PaymentController getInstance() {
        return instance;
    }

    public boolean handlePayment(GatewayType type, PaymentRequest req) {
        PaymentGateway paymentGateway = GatewayFactory.getInstance().getGateway(type);
        PaymentService.getInstance().setGateway(paymentGateway);
        return PaymentService.getInstance().processPayment(req);
    }
}
