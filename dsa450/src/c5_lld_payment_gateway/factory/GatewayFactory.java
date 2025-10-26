package c5_lld_payment_gateway.factory;

import c5_lld_payment_gateway.paymentgateway.PaymentGateway;
import c5_lld_payment_gateway.paymentgateway.PaytmGateway;
import c5_lld_payment_gateway.paymentgateway.RazorpayGateway;
import c5_lld_payment_gateway.proxy.PaymentGatewayProxy;

public class GatewayFactory {
    private static final GatewayFactory instance = new GatewayFactory();

    private GatewayFactory() {}

    public static GatewayFactory getInstance() {
        return instance;
    }

    public PaymentGateway getGateway(GatewayType type) {
        if (type == GatewayType.PAYTM) {
            PaymentGateway paymentGateway = new PaytmGateway();
            return new PaymentGatewayProxy(paymentGateway, 3);
        } else {
            PaymentGateway paymentGateway = new RazorpayGateway();
            return new PaymentGatewayProxy(paymentGateway, 1);
        }
    }
}
